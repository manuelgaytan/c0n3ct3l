package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Clase de persistencia para la tabla proyecto.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ProyectoDO.findByFilter", query = "select p from ProyectoDO p where ((:idProyecto is null or :idProyecto = 0) or p.id = :idProyecto) and ((:idCategoria is null or :idCategoria = 0) or p.categoria.id = :idCategoria) and ((:idCliente is null or :idCliente = 0) or p.producto.cliente.id = :idCliente) and ((:tipoProyecto is null or :tipoProyecto = '') or p.producto.tipoProyecto = :tipoProyecto) and ((:tecnologia is null or :tecnologia = '') or p.producto.teconologia = :tecnologia) and ((:equipo is null or :equipo = '') or p.producto.equipo = :equipo) and ((:actividadRealizar is null or :actividadRealizar = '') or p.producto.actividadRealizar = :actividadRealizar) and ((:modelo is null or :modelo = '') or p.producto.modelo = :modelo) and ((:descripcionServicio is null or :descripcionServicio = '') or p.producto.descripcionServicio = :descripcionServicio) and ((:tipoServicio is null or :tipoServicio = '') or p.producto.tipoServicio = :tipoServicio) and ((:costo is null or :costo = 0) or p.producto.costo = :costo)") })
@Table(name = "proyecto")
public class ProyectoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "central_sitio")
	private String centralSitio;

	@Column(name = "fecha_captura")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaCaptura;

	@JoinColumn(name = "id_categoria_proyecto")
	private CategoriaDO categoria;

	@JoinColumn(name = "id_producto")
	private ProductoDO producto;

	@OneToMany(mappedBy = "proyecto")
	private List<ObservacionDO> observaciones;

	@JoinColumn(name = "id_estato")
	private EstadoDO estado;

	@OneToMany(mappedBy = "proyecto")
	private List<RequisicionDO> requisiciones;

	public ProyectoDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public Date getFechaCaptura() {
		return this.fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public CategoriaDO getCategoria() {
		return this.categoria;
	}

	public void setCategoria(CategoriaDO categoria) {
		this.categoria = categoria;
	}

	public ProductoDO getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoDO producto) {
		this.producto = producto;
	}

	public List<ObservacionDO> getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(List<ObservacionDO> observaciones) {
		this.observaciones = observaciones;
	}

	public EstadoDO getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoDO estado) {
		this.estado = estado;
	}

	public List<RequisicionDO> getRequisiciones() {
		return this.requisiciones;
	}

	public void setRequisiciones(List<RequisicionDO> requisiciones) {
		this.requisiciones = requisiciones;
	}

}