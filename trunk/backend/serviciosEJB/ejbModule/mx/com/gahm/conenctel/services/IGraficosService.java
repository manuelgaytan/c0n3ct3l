package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.ItemEstatusProyecto;

@Remote
public interface IGraficosService extends Serializable{

	public List<ItemEstatusProyecto> getEstatusProyectos() throws ConectelException;
	public List<ItemEstatusProyecto> getFasesProyectos() throws ConectelException;
}
