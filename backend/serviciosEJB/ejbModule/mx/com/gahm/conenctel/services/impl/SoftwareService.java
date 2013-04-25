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
import mx.com.gahm.conenctel.entities.SoftwareDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.ISoftwareService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/SoftwareService")
public class SoftwareService implements ISoftwareService {

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SoftwareDO> getAll() throws ConectelException {
		TypedQuery<SoftwareDO> query = entityManager.createNamedQuery(
				"SoftwareDO.findAll", SoftwareDO.class);
		List<SoftwareDO> softwareList;
		try {
			softwareList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Software registrado.");
		}
		return softwareList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			SoftwareDO current = entityManager.find(SoftwareDO.class, id);
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
	public SoftwareDO save(SoftwareDO item) {
		entityManager.persist(item);
		entityManager.flush();
		saveDocumentos(item);
		return null;
	}
	private void saveDocumentos(SoftwareDO item){
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_SOFTWARE);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SoftwareDO update(SoftwareDO item) {
		try {
			almacenUtilService.deleteDocumentos(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		try {
			almacenUtilService.deleteComentarios(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		saveDocumentos(item);
		
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public SoftwareDO getItem(Long id) throws ConectelException {
		SoftwareDO software = entityManager.find(SoftwareDO.class, id);
		List<ComentariosDO> comentarios=null; 
		List<DocumentoAlmacenDO> documentos=null;
		if (software == null) {
			throw new ConectelException("El Software no existe");
		}
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		software.setCertificadoCalibracion(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA);
		software.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO);
		software.setPolizaSeguro(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO);
		software.setOrdenMantenimiento(documentos);
		
		
		comentarios = almacenUtilService.getAllComentariosById(software.getId(),TipoAlmacenDO.ID_SOFTWARE);
		software.setComentarios(comentarios);
		return software;
	}

}
