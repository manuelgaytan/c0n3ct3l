package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.entities.HerramientaDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.IHerramientaService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/HerramientaService")
public class HerramientaService implements IHerramientaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HerramientaDO> getAll() throws ConectelException {
		TypedQuery<HerramientaDO> query = entityManager.createNamedQuery(
				"HerramientaDO.findAll", HerramientaDO.class);
		List<HerramientaDO> herramientaList;
		try {
			herramientaList = query.getResultList();
			
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		
		
		
		return herramientaList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			HerramientaDO current = entityManager.find(HerramientaDO.class, id);
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
	public HerramientaDO save(HerramientaDO item) {
		
		entityManager.persist(item);
		entityManager.flush();
		
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_HERRAMIENTA );
		 
		return null;
	}

	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HerramientaDO update(HerramientaDO item) {
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
		
		almacenUtilService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenUtilService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenUtilService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenUtilService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_HERRAMIENTA);
		
		entityManager.merge(item);
		return null;
	}
	
	
	
	
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HerramientaDO getItem(Long id) throws ConectelException {
		HerramientaDO herramienta = entityManager.find(HerramientaDO.class, id);
		List<ComentariosDO> comentarios=null; 
		List<DocumentoAlmacenDO> documentos=null;
		if (herramienta == null) {
			throw new ConectelException("La Herramienta no existe");
		}
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION);
		herramienta.setCertificadoCalibracion(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA);
		herramienta.setPolizaGarantia(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO);
		herramienta.setPolizaSeguro(documentos);
		
		documentos =almacenUtilService.getDocumentosByTipo(id, TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO);
		herramienta.setOrdenMantenimiento(documentos);
		
		
		comentarios = almacenUtilService.getAllComentariosById(herramienta.getId(),TipoAlmacenDO.ID_HERRAMIENTA);
		herramienta.setComentarios(comentarios);

		return herramienta;
	}

	public IAlmacenUtilService getAlmacenUtilService() {
		return almacenUtilService;
	}

	public void setAlmacenUtilService(IAlmacenUtilService almacenUtilService) {
		this.almacenUtilService = almacenUtilService;
	}
	
	
}
