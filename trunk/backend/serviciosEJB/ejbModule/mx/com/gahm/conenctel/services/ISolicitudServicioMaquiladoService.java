/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SolicitudServicioMaquiladoDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ISolicitudServicioMaquiladoService {
	
	List<SolicitudServicioMaquiladoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SolicitudServicioMaquiladoDO save( SolicitudServicioMaquiladoDO item );
	SolicitudServicioMaquiladoDO update( SolicitudServicioMaquiladoDO item );
	SolicitudServicioMaquiladoDO getItem( Integer id );
}
