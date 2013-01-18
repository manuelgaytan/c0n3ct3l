package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Catalogo;
import mx.com.gahm.conenctel.model.FiltroProducto;

@Remote
public interface IProductoService {
	public List<ProductoDO> getAllByFiltro(FiltroProducto productFilter) throws ConectelException;
	
	public ProductoDO save(ProductoDO product) throws ConectelException;
	
	public ProductoDO update(ProductoDO product) throws ConectelException;
	
	public boolean deleteProductos(List<Long> ids);
	
	public ProductoDO getProducto(Long id) throws ConectelException;
	
	public List<Catalogo> getTiposProyecto(Long idCliente);
	
	public List<Catalogo> getTecnologias(Long idCliente, String tipoProyecto);
	
	public List<Catalogo> getEquipos(Long idCliente, String tipoProyecto, String tecnologia);
	
	public List<Catalogo> getActividadRealizar(Long idCliente,
			String tipoProyecto, String tecnologia, String equipo);

	public List<Catalogo> getModelo(Long idCliente, String tipoProyecto,
			String tecnologia, String equipo, String actividadRealizar);

	public List<Catalogo> getDescripcionServicio(Long idCliente,
			String tipoProyecto, String tecnologia, String equipo,
			String actividadRealizar, String modelo);

	public List<Catalogo> getTipoServicio(Long idCliente,
			String tipoProyecto, String tecnologia, String equipo,
			String actividadRealizar, String modelo, String descripcionServicio);

	public List<Catalogo> getCostoLocalCliente(Long idCliente, String tipoProyecto,
			String tecnologia, String equipo, String actividadRealizar,
			String modelo, String descripcionServicio, String tipoServicio);
	
	public List<Catalogo> getCostoForaneoCliente(Long idCliente, String tipoProyecto,
			String tecnologia, String equipo, String actividadRealizar,
			String modelo, String descripcionServicio, String tipoServicio);
	
	public List<Catalogo> getCostoLocalProveedor(Long idCliente, String tipoProyecto,
			String tecnologia, String equipo, String actividadRealizar,
			String modelo, String descripcionServicio, String tipoServicio);
	
	public List<Catalogo> getCostoForaneoProveedor(Long idCliente, String tipoProyecto,
			String tecnologia, String equipo, String actividadRealizar,
			String modelo, String descripcionServicio, String tipoServicio);
	
	public void export(String rutaArchivo);
	
	public void importProductos(String rutaArchivo) throws ConectelException;
}
