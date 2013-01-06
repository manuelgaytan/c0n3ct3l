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
		if(item!=null)
		System.out.println("orden compra"+ item.getDescripcion()); 
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
		ordenCompra.setCantidad(10L);
		ordenCompra.setCostoUnitario(10L);
		ordenCompra.setDescripcion("Prueba");
		ordenCompra.setFecha(new Date());
		ordenCompra.setFechaEntregaAlmacen(new Date());
		ordenCompra.setCotizacion(new CotizacionDO());
		ordenCompra.getCotizacion().setId(1);
		ordenCompra.setProveedorCalificado(new ProveedorCalificadoDO());
		ordenCompra.getProveedorCalificado().setId(1);
		ordenCompra.setProyecto(new ProyectoDO());
		ordenCompra.getProyecto().setId(1);
		ordenCompra.setRequisicionCompra(new RequisicionCompraDO());
		ordenCompra.getRequisicionCompra().setId(1);
		ordenCompra.setUnidadOrdenCompra(new UnidadOrdenCompraDO());
		ordenCompra.getUnidadOrdenCompra().setId(1);
		ordenCompra.setIeps(10L);
		ordenCompra.setImporte(100L);
		ordenCompra.setIva(10L);
		ordenCompra.setOtrosImpuestos(1L);
		ordenCompra.setRetencionIsr(1L);
		ordenCompra.setTotal(10L);
		ordenCompra.setSubtotal(10L);
		ordenCompra.setRetencionIsr(1L);
		
		OrdenCompraDO g=bean.save(ordenCompra);
		System.out.println("ID : "+g.getId());
	}
	
	@Test
	public void testFindAll(){
		
		List<OrdenCompraDO> items= bean.getAll();
		
		for (OrdenCompraDO item : items) {
			System.out.println("orden compra"+ item.getDescripcion());
		}
		 
	}
	
}
