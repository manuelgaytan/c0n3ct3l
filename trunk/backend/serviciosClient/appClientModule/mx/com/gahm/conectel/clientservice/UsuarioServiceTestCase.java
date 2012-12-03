package mx.com.gahm.conectel.clientservice;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.Usuario;
import mx.com.gahm.conenctel.services.IUsuarioService;

import org.junit.Before;
import org.junit.Test;

public class UsuarioServiceTestCase {

	IUsuarioService bean = null;
	
	@Before
	public void setUp() throws Exception {
		InitialContext contexto = new InitialContext();
		bean = ( IUsuarioService ) contexto.lookup("java:global/servicios/serviciosEJB/UsuarioService!mx.com.gahm.conenctel.services.IUsuarioService");
	}

	@Test
	public final void testGetAll() {
		System.out.println("inicio - testGetAll()");
		try {
//			for (Usuario iterable_element : bean.getAll()) {
//				System.out.println(iterable_element.getId() + " " + iterable_element.getNombreCompleto());
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fin - testGetAll()");
	}

	@Test
	public final void testLogin() {
		Usuario user = null;
		try {
//			user = bean.login("manu", "manu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getId() + " " + user.getNombreCompleto());
	}

	@Test
	public final void testSave() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDeleteUsuarios() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetUsuario() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAllPerfiles() {
		fail("Not yet implemented"); // TODO
	}

}
