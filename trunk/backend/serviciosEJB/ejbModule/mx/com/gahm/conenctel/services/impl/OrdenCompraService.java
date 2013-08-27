package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.OrdenCompraDO;
import mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.services.IOrdenCompraService;

@Stateless(mappedName = "ejb/OrdenCompraService")
public class OrdenCompraService  implements IOrdenCompraService{
	
	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDO> getAll() {
		List<OrdenCompraDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("OrdenCompraDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query =null;
		OrdenCompraDO ordenCompraDO=null;
		for (Integer id : idsItems) {
			query=entityManager.createNamedQuery("OrdenCompraDO.findById");
			query.setParameter("id", id);
			ordenCompraDO = (OrdenCompraDO)query.getSingleResult();
			if(ordenCompraDO!=null){
				entityManager.remove(ordenCompraDO);
			}
		}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public OrdenCompraDO save(OrdenCompraDO item) {
	    try {
	    	item.setFecha( new Date() );
	    	entityManager.persist(item);
	    	RequisicionCompraDO requisicionCompra = entityManager.find(RequisicionCompraDO.class, item.getRequisicionCompra().getId());
	    	this.deletePartidasRequisicionCompra( requisicionCompra );
	    	this.savePartidasRequisicionCompra( item.getRequisicionCompra() );
	    	entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    this.validarEnvioNotificaciones(item);
	    return item;
	}
	
	private void validarEnvioNotificaciones(OrdenCompraDO item) {
		if( item == null ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.ORDEN_COMPRA_ALMACEN_CREACION + item.getId();
		this.enviarNotificacion(PerfilDO.ID_ALMACEN, mensaje);
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
	
	private void deletePartidasRequisicionCompra( RequisicionCompraDO item ){
		RequisicionCompraDO requisicionCompra = entityManager.find(RequisicionCompraDO.class, item.getId());
		List<PartidaRequisicionCompraDO> list = requisicionCompra.getPartidasRequisicionCompra();
		if( list != null ){
			for (PartidaRequisicionCompraDO partidaRequisicionCompraDO : list) {
				entityManager.remove(partidaRequisicionCompraDO);
			}
		}
	}
	
	private void savePartidasRequisicionCompra( RequisicionCompraDO item ){
		List<PartidaRequisicionCompraDO> list = item.getPartidasRequisicionCompra();
		if( list != null ){
			for (PartidaRequisicionCompraDO partidaRequisicionCompraDO : list) {
				partidaRequisicionCompraDO.setId(null);
				partidaRequisicionCompraDO.setRequisicionCompra(item);
				entityManager.persist(partidaRequisicionCompraDO);
			}
		}
	}

	@Override
	public OrdenCompraDO update(OrdenCompraDO item) {
		entityManager.merge(item);
		RequisicionCompraDO requisicionCompra = entityManager.find(RequisicionCompraDO.class, item.getRequisicionCompra().getId());
    	this.deletePartidasRequisicionCompra( requisicionCompra );
    	this.savePartidasRequisicionCompra( item.getRequisicionCompra() );
		return item;
	}

	@Override
	public OrdenCompraDO getItem(Integer id) {
		OrdenCompraDO ordenCompraDO=null;
		try {
			 ordenCompraDO = entityManager.find(OrdenCompraDO.class, id);
		} catch (Exception e) {
			ordenCompraDO =null;
		}
		
		return ordenCompraDO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDO> getOrdenCompraByProveedor(Long idProveedor) {
		List<OrdenCompraDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("OrdenCompraDO.findByProveedor");
		query.setParameter("id", idProveedor);
		datos = query.getResultList();
		
		return datos;
	}


	
	
	
}
