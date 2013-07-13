package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="OrdenCompra"
)

@NamedQueries({
	@NamedQuery(name = "OrdenCompraDO.findAll", query = "select oc from OrdenCompraDO oc"),
	@NamedQuery(name = "OrdenCompraDO.findById", 
				query = "select oc from OrdenCompraDO oc where oc.id = :id"),
	@NamedQuery(name = "OrdenCompraDO.findByProveedor", 
				query = "select oc from OrdenCompraDO oc where oc.proveedorCalificado.proveedorSeleccionado.id = :id")			
	})

public class OrdenCompraDO  implements java.io.Serializable {


   
	private static final long serialVersionUID = 2266679066287264065L;
	
	 private Integer id;
     private Date fecha;
     private ProyectoDO proyecto;
     private Double subtotal;
     private Double iva;
     private Double ieps;
     private Double retencionIsr;
     private Double retencionIva;
     private Double otrosImpuestos;
     private Double total;
     private Date fechaEntregaAlmacen;
     private String leyenda;
     
     private ProveedorCalificadoDO proveedorCalificado;
     private CotizacionDO cotizacion;
     private RequisicionCompraDO requisicionCompra;
     
     	

    public OrdenCompraDO() {
    }

	public OrdenCompraDO(Date fecha,ProveedorCalificadoDO proveedorCalificado, ProyectoDO proyecto, RequisicionCompraDO requisicionCompra, Double subtotal, Double iva, Double total, Date fechaEntregaAlmacen) {
        this.fecha = fecha;
        this.proveedorCalificado = proveedorCalificado;
        this.proyecto = proyecto;
        this.requisicionCompra = requisicionCompra;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.fechaEntregaAlmacen = fechaEntregaAlmacen;
    }
    
    public OrdenCompraDO(CotizacionDO cotizacion, Date fecha, ProveedorCalificadoDO proveedorCalificado, ProyectoDO proyecto, RequisicionCompraDO requisicionCompra, Double subtotal, Double iva, Double ieps, Double retencionIsr, Double retencionIva, Double otrosImpuestos, Double total, Date fechaEntregaAlmacen) {
        this.cotizacion = cotizacion;
        this.fecha = fecha;
        this.proveedorCalificado = proveedorCalificado;
        this.proyecto = proyecto;
        this.requisicionCompra = requisicionCompra;
        this.subtotal = subtotal;
        this.iva = iva;
        this.ieps = ieps;
        this.retencionIsr = retencionIsr;
        this.retencionIva = retencionIva;
        this.otrosImpuestos = otrosImpuestos;
        this.total = total;
        this.fechaEntregaAlmacen = fechaEntregaAlmacen;
    }

   
    @Id 
    @GeneratedValue(strategy=IDENTITY)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @ManyToOne
	@JoinColumn(name="fk_cotizacion")
    public CotizacionDO getCotizacion() {
        return this.cotizacion;
    }
    
    public void setCotizacion(CotizacionDO cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    @OneToOne  
    @JoinColumn(name = "fk_proveedor_calificado")  
       public ProveedorCalificadoDO getProveedorCalificado() {
        return this.proveedorCalificado;
    }
    
    public void setProveedorCalificado(ProveedorCalificadoDO proveedorCalificado) {
        this.proveedorCalificado = proveedorCalificado;
    }
    
    @ManyToOne
	@JoinColumn(name="fk_proyecto")
    public ProyectoDO getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(ProyectoDO proyecto) {
        this.proyecto = proyecto;
    }
    
    @ManyToOne
	@JoinColumn(name="fk_requisicion_compra")
    public RequisicionCompraDO getRequisicionCompra() {
        return this.requisicionCompra;
    }
    
    public void setRequisicionCompra(RequisicionCompraDO requisicionCompra) {
        this.requisicionCompra = requisicionCompra;
    }
    
    
    @Column(name="subtotal", nullable=false, precision=10, scale=0)

    public Double getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    @Column(name="iva", nullable=false, precision=10, scale=0)

    public Double getIva() {
        return this.iva;
    }
    
    public void setIva(Double iva) {
        this.iva = iva;
    }
    
    @Column(name="ieps", precision=10, scale=0)

    public Double getIeps() {
        return this.ieps;
    }
    
    public void setIeps(Double ieps) {
        this.ieps = ieps;
    }
    
    @Column(name="retencion_isr", precision=10, scale=0)

    public Double getRetencionIsr() {
        return this.retencionIsr;
    }
    
    public void setRetencionIsr(Double retencionIsr) {
        this.retencionIsr = retencionIsr;
    }
    
    @Column(name="retencion_iva", precision=10, scale=0)

    public Double getRetencionIva() {
        return this.retencionIva;
    }
    
    public void setRetencionIva(Double retencionIva) {
        this.retencionIva = retencionIva;
    }
    
    @Column(name="otros_impuestos", precision=10, scale=0)

    public Double getOtrosImpuestos() {
        return this.otrosImpuestos;
    }
    
    public void setOtrosImpuestos(Double otrosImpuestos) {
        this.otrosImpuestos = otrosImpuestos;
    }
    
    @Column(name="total", nullable=false, precision=10, scale=0)

    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_entrega_almacen", nullable=false, length=10)

    public Date getFechaEntregaAlmacen() {
        return this.fechaEntregaAlmacen;
    }
    
    public void setFechaEntregaAlmacen(Date fechaEntregaAlmacen) {
        this.fechaEntregaAlmacen = fechaEntregaAlmacen;
    }

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
   








}