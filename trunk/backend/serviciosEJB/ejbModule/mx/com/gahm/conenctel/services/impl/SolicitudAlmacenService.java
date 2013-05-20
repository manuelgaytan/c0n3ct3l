package mx.com.gahm.conenctel.services.impl;

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
		
	
		if(item.getHerramientasSolicitudAlmacen()!=null && 
				!item.getHerramientasSolicitudAlmacen().isEmpty()){
			for (HerramientaSolicitudAlmacenDO dato : item.getHerramientasSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getSoftwareSolicitudAlmacen()!=null && 
				!item.getSoftwareSolicitudAlmacen().isEmpty()){
			for (SoftwareSolicitudAlmacenDO dato : item.getSoftwareSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getConsumiblesSolicitudAlmacen()!=null && 
				!item.getConsumiblesSolicitudAlmacen().isEmpty()){
			for (ConsumibleSolicitudAlmacenDO dato : item.getConsumiblesSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getHardwareSolicitudAlmacen()!=null && 
				!item.getHardwareSolicitudAlmacen().isEmpty()){
			for (HardwareSolicitudAlmacenDO dato : item.getHardwareSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getTelefoniaMovilSolicitudAlmacen()!=null && 
				!item.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
			for (TelefoniaMovilSolicitudAlmacenDO dato : item.getTelefoniaMovilSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getEquipoMedicionSolicitudAlmacen()!=null && 
				!item.getEquipoMedicionSolicitudAlmacen().isEmpty()){
			for (EquipoMedicionSolicitudAlmacenDO dato : item.getEquipoMedicionSolicitudAlmacen()) {
				dato.setSolicitudAlmacen(item);	
			}
		}else
			if(item.getEquipoTransporteSolicitudAlmacen()!=null && 
				!item.getEquipoTransporteSolicitudAlmacen().isEmpty()){
				for (EquipoTransporteSolicitudAlmacenDO dato : item.getEquipoTransporteSolicitudAlmacen()) {
					dato.setSolicitudAlmacen(item);	
				}
		}else
			if(item.getMaterialesSolicitudAlmacen()!=null && 
				!item.getMaterialesSolicitudAlmacen().isEmpty()){
				for (MaterialSolicitudAlmacenDO dato : item.getMaterialesSolicitudAlmacen()) {
					dato.setSolicitudAlmacen(item);	
				}
			}
		
		entityManager.persist(item);
			return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SolicitudAlmacenDO update(SolicitudAlmacenDO item) {
		
		HerramientaDO herramienta =null;
		SoftwareDO    software =null;
		ConsumibleDO consumible =null;
		HardwareDO hardware =null;
		TelefoniaMovilDO telefonia =null;
		EquipoMedicionDO equipoMedicion=null;
		EquipoTransporteDO equipoTransporte =null;
		MaterialDO material =null;
		Double cantidadPedido =0.0;	
		SolicitudAlmacenDO dato=null;
		try {
			dato = getItem(item.getId());
		} catch (ConectelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		entityManager.merge(item);
		
		if(dato!=null && dato.getEstadoSolicitudAlmacen()!=null 
				&& item.getEstadoSolicitudAlmacen().getId()==EstadoSolicitudAlmacenDO.ID_AUTORIZADO){
			
			if(dato.getHerramientasSolicitudAlmacen()!=null && 
					!dato.getHerramientasSolicitudAlmacen().isEmpty()){
				for (HerramientaSolicitudAlmacenDO herramientaDO : item.getHerramientasSolicitudAlmacen()) {
					cantidadPedido +=herramientaDO.getCantidadSolicitada().doubleValue(); 
				}
				
				
				herramienta = dato.getHerramientasSolicitudAlmacen().get(0).getHerramienta();
				herramienta.setExistencia(herramienta.getExistencia()-cantidadPedido);
				entityManager.merge(herramienta);
				
			}else
				if(dato.getSoftwareSolicitudAlmacen()!=null && 
					!dato.getSoftwareSolicitudAlmacen().isEmpty()){
				
					for (SoftwareSolicitudAlmacenDO datoAlmacen : item.getSoftwareSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					software = dato.getSoftwareSolicitudAlmacen().get(0).getSoftware();
					software.setExistencia(software.getExistencia()-cantidadPedido);
					entityManager.merge(software);
			}else
				if(dato.getConsumiblesSolicitudAlmacen()!=null && 
					!dato.getConsumiblesSolicitudAlmacen().isEmpty()){
				
					for (SoftwareSolicitudAlmacenDO datoAlmacen : item.getSoftwareSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					consumible = dato.getConsumiblesSolicitudAlmacen().get(0).getConsumible();
					consumible.setExistencia(consumible.getExistencia()-cantidadPedido);
					entityManager.merge(consumible);
			}else
				if(dato.getHardwareSolicitudAlmacen()!=null && 
					!dato.getHardwareSolicitudAlmacen().isEmpty()){
				
					for (HardwareSolicitudAlmacenDO datoAlmacen : item.getHardwareSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					hardware = dato.getHardwareSolicitudAlmacen().get(0).getHardware();
					hardware.setExistencia(hardware.getExistencia()-cantidadPedido);
					entityManager.merge(hardware);
					
			}else
				if(dato.getTelefoniaMovilSolicitudAlmacen()!=null && 
					!dato.getTelefoniaMovilSolicitudAlmacen().isEmpty()){
				
					for (TelefoniaMovilSolicitudAlmacenDO datoAlmacen : item.getTelefoniaMovilSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					telefonia = dato.getTelefoniaMovilSolicitudAlmacen().get(0).getTelefoniaMovil();
					telefonia.setExistencia(telefonia.getExistencia()-cantidadPedido);
					entityManager.merge(telefonia);
			}else
				if(dato.getEquipoMedicionSolicitudAlmacen()!=null && 
					!dato.getEquipoMedicionSolicitudAlmacen().isEmpty()){
					/*for (EquipoMedicionSolicitudAlmacenDO datoAlmacen : item.getEquipoMedicionSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					equipoMedicion = dato.getEquipoMedicionSolicitudAlmacen().get(0).getEquipoMedicion();
					equipoMedicion.setExistencia(equipoMedicion.getExistencia()-cantidadPedido);
					entityManager.merge(equipoMedicion);
					*/
				
			}else
				if(dato.getEquipoTransporteSolicitudAlmacen()!=null && 
					!dato.getEquipoTransporteSolicitudAlmacen().isEmpty()){
				
					/*for (EquipoTransporteSolicitudAlmacenDO datoAlmacen : item.getEquipoTransporteSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					equipoTransporte = dato.getEquipoTransporteSolicitudAlmacen().get(0).getEquipoTransporte();
					equipoTransporte.setExistencia(telefonia.getExistencia()-cantidadPedido);
					entityManager.merge(equipoTransporte);*/
			}else
				if(dato.getMaterialesSolicitudAlmacen()!=null && 
					!dato.getMaterialesSolicitudAlmacen().isEmpty()){
					for (MaterialSolicitudAlmacenDO datoAlmacen : item.getMaterialesSolicitudAlmacen()) {
						cantidadPedido +=datoAlmacen.getCantidadSolicitada().doubleValue(); 
					}
					
					
					material = dato.getMaterialesSolicitudAlmacen().get(0).getMaterial();
					material.setExistencia(material.getExistencia()-cantidadPedido);
					entityManager.merge(material);
					
					
				}
			}
			
			
			
			
			
		
		
		
		
		return null;
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
