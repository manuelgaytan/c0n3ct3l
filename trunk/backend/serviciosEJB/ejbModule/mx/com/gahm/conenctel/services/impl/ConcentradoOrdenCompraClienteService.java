package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioConcentradoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.ComentarioValidacionAdministrativaDO;
import mx.com.gahm.conenctel.entities.ConcentradoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.entities.PartidaConcentradoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IConcentradoOrdenCompraClienteService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/ConcentradoOrdenCompraClienteService")
public class ConcentradoOrdenCompraClienteService implements IConcentradoOrdenCompraClienteService{
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConcentradoOrdenCompraClienteDO> getAll() throws ConectelException {
		TypedQuery<ConcentradoOrdenCompraClienteDO> query = entityManager.createNamedQuery(
				"ConcentradoOrdenCompraClienteDO.findAll", ConcentradoOrdenCompraClienteDO.class);
		List<ConcentradoOrdenCompraClienteDO> solicitudAlmacenList;
		try {
			solicitudAlmacenList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Solicitud Almacen registrado.");
		}
		return solicitudAlmacenList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			ConcentradoOrdenCompraClienteDO current = entityManager.find(ConcentradoOrdenCompraClienteDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConcentradoOrdenCompraClienteDO save(ConcentradoOrdenCompraClienteDO item) {
		if( item != null ){
			List<ComentarioConcentradoOrdenCompraClienteDO> comentariosValidacion = item.getComentariosConcentradoOrdenCompraCliente();
			List<PartidaConcentradoOrdenCompraClienteDO> partidas = item.getPartidasConcentradoOrdenCompraCliente();
			item.setComentariosConcentradoOrdenCompraCliente(null);
			item.setPartidasConcentradoOrdenCompraCliente(null);
			entityManager.persist(item);
			saveComentariosComentarioConcentradoOrdenCompraCliente(item, comentariosValidacion);
			savePartidasConcentradoOrdenCompraCliente(item, partidas);
		}
		return item;
	}

	private void savePartidasConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO item,
			List<PartidaConcentradoOrdenCompraClienteDO> partidas) {
		if( partidas == null ){
			return;
		}
		for (PartidaConcentradoOrdenCompraClienteDO dato : partidas) {
			dato.setConcentradoOrdenCompraCliente(item);
			entityManager.persist(dato);
		}
	}

	private void saveComentariosComentarioConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO item,
			List<ComentarioConcentradoOrdenCompraClienteDO> comentariosConcentradoOrdenCompraCliente) {
		if( comentariosConcentradoOrdenCompraCliente == null ){
			return;
		}
		for (ComentarioConcentradoOrdenCompraClienteDO dato : comentariosConcentradoOrdenCompraCliente) {
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativaDO = dato.getComentarioValidacionAdministrativa();
			entityManager.persist( comentarioValidacionAdministrativaDO );
			dato.setComentarioValidacionAdministrativa( comentarioValidacionAdministrativaDO );
			dato.setConcentradoOrdenCompraCliente(item);
			entityManager.persist(dato);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConcentradoOrdenCompraClienteDO update(ConcentradoOrdenCompraClienteDO item) {
		deleteConcentradoOrdenCompraCliente(item);
		deletePartidasConcentradoOrdenCompraCliente(item);
		List<ComentarioConcentradoOrdenCompraClienteDO> comentariosConcentradoOrdenCompraCliente = item.getComentariosConcentradoOrdenCompraCliente();
		List<PartidaConcentradoOrdenCompraClienteDO> partidas = item.getPartidasConcentradoOrdenCompraCliente();
		item.setComentariosConcentradoOrdenCompraCliente(null);
		item.setPartidasConcentradoOrdenCompraCliente(null);
		this.colocarConcentradoOrdenCompraCliente( item );
		entityManager.merge(item);
		saveComentariosComentarioConcentradoOrdenCompraCliente(item, comentariosConcentradoOrdenCompraCliente);
		savePartidasConcentradoOrdenCompraCliente(item, partidas);
		item.setComentariosConcentradoOrdenCompraCliente(comentariosConcentradoOrdenCompraCliente);
		item.setPartidasConcentradoOrdenCompraCliente(partidas);
		return item;
	}

	
	private void colocarConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO item) {
		List<ComentarioConcentradoOrdenCompraClienteDO> comentarios = item.getComentariosConcentradoOrdenCompraCliente();
		if(comentarios!=null){
			for (ComentarioConcentradoOrdenCompraClienteDO comentario : comentarios) {
				comentario.setConcentradoOrdenCompraCliente( item );
			}
		}
		List<PartidaConcentradoOrdenCompraClienteDO> partidas= item.getPartidasConcentradoOrdenCompraCliente();
		if(partidas!=null){
			for (PartidaConcentradoOrdenCompraClienteDO partida : partidas) {
				partida.setConcentradoOrdenCompraCliente( item );
			}
		}
	}

	private void deletePartidasConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO itemParam) {
		ConcentradoOrdenCompraClienteDO item = entityManager.find(ConcentradoOrdenCompraClienteDO.class, itemParam.getId());
		if( item == null || item.getPartidasConcentradoOrdenCompraCliente() == null){
			return;
		}
		for (PartidaConcentradoOrdenCompraClienteDO partida : item.getPartidasConcentradoOrdenCompraCliente()) {
			if(partida!=null){
				entityManager.remove(partida);
			}
		}
	}

	private void deleteConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO itemParam) {
		ConcentradoOrdenCompraClienteDO item = entityManager.find(ConcentradoOrdenCompraClienteDO.class, itemParam.getId());
		if( item == null || item.getComentariosConcentradoOrdenCompraCliente() == null){
			return;
		}
		for (ComentarioConcentradoOrdenCompraClienteDO comentario : item.getComentariosConcentradoOrdenCompraCliente()) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ConcentradoOrdenCompraClienteDO getItem(Long id) throws ConectelException {
		ConcentradoOrdenCompraClienteDO solicitudAlmacen = entityManager.find(ConcentradoOrdenCompraClienteDO.class, id);
		if (solicitudAlmacen == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return solicitudAlmacen;
	}


}
