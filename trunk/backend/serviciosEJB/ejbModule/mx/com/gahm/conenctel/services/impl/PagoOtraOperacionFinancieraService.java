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
		saveComentarios(item,comentarios);
		return item;
	}

	private void saveComentarios(PagoOtraOperacionFinancieraDO item,List<ComentarioPagoOtraOperacionFinancieraDO> comentarios) {
    	if( !(comentarios == null) ){ 
	    	for (ComentarioPagoOtraOperacionFinancieraDO dato : comentarios) {
	    		entityManager.persist(dato.getComentarioTesoreria());
	    		dato.setPagoOtraOperacionFinanciera(item);
	    		entityManager.persist(dato);
			}
    	}
    	item.setComentariosPagoOtraOperacionFinanciera(comentarios);
	}
	
	@Override
	public PagoOtraOperacionFinancieraDO update(PagoOtraOperacionFinancieraDO item) {
		this.deleteComentarios( item );
		List<ComentarioPagoOtraOperacionFinancieraDO> comentarios = item.getComentariosPagoOtraOperacionFinanciera();
		item.setComentariosPagoOtraOperacionFinanciera(null);
		entityManager.merge(item);
		saveComentarios(item,comentarios);
		return item;
	}

	private void deleteComentarios(PagoOtraOperacionFinancieraDO itemParam) {
		PagoOtraOperacionFinancieraDO item = entityManager.find(PagoOtraOperacionFinancieraDO.class, itemParam.getId());
		if( item.getComentariosPagoOtraOperacionFinanciera() != null ){
			for (ComentarioPagoOtraOperacionFinancieraDO comentario : item.getComentariosPagoOtraOperacionFinanciera()) {
				entityManager.remove( comentario );
			}
		}
	}

	@Override
	public PagoOtraOperacionFinancieraDO getItem(Integer id) {
		PagoOtraOperacionFinancieraDO cotizacion = entityManager.find(PagoOtraOperacionFinancieraDO.class,id);
		return cotizacion;
	}
}
