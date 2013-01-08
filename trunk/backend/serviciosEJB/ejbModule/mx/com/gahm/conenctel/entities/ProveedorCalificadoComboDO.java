package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

public class ProveedorCalificadoComboDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7756902274495867632L;

	private long id;
	private String etiqueta;

	public ProveedorCalificadoComboDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProveedorCalificadoComboDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}
