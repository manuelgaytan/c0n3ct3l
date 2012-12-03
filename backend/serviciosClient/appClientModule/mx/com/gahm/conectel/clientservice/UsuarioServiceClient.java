package mx.com.gahm.conectel.clientservice;

import javax.naming.InitialContext;

import mx.com.gahm.conenctel.services.IUsuarioService;

public class UsuarioServiceClient{
	public static void main(String[] args) {
		try{
			InitialContext contexto = new InitialContext();
			IUsuarioService bean = ( IUsuarioService ) contexto.lookup("ejb/UsuarioService");
			System.out.println( bean.login("Manuel Gaytan","Manuel Gaytan") );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}