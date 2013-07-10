package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioCotizacionDO;
import mx.com.gahm.conenctel.entities.ComentarioProveedorDO;
import mx.com.gahm.conenctel.entities.CotizacionDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;
import mx.com.gahm.conenctel.services.ICotizacionService;

@Stateless(mappedName = "ejb/CotizacionService")
public class CotizacionService implements ICotizacionService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<CotizacionDO> getAll() {
		List<CotizacionDO> datos= null;
		TypedQuery<CotizacionDO>  query =null;
		query = entityManager.createNamedQuery("CotizacionDO.findAll",CotizacionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		for (Integer id : idsItems) {
			CotizacionDO item = new CotizacionDO();
			item.setId(id);
			deleteComentarios(item);
		}
	}

	@Override
	public CotizacionDO save(CotizacionDO item) {
		List<ComentarioCotizacionDO> comentarios= item.getComentariosCotizacion();
		item.setComentariosCotizacion(null);
		entityManager.persist(item);
		item.setComentariosCotizacion(comentarios);
		saveComentarios(item);
		return item;
	}

	private void saveComentarios(CotizacionDO item){
		List<ComentarioCotizacionDO> comentarios = item.getComentariosCotizacion();
		if(comentarios!=null)
		for (ComentarioCotizacionDO comentario : comentarios) {
			entityManager.persist(comentario.getComentarioCompras());
			comentario.setCotizacion(item);
			entityManager.persist(comentario);
		}
	}
	
	private void deleteComentarios(CotizacionDO cotizacion){
		CotizacionDO item = getItem( cotizacion.getId() );
		List<ComentarioCotizacionDO> comentarios= item.getComentariosCotizacion();
		if(comentarios!=null){
			for (ComentarioCotizacionDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}
	
	
	@Override
	public CotizacionDO update(CotizacionDO item) {
		deleteComentarios(item);
		this.colocarCotizacion( item );
		entityManager.merge(item);
		return null;
	}
	
	private void colocarCotizacion(CotizacionDO item){
		List<ComentarioCotizacionDO> comentarios = item.getComentariosCotizacion();
		if(comentarios!=null){
			for (ComentarioCotizacionDO comentario : comentarios) {
				comentario.setCotizacion(item);
			}
		}
	}

	@Override
	public CotizacionDO getItem(Integer id) {
		CotizacionDO cotizacion = entityManager.find(CotizacionDO.class,id);
		return cotizacion;
	}

}
