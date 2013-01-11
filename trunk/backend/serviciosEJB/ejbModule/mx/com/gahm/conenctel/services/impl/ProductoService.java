package mx.com.gahm.conenctel.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.table.TableModel;

import mx.com.gahm.conenctel.entities.ClienteDO;
import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Catalogo;
import mx.com.gahm.conenctel.model.FiltroProducto;
import mx.com.gahm.conenctel.services.IProductoService;
import mx.com.gahm.conenctel.util.CSVParser;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * Session Bean implementation class ProductoService
 */
@Stateless(mappedName = "ejb/ProductoService")
public class ProductoService implements IProductoService {

	@Inject
	private EntityManager entityManager;

	private static final String QUERY_EXPORT_ALL_PRODUCTO = "SELECT CONCAT(c.nombre_comercial,';',p.tipo_proyecto,';',p.teconologia,';',p.equipo,';',p.actividad_realizar,';',p.modelo,';',p.descripcion_servicio,';',p.tipo_servicio,';',p.costo,';',p.dias_implementacion) FROM producto p INNER JOIN cliente c ON p.id_cliente = c.id";

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProductoDO> getAllByFiltro(FiltroProducto productFilter)
			throws ConectelException {
		TypedQuery<ProductoDO> query = entityManager.createNamedQuery(
				"ProductoDO.findByFilter", ProductoDO.class);
		query.setParameter("idCliente", productFilter.getIdCliente());
		query.setParameter("tipoProyecto", productFilter.getTipoProyecto());
		query.setParameter("teconologia", productFilter.getTecnologia());
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
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findTipoProyecto", String.class);
		query.setParameter("idCliente", id);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tipoProyecto;
		for (String current:tipoProyectoList) {
			tipoProyecto = new Catalogo();
			tipoProyecto.setEtiqueta(current);
			responseList.add(tipoProyecto);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getTecnologias(Long idCliente, String tipoProyecto) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findTecnologia", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tecnologia;
		for (String current:tipoProyectoList) {
			tecnologia = new Catalogo();
			tecnologia.setEtiqueta(current);
			responseList.add(tecnologia);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getEquipos(Long idCliente, String tipoProyecto, String tecnologia) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findEquipo", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo equipo;
		for (String current:tipoProyectoList) {
			equipo = new Catalogo();
			equipo.setEtiqueta(current);
			responseList.add(equipo);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getActividadRealizar(Long idCliente, String tipoProyecto, String tecnologia, String equipo) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findActividadRealizar", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		query.setParameter("equipo", equipo);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo actividadRealizar;
		for (String current:tipoProyectoList) {
			actividadRealizar = new Catalogo();
			actividadRealizar.setEtiqueta(current);
			responseList.add(actividadRealizar);
		}
		return responseList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getModelo(Long idCliente, String tipoProyecto, String tecnologia, String equipo, String actividadRealizar) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findModelo", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		query.setParameter("equipo", equipo);
		query.setParameter("actividadRealizar", actividadRealizar);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo modelo;
		for (String current:tipoProyectoList) {
			modelo = new Catalogo();
			modelo.setEtiqueta(current);
			responseList.add(modelo);
		}
		return responseList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getDescripcionServicio(Long idCliente, String tipoProyecto, String tecnologia, String equipo, String actividadRealizar, String modelo) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findDescripcionServicio", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		query.setParameter("equipo", equipo);
		query.setParameter("actividadRealizar", actividadRealizar);
		query.setParameter("modelo", modelo);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo descServicio;
		for (String current:tipoProyectoList) {
			descServicio = new Catalogo();
			descServicio.setEtiqueta(current);
			responseList.add(descServicio);
		}
		return responseList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getTipoServicio(Long idCliente, String tipoProyecto, String tecnologia, String equipo, String actividadRealizar, String modelo, String descripcionServicio) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<String> query = entityManager.createNamedQuery(
				"ProductoDO.findTipoServicio", String.class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		query.setParameter("equipo", equipo);
		query.setParameter("actividadRealizar", actividadRealizar);
		query.setParameter("modelo", modelo);
		query.setParameter("descripcionServicio", descripcionServicio);
		List<String> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo tipoServicio;
		for (String current:tipoProyectoList) {
			tipoServicio = new Catalogo();
			tipoServicio.setEtiqueta(current);
			responseList.add(tipoServicio);
		}
		return responseList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Catalogo> getCosto(Long idCliente, String tipoProyecto, String tecnologia, String equipo, String actividadRealizar, String modelo, String descripcionServicio, String tipoServicio) {
		Long id = (Long) DataTypeUtil.convertToLong(idCliente);
		TypedQuery<Object[]> query = entityManager.createNamedQuery(
				"ProductoDO.findCosto", Object[].class);
		query.setParameter("idCliente", id);
		query.setParameter("tipoProyecto", tipoProyecto);
		query.setParameter("tecnologia", tecnologia);
		query.setParameter("equipo", equipo);
		query.setParameter("actividadRealizar", actividadRealizar);
		query.setParameter("modelo", modelo);
		query.setParameter("descripcionServicio", descripcionServicio);
		query.setParameter("tipoServicio", tipoServicio);
		List<Object[]> tipoProyectoList = null;
		try {
			tipoProyectoList = query.getResultList();
		} catch(NoResultException e) {
		}
		List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo costo;
		for (Object[] current:tipoProyectoList) {
			costo = new Catalogo();
			costo.setId((Long) current[0]);
			costo.setEtiqueta(String.valueOf(current[1]));
			responseList.add(costo);
		}
		return responseList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void export(String rutaArchivo) {
		Query query = entityManager.createNativeQuery(QUERY_EXPORT_ALL_PRODUCTO);
		List<Object> exportList = query.getResultList();
		File file = new File(rutaArchivo);
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (Object current:exportList) {
				bufferedWriter.write((String) current);
				bufferedWriter.newLine();
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void importProductos(String rutaArchivo) throws ConectelException {
		TableModel t = null;
		try {
			t = CSVParser.parse(new File(rutaArchivo));
		} catch (FileNotFoundException e) {
			throw new ConectelException("No se encontro el archivo con la ruta"
					+ rutaArchivo);
		}
		ProductoDO producto = null;
		for (int x = 0; x < t.getRowCount(); x++) {
			producto = new ProductoDO();
			TypedQuery<ClienteDO> query = entityManager.createNamedQuery(
					"ClienteDO.findByName", ClienteDO.class);
			query.setParameter("nombre", t.getValueAt(x, 0));
			ClienteDO cliente = query.getSingleResult();
			producto.setCliente(cliente);
			producto.setTipoProyecto((String) t.getValueAt(x, 1));
			producto.setTeconologia((String) t.getValueAt(x, 2));
			producto.setEquipo((String) t.getValueAt(x, 3));
			producto.setActividadRealizar((String) t.getValueAt(x, 4));
			producto.setModelo((String) t.getValueAt(x, 5));
			producto.setDescripcionServicio((String) t.getValueAt(x, 6));
			producto.setTipoServicio((String) t.getValueAt(x, 7));
			producto.setCosto(Double.valueOf((String) t.getValueAt(x, 8)));
			entityManager.persist(producto);
		}
	}
}
