/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Manuel Gaytan
 *
 */
@Entity
@Table(name = "Notificacion")
@NamedQueries({
	@NamedQuery(name = "NotificacionDO.findAll", query = "select rc from NotificacionDO rc"),
	@NamedQuery(name = "NotificacionDO.findByFilter", query = "select rc from NotificacionDO rc where rc.perfil.id = :idPerfil")
	})
public class NotificacionDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9129720797707900471L;
	
	public static final String PROYECTO_ALMACEN = "Se ha requerido Material, Herramienta, Equipo — Unidad en el Proyecto con id: ";
	public static final String PROYECTO_VIATICOS = "Se ha requerido Vi‡ticos en el Proyecto con id: ";
	public static final String PROYECTO_CREACION = "Se ha creado un Proyecto con id: ";
	public static final String PROYECTO_TERMINO = "Se ha terminado el Proyecto con id: ";;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_perfil", nullable = false)
	private PerfilDO perfil;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_hora_creacion", nullable = false, length = 10)
	private Date fechaHoraCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_hora_modificacion", nullable = true, length = 10)
	private Date fechaHoraModificacion;
	
	@Column(name = "notificacion", nullable = false)
	private String notificacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado", nullable = false)
	private EstadoNotificacionDO estado;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario_creacion", nullable = false)
	private UsuarioDO usuarioCreacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario_modificacion", nullable = true)
	private UsuarioDO usuarioModificacion;

	public NotificacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificacionDO(Integer id, 
			PerfilDO perfil,
			Date fechaHoraCreacion,
			Date fechaHoraModificacion, 
			String notificacion,
			EstadoNotificacionDO estado, 
			UsuarioDO usuarioCreacion, 
			UsuarioDO usuarioModificacion) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.fechaHoraCreacion = fechaHoraCreacion;
		this.fechaHoraModificacion = fechaHoraModificacion;
		this.notificacion = notificacion;
		this.estado = estado;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PerfilDO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}

	public Date getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}

	public void setFechaHoraCreacion(Date fechaHoraCreacion) {
		this.fechaHoraCreacion = fechaHoraCreacion;
	}

	public Date getFechaHoraModificacion() {
		return fechaHoraModificacion;
	}

	public void setFechaHoraModificacion(Date fechaHoraModificacion) {
		this.fechaHoraModificacion = fechaHoraModificacion;
	}

	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	public EstadoNotificacionDO getEstado() {
		return estado;
	}

	public void setEstado(EstadoNotificacionDO estado) {
		this.estado = estado;
	}

	public UsuarioDO getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(UsuarioDO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public UsuarioDO getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(UsuarioDO usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
}
