package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.DesarrolloProyectoABDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IDesarrolloProyectoABService {
	public List<DesarrolloProyectoABDO> getAll() throws ConectelException;

	public void hechoFase(long idProject) throws ConectelException;

	public DesarrolloProyectoABDO save(DesarrolloProyectoABDO developmentProject)
			throws ConectelException;

	public DesarrolloProyectoABDO update(DesarrolloProyectoABDO developmentProject)
			throws ConectelException;
	
	public DesarrolloProyectoABDO getDesarrolloProyectoAB(long idDevelopmentProject)
			throws ConectelException;
	
	public List<ProyectoDO> getAllBySinDesarrolloProyecto() throws ConectelException;
}
