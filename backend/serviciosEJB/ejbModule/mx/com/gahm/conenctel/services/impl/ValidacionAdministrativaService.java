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

import mx.com.gahm.conenctel.entities.ComentarioComprasDO;
import mx.com.gahm.conenctel.entities.ComentarioPantallaValidacionAdministrativaDO;
import mx.com.gahm.conenctel.entities.ComentarioRequisicionDO;
import mx.com.gahm.conenctel.entities.ComentarioSugerenciaDO;
import mx.com.gahm.conenctel.entities.ComentarioValidacionAdministrativaDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SugerenciaDO;
import mx.com.gahm.conenctel.entities.ValidacionAdministrativaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IValidacionAdministrativaService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/ValidacionAdministrativaService")
public class ValidacionAdministrativaService implements IValidacionAdministrativaService{

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ValidacionAdministrativaDO> getAll() throws ConectelException {
		TypedQuery<ValidacionAdministrativaDO> query = entityManager.createNamedQuery(
				"ValidacionAdministrativaDO.findAll", ValidacionAdministrativaDO.class);
		List<ValidacionAdministrativaDO> solicitudAlmacenList;
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
			ValidacionAdministrativaDO current = entityManager.find(ValidacionAdministrativaDO.class, id);
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
	public ValidacionAdministrativaDO save(ValidacionAdministrativaDO item) {
		if (item != null) 
		entityManager.persist(item);
	
		this.saveComentarios(item, item.getComentariosPantallaValidacionAdministrativa());
		
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ValidacionAdministrativaDO update(ValidacionAdministrativaDO item) throws ConectelException {
		deleteComentarios(item.getId());
		List<ComentarioPantallaValidacionAdministrativaDO> comentarios = item.getComentariosPantallaValidacionAdministrativa();
		item.setComentariosPantallaValidacionAdministrativa(null);
		entityManager.merge(item);
		saveComentarios(item, comentarios);
		return item;
	}
	
	private void deleteComentarios(Long id) throws ConectelException{
		ValidacionAdministrativaDO item = getItem(id);
		List<ComentarioPantallaValidacionAdministrativaDO> comentarios = item.getComentariosPantallaValidacionAdministrativa();
		if( comentarios != null ){
			for (ComentarioPantallaValidacionAdministrativaDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}

	private void saveComentarios(ValidacionAdministrativaDO item,List<ComentarioPantallaValidacionAdministrativaDO> comentarios){
		if( comentarios != null ){
			for (ComentarioPantallaValidacionAdministrativaDO comentario : comentarios) {
				entityManager.persist(comentario.getComentarioValidacionAdministrativa());
				comentario.setValidacionAdministrativa(item);
				entityManager.persist(comentario);
			}
		}
		item.setComentariosPantallaValidacionAdministrativa(comentarios);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ValidacionAdministrativaDO getItem(Long id) throws ConectelException {
		ValidacionAdministrativaDO validacionProyecto = entityManager.find(ValidacionAdministrativaDO.class, id);
		if (validacionProyecto == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return validacionProyecto;
	}
}
