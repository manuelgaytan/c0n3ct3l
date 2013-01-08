/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProyectoPadreDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IProyectoPadreService {

	List<ProyectoPadreDO> getAll();
	void deleteItems( List<Integer> idsItems);
	ProyectoPadreDO save( ProyectoPadreDO item );
	ProyectoPadreDO update( ProyectoPadreDO item );
	ProyectoPadreDO getItem( Integer id );
	
}
