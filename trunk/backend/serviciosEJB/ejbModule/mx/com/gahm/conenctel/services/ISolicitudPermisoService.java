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

/**
 * @author MHDolores
 *
 */
@Remote
public interface ISolicitudPermisoService {

	List<SolicitudPermisoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SolicitudPermisoDO save( SolicitudPermisoDO item );
	SolicitudPermisoDO update( SolicitudPermisoDO item );
	SolicitudPermisoDO getItem( Integer id );	
	
}