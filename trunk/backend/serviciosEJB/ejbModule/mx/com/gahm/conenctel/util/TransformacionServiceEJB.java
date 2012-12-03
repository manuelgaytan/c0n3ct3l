/**
 * 
 */
package mx.com.gahm.conenctel.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import mx.com.gahm.conenctel.exceptions.ConectelMappingException;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

/**
 * Clase que realiza el mapeo de 2 objetos.
 * 
 * @author carlos.leyva
 * @version 1.0
 */
@Stateless
public class TransformacionServiceEJB implements Serializable{

    /** El mapper. */
    private Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance(); ;

    /**
	 * Map.
	 * 
	 * @param <T>
	 *            el tipo de generico
	 * @param source
	 *            el source
	 * @param destinationClass
	 *            Clase deseada del objeto destino.
	 * @return t
	 * @throws MedClsMappingException
	 *             el med cls mapping exception
	 */
	public <T> T map(Object source, Class<T> destinationClass)
			throws ConectelMappingException {
		return (T) mapper.map(source, destinationClass);
	}

    /**
	 * Map.
	 * 
	 * @param <T>
	 *            el tipo de generico
	 * @param source
	 *            el source
	 * @param destinationClass
	 *            el destination class
	 * @param mapId
	 *            el map id
	 * @return t
	 * @throws MedClsMappingException
	 *             el med cls mapping exception
	 */
	public <T> T map(Object source, Class<T> destinationClass, String mapId)
			throws ConectelMappingException {
		return (T) mapper.map(source, destinationClass, mapId);
	}

    /* ------ listas ---------- */
	/**
	 * Map list.
	 * 
	 * @param <S>
	 *            el tipo de generico
	 * @param <D>
	 *            el tipo de generico
	 * @param lista
	 *            el lista
	 * @param claseDestino
	 *            el clase destino
	 * @return list
	 * @throws MedClsMappingException
	 *             el med cls mapping exception
	 */
    public <S extends Serializable, D extends Serializable> List<D> mapList(
	    List<S> lista, Class<D> claseDestino) throws ConectelMappingException {
	return mapList(lista, claseDestino, null);
    }

    /**
	 * Map list.
	 * 
	 * @param <S>
	 *            el tipo de generico
	 * @param <D>
	 *            el tipo de generico
	 * @param lista
	 *            el lista
	 * @param claseDestino
	 *            el clase destino
	 * @param mapId
	 *            el map id
	 * @return list
	 * @throws MedClsMappingException
	 *             el med cls mapping exception
	 */
    public <S extends Serializable, D extends Serializable> List<D> mapList(
	    List<S> lista, Class<D> claseDestino, String mapId)
	    throws ConectelMappingException {
	List<D> listaResultante = new ArrayList<D>();
	D destination = null;
	for (S source : lista) {
	    if (mapId == null) {
		destination = (D) map(source, claseDestino);		
	    } else {
		destination = (D) map(source, (Class<D>) claseDestino, mapId);
	    }
	    listaResultante.add(destination);
	}
	return listaResultante;
    }

}
