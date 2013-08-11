package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.FacturaProveedorDO;

@Remote
public interface IFacturaProveedorService {

	List<FacturaProveedorDO> getAll();
	void deleteItems( List<Integer> idsItems);
	FacturaProveedorDO save( FacturaProveedorDO item );
	FacturaProveedorDO update( FacturaProveedorDO item );
	FacturaProveedorDO getItem( Integer id );
	List<FacturaProveedorDO> getAllByIdMaquilador( long id );
	List<FacturaProveedorDO> getAllByIdCalificado( long id );
}
