package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IConfiguracionPruebaEntregaService extends Serializable {
	public List<ConfigPruebaEntregaDO> getAll() throws ConectelException;

	public void hechoFase(long idProject) throws ConectelException;

	public ConfigPruebaEntregaDO save(ConfigPruebaEntregaDO config)
			throws ConectelException;

	public ConfigPruebaEntregaDO update(ConfigPruebaEntregaDO config)
			throws ConectelException;
}
