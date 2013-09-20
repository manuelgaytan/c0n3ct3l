package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EstadoDO;
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
		List<ItemEstatusProyecto> datos= null;
		TypedQuery<ItemEstatusProyecto>  query =null;
		query = entityManager.createNamedQuery("NumeroFoliosFacturaFacturadosDO.getProyectosFacturados",ItemEstatusProyecto.class);
		datos = query.getResultList();
		query = entityManager.createNamedQuery("ProyectoDO.getCantidadProyectosByEstado",ItemEstatusProyecto.class);
		query.setParameter("idEstadoProyecto", EstadoDO.ID_CANCELADO);
		datos.add( query.getResultList().get( 0 ) );
		
		System.out.println("\n\nTipo: " + ((ItemEstatusProyecto)datos.get(0)).getTipo() + ", cantidad: " + ((ItemEstatusProyecto)datos.get(0)).getCantidad() + "\n\n");
		return datos;
	}
}
