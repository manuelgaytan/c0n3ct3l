/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ComprobacionViaticosDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IComprobacionViaticosService {
	List<ComprobacionViaticosDO> getAll();
	void deleteItems( List<Integer> idsItems);
	ComprobacionViaticosDO save( ComprobacionViaticosDO item );
	ComprobacionViaticosDO update( ComprobacionViaticosDO item );
	ComprobacionViaticosDO getItem( Integer id );
}
