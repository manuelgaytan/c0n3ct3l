package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CategoriaDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.ConsultaGeneralOperacion;
import mx.com.gahm.conenctel.model.FiltroProyecto;

@Remote
public interface IProyectoService {

	public List<ProyectoDO> getAllByFiltro(FiltroProyecto projectFilter)
			throws ConectelException;

	public void cancelarProyecto(long idProject) throws ConectelException;

	public ProyectoDO save(ProyectoDO project) throws ConectelException;

	public ProyectoDO update(ProyectoDO project) throws ConectelException;

	public List<CategoriaDO> getCategorias() throws ConectelException;
	
	public ProyectoDO getProyecto(long idProject) throws ConectelException;
	public List<ProyectoDO> getAllByEstado(Long idEstado) throws ConectelException;
	public List<ProyectoDO> getAllByWithOutMaquilaRequest() throws ConectelException;
	public List<ConsultaGeneralOperacion> getProyectosAndDerivates() throws ConectelException;
	public List<ProyectoDO> getAllByWithOutCustomerPurchaseOrder() throws ConectelException;
}
