package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.EquipoMedicionSolicitudAlmacenDO;

@Remote
public interface IEquipoMedicionSolicitudAlmacenService {
	List<EquipoMedicionSolicitudAlmacenDO> getAll(Integer idSolicitudalamacen);
	void deleteItems( List<Integer> idsItems);
	void save( List<EquipoMedicionSolicitudAlmacenDO> items);
	void update( List<EquipoMedicionSolicitudAlmacenDO> item);
	EquipoMedicionSolicitudAlmacenDO getItem( Integer id );
}
