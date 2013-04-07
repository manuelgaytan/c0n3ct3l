/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ReclutamientoSolicitudEmpleoDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IReclutamientoSolicitudEmpleoService{

	List<ReclutamientoSolicitudEmpleoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	ReclutamientoSolicitudEmpleoDO save( ReclutamientoSolicitudEmpleoDO item );
	ReclutamientoSolicitudEmpleoDO update( ReclutamientoSolicitudEmpleoDO item );
	ReclutamientoSolicitudEmpleoDO getItem( Integer id );	
}
