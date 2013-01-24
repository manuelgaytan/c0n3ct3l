package mx.com.gahm.conenctel.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ProyectoPadre")
@NamedQueries({
	@NamedQuery(name = "ProyectoPadreDO.findAll", query = "select oc from ProyectoPadreDO oc"),
	@NamedQuery(name = "ProyectoPadreDO.findById", 
				query = "select pp from ProyectoPadreDO pp where pp.id = :id")})
public class ProyectoPadreDO implements java.io.Serializable {


	/**
	 * 
	 */

	private static final long serialVersionUID = -5698717757882464506L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false, length = 10)
	private Date fechaCreacion;
	@OneToMany(mappedBy="proyectoPadre", fetch = FetchType.EAGER)
	private List<ProyectoPadreHijoDO> proyectoPadreHijos;
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	

	public ProyectoPadreDO() {
	}

	public ProyectoPadreDO(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<ProyectoPadreHijoDO> getProyectoPadreHijos() {
		return proyectoPadreHijos;
	}

	public void setProyectoPadreHijos(List<ProyectoPadreHijoDO> proyectoPadreHijos) {
		this.proyectoPadreHijos = proyectoPadreHijos;
	}
	
}