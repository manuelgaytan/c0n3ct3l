package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.HardwareSolicitudAlmacenDO;

@Remote
public interface IHardwareSolicitudAlmacenService {
	List<HardwareSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<HardwareSolicitudAlmacenDO> items);
	void update( List<HardwareSolicitudAlmacenDO> item);
	HardwareSolicitudAlmacenDO getItem( Integer id );
}
