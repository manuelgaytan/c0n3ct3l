/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SolicitudViaticosDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ISolicitudViaticosService {
	List<SolicitudViaticosDO> getAll();
	List<SolicitudViaticosDO> getAllByPerfil( long idPerfil );
	void deleteItems( List<Integer> idsItems);
	SolicitudViaticosDO save( SolicitudViaticosDO item );
	SolicitudViaticosDO update( SolicitudViaticosDO item );
	SolicitudViaticosDO getItem( Integer id );
	long getSiguienteId();
	List<SolicitudViaticosDO> getAllByWithOutPayment();
}
