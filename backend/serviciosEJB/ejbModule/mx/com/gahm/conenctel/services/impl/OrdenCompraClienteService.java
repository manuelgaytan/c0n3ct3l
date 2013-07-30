/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.ComentarioRequisicionDO;
import mx.com.gahm.conenctel.entities.ComentarioValidacionAdministrativaDO;
import mx.com.gahm.conenctel.entities.ComentarioValidacionCostoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.OrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SolicitanteRequisicionDO;
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
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativaDO = dato.getComentarioValidacionAdministrativa();
			entityManager.persist( comentarioValidacionAdministrativaDO );
			dato.setComentarioValidacionAdministrativa( comentarioValidacionAdministrativaDO );
			dato.setOrdenCompraCliente(item);
			entityManager.persist(dato);
		}
	}

	private void saveComentariosOrden(OrdenCompraClienteDO item,List<ComentarioOrdenCompraClienteDO> comentariosOrden){
		if( comentariosOrden == null ){
			return;
		}
		for (ComentarioOrdenCompraClienteDO dato : comentariosOrden) {
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativaDO = dato.getComentarioValidacionAdministrativa();
			entityManager.persist( comentarioValidacionAdministrativaDO );
			dato.setComentarioValidacionAdministrativa( comentarioValidacionAdministrativaDO );
			dato.setOrdenCompraCliente(item);
			entityManager.persist(dato);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public OrdenCompraClienteDO update(OrdenCompraClienteDO item) {
		deleteComentariosValidacionCostoOrdenCompraCliente(item);
		deleteComentariosOrdenCompraCliente(item);
		List<ComentarioValidacionCostoOrdenCompraClienteDO> comentarioValidacionCostoOrdenCompraCliente = item.getComentarioValidacionCostoOrdenCompraCliente();
		List<ComentarioOrdenCompraClienteDO> comentarioOrdenCompraCliente = item.getComentarioOrdenCompraCliente();
		item.setComentarioValidacionCostoOrdenCompraCliente(null);
		item.setComentarioOrdenCompraCliente(null);
		this.colocarOrdenCompraCliente( item );
		entityManager.merge(item);
		saveComentariosValidacion(item,comentarioValidacionCostoOrdenCompraCliente);
		saveComentariosOrden(item,comentarioOrdenCompraCliente);
		item.setComentarioValidacionCostoOrdenCompraCliente(comentarioValidacionCostoOrdenCompraCliente);
		item.setComentarioOrdenCompraCliente(comentarioOrdenCompraCliente);
		return item;
	}

	

	private void colocarOrdenCompraCliente(OrdenCompraClienteDO item) {
		List<ComentarioValidacionCostoOrdenCompraClienteDO> comentarios = item.getComentarioValidacionCostoOrdenCompraCliente();
		if(comentarios!=null){
			for (ComentarioValidacionCostoOrdenCompraClienteDO comentario : comentarios) {
				comentario.setOrdenCompraCliente( item );
			}
		}
		List<ComentarioOrdenCompraClienteDO> comentarios2= item.getComentarioOrdenCompraCliente();
		if(comentarios2!=null){
			for (ComentarioOrdenCompraClienteDO comentario : comentarios2) {
				comentario.setOrdenCompraCliente( item );
			}
		}
	}


	private void deleteComentariosOrdenCompraCliente(OrdenCompraClienteDO itemParam) {
		OrdenCompraClienteDO item = entityManager.find(OrdenCompraClienteDO.class, itemParam.getId());
		if( item == null || item.getComentarioOrdenCompraCliente() == null){
			return;
		}
		for (ComentarioOrdenCompraClienteDO comentario : item.getComentarioOrdenCompraCliente()) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}


	private void deleteComentariosValidacionCostoOrdenCompraCliente(
			OrdenCompraClienteDO itemParam) {
		OrdenCompraClienteDO item = entityManager.find(OrdenCompraClienteDO.class, itemParam.getId());
		if( item == null || item.getComentarioValidacionCostoOrdenCompraCliente() == null){
			return;
		}
		for (ComentarioValidacionCostoOrdenCompraClienteDO comentario : item.getComentarioValidacionCostoOrdenCompraCliente()) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
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
