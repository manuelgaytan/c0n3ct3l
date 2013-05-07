package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ConsumibleSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.EquipoMedicionSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.EquipoTransporteSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.HardwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.HerramientaSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.MaterialSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.SoftwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.entities.SolicitudAlmacenDO;
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
		
		
		/*



		 */
		
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
		entityManager.merge(item);
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
