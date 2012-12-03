package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Catalogo;
import mx.com.gahm.conenctel.model.FiltroProducto;

@Remote
public interface IProductoService extends Serializable {
	public List<ProductoDO> getAllByFiltro(FiltroProducto productFilter) throws ConectelException;
	
	public ProductoDO save(ProductoDO product) throws ConectelException;
	
	public ProductoDO update(ProductoDO product) throws ConectelException;
	
	public boolean deleteProductos(List<Long> ids);
	
	public ProductoDO getProducto(Long id) throws ConectelException;
	
	public List<Catalogo> getTiposProyecto(Long idCliente);
	
	public List<Catalogo> getTecnologias(Long idTiposProyecto);
	
	public List<Catalogo> getEquipos(Long idTecnologia);
	
	public void export();
	
	public void importProductos(String rutaArchivo);
}
