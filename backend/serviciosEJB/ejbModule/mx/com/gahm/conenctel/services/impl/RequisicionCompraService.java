package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
		
		savePartidas(item.getId(),partidasRequisicionCompra);
		saveComentariosRequisicion(item.getId(), comentariosRequisicion);
		saveSolicitantesRequisicion(item.getId(), solicitantesRequisicion);
		
		return item;
	}

	@Override
	public RequisicionCompraDO update(RequisicionCompraDO item) {
		deletePartidas(item.getPartidasRequisicionCompra());
		savePartidas(item.getId(), item.getPartidasRequisicionCompra());
		
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
	
	private void saveSolicitantesRequisicion(Integer idRequisicionCompra,List<SolicitanteRequisicionDO> datos){
		if( datos == null ){
			return;
		}
		for (SolicitanteRequisicionDO dato : datos) {
			dato.setRequisicionCompra(new RequisicionCompraDO());
			dato.getRequisicionCompra().setId(idRequisicionCompra);
			entityManager.persist(dato);
		}
		
	}
	
	private void saveComentariosRequisicion(Integer idRequisicionCompra,List<ComentarioRequisicionDO> datos){
		if( datos == null ){
			return;
		}
		for (ComentarioRequisicionDO dato : datos) {
			dato.setRequisicionCompra(new RequisicionCompraDO());
			dato.getRequisicionCompra().setId(idRequisicionCompra);
			entityManager.persist(dato);
		}
		
	}
}
