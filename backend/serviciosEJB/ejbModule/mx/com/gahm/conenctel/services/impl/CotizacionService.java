package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioCotizacionDO;
import mx.com.gahm.conenctel.entities.CotizacionDO;
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
			deletecomentarios(id);
		}
		
	}

	@Override
	public CotizacionDO save(CotizacionDO item) {
		
		List<ComentarioCotizacionDO> comentarios= item.getComentariosCotizacion();
		if(comentarios!=null){
			savecomentarios(item ,comentarios);
		}
		
		
		entityManager.persist(item);
		return item;
	}

	private void savecomentarios(CotizacionDO item ,List<ComentarioCotizacionDO> comentarios){
		for (ComentarioCotizacionDO comentario : comentarios) {
			entityManager.persist(comentario.getComentarioCompras());
			comentario.setCotizacion(item);
		}
	}
	
	private void deletecomentarios(Integer id){
		CotizacionDO item = getItem(id);
		List<ComentarioCotizacionDO> comentarios= item.getComentariosCotizacion();
		
		for (ComentarioCotizacionDO comentario : comentarios) {
			entityManager.remove(comentario);
			entityManager.remove(comentario.getComentarioCompras());
		}
	}
	
	
	@Override
	public CotizacionDO update(CotizacionDO item) {
		deletecomentarios(item.getId());
		List<ComentarioCotizacionDO> comentarios= item.getComentariosCotizacion();
		if(comentarios!=null){
			savecomentarios(item ,comentarios);
		}
		entityManager.merge(item);
		return item;
	}

	@Override
	public CotizacionDO getItem(Integer id) {
		CotizacionDO cotizacion = entityManager.find(CotizacionDO.class,id);
		return cotizacion;
	}

}
