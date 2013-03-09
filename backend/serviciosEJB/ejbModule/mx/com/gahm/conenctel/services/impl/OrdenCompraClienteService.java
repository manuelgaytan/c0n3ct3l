/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.ComentarioValidacionCostoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.OrdenCompraClienteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IOrdenCompraClienteService;

/**
 * @author GUILLERMOH
 *
 */
@Stateless(mappedName = "ejb/OrdenCompraClienteService")
public class OrdenCompraClienteService implements IOrdenCompraClienteService{

	@Inject
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<OrdenCompraClienteDO> getAll() throws ConectelException {
		TypedQuery<OrdenCompraClienteDO> query = entityManager.createNamedQuery(
				"OrdenCompraClienteDO.findAll", OrdenCompraClienteDO.class);
		List<OrdenCompraClienteDO> datos;
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existe Solicitud Almacen registrado.");
		}
		return datos;
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public OrdenCompraClienteDO save(OrdenCompraClienteDO item) {
		
		
		if(item!=null){
			List<ComentarioValidacionCostoOrdenCompraClienteDO> comentariosValidacion=item.getComentarioValidacionCostoOrdenCompraCliente();
			List<ComentarioOrdenCompraClienteDO> comentatiosOrden =item.getComentarioOrdenCompraCliente();
			
			item.setComentarioOrdenCompraCliente(null);
			item.setComentarioValidacionCostoOrdenCompraCliente(null);
			entityManager.persist(item);
			saveComentariosValidacion(item,comentariosValidacion);
			saveComentariosOrden(item,comentatiosOrden);
			
		}
		
		
		return item;
	}
	
	private void saveComentariosValidacion(OrdenCompraClienteDO item,List<ComentarioValidacionCostoOrdenCompraClienteDO> comentariosValidacion){
		if( comentariosValidacion == null ){
			return;
		}
		for (ComentarioValidacionCostoOrdenCompraClienteDO dato : comentariosValidacion) {
			dato.setOrdenCompraCliente(item);
			entityManager.persist(dato);
			
		}
		item.setComentarioValidacionCostoOrdenCompraCliente(comentariosValidacion);
	}

	private void saveComentariosOrden(OrdenCompraClienteDO item,List<ComentarioOrdenCompraClienteDO> comentatiosOrden){
		if( comentatiosOrden == null ){
			return;
		}
		for (ComentarioOrdenCompraClienteDO dato : comentatiosOrden) {
			
			dato.setOrdenCompraCliente(item);
			entityManager.persist(dato);
		}
		item.setComentarioOrdenCompraCliente(comentatiosOrden);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public OrdenCompraClienteDO update(OrdenCompraClienteDO item) {
		entityManager.merge(item);
		return item;
	}

	

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public OrdenCompraClienteDO getItem(Long id) throws ConectelException {
		OrdenCompraClienteDO dato = entityManager.find(
				OrdenCompraClienteDO.class, id);
		if (dato == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return dato;
	}

	@Override
	public boolean deleteItems(List<Long> idsItems) {
		boolean response = true;
		for (Long id : idsItems) {
			OrdenCompraClienteDO current = entityManager.find(
					OrdenCompraClienteDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

}
