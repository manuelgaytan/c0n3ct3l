package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.services.IRequisicionCompraService;

@Stateless(mappedName = "ejb/RequisicionCompraService")
public class RequisicionCompraService  implements IRequisicionCompraService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<RequisicionCompraDO> getAll() {
		List<RequisicionCompraDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("RequisicionCompraDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		RequisicionCompraDO requisicion =null;
		for (Integer id : idsItems) {
			requisicion = entityManager.find(RequisicionCompraDO.class, id);
			deletePartidas(requisicion.getPartidasReqisicionCompra());
			entityManager.remove(requisicion);
		}
	}

	@Override
	public RequisicionCompraDO save(RequisicionCompraDO item) {
		entityManager.persist(item);
		savePartidas(item.getId(), item.getPartidasReqisicionCompra());
		return item;
	}

	@Override
	public RequisicionCompraDO update(RequisicionCompraDO item) {
		deletePartidas(item.getPartidasReqisicionCompra());
		savePartidas(item.getId(), item.getPartidasReqisicionCompra());
		
		return item;
	}

	@Override
	public RequisicionCompraDO getItem(Integer id) {
		RequisicionCompraDO dato=null;
		try {
			 dato = entityManager.find(RequisicionCompraDO.class, id);
		} catch (Exception e) {
			dato =null;
		}
		
		return dato;
		
	}
	
	
	private void deletePartidas(List<PartidaRequisicionCompraDO> partidas){
		PartidaRequisicionCompraDO partidaDO =null;
		for (PartidaRequisicionCompraDO partida : partidas) {
			partidaDO = entityManager.find(PartidaRequisicionCompraDO.class, partida.getId());
			if(partidaDO!=null){
				entityManager.remove(partidaDO);
			}
		}
		 
	}
	
	private void savePartidas(Integer idRequisicionCompra,List<PartidaRequisicionCompraDO> partidas){
		if( partidas == null ){
			return;
		}
		for (PartidaRequisicionCompraDO partida : partidas) {
			partida.setRequisicionCompra(new RequisicionCompraDO());
			partida.getRequisicionCompra().setId(idRequisicionCompra);
			entityManager.persist(partida);
		}
		
	}
	
}
