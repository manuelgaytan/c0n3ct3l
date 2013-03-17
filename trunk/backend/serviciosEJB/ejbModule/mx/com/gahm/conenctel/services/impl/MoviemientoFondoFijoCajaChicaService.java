/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

			entityManager.persist(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}


	@Override
	public MoviemientoFondoFijoCajaChicaDO update(MoviemientoFondoFijoCajaChicaDO item) {
		entityManager.merge(item);

		return item;
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
