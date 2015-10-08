/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioSolicitudPermisoDO;
import mx.com.gahm.conenctel.entities.SolicitudPermisoDO;
import mx.com.gahm.conenctel.services.ISolicitudPermisoService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/SolicitudPermisoService")
public class SolicitudPermisoService implements ISolicitudPermisoService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SolicitudPermisoDO> getAll() {
		List<SolicitudPermisoDO> datos= null;
		TypedQuery<SolicitudPermisoDO>  query =null;
		query = entityManager.createNamedQuery("SolicitudPermisoDO.findAll",SolicitudPermisoDO.class);
		datos = query.getResultList();
		
		return datos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudPermisoDO> getAllByPerfil( long idPerfil ) {
		List<SolicitudPermisoDO> datos= null;
		Query query = null;
		query = entityManager.createNamedQuery("SolicitudPermisoDO.findAllByPerfil");
		query.setParameter("idPerfil",idPerfil);
		datos = query.getResultList();
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SolicitudPermisoDO dato = null;
		for (Integer id : idsItems) {
			dato =getItem(id);
			entityManager.remove(dato);
		}
		
	}

	@Override
	public SolicitudPermisoDO save(SolicitudPermisoDO item) {
		List<ComentarioSolicitudPermisoDO> comentarios = item.getComentarios();
		item.setComentarios( null );
		item.setFechaRegistro(new Date());
		entityManager.persist(item);
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void saveComentarios(SolicitudPermisoDO item,List<ComentarioSolicitudPermisoDO> comentarios){
		if( comentarios == null ){
			return;
		}
		for (ComentarioSolicitudPermisoDO dato : comentarios) {
			entityManager.persist(dato.getComentarioRecursosHumanos());
			dato.setSolicitudPermiso(item);
			entityManager.persist(dato);
		}
		item.setComentarios(comentarios);
	}
	
	@Override
	public SolicitudPermisoDO update(SolicitudPermisoDO item) {
		deleteComentarios(item);
		List<ComentarioSolicitudPermisoDO> comentarios = item.getComentarios();
		item.setComentarios(null);
		item.setFechaRegistro(new Date());
		entityManager.merge(item);
		saveComentarios(item,comentarios);
		return item;
	}

	private void deleteComentarios(SolicitudPermisoDO itemParam) {
		SolicitudPermisoDO solicitudPermisoDO = entityManager.find(SolicitudPermisoDO.class, itemParam.getId());
		if( solicitudPermisoDO.getComentarios() != null ){
			for (ComentarioSolicitudPermisoDO comentario : solicitudPermisoDO.getComentarios()) {
				entityManager.remove( comentario );
			}
		}
	}

	@Override
	public SolicitudPermisoDO getItem(Integer id) {
		SolicitudPermisoDO dato = entityManager.find(SolicitudPermisoDO.class,id);
		return dato;
	}

	
}
