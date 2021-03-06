<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
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
	  System.out.println("Error de conexión: " + e.getMessage());
	  System.exit(4);
	}

	try {
		
		Context context = new InitialContext();
		IOrdenCompraService service = (IOrdenCompraService) context.lookup("ejb/OrdenCompraService");
		Integer idInteger = Integer.valueOf( id.toString() );
		OrdenCompraDO ordenCompra = service.getItem( idInteger );
		List<OrdenCompraDO> list = new ArrayList<OrdenCompraDO>();
		list.add( ordenCompra );
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("contexto",this.getServletContext().getRealPath("/"));
		parameters.put("title", "Orden de Compra");
	    parameters.put("confidence", "Esta informaci�n es confidencial y exclusiva para el uso de Conectel.");
	    parameters.put("legalName", "CONECTIVIDAD EN EQUIPOS DE TELECOMUNICACIONES S.A. DE C.V.");
	    parameters.put("rfc", "CET0506085AA");
	    parameters.put("address1", "Calle Laurel No. 62 Col. Agr�cola Pantitl�n");
	    parameters.put("address2", "Del. Iztacalco, M�xico D.F. C.P. 08100");
	    parameters.put("phones", "Tel�fonos: (55) 58-51-93-42/43 (55) 57-01-99-97");
	    parameters.put("maker", "");
	    parameters.put("authorizer","");
	    parameters.put("website","www.conectel.com.mx");
	    parameters.put("area","COMPRAS");
	    parameters.put("phonesContact","58 51 93 42 , 58 51 93 43 EXT 115");
	    JasperReport report = (JasperReport) JRLoader.loadObject( this.getServletContext().getResourceAsStream("/reports/OrdenCompraMaterial.jasper") );
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