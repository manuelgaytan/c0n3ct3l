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
import mx.com.gahm.conenctel.services.IOrdenCompraService;
import mx.com.gahm.conenctel.services.IProyectoPadreService;

import org.junit.Before;
import org.junit.Test;

public class ProyectoServiceTestCase {

	IProyectoPadreService bean= null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IProyectoPadreService ) contexto.lookup("ejb/ProyectoPadreService");
	}
	
	@Test
	public void testGetItem(){
		
		ProyectoPadreDO item= bean.getItem(2);
		if(item!=null)
		System.out.println("Proyecto Padre "+ item.getProyectoPadreHijos().size()); 
	}
	
		
}
