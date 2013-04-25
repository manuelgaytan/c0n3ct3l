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
import mx.com.gahm.conenctel.entities.HardwareDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.IHardwareService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/HardwareService")
public class HardwareService implements IHardwareService {

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HardwareDO> getAll() throws ConectelException {
		TypedQuery<HardwareDO> query = entityManager.createNamedQuery(
				"HardwareDO.findAll", HardwareDO.class);
		List<HardwareDO> hardwareList;
		try {
			hardwareList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Hardware registrado.");
		}
		return hardwareList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			HardwareDO current = entityManager.find(HardwareDO.class, id);
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
	public HardwareDO save(HardwareDO item) {
		entityManager.persist(item);
		entityManager.flush();
		saveDocumentos(item);
		return null;
	}
	
	private void saveDocumentos(HardwareDO item){
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_HARDWARE);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HardwareDO update(HardwareDO item) {
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
	public HardwareDO getItem(Long id) throws ConectelException {
		HardwareDO hardware = entityManager.find(HardwareDO.class, id);
		List<ComentariosDO> comentarios=null; 
		List<DocumentoAlmacenDO> documentos=null;
		if (hardware == null) {
			throw new ConectelException("El Hardware no existe");
		}
		

		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		hardware.setCertificadoCalibracion(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA);
		hardware.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO);
		hardware.setPolizaSeguro(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO);
		hardware.setOrdenMantenimiento(documentos);
		
		
		comentarios = almacenUtilService.getAllComentariosById(hardware.getId(),TipoAlmacenDO.ID_HARDWARE);
		hardware.setComentarios(comentarios);

		
		
		return hardware;
	}

}
