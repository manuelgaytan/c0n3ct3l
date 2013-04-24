package mx.com.gahm.conenctel.services.impl;

import java.util.ArrayList;
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
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilsService;
import mx.com.gahm.conenctel.services.IHerramientaService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/HerramientaService")
public class HerramientaService implements IHerramientaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@EJB
	private IAlmacenUtilsService almacenService;
	
	
	
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
		
		almacenService.saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		almacenService.saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		almacenService.saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		almacenService.saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		saveComentarios(item.getComentarios(), item.getId());
		
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
	
	private void saveComentarios(List<ComentariosDO> comentarios, Long id ){
		if( comentarios == null || id == null ){
			return;
		}
		for (ComentariosDO comentario : comentarios) {
			comentario.setAlmacen(id);
			comentario.setTipoAlmacen(new TipoAlmacenDO());
			comentario.getTipoAlmacen().setId(1L);
			entityManager.persist(comentario);
		}
	}

		
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HerramientaDO update(HerramientaDO item) {
		try {
			deleteDocumentos(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		try {
			deleteComentarios(item.getId());
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		saveDocumentos(item.getCertificadoCalibracion(), item.getId(), TipoDocumentoAlmacenDO.ID_CERTIFICADO_CALIBRACION );
		saveDocumentos(item.getPolizaSeguro(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_SEGURO );
		saveDocumentos(item.getPolizaGarantia(), item.getId(), TipoDocumentoAlmacenDO.ID_POLIZA_GARANTIA );
		saveDocumentos(item.getOrdenMantenimiento(), item.getId(), TipoDocumentoAlmacenDO.ID_ORDEN_MANTENIMIENTO_SERVICIO );
		
		saveComentarios(item.getComentarios(), item.getId());
		
		entityManager.merge(item);
		return null;
	}
	
	public List<DocumentoAlmacenDO> getAllDocumentosById(Long id) throws ConectelException {
		TypedQuery<DocumentoAlmacenDO> query = entityManager.createNamedQuery(
				"DocumentoAlmacenDO.findAll", DocumentoAlmacenDO.class);
		query.setParameter("almacen", id);
		List<DocumentoAlmacenDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	public List<DocumentoAlmacenDO> getDocumentosByTipo(Long id,Long tipoDocumento) throws ConectelException {
		TypedQuery<DocumentoAlmacenDO> query = entityManager.createNamedQuery(
				"DocumentoAlmacenDO.getDocumentosByTipo", DocumentoAlmacenDO.class);
		query.setParameter("almacen", id);
		query.setParameter("tipoDocumento", tipoDocumento);
		List<DocumentoAlmacenDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	public List<ComentariosDO> getAllComentariosById(Long id) throws ConectelException {
		TypedQuery<ComentariosDO> query = entityManager.createNamedQuery(
				"ComentariosDO.findAll", ComentariosDO.class);
		query.setParameter("almacen", id);
		List<ComentariosDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HerramientaDO getItem(Long id) throws ConectelException {
		HerramientaDO herramienta = entityManager.find(HerramientaDO.class, id);
		List<ComentariosDO> comentarios=null; 
		
		if (herramienta == null) {
			throw new ConectelException("La Herramienta no existe");
		}
		
		comentarios = getAllComentariosById(herramienta.getId());
		herramienta.setComentarios(comentarios);

		return herramienta;
	}
	
	private void deleteDocumentos(Long idAlmacen) throws ConectelException{
		 List<DocumentoAlmacenDO> documentos = getAllDocumentosById(idAlmacen);
		 
		 if( documentos == null ){
			 return;
		 }
		 for (DocumentoAlmacenDO documentoAlmacenDO : documentos) {
			 entityManager.remove(documentoAlmacenDO);
		}
		
	}
	
	private void deleteComentarios(Long idAlmacen) throws ConectelException{
		 List<ComentariosDO> comentarios = getAllComentariosById(idAlmacen);
		 
		 if( comentarios == null ){
			 return;
		 }
		 for (ComentariosDO comentario : comentarios ) {
			 entityManager.remove( comentario );
		}
		
	}
}
