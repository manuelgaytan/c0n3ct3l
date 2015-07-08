package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SolicitudAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface ISolicitudAlmacenService {

	public List<SolicitudAlmacenDO> getAll() throws ConectelException;
	
	public List<SolicitudAlmacenDO> getAllByPerfil( long idPerfil ) throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public SolicitudAlmacenDO save(SolicitudAlmacenDO item);

	public SolicitudAlmacenDO update(SolicitudAlmacenDO item);

	public boolean enviarCompras(SolicitudAlmacenDO item);

	public SolicitudAlmacenDO getItem(Long id) throws ConectelException;
	
	public SolicitudAlmacenDO updateValeDevolucion(SolicitudAlmacenDO item);
}
