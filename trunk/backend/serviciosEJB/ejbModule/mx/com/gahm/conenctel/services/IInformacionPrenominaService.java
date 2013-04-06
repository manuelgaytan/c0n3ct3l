package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.InformacionPrenominaDO;

@Remote
public interface IInformacionPrenominaService {
	List<InformacionPrenominaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	InformacionPrenominaDO save( InformacionPrenominaDO item );
	InformacionPrenominaDO update( InformacionPrenominaDO item );
	InformacionPrenominaDO getItem( Integer id );	
}
