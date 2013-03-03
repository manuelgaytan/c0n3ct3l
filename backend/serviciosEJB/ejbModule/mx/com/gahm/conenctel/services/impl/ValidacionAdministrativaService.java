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
import mx.com.gahm.conenctel.entities.ComentarioValidacionAdministrativaDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
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
	public ValidacionAdministrativaDO update(ValidacionAdministrativaDO item) {
		this.updateComentarios(item, item.getComentariosPantallaValidacionAdministrativa());
		entityManager.merge(item);
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ValidacionAdministrativaDO getItem(Long id) throws ConectelException {
		ValidacionAdministrativaDO validacionProyecto = entityManager.find(ValidacionAdministrativaDO.class, id);
		if (validacionProyecto == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return validacionProyecto;
	}

	private void saveComentarios(ValidacionAdministrativaDO validacionAdministrativaDO,List<ComentarioPantallaValidacionAdministrativaDO> datos){
		if( datos == null ){
			return;
		}
		for (ComentarioPantallaValidacionAdministrativaDO dato : datos) {
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativaDO = dato.getComentarioValidacionAdministrativa();
			entityManager.persist(comentarioValidacionAdministrativaDO);
			dato.setComentarioValidacionAdministrativa(comentarioValidacionAdministrativaDO);
			dato.setValidacionAdministrativa(validacionAdministrativaDO);
			entityManager.persist(dato);
		}
		
	}
	
	private void updateComentarios(ValidacionAdministrativaDO validacionAdministrativaDO,List<ComentarioPantallaValidacionAdministrativaDO> datos){
		if( datos == null ){
			return;
		}
		for (ComentarioPantallaValidacionAdministrativaDO dato : datos) {
			dato.setValidacionAdministrativa(validacionAdministrativaDO);
		}
	}
}
