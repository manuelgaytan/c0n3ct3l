package mx.com.gahm.conectel.clientservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.entities.CotizacionDO;
import mx.com.gahm.conenctel.entities.OrdenCompraDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.UnidadOrdenCompraDO;
import mx.com.gahm.conenctel.services.IOrdenCompraService;

import org.junit.Before;
import org.junit.Test;

public class OrdenCompraServiceTestCase {

	IOrdenCompraService bean= null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IOrdenCompraService ) contexto.lookup("ejb/OrdenCompraService");
	}
	
	//@Test
	public void testGetItem(){
		
		OrdenCompraDO item= bean.getItem(13);
	}
	
	//@Test
	public void testDelete(){
		List<Integer> idsItems = new ArrayList<Integer>();
		idsItems.add(9);
		idsItems.add(11);
		
		bean.deleteItems(idsItems);
		 
	}
	
	//@Test
	public void save(){
		
		OrdenCompraDO ordenCompra= new OrdenCompraDO();
		ordenCompra.setFecha(new Date());
		ordenCompra.setFechaEntregaAlmacen(new Date());
		ordenCompra.setCotizacion(new CotizacionDO());
		ordenCompra.getCotizacion().setId(1);
		ordenCompra.setProveedorCalificado(new ProveedorCalificadoDO());
		ordenCompra.getProveedorCalificado().setId(1);
		ordenCompra.setProyecto(new ProyectoDO());
		ordenCompra.setRequisicionCompra(new RequisicionCompraDO());
		ordenCompra.getRequisicionCompra().setId(1);
		
		OrdenCompraDO g=bean.save(ordenCompra);
		System.out.println("ID : "+g.getId());
	}
	
	@Test
	public void testFindAll(){
		
		List<OrdenCompraDO> items= bean.getAll();
		
		for (OrdenCompraDO item : items) {
		}
		 
	}
	
}
