package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.entities.EquipoMedicionDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.IEquipoMedicionService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/EquipoMedicionService")
public class EquipoMedicionService implements IEquipoMedicionService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EquipoMedicionDO> getAll() throws ConectelException {
		TypedQuery<EquipoMedicionDO> query = entityManager.createNamedQuery(
				"EquipoMedicionDO.findAll", EquipoMedicionDO.class);
		List<EquipoMedicionDO> equipoMedicionList;
		try {
			equipoMedicionList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Equipos de Medición registrados.");
		}
		return equipoMedicionList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			EquipoMedicionDO current = entityManager.find(EquipoMedicionDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		// TODO
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EquipoMedicionDO save(EquipoMedicionDO item) {
		entityManager.persist(item);
		entityManager.flush();
		saveDocumentos(item);
		return null;
	}

	private void saveDocumentos(EquipoMedicionDO item){
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_EQUIPO_MEDICION);
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EquipoMedicionDO update(EquipoMedicionDO item) {
		try {
			almacenUtilService.deleteDocumentos(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		try {
			almacenUtilService.deleteComentarios(item.getId(),TipoAlmacenDO.ID_EQUIPO_MEDICION);
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		entityManager.merge(item);
		saveDocumentos(item);
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_EQUIPO_MEDICION);

		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EquipoMedicionDO getItem(Long id) throws ConectelException {
		List<ComentariosDO> comentarios=null;
		List<DocumentoAlmacenDO> documentos= null;
		EquipoMedicionDO equipoMedicion = entityManager.find(EquipoMedicionDO.class, id);
		if (equipoMedicion == null) {
			throw new ConectelException("El Equipo de Medición no existe");
		}
		comentarios = almacenUtilService.getAllComentariosById(equipoMedicion.getId(),TipoAlmacenDO.ID_EQUIPO_MEDICION);
		documentos =almacenUtilService.getDocumentosByTipo(equipoMedicion.getId(),TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO,TipoAlmacenDO.ID_EQUIPO_MEDICION);
		equipoMedicion.setPolizaSeguro(documentos);
		documentos =almacenUtilService.getDocumentosByTipo(equipoMedicion.getId(),TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION,TipoAlmacenDO.ID_EQUIPO_MEDICION);
		equipoMedicion.setCertificadoCalibracion(documentos);
		documentos =almacenUtilService.getDocumentosByTipo(equipoMedicion.getId(),TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA,TipoAlmacenDO.ID_EQUIPO_MEDICION);
		equipoMedicion.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(equipoMedicion.getId(),TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO,TipoAlmacenDO.ID_EQUIPO_MEDICION);
		equipoMedicion.setOrdenMantenimiento(documentos);
		
		equipoMedicion.setComentarios(comentarios);
		return equipoMedicion;
	}

}
