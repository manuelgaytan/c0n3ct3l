package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO;

@Remote
public interface IOrdenCompraMaquiladoService {
	List<OrdenCompraMaquiladoDO> getAll();
	void deleteItems( List<Integer> idsItems);
	OrdenCompraMaquiladoDO save( OrdenCompraMaquiladoDO item );
	OrdenCompraMaquiladoDO update( OrdenCompraMaquiladoDO item );
	OrdenCompraMaquiladoDO getItem( Integer id );
}
