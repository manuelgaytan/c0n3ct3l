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
import mx.com.gahm.conenctel.entities.EquipoTransporteDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.IEquipoTransporteService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/EquipoTransporteService")
public class EquipoTransporteService implements IEquipoTransporteService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EquipoTransporteDO> getAll() throws ConectelException {
		TypedQuery<EquipoTransporteDO> query = entityManager.createNamedQuery(
				"EquipoTransporteDO.findAll", EquipoTransporteDO.class);
		List<EquipoTransporteDO> equipoTransporteList;
		try {
			equipoTransporteList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Equipos de Transporte registrados.");
		}
		return equipoTransporteList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			EquipoTransporteDO current = entityManager.find(EquipoTransporteDO.class, id);
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
	public EquipoTransporteDO save(EquipoTransporteDO item) {
		entityManager.persist(item);
		entityManager.flush();
		saveDocumentos(item);
		return null;
	}

	private void saveDocumentos(EquipoTransporteDO item){
		almacenUtilService.saveDocumentos(item.getTarjetaCirculacion(), item.getId(), TipoDocumentoAlmacenDO.ID_TARJETA_CIRCULACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
	}

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EquipoTransporteDO update(EquipoTransporteDO item) {
		try {
			almacenUtilService.deleteDocumentos(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		try {
			almacenUtilService.deleteComentarios(item.getId(),TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		saveDocumentos(item);
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		
		entityManager.merge(item);
		
		
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EquipoTransporteDO getItem(Long id) throws ConectelException {
		EquipoTransporteDO equipoTransporte = entityManager.find(EquipoTransporteDO.class, id);
		List<ComentariosDO> comentarios=null; 
		List<DocumentoAlmacenDO> documentos=null;
		
		if (equipoTransporte == null) {
			throw new ConectelException("El Equipo de Transporte no existe");
		}
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_TARJETA_CIRCULACION,TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		equipoTransporte.setTarjetaCirculacion(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA,TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		equipoTransporte.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO,TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		equipoTransporte.setPolizaSeguro(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO,TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		equipoTransporte.setOrdenMantenimiento(documentos);
		
		
		comentarios = almacenUtilService.getAllComentariosById(equipoTransporte.getId(),TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		equipoTransporte.setComentarios(comentarios);

		
		return equipoTransporte;
	}

}
