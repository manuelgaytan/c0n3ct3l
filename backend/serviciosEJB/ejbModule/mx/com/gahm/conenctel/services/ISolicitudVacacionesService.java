/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CobranzaDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;
import mx.com.gahm.conenctel.entities.SolicitudPermisoDO;
import mx.com.gahm.conenctel.entities.SolicitudVacacionesDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ISolicitudVacacionesService {

	List<SolicitudVacacionesDO> getAll();
	List<SolicitudVacacionesDO> getAllByPerfil( long idPerfil );
	void deleteItems( List<Integer> idsItems);
	SolicitudVacacionesDO save( SolicitudVacacionesDO item );
	SolicitudVacacionesDO update( SolicitudVacacionesDO item );
	SolicitudVacacionesDO getItem( Integer id );	
	
}
