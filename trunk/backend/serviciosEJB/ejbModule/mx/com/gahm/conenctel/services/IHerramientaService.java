package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.HerramientaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IHerramientaService extends Serializable {

	public List<HerramientaDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public HerramientaDO save(HerramientaDO item);

	public HerramientaDO update(HerramientaDO item);

	public HerramientaDO getItem(Long id) throws ConectelException;

}
