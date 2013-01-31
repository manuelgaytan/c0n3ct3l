package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ConsumibleSolicitudAlmacenDO;

@Remote
public interface IConsumibleSolicitudAlmacenService {
	List<ConsumibleSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<ConsumibleSolicitudAlmacenDO> items);
	void update( List<ConsumibleSolicitudAlmacenDO> item);
	ConsumibleSolicitudAlmacenDO getItem( Integer id );
}
