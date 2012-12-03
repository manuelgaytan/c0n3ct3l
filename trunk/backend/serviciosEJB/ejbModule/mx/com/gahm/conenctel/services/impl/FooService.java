package mx.com.gahm.conenctel.services.impl;

import javax.ejb.Stateless;

import mx.com.gahm.conenctel.services.IFooService;

/**
 * Session Bean implementation class FooService
 */
@Stateless(mappedName = "ejb/FooService")
public class FooService implements IFooService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public FooService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String saluda(String nombre){
    	return "Hello " + nombre;
    }
    
}
