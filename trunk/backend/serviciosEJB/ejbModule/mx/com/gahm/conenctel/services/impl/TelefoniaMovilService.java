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
import mx.com.gahm.conenctel.entities.TelefoniaMovilDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.ITelefoniaMovilService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/TelefoniaMovilService")
public class TelefoniaMovilService implements ITelefoniaMovilService {

	@Inject
	private EntityManager entityManager;

	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TelefoniaMovilDO> getAll() throws ConectelException {
		TypedQuery<TelefoniaMovilDO> query = entityManager.createNamedQuery(
				"TelefoniaMovilDO.findAll", TelefoniaMovilDO.class);
		List<TelefoniaMovilDO> telefoniaMovilList;
		try {
			telefoniaMovilList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Telefonia Movil registrada.");
		}
		return telefoniaMovilList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			TelefoniaMovilDO current = entityManager.find(TelefoniaMovilDO.class, id);
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
	public TelefoniaMovilDO save(TelefoniaMovilDO item) {
		entityManager.persist(item);
		entityManager.flush();
		saveDocumentos(item);
		return null;
	}

	private void saveDocumentos(TelefoniaMovilDO item){
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_TELEFONIA_MOVIL);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TelefoniaMovilDO update(TelefoniaMovilDO item) {
		try {
			almacenUtilService.deleteDocumentos(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		try {
			almacenUtilService.deleteComentarios(item.getId(),TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		saveDocumentos(item);
		almacenUtilService.saveComentarios(item.getComentarios(),item.getId(),TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public TelefoniaMovilDO getItem(Long id) throws ConectelException {
		TelefoniaMovilDO telefoniaMovil = entityManager.find(TelefoniaMovilDO.class, id);
		List<ComentariosDO> comentarios=null; 
		List<DocumentoAlmacenDO> documentos=null;
		if (telefoniaMovil == null) {
			throw new ConectelException("El Telefonia Movil no existe");
		}
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION,TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		telefoniaMovil.setCertificadoCalibracion(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA,TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		telefoniaMovil.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO,TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		telefoniaMovil.setPolizaSeguro(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO,TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		telefoniaMovil.setOrdenMantenimiento(documentos);
		
		
		comentarios = almacenUtilService.getAllComentariosById(telefoniaMovil.getId(),TipoAlmacenDO.ID_TELEFONIA_MOVIL);
		telefoniaMovil.setComentarios(comentarios);

		return telefoniaMovil;
	}

}
