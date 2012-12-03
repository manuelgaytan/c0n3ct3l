package mx.com.gahm.conectel.clientservice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Cliente;
import mx.com.gahm.conenctel.model.Contacto;
import mx.com.gahm.conenctel.services.IClienteService;

import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTestCase {

	IClienteService bean = null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IClienteService ) contexto.lookup("ejb/ClienteService");
	}

	@Test
	public final void test() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testGetAll() {
//		try {
//			for (Cliente iterable_element : bean.getAll()) {
//				System.out.println(iterable_element.getId() + " " + iterable_element.getNombreComercial());
//			}
//		} catch (ConectelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Test
	public final void testSave() {
		Cliente client = new Cliente();
		System.out.println("getAll -----");
		this.testGetAll();
		System.out.println("save -----");
		client.setNombreComercial("PATITOS");
		Contacto contact = new Contacto();
		contact.setNombreCompleto("MANU MANITO");
		client.setContacto(contact);
//		try {
//			bean.save(client);
//		} catch (ConectelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("getALl -----");
		this.testGetAll();
		System.out.println("delete -----");
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		bean.deleteClientes(ids );
		System.out.println("getAll -----");
		this.testGetAll();
		System.out.println("-----");
		fail("Not yet implemented"); // TODO
	}

}
