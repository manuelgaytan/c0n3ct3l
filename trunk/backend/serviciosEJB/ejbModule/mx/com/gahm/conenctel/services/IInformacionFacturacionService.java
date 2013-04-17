/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IInformacionFacturacionService {
	List<InformacionFacturacionDO> getAll();
	void deleteItems(List<Integer> idsItems);
	InformacionFacturacionDO save(InformacionFacturacionDO item);
	InformacionFacturacionDO update(InformacionFacturacionDO item);
	InformacionFacturacionDO getItem(Integer id);
	public List<InformacionFacturacionDO> getAllByFiltro(Integer idCliente);
}
