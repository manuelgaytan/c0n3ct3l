package mx.com.gahm.conenctel.constants;

public enum EstadoProyecto {
	ALTA(1), DATOS_GRLS(2), PROYECTO_AB(3), CONFIG(4), CERRADO(5), CANCELADO(6);
	private long id;

	EstadoProyecto(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}
}
