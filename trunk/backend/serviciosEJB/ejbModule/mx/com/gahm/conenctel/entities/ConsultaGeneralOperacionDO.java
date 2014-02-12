package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla consultageneraloperacion.
 * 
 * @author Manuel Gaytan
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ConsultaGeneralOperacionDO.findAll", query = "select c from ConsultaGeneralOperacionDO c where c.proyecto.id=3") })
@Table(name="consultageneraloperacion")
public class ConsultaGeneralOperacionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_datos_generales")
	private DatosGeneralesProyectoDO datosGeneralesProyecto;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_desarrollo_proyecto")
	private DesarrolloProyectoABDO desarrolloProyecto;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_configuracion_prueba_entrega")
	private ConfigPruebaEntregaDO configuracionPruebaEntrega;
	
	public ConsultaGeneralOperacionDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}