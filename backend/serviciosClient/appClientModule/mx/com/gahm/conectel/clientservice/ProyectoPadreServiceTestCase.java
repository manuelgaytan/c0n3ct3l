package mx.com.gahm.conectel.clientservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.entities.CotizacionDO;
import mx.com.gahm.conenctel.entities.OrdenCompraDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.ProyectoPadreDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.UnidadOrdenCompraDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IOrdenCompraService;
import mx.com.gahm.conenctel.services.IProyectoPadreService;
import mx.com.gahm.conenctel.services.IProyectoService;

import org.junit.Before;
import org.junit.Test;

public class ProyectoPadreServiceTestCase {

	IProyectoService bean= null;
	IProyectoPadreService proyectoPadreService = null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IProyectoService ) contexto.lookup("ejb/ProyectoService");
		proyectoPadreService = ( IProyectoPadreService ) contexto.lookup("ejb/ProyectoPadreService");
	}
	
	@Test
	public void testGetItem(){
		
		ProyectoDO item;
		try {
			item = bean.getProyecto(2);
			if(item!=null)
				System.out.println("Proyecto Padre "+ item.getProyectoPadreHijo().getProyectoPadre().getId()); 
		} catch (ConectelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetHijos(){
		ProyectoPadreDO item;
		//try {
			item = proyectoPadreService.getItem(2);
			if(item!=null)
				System.out.println( "Numero de Hijos "+ item.getProyectoPadreHijos().size() ); 
		//} catch( ConectelException e ) {
//			e.printStackTrace();
	//	}
	}
	
		
}
