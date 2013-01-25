package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProyectoPadreHijo")
public class ProyectoPadreHijoDO implements java.io.Serializable {


	private static final long serialVersionUID = -2270310946849740625L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="fk_proyecto_padre")
	private ProyectoPadreDO proyectoPadre;
	@OneToOne
	@JoinColumn(name="fk_proyecto")
	private ProyectoDO proyecto;


	public ProyectoPadreHijoDO() {
	}

	public ProyectoPadreHijoDO(ProyectoPadreDO proyectoPadre, ProyectoDO proyecto) {
		this.proyectoPadre = proyectoPadre;
		this.proyecto = proyecto;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public ProyectoPadreDO getProyectoPadre() {
		return this.proyectoPadre;
	}

	public void setProyectoPadre(ProyectoPadreDO proyectoPadre) {
		this.proyectoPadre = proyectoPadre;
	}

	
	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

}