package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.TelefoniaMovilSolicitudAlmacenDO;

@Remote
public interface ITelefoniaMovilSolicitudAlmacenService {
	List<TelefoniaMovilSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<TelefoniaMovilSolicitudAlmacenDO> items);
	void update( List<TelefoniaMovilSolicitudAlmacenDO> item);
	TelefoniaMovilSolicitudAlmacenDO getItem( Integer id );
}
