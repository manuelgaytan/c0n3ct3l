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
		// TODO
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConcentradoOrdenCompraClienteDO save(ConcentradoOrdenCompraClienteDO item) {
		
		entityManager.persist(item);
		
		List<ComentarioConcentradoOrdenCompraClienteDO> comentarios =item.getComentariosConcentradoOrdenCompraCliente();
		for (ComentarioConcentradoOrdenCompraClienteDO comentario : comentarios) {
			comentario.setConcentradoOrdenCompraCliente(item);
			entityManager.persist(comentario);
		}
		List<PartidaConcentradoOrdenCompraClienteDO> partidas= item.getPartidasConcentradoOrdenCompraCliente();
		
		for (PartidaConcentradoOrdenCompraClienteDO partida : partidas) {
			partida.setConcentradoOrdenCompraCliente(item);
			entityManager.persist(partida);
		}
			return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConcentradoOrdenCompraClienteDO update(ConcentradoOrdenCompraClienteDO item) {
		entityManager.merge(item);
		return item;
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
