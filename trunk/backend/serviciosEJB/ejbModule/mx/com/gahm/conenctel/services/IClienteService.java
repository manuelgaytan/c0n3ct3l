package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ClienteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IClienteService extends Serializable {
	public List<ClienteDO> getAll() throws ConectelException;
	
	public ClienteDO save(ClienteDO client) throws ConectelException;
	
	public ClienteDO update(ClienteDO client) throws ConectelException;
	
	public boolean deleteClientes(List<Long> ids);
	
	public ClienteDO getCliente(Long id ) throws ConectelException;
	
	public List<ClienteDO> getClientes();
	
	public void export();
}
