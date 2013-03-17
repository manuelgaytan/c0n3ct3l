/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioCuentasPagarFacturacionDO;
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

						entityManager.persist(item);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public MovimientoPagoContableServicioDO update(MovimientoPagoContableServicioDO item) {
		entityManager.merge(item);

		return item;
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
