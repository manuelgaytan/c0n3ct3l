package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.MaterialSolicitudAlmacenDO;

@Remote
public interface IMaterialSolicitudAlmacenService {
	List<MaterialSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<MaterialSolicitudAlmacenDO> items);
	void update( List<MaterialSolicitudAlmacenDO> item);
	MaterialSolicitudAlmacenDO getItem( Integer id );
}
