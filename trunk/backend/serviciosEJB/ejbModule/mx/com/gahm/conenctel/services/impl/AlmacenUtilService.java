/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;

/**
 * @author SEVEN
 *
 */
@Stateless(mappedName = "ejb/AlmacenUtilService")
public class AlmacenUtilService implements IAlmacenUtilService{
	

	@Inject
	private EntityManager entityManager;
	
	public List<DocumentoAlmacenDO> getDocumentosByTipo(Long id,Long tipoDocumento,Long tipoAlmacen) throws ConectelException {
		TypedQuery<DocumentoAlmacenDO> query = entityManager.createNamedQuery(
				"DocumentoAlmacenDO.getDocumentosByTipo", DocumentoAlmacenDO.class);
		query.setParameter("almacen", id);
		query.setParameter("tipoDocumento", tipoDocumento);
		query.setParameter("tipoAlmacen", tipoAlmacen);
		List<DocumentoAlmacenDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	public void saveComentarios(List<ComentariosDO> comentarios, Long id,Long idTipoAlmacen ){
		if( comentarios == null || id == null ){
			return;
		}
		for (ComentariosDO comentario : comentarios) {
			comentario.setAlmacen(id);
			comentario.setTipoAlmacen(new TipoAlmacenDO());
			comentario.getTipoAlmacen().setId(idTipoAlmacen);
			entityManager.persist(comentario);
		}
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
	
	public List<DocumentoAlmacenDO> getDocumentosByTipoAlmacen(Long id,Long tipoAlmacen) throws ConectelException {
		TypedQuery<DocumentoAlmacenDO> query = entityManager.createNamedQuery(
				"DocumentoAlmacenDO.getDocumentosByTipoAlmacen", DocumentoAlmacenDO.class);
		query.setParameter("almacen", id);
		query.setParameter("tipoAlmacen", tipoAlmacen);
		List<DocumentoAlmacenDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	
	
	public void deleteDocumentos(Long idAlmacen) throws ConectelException{
		 List<DocumentoAlmacenDO> documentos = getAllDocumentosById(idAlmacen);
		 
		 if( documentos == null ){
			 return;
		 }
		 for (DocumentoAlmacenDO documentoAlmacenDO : documentos) {
			 entityManager.remove(documentoAlmacenDO);
		}
		
	}
	
	public void deleteComentarios(Long idAlmacen,Long idTipoAlmacen) throws ConectelException{
		 List<ComentariosDO> comentarios = getAllComentariosById(idAlmacen,idTipoAlmacen);
		 
		 if( comentarios == null ){
			 return;
		 }
		 for (ComentariosDO comentario : comentarios ) {
			 entityManager.remove( comentario );
		}
		
	}

	
	public List<ComentariosDO> getAllComentariosById(Long id,Long tipoAlmacen) throws ConectelException {
		TypedQuery<ComentariosDO> query = entityManager.createNamedQuery(
				"ComentariosDO.findAll", ComentariosDO.class);
		query.setParameter("almacen", id);
		query.setParameter("tipoAlmacen", tipoAlmacen);
		List<ComentariosDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return datos;
	}
	
	public void saveDocumentos(List<DocumentoAlmacenDO> documentos, Long id,Long idTipoEntregable){
		if( documentos == null || id == null ){
			return;
		}
		for (DocumentoAlmacenDO doc : documentos) {
			doc.setAlmacen(id);
			entityManager.persist(doc);
		}
	}
	
}
