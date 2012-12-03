package mx.com.gahm.conenctel.services;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface IFooService extends Serializable {
	public String saluda(String nombre);
}
