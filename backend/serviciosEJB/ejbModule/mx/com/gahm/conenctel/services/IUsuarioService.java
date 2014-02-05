package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IUsuarioService extends Serializable {
	public List<UsuarioDO> getAll() throws ConectelException;
	
	public UsuarioDO login(String user, String password, String foo) throws ConectelException;
	
	public UsuarioDO save(UsuarioDO user) throws ConectelException;
	
	public UsuarioDO update(UsuarioDO user) throws ConectelException;
	
	public boolean deleteUsuarios(List<Long> ids);
	
	public UsuarioDO getUsuario(Long id ) throws ConectelException;
	
	public List<PerfilDO> getAllPerfiles() throws ConectelException;
}
