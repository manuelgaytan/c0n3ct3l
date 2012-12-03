package mx.com.gahm.conectel.clientservice;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.com.gahm.conenctel.services.IFooService;

public class FooServiceClient {
	public static void main(String[] args) {
		try{
			InitialContext contexto = new InitialContext();
			IFooService bean = ( IFooService ) contexto.lookup("ejb/FooService");//java:global/servicios/serviciosEJB/FooService!mx.com.gahm.conenctel.services.IFooService");
			System.out.println( bean.saluda("Manuel Gaytan") );
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
