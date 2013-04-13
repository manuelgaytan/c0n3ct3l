/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SeleccionReclutamientoDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ISeleccionReclutamientoService {

	List<SeleccionReclutamientoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SeleccionReclutamientoDO save( SeleccionReclutamientoDO item );
	SeleccionReclutamientoDO update( SeleccionReclutamientoDO item );
	SeleccionReclutamientoDO getItem( Integer id );	
}
