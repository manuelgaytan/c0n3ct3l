package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion1DO;
import mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion2DO;
import mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion3DO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.services.IInformacionFacturacionService;

@Stateless(mappedName = "ejb/InformacionFacturacionService")
public class InformacionFacturacionService implements IInformacionFacturacionService{
	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<InformacionFacturacionDO> getAll() {
		List<InformacionFacturacionDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("InformacionFacturacionDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		InformacionFacturacionDO requisicion =null;
		for (Integer id : idsItems) {
			requisicion = entityManager.find(InformacionFacturacionDO.class, id);
			entityManager.remove(requisicion);
		}
	}

	@Override
	public InformacionFacturacionDO save(InformacionFacturacionDO item) {
	
		List<ComentarioInformacionFacturacion3DO> comentarios3 = item.getComentariosInformacionFacturacion3DO();
		List<ComentarioInformacionFacturacion2DO> comentarios2 = item.getComentariosInformacionFacturacion2DO();
		List<ComentarioInformacionFacturacion1DO> comentarios1 = item.getComentariosInformacionFacturacion1DO();
		item.setComentariosInformacionFacturacion1DO(null);
		item.setComentariosInformacionFacturacion2DO(null);
		item.setComentariosInformacionFacturacion3DO(null);
		entityManager.persist(item);
		saveComentarios3(item,comentarios3);
		saveComentarios2(item,comentarios2);
		saveComentarios1(item,comentarios1);
		return item;
	}
	
	private void saveComentarios3(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion3DO> comentarios3){
		
		for (ComentarioInformacionFacturacion3DO dato : comentarios3) {
			dato.setInformacionFacturacion(item);
			entityManager.persist(item);
		}
		
		item.setComentariosInformacionFacturacion3DO(comentarios3);
	}
	
	private void saveComentarios2(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion2DO> comentarios2){
		
		for (ComentarioInformacionFacturacion2DO dato : comentarios2) {
			dato.setInformacionFacturacion(item);
			entityManager.persist(item);
		}
		
		item.setComentariosInformacionFacturacion2DO(comentarios2);
	}

private void saveComentarios1(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion1DO> comentarios1){
		
		for (ComentarioInformacionFacturacion1DO dato : comentarios1) {
			dato.setInformacionFacturacion(item);
			entityManager.persist(item);
		}
		
		item.setComentariosInformacionFacturacion1DO(comentarios1);
	}
	
	@Override
	public InformacionFacturacionDO update(InformacionFacturacionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public InformacionFacturacionDO getItem(Integer id) {
		InformacionFacturacionDO dato=null;
		try {
			 dato = entityManager.find(InformacionFacturacionDO.class, id);
		} catch (Exception e) {
			dato =null;
		}
		
		return dato;
		
	}
	
	
	
	
}
