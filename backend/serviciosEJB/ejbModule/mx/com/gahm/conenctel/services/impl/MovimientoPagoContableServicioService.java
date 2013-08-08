/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioMovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.entities.MovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.services.IMovimientoPagoContableServicioService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/MovimientoPagoContableServicioService")
public class MovimientoPagoContableServicioService implements IMovimientoPagoContableServicioService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<MovimientoPagoContableServicioDO> getAll() {
		List<MovimientoPagoContableServicioDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("MovimientoPagoContableServicioDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		MovimientoPagoContableServicioDO MovimientoPagoContableServicioDO = null;
		for (Integer id : idsItems) {
			MovimientoPagoContableServicioDO = entityManager.find(
					MovimientoPagoContableServicioDO.class, id);

			if (MovimientoPagoContableServicioDO != null) {
				entityManager.remove(MovimientoPagoContableServicioDO);
			}
		}

	}

	@Override
	public MovimientoPagoContableServicioDO save(MovimientoPagoContableServicioDO item) {
		try {
			List<ComentarioMovimientoPagoContableServicioDO> comentarios =item.getComentarios();
			item.setComentarios(null);
			entityManager.persist(item);
			saveComentarios(item,comentarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	
	private void saveComentarios(MovimientoPagoContableServicioDO item,List<ComentarioMovimientoPagoContableServicioDO> comentarios){
		if( comentarios != null ){
			for (ComentarioMovimientoPagoContableServicioDO comentario : comentarios) {
				entityManager.persist(comentario.getComentarioContabilidad());
				comentario.setMovimientoPagoContableServicio(item);
				entityManager.persist(comentario);
			}
		}
		item.setComentarios(comentarios);
	}
	
	@Override
	public MovimientoPagoContableServicioDO update(MovimientoPagoContableServicioDO item) {
		deleteComentarios(item.getId());
		List<ComentarioMovimientoPagoContableServicioDO> comentarios =item.getComentarios();
		item.setComentarios(null);
		entityManager.merge(item);
		saveComentarios(item, comentarios);
		return item;
	}

	
	private void deleteComentarios(Integer id){
		MovimientoPagoContableServicioDO item = getItem(id);
		List<ComentarioMovimientoPagoContableServicioDO> comentarios = item.getComentarios();
		if( comentarios != null ){
			for (ComentarioMovimientoPagoContableServicioDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}
	
	@Override
	public MovimientoPagoContableServicioDO getItem(Integer id) {
		MovimientoPagoContableServicioDO MovimientoPagoContableServicioDO = null;
		try {
			MovimientoPagoContableServicioDO = entityManager.find(
					MovimientoPagoContableServicioDO.class, id);
		} catch (Exception e) {
			MovimientoPagoContableServicioDO = null;
		}
		return MovimientoPagoContableServicioDO;
	}
}
