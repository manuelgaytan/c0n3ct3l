package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioComprasDO;
import mx.com.gahm.conenctel.entities.ComentarioRequisicionDO;
import mx.com.gahm.conenctel.entities.DocumentoLiderProveedorMaquiladorDO;
import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SolicitanteRequisicionDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
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
			this.deleteComentariosRequisicion(requisicion);
			this.deleteSolicitantesRequisicion(requisicion);
			this.deletePartidas(requisicion);
			entityManager.remove(requisicion);
		}
	}

	@Override
	public RequisicionCompraDO save(RequisicionCompraDO item) {
		Date fechaActual = new Date();
		List<SolicitanteRequisicionDO> solicitantesRequisicion = item.getSolicitantesRequisicion();
		List<PartidaRequisicionCompraDO> partidasRequisicionCompra = item.getPartidasRequisicionCompra();
		List<ComentarioRequisicionDO> comentariosRequisicion = item.getComentariosRequisicion();
		item.setSolicitantesRequisicion(null);
		item.setPartidasRequisicionCompra(null);
		item.setComentariosRequisicion(null);
		item.setFechaSolicitud( fechaActual );
		item.setFechaEstatusRequisicion( fechaActual );
		entityManager.persist(item);
		savePartidas(item,partidasRequisicionCompra);
		saveComentariosRequisicion(item, comentariosRequisicion);
		saveSolicitantesRequisicion(item, solicitantesRequisicion);
		item.setSolicitantesRequisicion(solicitantesRequisicion);
		item.setPartidasRequisicionCompra(partidasRequisicionCompra);
		item.setComentariosRequisicion(comentariosRequisicion);
		
		this.validarEnvioNotificaciones(item);
		return item;
	}
	
	private void validarEnvioNotificaciones(RequisicionCompraDO item) {
		if( item == null ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.REQUISICION_COMPRA_CREACION + item.getId();
		this.enviarNotificacion(PerfilDO.ID_COMPRAS, mensaje);
	}
	
	private void enviarNotificacion(int idPerfil, String mensaje) {
		PerfilDO perfil = entityManager.find(PerfilDO.class, idPerfil);
		UsuarioDO usuario = entityManager.find(UsuarioDO.class, UsuarioDO.ID_AUTOMATICO);
		EstadoNotificacionDO estado = entityManager.find(EstadoNotificacionDO.class, EstadoNotificacionDO.ID_PENDIENTE);
		NotificacionDO notificacion = new NotificacionDO();
		notificacion.setPerfil(perfil);
		notificacion.setNotificacion(mensaje);
		notificacion.setUsuarioCreacion(usuario);
		notificacion.setFechaHoraCreacion(new Date());
		notificacion.setEstado(estado);
		entityManager.persist(notificacion);
	}

	@Override
	public RequisicionCompraDO update(RequisicionCompraDO item) {
		item.setFechaEstatusRequisicion(new Date());
		deleteSolicitantesRequisicion(item);
		deletePartidas(item);
		deleteComentariosRequisicion(item);
		List<SolicitanteRequisicionDO> solicitantesRequisicion = item.getSolicitantesRequisicion();
		List<PartidaRequisicionCompraDO> partidasRequisicionCompra = item.getPartidasRequisicionCompra();
		List<ComentarioRequisicionDO> comentariosRequisicion = item.getComentariosRequisicion();
		item.setSolicitantesRequisicion(null);
		item.setPartidasRequisicionCompra(null);
		item.setComentariosRequisicion(null);
		this.colocarRequisicionCompra( item );
		
		entityManager.merge(item);
		
		savePartidas(item,partidasRequisicionCompra);
		saveComentariosRequisicion(item, comentariosRequisicion);
		saveSolicitantesRequisicion(item, solicitantesRequisicion);
		item.setSolicitantesRequisicion(solicitantesRequisicion);
		item.setPartidasRequisicionCompra(partidasRequisicionCompra);
		item.setComentariosRequisicion(comentariosRequisicion);
		return item;
	}

	private void colocarRequisicionCompra(RequisicionCompraDO requisicionCompra){
		List<PartidaRequisicionCompraDO> partidas = requisicionCompra.getPartidasRequisicionCompra();
		if(partidas!=null){
			for (PartidaRequisicionCompraDO partida : partidas) {
				partida.setRequisicionCompra( requisicionCompra );
			}
		}
		List<ComentarioRequisicionDO> comentarios = requisicionCompra.getComentariosRequisicion();
		if(comentarios!=null){
			for (ComentarioRequisicionDO comentario : comentarios) {
				comentario.setRequisicionCompra( requisicionCompra );
			}
		}
		List<SolicitanteRequisicionDO> solicitantes = requisicionCompra.getSolicitantesRequisicion();
		if(solicitantes!=null){
			for (SolicitanteRequisicionDO solicitante : solicitantes) {
				solicitante.setRequisicionCompra( requisicionCompra );
			}
		}
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
	
	private void deleteSolicitantesRequisicion(RequisicionCompraDO requisicionCompra ){
		RequisicionCompraDO item = entityManager.find(RequisicionCompraDO.class, requisicionCompra.getId());
		if( item == null || item.getSolicitantesRequisicion() == null){
			return;
		}
		for (SolicitanteRequisicionDO solicitante : item.getSolicitantesRequisicion()) {
			if(solicitante!=null){
				entityManager.remove(solicitante);
			}
		}
	}
	
	private void deleteComentariosRequisicion(RequisicionCompraDO requisicionCompra ){
		RequisicionCompraDO item = entityManager.find(RequisicionCompraDO.class, requisicionCompra.getId());
		if( item == null || item.getComentariosRequisicion() == null){
			return;
		}
		for (ComentarioRequisicionDO comentario : item.getComentariosRequisicion()) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}
	
	private void deletePartidas(RequisicionCompraDO requisicionCompra ){
		RequisicionCompraDO item = entityManager.find(RequisicionCompraDO.class, requisicionCompra.getId());
		if( item == null || item.getPartidasRequisicionCompra() == null){
			return;
		}
		for (PartidaRequisicionCompraDO partida : item.getPartidasRequisicionCompra()) {
			if(partida!=null){
				entityManager.remove(partida);
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
