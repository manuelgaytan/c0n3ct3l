package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ColaboradorDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IColaboradorService extends Serializable {

	public List<ColaboradorDO> getColaborador() throws ConectelException;

}
