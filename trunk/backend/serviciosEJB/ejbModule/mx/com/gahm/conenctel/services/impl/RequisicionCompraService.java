package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioComprasDO;
import mx.com.gahm.conenctel.entities.ComentarioRequisicionDO;
import mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SolicitanteRequisicionDO;
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
			deletePartidas(requisicion.getPartidasRequisicionCompra());
			entityManager.remove(requisicion);
		}
	}

	@Override
	public RequisicionCompraDO save(RequisicionCompraDO item) {
		List<SolicitanteRequisicionDO> solicitantesRequisicion = item.getSolicitanteRequisicion();
		List<PartidaRequisicionCompraDO> partidasRequisicionCompra = item.getPartidasRequisicionCompra();
		List<ComentarioRequisicionDO> comentariosRequisicion = item.getComentariosRequisicion();
		item.setSolicitantesRequisicion(null);
		item.setPartidasRequisicionCompra(null);
		item.setComentariosRequisicion(null);

		entityManager.persist(item);
		
		savePartidas(item,partidasRequisicionCompra);
		saveComentariosRequisicion(item, comentariosRequisicion);
		saveSolicitantesRequisicion(item, solicitantesRequisicion);
		item.setSolicitantesRequisicion(solicitantesRequisicion);
		item.setPartidasRequisicionCompra(partidasRequisicionCompra);
		item.setComentariosRequisicion(comentariosRequisicion);
		return item;
	}

	@Override
	public RequisicionCompraDO update(RequisicionCompraDO item) {
		deletePartidas(item.getPartidasRequisicionCompra());
		savePartidas(item, item.getPartidasRequisicionCompra());
		
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
		if( partidas == null ){
			return;
		}
		PartidaRequisicionCompraDO partidaDO =null;
		for (PartidaRequisicionCompraDO partida : partidas) {
			partidaDO = entityManager.find(PartidaRequisicionCompraDO.class, partida.getId());
			if(partidaDO!=null){
				entityManager.remove(partidaDO);
			}
		}
		 
	}
	
	private void savePartidas(RequisicionCompraDO requisicionCompra,List<PartidaRequisicionCompraDO> partidas){
		if( partidas == null ){
			return;
		}
		for (PartidaRequisicionCompraDO partida : partidas) {
			partida.setRequisicionCompra(requisicionCompra);
			entityManager.persist(partida);
		}
		
	}
	
	private void saveSolicitantesRequisicion(RequisicionCompraDO requisicionCompra,List<SolicitanteRequisicionDO> datos){
		if( datos == null ){
			return;
		}
		for (SolicitanteRequisicionDO dato : datos) {
			dato.setRequisicionCompra(requisicionCompra);
			entityManager.persist(dato);
		}
		
	}
	
	private void saveComentariosRequisicion(RequisicionCompraDO requisicionCompra,List<ComentarioRequisicionDO> datos){
		if( datos == null ){
			return;
		}
		for (ComentarioRequisicionDO dato : datos) {
			ComentarioComprasDO comentarioComprasDO = dato.getComentarioCompras();
			entityManager.persist(comentarioComprasDO);
			dato.setComentarioCompras(comentarioComprasDO);
			dato.setRequisicionCompra(requisicionCompra);
			entityManager.persist(dato);
		}
		
	}
}
