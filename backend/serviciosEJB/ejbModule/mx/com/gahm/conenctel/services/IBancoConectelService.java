package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.BancoConectelDO;

@Remote
public interface IBancoConectelService {
	List<BancoConectelDO> getAll();
	void deleteItems( List<Integer> idsItems);
	BancoConectelDO save( BancoConectelDO item );
	BancoConectelDO update( BancoConectelDO item );
	BancoConectelDO getItem( Integer id );	
}
