package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ProyectoPadreDO;
import mx.com.gahm.conenctel.entities.ProyectoPadreHijoDO;
import mx.com.gahm.conenctel.services.IProyectoPadreService;

@Stateless(mappedName = "ejb/ProyectoPadreService")
public class ProyectoPadreService implements IProyectoPadreService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<ProyectoPadreDO> getAll() {
		
		List<ProyectoPadreDO> datos= null;
		TypedQuery<ProyectoPadreDO>  query =null;
		query = entityManager.createNamedQuery("ProyectoPadreDO.findAll",ProyectoPadreDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ProyectoPadreDO proyecto = null;
		for (Integer id : idsItems) {
			proyecto =getItem(id);
			entityManager.remove(proyecto);
		}
		
	}

	@Override
	public ProyectoPadreDO save(ProyectoPadreDO item) {
		entityManager.persist(item);
		
		return item;
	}

	@Override
	public ProyectoPadreDO update(ProyectoPadreDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public ProyectoPadreDO getItem(Integer id) {
		ProyectoPadreDO proyecto = entityManager.find(ProyectoPadreDO.class,id);
		return proyecto;
	}

	@Override
	public ProyectoPadreHijoDO getItemHijo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
