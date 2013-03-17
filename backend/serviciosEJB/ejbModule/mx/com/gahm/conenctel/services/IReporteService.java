package mx.com.gahm.conenctel.services;

import javax.ejb.Remote;

@Remote
public interface IReporteService {
	Object getOrdenCompraMateriales();
}
