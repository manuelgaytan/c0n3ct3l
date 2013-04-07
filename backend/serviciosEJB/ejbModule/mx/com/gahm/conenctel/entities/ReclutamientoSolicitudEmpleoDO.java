/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author MHDolores
 * 
 */
@Entity
@Table(name = "ReclutamientoSolicitudEmpleo")
public class ReclutamientoSolicitudEmpleoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3151207624640553362L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosPrincipalesSolicitanteDO datosPrincipalesSolicitante;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosGeneralesSolicitanteDO datosGeneralesSolicitante;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosFamiliaresSolicitanteDO datosFamiliaresSolicitante;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosEscolaresHabilidadesDO datosEscolaresHabilidades;
	// @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL
	// ,mappedBy="reclutamientoSolicitudEmpleo")
	// private PaqueteriaDO paqueteria;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosUltimoEmpleoSolicitanteDO datosUltimoEmpleoSolicitante;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private DatosSobreConectelSolicitanteDO datosSobreConectelSolicitante;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reclutamientoSolicitudEmpleo")
	private SeleccionReclutamientoDO seleccionReclutamiento;

	// @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL
	// ,mappedBy="reclutamientoSolicitudEmpleo")
	// private InformacionConfidencialColaboradorDO
	// informacionConfidencialColaborador;

	public ReclutamientoSolicitudEmpleoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReclutamientoSolicitudEmpleoDO(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the datosPrincipalesSolicitante
	 */
	public DatosPrincipalesSolicitanteDO getDatosPrincipalesSolicitante() {
		return datosPrincipalesSolicitante;
	}

	/**
	 * @param datosPrincipalesSolicitante
	 *            the datosPrincipalesSolicitante to set
	 */
	public void setDatosPrincipalesSolicitante(
			DatosPrincipalesSolicitanteDO datosPrincipalesSolicitante) {
		this.datosPrincipalesSolicitante = datosPrincipalesSolicitante;
	}

	/**
	 * @return the datosGeneralesSolicitante
	 */
	public DatosGeneralesSolicitanteDO getDatosGeneralesSolicitante() {
		return datosGeneralesSolicitante;
	}

	/**
	 * @param datosGeneralesSolicitante
	 *            the datosGeneralesSolicitante to set
	 */
	public void setDatosGeneralesSolicitante(
			DatosGeneralesSolicitanteDO datosGeneralesSolicitante) {
		this.datosGeneralesSolicitante = datosGeneralesSolicitante;
	}

	/**
	 * @return the datosFamiliaresSolicitante
	 */
	public DatosFamiliaresSolicitanteDO getDatosFamiliaresSolicitante() {
		return datosFamiliaresSolicitante;
	}

	/**
	 * @param datosFamiliaresSolicitante
	 *            the datosFamiliaresSolicitante to set
	 */
	public void setDatosFamiliaresSolicitante(
			DatosFamiliaresSolicitanteDO datosFamiliaresSolicitante) {
		this.datosFamiliaresSolicitante = datosFamiliaresSolicitante;
	}

	/**
	 * @return the datosEscolaresHabilidades
	 */
	public DatosEscolaresHabilidadesDO getDatosEscolaresHabilidades() {
		return datosEscolaresHabilidades;
	}

	/**
	 * @param datosEscolaresHabilidades
	 *            the datosEscolaresHabilidades to set
	 */
	public void setDatosEscolaresHabilidades(
			DatosEscolaresHabilidadesDO datosEscolaresHabilidades) {
		this.datosEscolaresHabilidades = datosEscolaresHabilidades;
	}

	/**
	 * @return the datosUltimoEmpleoSolicitante
	 */
	public DatosUltimoEmpleoSolicitanteDO getDatosUltimoEmpleoSolicitante() {
		return datosUltimoEmpleoSolicitante;
	}

	/**
	 * @param datosUltimoEmpleoSolicitante
	 *            the datosUltimoEmpleoSolicitante to set
	 */
	public void setDatosUltimoEmpleoSolicitante(
			DatosUltimoEmpleoSolicitanteDO datosUltimoEmpleoSolicitante) {
		this.datosUltimoEmpleoSolicitante = datosUltimoEmpleoSolicitante;
	}

	/**
	 * @return the datosSobreConectelSolicitante
	 */
	public DatosSobreConectelSolicitanteDO getDatosSobreConectelSolicitante() {
		return datosSobreConectelSolicitante;
	}

	/**
	 * @param datosSobreConectelSolicitante
	 *            the datosSobreConectelSolicitante to set
	 */
	public void setDatosSobreConectelSolicitante(
			DatosSobreConectelSolicitanteDO datosSobreConectelSolicitante) {
		this.datosSobreConectelSolicitante = datosSobreConectelSolicitante;
	}

	/**
	 * @return the seleccionReclutamiento
	 */
	public SeleccionReclutamientoDO getSeleccionReclutamiento() {
		return seleccionReclutamiento;
	}

	/**
	 * @param seleccionReclutamiento
	 *            the seleccionReclutamiento to set
	 */
	public void setSeleccionReclutamiento(
			SeleccionReclutamientoDO seleccionReclutamiento) {
		this.seleccionReclutamiento = seleccionReclutamiento;
	}

	/**
	 * @return the informacionConfidencialColaborador
	 */
	/*
	 * public InformacionConfidencialColaboradorDO
	 * getInformacionConfidencialColaborador() { return
	 * informacionConfidencialColaborador; }
	 */

	/**
	 * @param informacionConfidencialColaborador
	 *            the informacionConfidencialColaborador to set
	 */
	/*
	 * public void setInformacionConfidencialColaborador(
	 * InformacionConfidencialColaboradorDO informacionConfidencialColaborador)
	 * { this.informacionConfidencialColaborador =
	 * informacionConfidencialColaborador; }
	 */

}
