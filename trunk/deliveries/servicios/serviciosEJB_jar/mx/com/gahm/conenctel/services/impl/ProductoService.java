package mx.com.gahm.conenctel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Catalogo;
import mx.com.gahm.conenctel.model.FiltroProducto;
import mx.com.gahm.conenctel.services.IProductoService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * Session Bean implementation class ProductoService
 */
@Stateless(mappedName = "ejb/ProductoService")
public class ProductoService implements IProductoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProductoDO> getAllByFiltro(FiltroProducto productFilter)
			throws ConectelException {
		TypedQuery<ProductoDO> query = entityManager.createNamedQuery(
				"ProductoDO.findByFilter", ProductoDO.class);
		query.setParameter("idCliente", productFilter.getIdCliente());
		query.setParameter("tipoProyecto", productFilter.getTipoProyecto());
		query.setParameter("tipoServicio", productFilter.getTecnologia());
		query.setParameter("equipo", productFilter.getEquipo());
		List<ProductoDO> productList;
		try {
			productList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Productos registrados.");
		}
		/*List<Producto> responseList;
		try {
			responseList = transformacionService.mapList(productList,
					Producto.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return productList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProductoDO save(ProductoDO product) throws ConectelException {
		/*try {
			ProductoDO current = transformacionService.map(product,
					ProductoDO.class);*/
			entityManager.persist(product);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProductoDO update(ProductoDO product) throws ConectelException {
		/*try {
			ProductoDO current = transformacionService.map(product,
					ProductoDO.class);*/
			entityManager.merge(product);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteProductos(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ProductoDO current = entityManager.find(ProductoDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@Override
	public ProductoDO getProducto(Long id) throws ConectelException {
		ProductoDO product = entityManager.find(ProductoDO.class, id);
		/*Producto response;
		try {
			response = transformacionService.map(product, Producto.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return product;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getTiposProyecto(Long idCliente) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<Object[]> query = entityManager.createNamedQuery(
				"ProductoDO.findTipoProyecto", Object[].class);
		query.setParameter("idCliente", id);
		List<Object[]> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tipoProyecto;
		for (Object[] current:tipoProyectoList) {
			tipoProyecto = new Catalogo();
			tipoProyecto.setId((Long) current[0]);
			tipoProyecto.setEtiqueta((String) current[1]);
			responseList.add(tipoProyecto);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getTecnologias(Long idCliente) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<Object[]> query = entityManager.createNamedQuery(
				"ProductoDO.findTecnologia", Object[].class);
		query.setParameter("idCliente", id);
		List<Object[]> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tipoProyecto;
		for (Object[] current:tipoProyectoList) {
			tipoProyecto = new Catalogo();
			tipoProyecto.setId((Long) current[0]);
			tipoProyecto.setEtiqueta((String) current[1]);
			responseList.add(tipoProyecto);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getEquipos(Long idCliente) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<Object[]> query = entityManager.createNamedQuery(
				"ProductoDO.findEquipo", Object[].class);
		query.setParameter("idCliente", id);
		List<Object[]> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tipoProyecto;
		for (Object[] current:tipoProyectoList) {
			tipoProyecto = new Catalogo();
			tipoProyecto.setId((Long) current[0]);
			tipoProyecto.setEtiqueta((String) current[1]);
			responseList.add(tipoProyecto);
		}
		return responseList;
	}

	@Override
	public void export() {
		// TODO Auto-generated method stub

	}

	@Override
	public void importProductos(String rutaArchivo) {
		// TODO Auto-generated method stub

	}
}
