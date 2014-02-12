package mx.com.gahm.conenctel.model;

import java.io.Serializable;

import mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO;
import mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO;
import mx.com.gahm.conenctel.entities.DesarrolloProyectoABDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;


/**
 * Clase para la consulta general del m&oacute;dulo operaci&oacute;n.
 * 
 * @author Manuel Gayt&aacute;n
 */
public class ConsultaGeneralOperacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	
	private ProyectoDO proyecto;
	
	private DatosGrlsProyectoDO datosGeneralesProyecto;
	
	private DesarrolloProyectoABDO desarrolloProyecto;
	
	private ConfigPruebaEntregaDO configuracionPruebaEntrega;
	
	public ConsultaGeneralOperacion( ProyectoDO proyecto,
			DatosGrlsProyectoDO datosGeneralesProyecto, 
			DesarrolloProyectoABDO desarrolloProyecto, 
			ConfigPruebaEntregaDO configuracionPruebaEntrega ) {
		this.proyecto = proyecto;
		this.datosGeneralesProyecto = datosGeneralesProyecto;
		this.desarrolloProyecto = desarrolloProyecto;
		this.configuracionPruebaEntrega = configuracionPruebaEntrega;
	}

	public ConsultaGeneralOperacion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public DatosGrlsProyectoDO getDatosGeneralesProyecto() {
		return datosGeneralesProyecto;
	}

	public void setDatosGeneralesProyecto(
			DatosGrlsProyectoDO datosGeneralesProyecto) {
		this.datosGeneralesProyecto = datosGeneralesProyecto;
	}

	public DesarrolloProyectoABDO getDesarrolloProyecto() {
		return desarrolloProyecto;
	}

	public void setDesarrolloProyecto(DesarrolloProyectoABDO desarrolloProyecto) {
		this.desarrolloProyecto = desarrolloProyecto;
	}

	public ConfigPruebaEntregaDO getConfiguracionPruebaEntrega() {
		return configuracionPruebaEntrega;
	}

	public void setConfiguracionPruebaEntrega(
			ConfigPruebaEntregaDO configuracionPruebaEntrega) {
		this.configuracionPruebaEntrega = configuracionPruebaEntrega;
	}

	
}