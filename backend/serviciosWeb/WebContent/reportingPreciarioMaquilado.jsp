<%@page import="mx.com.gahm.conenctel.model.FiltroProducto"%>
<%@page import="mx.com.gahm.conenctel.entities.ProductoDO"%>
<%@page import="mx.com.gahm.conenctel.services.IProductoService"%>
<%@page import="mx.com.gahm.conenctel.services.IOrdenCompraMaquiladoService"%>
<%@page import="mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO"%>
<%@page import="mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO"%>
<%@page import="mx.com.gahm.conenctel.entities.OrdenCompraDO"%>
<%@page import="mx.com.gahm.conenctel.services.IOrdenCompraService"%>
<%@page import="mx.com.gahm.conenctel.services.ISolicitudAlmacenService"%>
<%@page import="javax.naming.Context"%>
<%@page import="mx.com.gahm.conenctel.services.impl.SolicitudAlmacenService"%>
<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%
	Long id = Long.parseLong( request.getParameter("id") );
	long start = System.currentTimeMillis();
	Connection conn = null;

	//Cargamos el driver JDBC
	try {
	  Class.forName("com.mysql.jdbc.Driver");
	}
	catch (ClassNotFoundException e) {
	  System.out.println("MySQL JDBC Driver not found.");
	  System.exit(1);
	}
	//Para iniciar el Logger.
	//inicializaLogger();
	try {
	  conn = DriverManager.getConnection("jdbc:mysql://localhost/conectel","root", "notiene");
	  conn.setAutoCommit(false);
	}
	catch (SQLException e) {
	  System.out.println("Error de conexiÃ³n: " + e.getMessage());
	  System.exit(4);
	}

	try {
		
		Context context = new InitialContext();
		IProductoService service = (IProductoService) context.lookup("ejb/ProductoService");
		//Integer idInteger = Integer.valueOf( id.toString() );
		Long idLong = Long.valueOf( id.toString() ); 
		System.out.println("\n\n\n----------------------------------------------");
		System.out.println("idLong: " + idLong );
		System.out.println("----------------------------------------------\n\n\n");
		List<ProductoDO> list = null;
		if( id == -1 ){
			list = service.getAllByFiltro(new FiltroProducto());
			System.out.println("\n\n\n----------------------------------------------");
			System.out.println("Se imprimen: " + list.size() );
			System.out.println("----------------------------------------------\n\n\n");
		}else{
			ProductoDO producto = service.getProducto( idLong );
			list = new ArrayList<ProductoDO>();
			list.add( producto );
			System.out.println("\n\n\n----------------------------------------------");
			System.out.println("Nombre Comercial: " + producto.getCliente().getNombreComercial() );
			System.out.println("----------------------------------------------\n\n\n");
		}
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("contexto",this.getServletContext().getRealPath("/"));
		parameters.put("title", "Preciario de Servicios de Telecomunicaciones");
	    parameters.put("confidence", "Esta información es confidencial y exclusiva para el uso de Conectel.");
	    parameters.put("legalName", "CONECTIVIDAD EN EQUIPOS DE TELECOMUNICACIONES S.A. DE C.V.");
	    parameters.put("rfc", "CET0506085AA");
	    parameters.put("address1", "Calle Laurel No. 62 Col. Agrícola Pantitlán");
	    parameters.put("address2", "Del. Iztacalco, México D.F. C.P. 08100");
	    parameters.put("phones", "Teléfonos: (55) 58-51-93-42/43 (55) 57-01-99-97");
	    parameters.put("fecha",new Date());
	    parameters.put("maker", "CLAUDIA E. ROMO PALMERÍN");
	    parameters.put("authorizer","GABRIELA FLORES CASTILLO");
	    parameters.put("website","www.conectel.com.mx");
	    parameters.put("area","COMPRAS");
	    parameters.put("phonesContact","58 51 93 42 , 58 51 93 43 EXT 115");
	    JasperReport report = JasperCompileManager.compileReport(
	          application.getRealPath("/reports/PreciarioMaquilador.jrxml") );
	    JasperPrint print = JasperFillManager.fillReport(report, parameters, beanCollectionDataSource);
	      
      	response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=report.pdf");  
        ServletOutputStream servletOutputStream = response.getOutputStream();  
        JasperExportManager.exportReportToPdfStream(print, servletOutputStream);  
	      
	    response.flushBuffer();
	    servletOutputStream.flush();
	    servletOutputStream.close();
	}catch (Exception e) {
	    e.printStackTrace();
	}finally {
	    /*
	     * Cleanup antes de salir
	     */
	    try {
	      if (conn != null) {
	        conn.rollback();
	        System.out.println("ROLLBACK EJECUTADO");
	        conn.close();
	      }
	    }catch (Exception e) {
	    	e.printStackTrace();
	 	}
	 }
%>
</html>