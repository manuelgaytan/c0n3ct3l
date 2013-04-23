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
import mx.com.gahm.conenctel.entities.HerramientaDO;
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
		
		saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId());
		
		return null;
	}

	private void saveDocumentos(List<DocumentoAlmacenDO> documentos, Long id,Long idTipoEntregable){
		if( documentos == null || id == null ){
			return;
		}
		for (DocumentoAlmacenDO doc : documentos) {
			doc.setAlmacen(id);
			entityManager.persist(doc);
		}
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
		
		saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId());
		
		entityManager.merge(item);
		return null;
	}
	
	
	
	
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HerramientaDO getItem(Long id) throws ConectelException {
		HerramientaDO herramienta = entityManager.find(HerramientaDO.class, id);
		List<ComentariosDO> comentarios=null; 
		
		if (herramienta == null) {
			throw new ConectelException("La Herramienta no existe");
		}
		
		comentarios = almacenUtilService.getAllComentariosById(herramienta.getId());
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
