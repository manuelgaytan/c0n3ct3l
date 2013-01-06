package mx.com.gahm.conectel.clientservice;

import java.util.List;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.entities.ProveedorCalificadoComboDO;
import mx.com.gahm.conenctel.services.IProveedorCalificadoService;

import org.junit.Before;
import org.junit.Test;

public class ProveedorCalificadoServiceTestCase {

	IProveedorCalificadoService bean= null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IProveedorCalificadoService ) contexto.lookup("ejb/ProveedorCalificadoService");
	}
	
	
	@Test
	public void testFindAll(){
		
		List<ProveedorCalificadoComboDO> items= bean.getProveedoresCalificadosCombo();
		
		for (ProveedorCalificadoComboDO item : items) {
			System.out.println("orden compra"+ item.getEtiqueta());
		}
		 
	}
	
}
