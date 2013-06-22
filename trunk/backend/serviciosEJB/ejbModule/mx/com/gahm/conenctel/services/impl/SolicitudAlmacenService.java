package mx.com.gahm.conenctel.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ConsumibleDO;
import mx.com.gahm.conenctel.entities.ConsumibleSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.EquipoMedicionDO;
import mx.com.gahm.conenctel.entities.EquipoMedicionSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.EquipoTransporteDO;
import mx.com.gahm.conenctel.entities.EquipoTransporteSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.EstadoSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.HardwareDO;
import mx.com.gahm.conenctel.entities.HardwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.HerramientaDO;
import mx.com.gahm.conenctel.entities.HerramientaSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.MaterialDO;
import mx.com.gahm.conenctel.entities.MaterialSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.SoftwareDO;
import mx.com.gahm.conenctel.entities.SoftwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.SolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.TelefoniaMovilDO;
import mx.com.gahm.conenctel.entities.TelefoniaMovilSolicitudAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.ISolicitudAlmacenService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/SolicitudAlmacenService")
public class SolicitudAlmacenService implements ISolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SolicitudAlmacenDO> getAll() throws ConectelException {
		TypedQuery<SolicitudAlmacenDO> query = entityManager.createNamedQuery(
				"SolicitudAlmacenDO.findAll", SolicitudAlmacenDO.class);
		List<SolicitudAlmacenDO> solicitudAlmacenList;
		try {
			solicitudAlmacenList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Solicitud Almacen registrado.");
		}
		return solicitudAlmacenList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			SolicitudAlmacenDO current = entityManager.find(SolicitudAlmacenDO.class, id);
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
	public SolicitudAlmacenDO save(SolicitudAlmacenDO item) {
		this.colocarSolicitudAlmacenAListas(item);
		item.setFechaSolicitud(new Date());
		entityManager.persist(item);
		return item;
	}
	
	private void colocarSolicitudAlmacenAListas(SolicitudAlmacenDO item){
		if(item.getHerramientasSolicitudAlmacen()!=null && 
				!item.getHerramientasSolicitudAlmacen().isEmpty()){
			for (HerramientaSolicitudAlmacenDO dato : item.getHerramientasSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getSoftwareSolicitudAlmacen()!=null && 
				!item.getSoftwareSolicitudAlmacen().isEmpty()){
			for (SoftwareSolicitudAlmacenDO dato : item.getSoftwareSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getConsumiblesSolicitudAlmacen()!=null && 
				!item.getConsumiblesSolicitudAlmacen().isEmpty()){
			for (ConsumibleSolicitudAlmacenDO dato : item.getConsumiblesSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getHardwareSolicitudAlmacen()!=null && 
				!item.getHardwareSolicitudAlmacen().isEmpty()){
			for (HardwareSolicitudAlmacenDO dato : item.getHardwareSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getTelefoniaMovilSolicitudAlmacen()!=null && 
				!item.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
			for (TelefoniaMovilSolicitudAlmacenDO dato : item.getTelefoniaMovilSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getEquipoMedicionSolicitudAlmacen()!=null && 
				!item.getEquipoMedicionSolicitudAlmacen().isEmpty()){
			for (EquipoMedicionSolicitudAlmacenDO dato : item.getEquipoMedicionSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}
		if(item.getEquipoTransporteSolicitudAlmacen()!=null && 
				!item.getEquipoTransporteSolicitudAlmacen().isEmpty()){
				for (EquipoTransporteSolicitudAlmacenDO dato : item.getEquipoTransporteSolicitudAlmacen()) {
					dato.setSolicitudAlmacen(item);	
				}
		}
		if(item.getMaterialesSolicitudAlmacen()!=null && 
				!item.getMaterialesSolicitudAlmacen().isEmpty()){
				for (MaterialSolicitudAlmacenDO dato : item.getMaterialesSolicitudAlmacen()) {
					dato.setSolicitudAlmacen(item);	
				}
			}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SolicitudAlmacenDO update(SolicitudAlmacenDO item) {
		this.colocarSolicitudAlmacenAListas(item);
		
		
		SolicitudAlmacenDO dato=null;
		try {
			dato = getItem(item.getId());
		} catch (ConectelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		this.eliminarListasViejas(dato, item);
		
		entityManager.merge(item);
		
		HerramientaDO herramienta = null;
		SoftwareDO    software = null;
		ConsumibleDO consumible = null;
		HardwareDO hardware = null;
		TelefoniaMovilDO telefonia = null;
		EquipoMedicionDO equipoMedicion = null;
		EquipoTransporteDO equipoTransporte = null;
		MaterialDO material = null;
		Double cantidadPedido = 0.0;	
		
		if(dato!=null && dato.getEstadoSolicitudAlmacen()!=null 
				&& item.getEstadoSolicitudAlmacen().getId()==EstadoSolicitudAlmacenDO.ID_AUTORIZADO){
			if(item.getHerramientasSolicitudAlmacen()!=null && 
					!item.getHerramientasSolicitudAlmacen().isEmpty()){
					for (HerramientaSolicitudAlmacenDO datoAlmacen : item.getHerramientasSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						herramienta = entityManager.find(HerramientaDO.class, datoAlmacen.getHerramienta().getId());
						herramienta.setExistencia(herramienta.getExistencia()-cantidadPedido);
						entityManager.merge(herramienta);
					}
			}
			if(item.getSoftwareSolicitudAlmacen()!=null && 
					!item.getSoftwareSolicitudAlmacen().isEmpty()){
					for (SoftwareSolicitudAlmacenDO datoAlmacen : item.getSoftwareSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						software = entityManager.find(SoftwareDO.class, datoAlmacen.getSoftware().getId());
						software.setExistencia(software.getExistencia()-cantidadPedido);
						entityManager.merge(software);
					}
			}
			if(item.getConsumiblesSolicitudAlmacen()!=null && 
					!item.getConsumiblesSolicitudAlmacen().isEmpty()){
					for (ConsumibleSolicitudAlmacenDO datoAlmacen : item.getConsumiblesSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						consumible = entityManager.find(ConsumibleDO.class, datoAlmacen.getConsumible().getId());
						consumible.setExistencia(consumible.getExistencia()-cantidadPedido);
						entityManager.merge(consumible);
					}
			}
			if(item.getHardwareSolicitudAlmacen()!=null && 
					!item.getHardwareSolicitudAlmacen().isEmpty()){
					for (HardwareSolicitudAlmacenDO datoAlmacen : item.getHardwareSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						hardware = entityManager.find(HardwareDO.class, datoAlmacen.getHardware().getId());
						hardware.setExistencia(hardware.getExistencia()-cantidadPedido);
						entityManager.merge(hardware);
					}
			}
			if(item.getTelefoniaMovilSolicitudAlmacen()!=null && 
					!item.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
					for (TelefoniaMovilSolicitudAlmacenDO datoAlmacen : item.getTelefoniaMovilSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						telefonia = entityManager.find(TelefoniaMovilDO.class, datoAlmacen.getTelefoniaMovil().getId());
						telefonia.setExistencia(telefonia.getExistencia()-cantidadPedido);
						entityManager.merge(telefonia);
					}
			}
			if(item.getEquipoMedicionSolicitudAlmacen()!=null && 
					!item.getEquipoMedicionSolicitudAlmacen().isEmpty()){
					/*
					for (EquipoMedicionSolicitudAlmacenDO datoAlmacen : item.getEquipoMedicionSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						equipoMedicion = entityManager.find(EquipoMedicionDO.class, datoAlmacen.getEquipoMedicion().getId());
						equipoMedicion.setExistencia(equipoMedicion.getExistencia()-cantidadPedido);
						entityManager.merge(equipoMedicion);
					}
					*/
			}
			if(item.getEquipoTransporteSolicitudAlmacen()!=null && 
					!item.getEquipoTransporteSolicitudAlmacen().isEmpty()){
					/*
					for (EquipoTransporteSolicitudAlmacenDO datoAlmacen : item.getEquipoTransporteSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						equipoTransporte = entityManager.find(EquipoTransporteDO.class, datoAlmacen.getEquipoTransporte().getId());
						equipoTransporte.setExistencia(equipoTransporte.getExistencia()-cantidadPedido);
						entityManager.merge(equipoTransporte);
					}
					*/
			}
			if(item.getMaterialesSolicitudAlmacen()!=null && 
					!item.getMaterialesSolicitudAlmacen().isEmpty()){
					for (MaterialSolicitudAlmacenDO datoAlmacen : item.getMaterialesSolicitudAlmacen()) {
						cantidadPedido = datoAlmacen.getCantidadSolicitada().doubleValue(); 
						material = entityManager.find(MaterialDO.class, datoAlmacen.getMaterial().getId());
						material.setExistencia(material.getExistencia()-cantidadPedido);
						entityManager.merge(material);
					}
				}
			}
		return item;
	}

	
	private void eliminarListasViejas(SolicitudAlmacenDO item,
			SolicitudAlmacenDO nuevo) {
		ArrayList<Object> itemsAEliminar = null;
		boolean noExiste = false;
		if(item.getHerramientasSolicitudAlmacen()!=null && 
				!item.getHerramientasSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (HerramientaSolicitudAlmacenDO datoAlmacen : item.getHerramientasSolicitudAlmacen()) {
				noExiste = false;
				if(nuevo.getHerramientasSolicitudAlmacen()!=null && 
						!nuevo.getHerramientasSolicitudAlmacen().isEmpty()){
					for (HerramientaSolicitudAlmacenDO datoNuevoAlmacen : nuevo.getHerramientasSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getSoftwareSolicitudAlmacen()!=null && 
				!item.getSoftwareSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (SoftwareSolicitudAlmacenDO datoAlmacen : item.getSoftwareSolicitudAlmacen()) {
				noExiste = false;
				if(item.getSoftwareSolicitudAlmacen()!=null && 
						!item.getSoftwareSolicitudAlmacen().isEmpty()){
					for (SoftwareSolicitudAlmacenDO datoNuevoAlmacen : item.getSoftwareSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getConsumiblesSolicitudAlmacen()!=null && 
				!item.getConsumiblesSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (ConsumibleSolicitudAlmacenDO datoAlmacen : item.getConsumiblesSolicitudAlmacen()) {
				noExiste = false;
				if(item.getConsumiblesSolicitudAlmacen()!=null && 
						!item.getConsumiblesSolicitudAlmacen().isEmpty()){
					for (ConsumibleSolicitudAlmacenDO datoNuevoAlmacen : item.getConsumiblesSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getHardwareSolicitudAlmacen()!=null && 
				!item.getHardwareSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (HardwareSolicitudAlmacenDO datoAlmacen : item.getHardwareSolicitudAlmacen()) {
				noExiste = false;
				if(item.getHardwareSolicitudAlmacen()!=null && 
						!item.getHardwareSolicitudAlmacen().isEmpty()){
					for (HardwareSolicitudAlmacenDO datoNuevoAlmacen : item.getHardwareSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getTelefoniaMovilSolicitudAlmacen()!=null && 
				!item.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (TelefoniaMovilSolicitudAlmacenDO datoAlmacen : item.getTelefoniaMovilSolicitudAlmacen()) {
				noExiste = false;
				if(item.getTelefoniaMovilSolicitudAlmacen()!=null && 
						!item.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
					for (TelefoniaMovilSolicitudAlmacenDO datoNuevoAlmacen : item.getTelefoniaMovilSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getEquipoMedicionSolicitudAlmacen()!=null && 
				!item.getEquipoMedicionSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (EquipoMedicionSolicitudAlmacenDO datoAlmacen : item.getEquipoMedicionSolicitudAlmacen()) {
				noExiste = false;
				if(item.getEquipoMedicionSolicitudAlmacen()!=null && 
						!item.getEquipoMedicionSolicitudAlmacen().isEmpty()){
					for (EquipoMedicionSolicitudAlmacenDO datoNuevoAlmacen : item.getEquipoMedicionSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getEquipoTransporteSolicitudAlmacen()!=null && 
				!item.getEquipoTransporteSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (EquipoTransporteSolicitudAlmacenDO datoAlmacen : item.getEquipoTransporteSolicitudAlmacen()) {
				noExiste = false;
				if(item.getEquipoTransporteSolicitudAlmacen()!=null && 
						!item.getEquipoTransporteSolicitudAlmacen().isEmpty()){
					for (EquipoTransporteSolicitudAlmacenDO datoNuevoAlmacen : item.getEquipoTransporteSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
		if(item.getMaterialesSolicitudAlmacen()!=null && 
				!item.getMaterialesSolicitudAlmacen().isEmpty()){
			itemsAEliminar = new ArrayList<Object>();
			for (MaterialSolicitudAlmacenDO datoAlmacen : item.getMaterialesSolicitudAlmacen()) {
				noExiste = false;
				if(item.getMaterialesSolicitudAlmacen()!=null && 
						!item.getMaterialesSolicitudAlmacen().isEmpty()){
					for (MaterialSolicitudAlmacenDO datoNuevoAlmacen : item.getMaterialesSolicitudAlmacen()) {
						if( datoAlmacen.getId().equals( datoNuevoAlmacen.getId() ) ){
							noExiste = true;
							break;
						}
					}
				}
				if( noExiste == false ){
					itemsAEliminar.add( datoAlmacen );
				}
			}
			for (Object object : itemsAEliminar) {
				entityManager.remove(object);
			}
		}
	}

	@Override
	public boolean enviarCompras(SolicitudAlmacenDO item) {
		// TODO Auto-generated method stub
		return false;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public SolicitudAlmacenDO getItem(Long id) throws ConectelException {
		SolicitudAlmacenDO solicitudAlmacen = entityManager.find(SolicitudAlmacenDO.class, id);
		if (solicitudAlmacen == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return solicitudAlmacen;
	}

}
