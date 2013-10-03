package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.ItemEstatusProyecto;
import mx.com.gahm.conenctel.services.IGraficosService;

@Stateless(mappedName = "ejb/GraficoService")
public class GraficoService implements IGraficosService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<ItemEstatusProyecto> getEstatusProyectos() throws ConectelException {
		List<ItemEstatusProyecto> datos= null;
		TypedQuery<ItemEstatusProyecto>  query =null;
		query = entityManager.createNamedQuery("ProyectoDO.getCantidadEstatusProyectos",ItemEstatusProyecto.class);
		datos = query.getResultList();
		return datos;
	}
	
	@Override
	public List<ItemEstatusProyecto> getFasesProyectos() throws ConectelException {
		List<ItemEstatusProyecto> datos = null;
		TypedQuery<ItemEstatusProyecto>  query =null;
		
		query = entityManager.createNamedQuery("NumeroFoliosFacturaFacturadosDO.getProyectosFacturados",ItemEstatusProyecto.class);
		datos = query.getResultList();
		query = entityManager.createNamedQuery("NumeroProyectosCobradosDO.getProyectosCobrados",ItemEstatusProyecto.class);
		datos.addAll( query.getResultList() );
		datos.add( this.obtenerNoCobrados( ((ItemEstatusProyecto)query.getResultList().get(0)).getCantidad() ) );
		query = entityManager.createNamedQuery("ProyectoDO.getCantidadProyectosByEstado",ItemEstatusProyecto.class);
		query.setParameter("idEstadoProyecto", EstadoDO.ID_CANCELADO);
		List<ItemEstatusProyecto> datosProyectosCancelados = query.getResultList();
		if( datosProyectosCancelados != null &&
				datosProyectosCancelados.size() > 0 ){
			datos.add( datosProyectosCancelados.get( 0 ) );
		}
		
		
		
		return datos;
	}
	
	private ItemEstatusProyecto obtenerNoCobrados(long cantidadCobrados){
		List<InformacionFacturacionDO> datos = null;
		TypedQuery<InformacionFacturacionDO>  query =null;
		query = entityManager.createNamedQuery("InformacionFacturacionDO.findAll",InformacionFacturacionDO.class);
		datos = query.getResultList();
		ItemEstatusProyecto itemEstatusProyecto = new ItemEstatusProyecto(1,"No Cobrados", "0");
		if( datos != null){
			itemEstatusProyecto.setCantidad( datos.size() - cantidadCobrados );
		}
		return itemEstatusProyecto;
	}
}
