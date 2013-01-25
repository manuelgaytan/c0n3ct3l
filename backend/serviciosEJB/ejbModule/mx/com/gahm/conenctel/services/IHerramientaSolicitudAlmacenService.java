package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.HerramientaSolicitudAlmacenDO;

@Remote
public interface IHerramientaSolicitudAlmacenService {
	List<HerramientaSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<HerramientaSolicitudAlmacenDO> items);
	void update( List<HerramientaSolicitudAlmacenDO> item);
	HerramientaSolicitudAlmacenDO getItem( Integer id );
}
