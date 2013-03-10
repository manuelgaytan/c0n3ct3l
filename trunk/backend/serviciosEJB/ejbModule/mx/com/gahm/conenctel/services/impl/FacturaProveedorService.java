/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioFacturaProveedorDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.services.IFacturaProveedorService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/FacturaProveedorService")
public class FacturaProveedorService implements  IFacturaProveedorService{

	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaProveedorDO> getAll() {
		List<FacturaProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("FacturaProveedorDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		FacturaProveedorDO FacturaProveedorDO=null;
		for (Integer id : idsItems) {
			 FacturaProveedorDO = entityManager.find(FacturaProveedorDO.class, id);
			
			
			if(FacturaProveedorDO!=null){
				entityManager.remove(FacturaProveedorDO);
			}
		}
		
	}

	@Override
	public FacturaProveedorDO save(FacturaProveedorDO item) {
	    try {
	    	
	    	List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor = item.getComentariosFacturaProveedor();
	    	item.setComentariosFacturaProveedor(null);
	    	entityManager.persist(item);
	    	saveComentarios(item,comentariosFacturaProveedor);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return item;
	}
	
	private void saveComentarios(FacturaProveedorDO item,List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor) {
	    try {
	    	
	    	for (ComentarioFacturaProveedorDO dato : comentariosFacturaProveedor) {
	    		dato.setFacturaProveedor(item);
	    		entityManager.persist(item);
			}
	    	
	    	item.setComentariosFacturaProveedor(comentariosFacturaProveedor);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	@Override
	public FacturaProveedorDO update(FacturaProveedorDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public FacturaProveedorDO getItem(Integer id) {
		FacturaProveedorDO FacturaProveedorDO=null;
		try {
			FacturaProveedorDO = entityManager.find(FacturaProveedorDO.class, id);
		} catch (Exception e) {
			FacturaProveedorDO =null;
		}
		
		return FacturaProveedorDO;
	}
}
