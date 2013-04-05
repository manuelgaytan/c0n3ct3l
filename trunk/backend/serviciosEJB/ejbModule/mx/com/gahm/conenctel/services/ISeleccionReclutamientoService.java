/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import mx.com.gahm.conenctel.entities.SeleccionReclutamientoDO;

/**
 * @author MHDolores
 *
 */
public interface ISeleccionReclutamientoService {

	List<SeleccionReclutamientoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SeleccionReclutamientoDO save( SeleccionReclutamientoDO item );
	SeleccionReclutamientoDO update( SeleccionReclutamientoDO item );
	SeleccionReclutamientoDO getItem( Integer id );	
}
