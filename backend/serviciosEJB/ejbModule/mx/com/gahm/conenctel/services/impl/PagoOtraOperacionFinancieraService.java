/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioFacturaProveedorDO;
import mx.com.gahm.conenctel.entities.ComentarioPagoOtraOperacionFinancieraDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.entities.PagoOtraOperacionFinancieraDO;
import mx.com.gahm.conenctel.services.IPagoOtraOperacionFinancieraService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/PagoOtraOperacionFinancieraService")
public class PagoOtraOperacionFinancieraService implements IPagoOtraOperacionFinancieraService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<PagoOtraOperacionFinancieraDO> getAll() {
		List<PagoOtraOperacionFinancieraDO> datos= null;
		TypedQuery<PagoOtraOperacionFinancieraDO>  query =null;
		query = entityManager.createNamedQuery("PagoOtraOperacionFinancieraDO.findAll",PagoOtraOperacionFinancieraDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		PagoOtraOperacionFinancieraDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public PagoOtraOperacionFinancieraDO save(PagoOtraOperacionFinancieraDO item) {
		List<ComentarioPagoOtraOperacionFinancieraDO> comentarios = item.getComentariosPagoOtraOperacionFinanciera();
		item.setComentariosPagoOtraOperacionFinanciera(null);
		entityManager.persist(item);
		
		if(comentarios!=null && comentarios.size()>0.)
			saveComentarios(item,comentarios);
		
		return item;
	}

	private void saveComentarios(PagoOtraOperacionFinancieraDO item,List<ComentarioPagoOtraOperacionFinancieraDO> comentarios) {
	    try {
	    	
	    	for (ComentarioPagoOtraOperacionFinancieraDO dato : comentarios) {
	    		dato.setPagoOtraOperacionFinanciera(item);
	    		entityManager.persist(dato.getComentarioTesoreria());
	    		entityManager.persist(item);
			}
	    	
	    	item.setComentariosPagoOtraOperacionFinanciera(comentarios);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public PagoOtraOperacionFinancieraDO update(PagoOtraOperacionFinancieraDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public PagoOtraOperacionFinancieraDO getItem(Integer id) {
		PagoOtraOperacionFinancieraDO cotizacion = entityManager.find(PagoOtraOperacionFinancieraDO.class,id);
		return cotizacion;
	}

}
