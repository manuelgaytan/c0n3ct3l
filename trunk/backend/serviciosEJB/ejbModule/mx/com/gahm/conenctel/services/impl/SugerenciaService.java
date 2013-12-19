/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioSugerenciaDO;
import mx.com.gahm.conenctel.entities.SugerenciaDO;
import mx.com.gahm.conenctel.services.ISugerenciaService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/SugerenciaService")
public class SugerenciaService implements ISugerenciaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SugerenciaDO> getAll() {
		List<SugerenciaDO> datos= null;
		TypedQuery<SugerenciaDO>  query =null;
		query = entityManager.createNamedQuery("SugerenciaDO.findAll",SugerenciaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SugerenciaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public SugerenciaDO save(SugerenciaDO item) {
		List<ComentarioSugerenciaDO> comentarios =item.getComentariosSugerencia();
		item.setComentariosSugerencia(null);
		entityManager.persist(item);
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void deleteComentarios(Integer id){
		SugerenciaDO item = getItem(id);
		List<ComentarioSugerenciaDO> comentarios = item.getComentariosSugerencia();
		if( comentarios != null ){
			for (ComentarioSugerenciaDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}
	
	private void saveComentarios(SugerenciaDO item,List<ComentarioSugerenciaDO> comentarios){
		if( comentarios != null ){
			for (ComentarioSugerenciaDO comentario : comentarios) {
				entityManager.persist(comentario.getComentarioSistemasGestion());
				comentario.setSugerencia(item);
				entityManager.persist(comentario);
			}
		}
		item.setComentariosSugerencia(comentarios);
	}

	@Override
	public SugerenciaDO update(SugerenciaDO item) {
		deleteComentarios(item.getId());
		List<ComentarioSugerenciaDO> comentarios =item.getComentariosSugerencia();
		item.setComentariosSugerencia(null);
		entityManager.merge(item);
		saveComentarios(item, comentarios);
		return item;
	}

	@Override
	public SugerenciaDO getItem(Integer id) {
		SugerenciaDO cotizacion = entityManager.find(SugerenciaDO.class,id);
		return cotizacion;
	}

}
