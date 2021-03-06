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

import mx.com.gahm.conenctel.entities.ComentarioSolicitudVacacionesDO;
import mx.com.gahm.conenctel.entities.SolicitudVacacionesDO;
import mx.com.gahm.conenctel.services.ISolicitudVacacionesService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/SolicitudVacacionesService")
public class SolicitudVacacionesService implements ISolicitudVacacionesService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SolicitudVacacionesDO> getAll() {
		List<SolicitudVacacionesDO> datos= null;
		TypedQuery<SolicitudVacacionesDO>  query =null;
		query = entityManager.createNamedQuery("SolicitudVacacionesDO.findAll",SolicitudVacacionesDO.class);
		datos = query.getResultList();
		
		return datos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudVacacionesDO> getAllByPerfil( long idPerfil ) {
		List<SolicitudVacacionesDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("SolicitudVacacionesDO.findAllByPerfil");
		query.setParameter("idPerfil",idPerfil);
		datos = query.getResultList();
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SolicitudVacacionesDO dato = null;
		for (Integer id : idsItems) {
			dato =getItem(id);
			entityManager.remove(dato);
		}
		
	}

	@Override
	public SolicitudVacacionesDO save(SolicitudVacacionesDO item) {
		List<ComentarioSolicitudVacacionesDO> comentarios = item.getComentarios();
		item.setComentarios( null ); 
		item.setFechaRegistro(new Date());
		entityManager.persist(item);
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void saveComentarios(SolicitudVacacionesDO item,List<ComentarioSolicitudVacacionesDO> comentarios){
		if( comentarios == null ){
			return;
		}
		for (ComentarioSolicitudVacacionesDO dato : comentarios) {
			entityManager.persist(dato.getComentarioRecursosHumanos());
			dato.setSolicitudVacaciones(item);
			entityManager.persist(dato);
		}
		item.setComentarios(comentarios);
	}
	
	@Override
	public SolicitudVacacionesDO update(SolicitudVacacionesDO item) {
		deleteComentarios(item);
		List<ComentarioSolicitudVacacionesDO> comentarios = item.getComentarios();
		item.setComentarios(null);
		item.setFechaRegistro(new Date());
		entityManager.merge(item);
		saveComentarios(item,comentarios);
		return item;
	}

	private void deleteComentarios(SolicitudVacacionesDO itemParam) {
		SolicitudVacacionesDO SolicitudVacacionesDO = entityManager.find(SolicitudVacacionesDO.class, itemParam.getId());
		if( SolicitudVacacionesDO.getComentarios() != null ){
			for (ComentarioSolicitudVacacionesDO comentario : SolicitudVacacionesDO.getComentarios()) {
				entityManager.remove( comentario );
			}
		}
	}

	@Override
	public SolicitudVacacionesDO getItem(Integer id) {
		SolicitudVacacionesDO dato = entityManager.find(SolicitudVacacionesDO.class,id);
		return dato;
	}

	
}
