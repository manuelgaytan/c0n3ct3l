package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProyectoPadreHijo")
public class ProyectoPadreHijoDO implements java.io.Serializable {


	private static final long serialVersionUID = -2270310946849740625L;
	private Integer id;
	private ProyectoPadreDO proyectoPadre;
	private ProyectoDO proyecto;


	public ProyectoPadreHijoDO() {
	}

	public ProyectoPadreHijoDO(ProyectoPadreDO proyectoPadre, ProyectoDO proyecto) {
		this.proyectoPadre = proyectoPadre;
		this.proyecto = proyecto;
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
	@JoinColumn(name="fk_proyecto_padre")
	public ProyectoPadreDO getProyectoPadre() {
		return this.proyectoPadre;
	}

	public void setProyectoPadre(ProyectoPadreDO proyectoPadre) {
		this.proyectoPadre = proyectoPadre;
	}

	@ManyToOne
	@JoinColumn(name="fk_proyecto")
	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

}