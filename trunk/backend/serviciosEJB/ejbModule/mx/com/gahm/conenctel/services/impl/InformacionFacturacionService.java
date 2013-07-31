package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioCuentasPagarFacturacionDO;
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
		List<ComentarioInformacionFacturacion3DO> comentarios3 = item.getComentariosInformacionFacturacion3();
		List<ComentarioInformacionFacturacion2DO> comentarios2 = item.getComentariosInformacionFacturacion2();
		List<ComentarioInformacionFacturacion1DO> comentarios1 = item.getComentariosInformacionFacturacion1();
		item.setComentariosInformacionFacturacion1(null);
		item.setComentariosInformacionFacturacion2(null);
		item.setComentariosInformacionFacturacion3(null);
		entityManager.persist(item);
		saveComentarios3(item,comentarios3);
		saveComentarios2(item,comentarios2);
		saveComentarios1(item,comentarios1);
		return item;
	}
	
	private void saveComentarios3(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion3DO> comentarios3){
		if( comentarios3 == null ){
			return;
		}
		for (ComentarioInformacionFacturacion3DO dato : comentarios3) {
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion = dato.getComentarioCuentasPagarFacturacion();
			entityManager.persist( comentarioCuentasPagarFacturacion );
			dato.setComentarioCuentasPagarFacturacion( comentarioCuentasPagarFacturacion );
			dato.setInformacionFacturacion( item );
			entityManager.persist(dato);
		}
		item.setComentariosInformacionFacturacion3(comentarios3);
	}
	
	private void saveComentarios2(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion2DO> comentarios2){
		if( comentarios2 == null ){
			return;
		}
		for (ComentarioInformacionFacturacion2DO dato : comentarios2) {
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion = dato.getComentarioCuentasPagarFacturacion();
			entityManager.persist( comentarioCuentasPagarFacturacion );
			dato.setComentarioCuentasPagarFacturacion( comentarioCuentasPagarFacturacion );
			dato.setInformacionFacturacion( item );
			entityManager.persist(dato);
		}
		
		item.setComentariosInformacionFacturacion2(comentarios2);
	}

private void saveComentarios1(InformacionFacturacionDO item,List<ComentarioInformacionFacturacion1DO> comentarios1){
		if( comentarios1 == null ){
			return;
		}
		for (ComentarioInformacionFacturacion1DO dato : comentarios1) {
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion = dato.getComentarioCuentasPagarFacturacion();
			entityManager.persist( comentarioCuentasPagarFacturacion );
			dato.setComentarioCuentasPagarFacturacion( comentarioCuentasPagarFacturacion );
			dato.setInformacionFacturacion( item );
			entityManager.persist(dato);
		}
		
		item.setComentariosInformacionFacturacion1(comentarios1);
	}
	
	@Override
	public InformacionFacturacionDO update(InformacionFacturacionDO item) {
		deleteComentariosInformacionFacturacion1(item);
		deleteComentariosInformacionFacturacion2(item);
		deleteComentariosInformacionFacturacion3(item);
		List<ComentarioInformacionFacturacion3DO> comentarios3 = item.getComentariosInformacionFacturacion3();
		List<ComentarioInformacionFacturacion2DO> comentarios2 = item.getComentariosInformacionFacturacion2();
		List<ComentarioInformacionFacturacion1DO> comentarios1 = item.getComentariosInformacionFacturacion1();
		item.setComentariosInformacionFacturacion1(null);
		item.setComentariosInformacionFacturacion2(null);
		item.setComentariosInformacionFacturacion3(null);
		entityManager.merge(item);
		saveComentarios3(item,comentarios3);
		saveComentarios2(item,comentarios2);
		saveComentarios1(item,comentarios1);
		return item;
	}

	private void deleteComentariosInformacionFacturacion1(
			InformacionFacturacionDO itemParam) {
		InformacionFacturacionDO item = entityManager.find(InformacionFacturacionDO.class, itemParam.getId());
		if( item == null || item.getComentariosInformacionFacturacion1() == null){
			return;
		}
		for ( ComentarioInformacionFacturacion1DO comentario : item.getComentariosInformacionFacturacion1() ) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}
	
	private void deleteComentariosInformacionFacturacion2(
			InformacionFacturacionDO itemParam) {
		InformacionFacturacionDO item = entityManager.find(InformacionFacturacionDO.class, itemParam.getId());
		if( item == null || item.getComentariosInformacionFacturacion2() == null){
			return;
		}
		for ( ComentarioInformacionFacturacion2DO comentario : item.getComentariosInformacionFacturacion2() ) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}
	
	private void deleteComentariosInformacionFacturacion3(
			InformacionFacturacionDO itemParam) {
		InformacionFacturacionDO item = entityManager.find(InformacionFacturacionDO.class, itemParam.getId());
		if( item == null || item.getComentariosInformacionFacturacion3() == null){
			return;
		}
		for ( ComentarioInformacionFacturacion3DO comentario : item.getComentariosInformacionFacturacion3() ) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
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
	
	@Override
	public List<InformacionFacturacionDO> getAllByFiltro(Integer idCliente){
		List<InformacionFacturacionDO> datos = null;
		TypedQuery<InformacionFacturacionDO>  query =null;
		query = entityManager.createNamedQuery("InformacionFacturacionDO.NotasCrediByCliente",InformacionFacturacionDO.class);
		query.setParameter("idCliente", idCliente);
		datos = query.getResultList();

		return datos;
	}
	
	
}
