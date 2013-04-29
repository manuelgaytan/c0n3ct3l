package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.MaterialDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IAlmacenUtilService;
import mx.com.gahm.conenctel.services.IMaterialService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/MaterialService")
public class MaterialService implements IMaterialService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@EJB(mappedName="ejb/AlmacenUtilService")
	private IAlmacenUtilService almacenUtilService; 
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MaterialDO> getAll() throws ConectelException {
		TypedQuery<MaterialDO> query = entityManager.createNamedQuery(
				"MaterialDO.findAll", MaterialDO.class);
		List<MaterialDO> materialList;
		try {
			materialList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Materiales registrados.");
		}
		return materialList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			MaterialDO current = entityManager.find(MaterialDO.class, id);
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
	public MaterialDO save(MaterialDO item) {
		entityManager.persist(item);
		entityManager.flush();
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_EQUIPO_TRANSPORTE);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public MaterialDO update(MaterialDO item) {
		try {
			almacenUtilService.deleteComentarios(item.getId(),TipoAlmacenDO.ID_MATERIALES);
		} catch (ConectelException e) {
			e.printStackTrace();
		}
		
		entityManager.merge(item);
		almacenUtilService.saveComentarios(item.getComentarios(), item.getId(),TipoAlmacenDO.ID_MATERIALES);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public MaterialDO getItem(Long id) throws ConectelException {
		MaterialDO material = entityManager.find(MaterialDO.class, id);
		List<ComentariosDO> comentarios=null;
		if (material == null) {
			throw new ConectelException("El Material no existe");
		}
		
		comentarios = almacenUtilService.getAllComentariosById(material.getId(),TipoAlmacenDO.ID_MATERIALES);
		material.setComentarios(comentarios);
		return material;
	}

}
