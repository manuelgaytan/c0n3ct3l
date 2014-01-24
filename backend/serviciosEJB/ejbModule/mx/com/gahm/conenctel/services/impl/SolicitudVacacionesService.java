/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.CobranzaDO;
import mx.com.gahm.conenctel.entities.ComentarioCobranzaDO;
import mx.com.gahm.conenctel.entities.ComentarioSolicitudVacacionesDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;
import mx.com.gahm.conenctel.entities.SolicitudVacacionesDO;
import mx.com.gahm.conenctel.services.ICobranzaService;
import mx.com.gahm.conenctel.services.ISolicitudPermisoService;
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
