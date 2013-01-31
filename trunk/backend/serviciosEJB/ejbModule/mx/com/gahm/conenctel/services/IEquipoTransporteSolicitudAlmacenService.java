package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.EquipoTransporteSolicitudAlmacenDO;

@Remote
public interface IEquipoTransporteSolicitudAlmacenService {
	List<EquipoTransporteSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<EquipoTransporteSolicitudAlmacenDO> items);
	void update( List<EquipoTransporteSolicitudAlmacenDO> item);
	EquipoTransporteSolicitudAlmacenDO getItem( Integer id );
}
