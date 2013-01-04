package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.RequisicionCompraDO;

@Remote
public interface IRequisicionCompraService {
	List<RequisicionCompraDO> getAll();
	void deleteItems(List<Integer> idsItems);
	RequisicionCompraDO save(RequisicionCompraDO item);
	RequisicionCompraDO update(RequisicionCompraDO item);
	RequisicionCompraDO getItem(Integer id);

}
