/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CursoDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ICursoService {
	List<CursoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	CursoDO save( CursoDO item );
	CursoDO update( CursoDO item );
	CursoDO getItem( Integer id );
}
