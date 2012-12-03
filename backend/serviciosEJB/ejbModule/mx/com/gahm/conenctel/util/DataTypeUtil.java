package mx.com.gahm.conenctel.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Conversiones de tipos de datos de Flex a Java.
 *
* @author carlos.leyva
 */
@SuppressWarnings("unchecked")
public class DataTypeUtil {

    /** La constante INSTANCE. */
    private static final DataTypeUtil INSTANCE = new DataTypeUtil();

    /**
     * Constructor.
     */
    private DataTypeUtil() {
        super();
    }

    /**
     * Obtiene una instantcia simple de MedClsDataTypeUtil.
     *
     * @return instancia de MedClsDataTypeUtil
     */
    public static DataTypeUtil getInstance() {
        return INSTANCE;
    }
	
	/**
	 * Convert to short.
	 *
	 * @param <T> el tipo de generico
	 * @param numbers los numbers.
	 * @return short[]
	 */
	public static final <T extends Number> Short[] convertToShort(T[] numbers) {
		if (numbers == null) {
			return null;
		}

		Short[] num = new Short[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			num[i] = numbers[i].shortValue();
		}

		return num;
	}

	/**
	 * Convert to integer.
	 *
	 * @param <T> el tipo de generico
	 * @param numbers los numbers.
	 * @return integer[]
	 */
	public static final <T extends Number> Integer[] convertToInteger(
			T[] numbers) {
		if (numbers == null) {
			return null;
		}

		Integer[] num = new Integer[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			num[i] = numbers[i].intValue();
		}

		return num;
	}

	/**
	 * Convert to long.
	 *
	 * @param <T> el tipo de generico
	 * @param numbers los numbers.
	 * @return long[]
	 */
	public static final <T extends Number> Long[] convertToLong(T[] numbers) {
		if (numbers == null) {
			return null;
		}

		Long[] num = new Long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			num[i] = numbers[i].longValue();
		}

		return num;
	}

	/**
	 * Convert to long.
	 *
	 * @param numbers los numbers.
	 * @return object
	 */
	public static final Object convertToLong(Object numbers) {
		if (numbers == null) {
			return null;
		}

		if (numbers.getClass().isArray()) {
			Object[] objs = (Object[]) numbers;
			Long[] num = new Long[objs.length];

			for (int i = 0; i < objs.length; i++) {
				num[i] = Long.valueOf(objs[i].toString());
			}

			return num;
		} else if (numbers instanceof Collection) {
			final List<Long> list = new ArrayList<Long>();

			for (Object object : ((Collection) numbers)) {
				list.add(Long.valueOf(object.toString()));
			}

			return list;
		} else {
			return Long.valueOf(numbers.toString());
		}
	}

	/**
	 * Convert to integer.
	 *
	 * @param numbers los numbers.
	 * @return object
	 */
	public static final Object convertToInteger(Object numbers) {
		if (numbers == null) {
			return null;
		}

		if (numbers.getClass().isArray()) {
			Object[] objs = (Object[]) numbers;
			Integer[] num = new Integer[objs.length];

			for (int i = 0; i < objs.length; i++) {
				num[i] = Integer.valueOf(objs[i].toString());
			}

			return num;
		} else if (numbers instanceof Collection) {
			final List<Integer> list = new ArrayList<Integer>();

			for (Object object : ((Collection) numbers)) {
				list.add(Integer.valueOf(object.toString()));
			}

			return list;
		} else {
			return  Integer.valueOf(numbers.toString());
		}
	}

	/**
	 * Convert to big decimal.
	 *
	 * @param numbers los numbers.
	 * @return object
	 */
	public static final Object convertToBigDecimal(Object numbers) {
		if (numbers == null) {
			return null;
		}

		if (numbers.getClass().isArray()) {
			Object[] objs = (Object[]) numbers;
			BigDecimal[] num = new BigDecimal[objs.length];

			for (int i = 0; i < objs.length; i++) {
				num[i] = new BigDecimal(objs[i].toString());
			}

			return num;
		} else if (numbers instanceof Collection) {
			final List<BigDecimal> list = new ArrayList<BigDecimal>();

			for (Object object : ((Collection) numbers)) {
				list.add(new BigDecimal(object.toString()));
			}

			return list;
		} else {
			return new BigDecimal(numbers.toString());
		}
	}

	/**
	 * Convert to list serizable.
	 *
	 * @param <T> el tipo de generico
	 * @param lista la lista.
	 * @param clase la clase.
	 * @return list
	 */
	/*
	 * public static <T extends BaseDTO> List<T> convertToList(Collection<Long>
	 * lista, Class<T> clase) { List<T> listaNueva = new ArrayList<T>();
	 * for(Long id : lista) { try { T elemento = clase.newInstance();
	 * elemento.setId(id); listaNueva.add(elemento); } catch(Exception err) {
	 * logger.warn(err.getMessage()); } } return listaNueva; }
	 */

	/**
	 * 
	 * @param <T>
	 * @param lista
	 * @param clase
	 * @return
	 */

	public static <T extends Serializable> List<T> convertToListSerizable(
			Collection<Long> lista, Class<T> clase) {
		List<T> listaNueva = new ArrayList<T>();

		for (Long id : lista) {
			try {
				T elemento = clase.newInstance();
				Field campo = elemento.getClass().getDeclaredField("id");
				campo.set(elemento, id);

				listaNueva.add(elemento);
			} catch (Exception err) {
			}
		}
		return listaNueva;
	}

	/**
	 * Distinct list.
	 *
	 * @param <T> el tipo de generico
	 * @param lista la lista.
	 * @param property el property
	 * @return list
	 */
	/*
	 * public static <T extends BaseDTO> List<T> convertToList(Collection<T>
	 * lista) { List<T> listaNueva = new ArrayList<T>(); for(T elemento : lista)
	 * { listaNueva.add(elemento); } return listaNueva; }
	 */

	/**
	 * 
	 * @param <T>
	 * @param lista
	 * @param property
	 * @return
	 */
	public static final <T extends Serializable> List<T> distinctList(
			List<T> lista, String property) {
		Hashtable<Object, T> listaR = new Hashtable<Object, T>();

		for (T object : lista) {
			try {
				Field field = object.getClass().getDeclaredField(property);
				field.setAccessible(true);

				Object id = field.get(object);

				if (!listaR.containsKey(id)) {
					listaR.put(id, object);
				}
			} catch (Exception err) {
				listaR.clear();
				listaR = null;

				return lista;
			}
		}

		return new ArrayList<T>(listaR.values());
	}

	/**
	 * Obtiene list.
	 *
	 * @param <T> el tipo de generico
	 * @param object el object
	 * @return list
	 */
	public static final <T extends Serializable> List<T> getList(T... object) {
		List<T> numbers = new ArrayList<T>();
		if (object != null && object.length > 0) {
			numbers.addAll(Arrays.asList(object));
		}
		return numbers;
	}

	/**
	 * Obtiene list id.
	 *
	 * @param <T> el tipo de generico
	 * @param lista la lista.
	 * @return list id
	 */
	public static final <T extends Serializable> List<Long> getListId(
			List<T> lista) {
		return getListProperty(lista, "id");
	}

	/**
	 * Obtiene list property.
	 *
	 * @param <T> el tipo de generico
	 * @param lista la lista.
	 * @param property el property
	 * @return list property
	 */
	public static final <T extends Serializable> List<Long> getListProperty(
			List<T> lista, String property) {
		List<Long> listaId = new ArrayList<Long>();
		Long id = null;
		String properties[] = property.split("\\.");
		for (T object : lista) {
			for (String propertyActual : properties) {
				try {
					StringBuffer getter = new StringBuffer("get");
					getter.append(propertyActual.toUpperCase().charAt(0))
							.append(propertyActual.substring(1));
					object = (T) object.getClass().getMethod(getter.toString(),
							(Class[]) null).invoke(object, (Object[]) null);
					if (object instanceof Long) {
						id = (Long) object;
						listaId.add(id);
					}
				} catch (Exception err) {
					continue;
				}
			}
		}
		return listaId;
	}

	/**
	 * Obtiene no unique list property.
	 *
	 * @param <T> el tipo de generico
	 * @param <R> el tipo de generico
	 * @param lista la lista.
	 * @param property el property
	 * @return no unique list property
	 */
	public static final <T extends Serializable, R> List<R> getNoUniqueListProperty(
			List<T> lista, String property) {
		List<R> listaId = new ArrayList<R>();
		String propertyActual = null;
		String properties[] = property.split("\\.");
		for (T object : lista) {
			for (int i = 0; i < properties.length; i++) {
				propertyActual = properties[i];
				try {
					StringBuffer getter = new StringBuffer("get");
					getter.append(propertyActual.toUpperCase().charAt(0))
							.append(propertyActual.substring(1));
					object = (T) object.getClass().getMethod(getter.toString(),
							(Class[]) null).invoke(object, (Object[]) null);
					if (i == (properties.length - 1)) {
						listaId.add((R) object);
					}
				} catch (Exception err) {
					continue;
				}
			}
		}
		return listaId;
	}

	/**
	 * Obtiene unique list property.
	 *
	 * @param <T> el tipo de generico
	 * @param <R> el tipo de generico
	 * @param lista la lista.
	 * @param property el property
	 * @return unique list property
	 */
	public static final <T extends Serializable, R> Set<R> getUniqueListProperty(
			List<T> lista, String property) {
		Set<R> listaId = new TreeSet<R>();
		String propertyActual = null;
		String properties[] = property.split("\\.");
		for (T object : lista) {
			for (int i = 0; i < properties.length; i++) {
				propertyActual = properties[i];
				try {
					StringBuffer getter = new StringBuffer("get");
					getter.append(propertyActual.toUpperCase().charAt(0))
							.append(propertyActual.substring(1));
					object = (T) object.getClass().getMethod(getter.toString(),
							(Class[]) null).invoke(object, (Object[]) null);
					if (i == (properties.length - 1)) {
						listaId.add((R) object);
					}
				} catch (Exception err) {
					continue;
				}
			}
		}
		return listaId;
	}

	/**
	 * Obtiene total list property.
	 *
	 * @param <T> el tipo de generico
	 * @param lista la lista.
	 * @param property el property
	 * @return total list property
	 */
	public static final <T extends Serializable> BigDecimal getTotalListProperty(
			List<T> lista, String property) {
		BigDecimal total = BigDecimal.ZERO;
		String propertyActual = null;
		String properties[] = property.split("\\.");
		for (T object : lista) {
			for (int i = 0; i < properties.length; i++) {
				propertyActual = properties[i];
				try {
					StringBuffer getter = new StringBuffer("get");
					getter.append(propertyActual.toUpperCase().charAt(0))
							.append(propertyActual.substring(1));
					object = (T) object.getClass().getMethod(getter.toString(),
							(Class[]) null).invoke(object, (Object[]) null);
					if (object instanceof BigDecimal) {
						BigDecimal parcial = (BigDecimal) object;
						total = total.add(parcial);
					}
				} catch (Exception err) {
					continue;
				}
			}
		}
		return total;
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param cadena la cadena.
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(String cadena) {
		return (cadena == null || cadena.length() == 0);
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param lista la lista.
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(List lista) {
		return (lista == null || lista.isEmpty());
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param number el number
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(Number number) {
		return ((number == null) || (number.doubleValue() == 0));
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param number el number
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(Number number[]) {
		boolean result = true;
		for (Number num : number) {
			result = isEmpty(num);
			if (!result) {
				break;
			}
		}
		return result;
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param number el number
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(BigDecimal... number) {
		boolean result = true;
		for (BigDecimal num : number) {
			result = isEmpty(num);
			if (!result) {
				break;
			}
		}
		return result;
	}

	/**
	 * Verifica si es empty.
	 *
	 * @param number el number
	 * @return true, si es empty
	 */
	public static final boolean isEmpty(BigInteger... number) {
		boolean result = true;
		for (BigInteger num : number) {
			result = isEmpty(num);
			if (!result) {
				break;
			}
		}
		return result;
	}

	/**
	 * Verifica si es empty or.
	 *
	 * @param number el number
	 * @return true, si es empty or
	 */
	public static final boolean isEmptyOr(Number... number) {
		boolean result = true;
		for (Number num : number) {
			result = isEmpty(num);
			if (result) {
				break;
			}
		}
		return result;
	}

	/**
	 * Metodo para concatenar cadenas.
	 *
	 * @param arg1 el arg1
	 * @param args los args.
	 * @return string
	 */
	public static final String concat(String arg1, Object... args) {
		StringBuffer buf = new StringBuffer(arg1);
		for (Object arg : args) {
			buf.append(arg == null ? "null" : arg.toString());
		}
		return buf.toString();
	}

	/**
	 * Insert string.
	 *
	 * @param str el str
	 * @param num el num
	 * @return string
	 */
	public static String insertString(String str, int num) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buf.append(str);
		}
		return buf.toString();
	}

}
