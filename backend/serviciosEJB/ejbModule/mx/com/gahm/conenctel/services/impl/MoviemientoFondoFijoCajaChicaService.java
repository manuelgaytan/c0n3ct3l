/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioMoviemientoFondoFijoCajaChicaDO;
import mx.com.gahm.conenctel.entities.MoviemientoFondoFijoCajaChicaDO;
import mx.com.gahm.conenctel.services.IMoviemientoFondoFijoCajaChicaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/MoviemientoFondoFijoCajaChicaService")
public class MoviemientoFondoFijoCajaChicaService implements IMoviemientoFondoFijoCajaChicaService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<MoviemientoFondoFijoCajaChicaDO> getAll() {
		List<MoviemientoFondoFijoCajaChicaDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("MoviemientoFondoFijoCajaChicaDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		MoviemientoFondoFijoCajaChicaDO MoviemientoFondoFijoCajaChicaDO = null;
		for (Integer id : idsItems) {
			MoviemientoFondoFijoCajaChicaDO = entityManager.find(
					MoviemientoFondoFijoCajaChicaDO.class, id);

			if (MoviemientoFondoFijoCajaChicaDO != null) {
				entityManager.remove(MoviemientoFondoFijoCajaChicaDO);
			}
		}
	}

	@Override
	public MoviemientoFondoFijoCajaChicaDO save(MoviemientoFondoFijoCajaChicaDO item) {
		try {
			List<ComentarioMoviemientoFondoFijoCajaChicaDO> comentarios=item.getComentariosMoviemientoFondoFijoCajaChica();
			item.setComentariosMoviemientoFondoFijoCajaChica(null);
			entityManager.persist(item);
			saveComentarios(item,comentarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	private void saveComentarios(MoviemientoFondoFijoCajaChicaDO item,List<ComentarioMoviemientoFondoFijoCajaChicaDO> comentarios){
		if( comentarios != null ){
			for (ComentarioMoviemientoFondoFijoCajaChicaDO comentario : comentarios) {
				comentario.setMoviemientoFondoFijoCajaChica(item);
				entityManager.persist(comentario.getComentarioContabilidad());
				entityManager.persist(comentario);
			}
		}
		item.setComentariosMoviemientoFondoFijoCajaChica(comentarios);
	}

	@Override
	public MoviemientoFondoFijoCajaChicaDO update(MoviemientoFondoFijoCajaChicaDO item) {
		deleteComentarios(item.getId());
		List<ComentarioMoviemientoFondoFijoCajaChicaDO> comentarios = item.getComentariosMoviemientoFondoFijoCajaChica();
		item.setComentariosMoviemientoFondoFijoCajaChica(null);
		entityManager.merge(item);
		saveComentarios(item, comentarios);
		return item;
	}
	
	private void deleteComentarios(Integer id){
		MoviemientoFondoFijoCajaChicaDO item = getItem(id);
		List<ComentarioMoviemientoFondoFijoCajaChicaDO> comentarios=item.getComentariosMoviemientoFondoFijoCajaChica();
		if( comentarios != null ){
			for (ComentarioMoviemientoFondoFijoCajaChicaDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}

	@Override
	public MoviemientoFondoFijoCajaChicaDO getItem(Integer id) {
		MoviemientoFondoFijoCajaChicaDO MoviemientoFondoFijoCajaChicaDO = null;
		try {
			MoviemientoFondoFijoCajaChicaDO = entityManager.find(
					MoviemientoFondoFijoCajaChicaDO.class, id);
		} catch (Exception e) {
			MoviemientoFondoFijoCajaChicaDO = null;
		}
		return MoviemientoFondoFijoCajaChicaDO;
	}
}
