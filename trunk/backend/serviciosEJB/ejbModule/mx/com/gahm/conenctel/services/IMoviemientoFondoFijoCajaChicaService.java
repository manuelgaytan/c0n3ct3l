/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.MoviemientoFondoFijoCajaChicaDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IMoviemientoFondoFijoCajaChicaService {
	List<MoviemientoFondoFijoCajaChicaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	MoviemientoFondoFijoCajaChicaDO save( MoviemientoFondoFijoCajaChicaDO item );
	MoviemientoFondoFijoCajaChicaDO update( MoviemientoFondoFijoCajaChicaDO item );
	MoviemientoFondoFijoCajaChicaDO getItem( Integer id );
}
