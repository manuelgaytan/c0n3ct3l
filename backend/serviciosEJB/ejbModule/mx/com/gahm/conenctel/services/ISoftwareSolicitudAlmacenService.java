package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SoftwareSolicitudAlmacenDO;

@Remote
public interface ISoftwareSolicitudAlmacenService {
	List<SoftwareSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<SoftwareSolicitudAlmacenDO> items);
	void update( List<SoftwareSolicitudAlmacenDO> item);
	SoftwareSolicitudAlmacenDO getItem( Integer id );
}
