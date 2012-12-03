package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IDatosGeneralesService {
	public List<DatosGrlsProyectoDO> getAll() throws ConectelException;

	public void hechoFase(long idProject) throws ConectelException;

	public DatosGrlsProyectoDO save(DatosGrlsProyectoDO dataProject)
			throws ConectelException;

	public DatosGrlsProyectoDO update(DatosGrlsProyectoDO dataProject)
			throws ConectelException;
	
	public DatosGrlsProyectoDO getDatosGrlsProyecto(long idDataProject)
			throws ConectelException;
}
