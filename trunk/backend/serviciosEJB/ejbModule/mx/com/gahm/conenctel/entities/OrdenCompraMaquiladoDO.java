package mx.com.gahm.conenctel.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrdenCompraMaquilado")
@NamedQueries({
	@NamedQuery(name = "OrdenCompraMaquiladoDO.findAll", query = "select oc from OrdenCompraMaquiladoDO oc"),
	@NamedQuery(name = "OrdenCompraMaquiladoDO.findById", 
				query = "select oc from OrdenCompraMaquiladoDO oc where oc.id = :id")})
public class OrdenCompraMaquiladoDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2659817735727555176L;
	private Integer id;
	private SolicitudServicioMaquiladoDO solicitudServicioMaquilado;
	private Date fecha;
	private ProveedorMaquiladorDO proveedorMaquilador;
	private String claveValidacion;
	private String leyenda;
	
	public static Double OC_QUANTITY = 0.5;
	public static String OC_UNIT = "PROYECTO";
	public static String OC_SITE = "SITIO";
	public static String OC_ADVANCE = "ANTICIPO";
	public static String OC_SETTLEMENT = "FINIQUITO";
	public static Double IVA = 0.16;
	
	public OrdenCompraMaquiladoDO() {
	}

	public OrdenCompraMaquiladoDO(SolicitudServicioMaquiladoDO solicitudServicioMaquilado,
			Date fecha, ProveedorMaquiladorDO proveedorMaquilador) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
		this.fecha = fecha;
		this.proveedorMaquilador = proveedorMaquilador;
	}

	public Double getSubtotal(){
		Double subtotal = 0d;
		for (PartidaOrdenCompraSolicitudServicioMaquilado item : this.getPartidas()) {
			subtotal += item.getImporte();
		}
		return subtotal;
	}
	
	public Double getIva(){
		Double iva = this.getSubtotal() * IVA;
		return iva;
	}
	
	public Double getTotal(){
		Double total = this.getSubtotal() + this.getIva();
		return total;
	}
	
	public List<PartidaOrdenCompraSolicitudServicioMaquilado> getPartidas(){
		List<PartidaOrdenCompraSolicitudServicioMaquilado> partidasOrdenCompraMaquilado = new ArrayList<PartidaOrdenCompraSolicitudServicioMaquilado>();
		Integer i = 1;
		if( this.getSolicitudServicioMaquilado().getProyectoPadre() == null ){
			this.dividirProyecto(partidasOrdenCompraMaquilado, i, this.getSolicitudServicioMaquilado().getProyecto());
		}else{
			for (ProyectoPadreHijoDO proyectoPadreHijo : this.getSolicitudServicioMaquilado().getProyectoPadre().getProyectoPadreHijos() ) {
				this.dividirProyecto(partidasOrdenCompraMaquilado, i, proyectoPadreHijo.getProyecto());
				i+=2;
			}
		}
		return partidasOrdenCompraMaquilado;
	}
	
	private void dividirProyecto(List<PartidaOrdenCompraSolicitudServicioMaquilado> partidasOrdenCompraMaquilado, Integer i, ProyectoDO proyecto){
		if( proyecto == null ){
			return;
		}
		PartidaOrdenCompraSolicitudServicioMaquilado entry = null;
		entry = new PartidaOrdenCompraSolicitudServicioMaquilado();
		entry.setPartida( i );
		entry.setCantidad( OC_QUANTITY );
		entry.setUnidad( OC_UNIT );
		entry.setDescripcion( OC_ADVANCE + " " + proyecto.getProducto().getModelo() + 
							"\n" + proyecto.getProducto().getActividadRealizar() + ", " + proyecto.getProducto().getEquipo() + 
							"\n" + proyecto.getProducto().getTipoServicio() + " " + OC_SITE + " " + proyecto.getCentralSitio() );
		if( proyecto.getProducto().getTipoServicio().compareTo( ProductoDO.TIPO_SERVICIO_LOCAL ) == 0 ){
			entry.setCosto( proyecto.getProducto().getCostoLocalProveedor() );
		}
		if( proyecto.getProducto().getTipoServicio().compareTo( ProductoDO.TIPO_SERVICIO_FORANEO ) == 0 ){
			entry.setCosto( proyecto.getProducto().getCostoForaneoProveedor() );
		}
		entry.setImporte( entry.getCantidad() * entry.getCosto() );
		partidasOrdenCompraMaquilado.add( entry );
		i++;
		entry = new PartidaOrdenCompraSolicitudServicioMaquilado();
		entry.setPartida( i );
		entry.setCantidad( OC_QUANTITY );
		entry.setUnidad( OC_UNIT );
		entry.setDescripcion( OC_SETTLEMENT + " " + proyecto.getProducto().getModelo() + 
			"\n" + proyecto.getProducto().getActividadRealizar() + ", " + proyecto.getProducto().getEquipo() + 
			"\n" + proyecto.getProducto().getTipoServicio() + " " + OC_SITE + " " + proyecto.getCentralSitio() );
		if( proyecto.getProducto().getTipoServicio().compareTo( ProductoDO.TIPO_SERVICIO_LOCAL ) == 0 ){
			entry.setCosto( proyecto.getProducto().getCostoLocalProveedor() );
		}
		if( proyecto.getProducto().getTipoServicio().compareTo( ProductoDO.TIPO_SERVICIO_FORANEO ) == 0 ){
			entry.setCosto( proyecto.getProducto().getCostoForaneoProveedor() );
		}
		entry.setImporte( entry.getCantidad() * entry.getCosto() );
		partidasOrdenCompraMaquilado.add( entry );
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
   	@JoinColumn(name="fk_solicitud_servicio_maquilado", nullable = false)
	public SolicitudServicioMaquiladoDO getSolicitudServicioMaquilado() {
		return this.solicitudServicioMaquilado;
	}

	public void setSolicitudServicioMaquilado(
			SolicitudServicioMaquiladoDO solicitudServicioMaquilado) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@ManyToOne
   	@JoinColumn(name="fk_proveedor_maquilador", nullable = false)
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return this.proveedorMaquilador;
	}

	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}

	@Column(name="clave_validacion")
	public String getClaveValidacion() {
		return claveValidacion;
	}

	public void setClaveValidacion(String claveValidacion) {
		this.claveValidacion = claveValidacion;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

}