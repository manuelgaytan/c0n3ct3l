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
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
   	@JoinColumn(name="fk_solicitud_servicio_maquilado", nullable = false)
	private SolicitudServicioMaquiladoDO solicitudServicioMaquilado;
	@Column(name = "fecha", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fecha;
	@ManyToOne
   	@JoinColumn(name="fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO proveedorMaquilador;
	@Column(name="subtotal", nullable=false, precision=10, scale=0)
	private Double subtotal;
	@Column(name="iva", nullable=false, precision=10, scale=0)
	private Double iva;
	@Column(name="ieps", precision=10, scale=0)
	private Double ieps;
	@Column(name="retencion_isr", precision=10, scale=0)
	private Double retencionIsr;
	@Column(name="retencion_iva", precision=10, scale=0)
	private Double retencionIva;
	@Column(name="otros_impuestos", precision=10, scale=0)
	private Double otrosImpuestos;
	@Column(name="total", nullable=false, precision=10, scale=0)
	private Double total;
	@Column(name="clave_validacion")
	private String claveValidacion;
	private String leyenda;
	@Column(name="importe_letra")
	private String importeLetra;
	@Column(name="anticipo", precision=10, scale=0)
	private Double anticipo;
	@Column(name="finiquito", precision=10, scale=0)
	private Double finiquito;
	
	public static String OC_UNIT = "PROYECTO";
	public static String OC_SITE = "SITIO";
	public static String OC_ADVANCE = "ANTICIPO";
	public static String OC_SETTLEMENT = "FINIQUITO";
	public static Double IVA = 0.16;
	
	public OrdenCompraMaquiladoDO() {
	}

	public OrdenCompraMaquiladoDO(SolicitudServicioMaquiladoDO solicitudServicioMaquilado,
			Double subtotal, Double iva, Double total, Date fecha, ProveedorMaquiladorDO proveedorMaquilador) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.fecha = fecha;
		this.proveedorMaquilador = proveedorMaquilador;
	}
	/*
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
	*/
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
		entry.setCantidad( this.getAnticipo() );
		entry.setUnidad( OC_UNIT );
		entry.setDescripcion( OC_ADVANCE + " " + proyecto.getProducto().getModelo() + 
							"\n" + proyecto.getProducto().getActividadRealizar() + ", " + proyecto.getProducto().getEquipo() + 
							"\n" + proyecto.getTipoServicio().getTipo() + " " + OC_SITE + " " + proyecto.getCentralSitio() );
		if( proyecto.getTipoServicio().getId() == TipoServicioDO.ID_LOCAL ){
			entry.setCosto( proyecto.getProducto().getCostoLocalProveedor() );
		}
		if( proyecto.getTipoServicio().getId() == TipoServicioDO.ID_FORANEO ){
			entry.setCosto( proyecto.getProducto().getCostoForaneoProveedor() );
		}
		entry.setImporte( entry.getCantidad() * entry.getCosto() );
		partidasOrdenCompraMaquilado.add( entry );
		i++;
		entry = new PartidaOrdenCompraSolicitudServicioMaquilado();
		entry.setPartida( i );
		entry.setCantidad( this.getFiniquito() );
		entry.setUnidad( OC_UNIT );
		entry.setDescripcion( OC_SETTLEMENT + " " + proyecto.getProducto().getModelo() + 
			"\n" + proyecto.getProducto().getActividadRealizar() + ", " + proyecto.getProducto().getEquipo() + 
			"\n" + proyecto.getTipoServicio().getTipo() + " " + OC_SITE + " " + proyecto.getCentralSitio() );
		if( proyecto.getTipoServicio().getId() == TipoServicioDO.ID_LOCAL ){
			entry.setCosto( proyecto.getProducto().getCostoLocalProveedor() );
		}
		if( proyecto.getTipoServicio().getId() == TipoServicioDO.ID_FORANEO ){
			entry.setCosto( proyecto.getProducto().getCostoForaneoProveedor() );
		}
		entry.setImporte( entry.getCantidad() * entry.getCosto() );
		partidasOrdenCompraMaquilado.add( entry );
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudServicioMaquiladoDO getSolicitudServicioMaquilado() {
		return this.solicitudServicioMaquilado;
	}

	public void setSolicitudServicioMaquilado(
			SolicitudServicioMaquiladoDO solicitudServicioMaquilado) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return this.proveedorMaquilador;
	}

	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}

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

	public Double getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Double getIva() {
        return this.iva;
    }
    
    public void setIva(Double iva) {
        this.iva = iva;
    }
    
    public Double getIeps() {
        return this.ieps;
    }
    
    public void setIeps(Double ieps) {
        this.ieps = ieps;
    }
    
    public Double getRetencionIsr() {
        return this.retencionIsr;
    }
    
    public void setRetencionIsr(Double retencionIsr) {
        this.retencionIsr = retencionIsr;
    }
    
    public Double getRetencionIva() {
        return this.retencionIva;
    }
    
    public void setRetencionIva(Double retencionIva) {
        this.retencionIva = retencionIva;
    }
    
    public Double getOtrosImpuestos() {
        return this.otrosImpuestos;
    }
    
    public void setOtrosImpuestos(Double otrosImpuestos) {
        this.otrosImpuestos = otrosImpuestos;
    }
    
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
	public String getImporteLetra() {
		return importeLetra;
	}

	public void setImporteLetra(String importeLetra) {
		this.importeLetra = importeLetra;
	}

	public Double getAnticipo() {
        return this.anticipo;
    }
    
    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }
    
    public Double getFiniquito() {
        return this.finiquito;
    }
    
    public void setFiniquito(Double finiquito) {
        this.finiquito = finiquito;
    }
}