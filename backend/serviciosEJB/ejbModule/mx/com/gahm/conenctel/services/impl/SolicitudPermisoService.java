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
import mx.com.gahm.conenctel.entities.ComentarioSolicitudPermisoDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;
import mx.com.gahm.conenctel.entities.SolicitudPermisoDO;
import mx.com.gahm.conenctel.services.ICobranzaService;
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
