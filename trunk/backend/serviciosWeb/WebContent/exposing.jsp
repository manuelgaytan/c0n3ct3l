<%@page import="java.io.IOException"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.nio.channels.FileChannel"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exposing File</title>
</head>
<body>
	<%
		String scheme = request.getScheme();             
		String serverName = request.getServerName(); 
		int serverPort = request.getServerPort();    
		String uri = request.getContextPath();
		String url = scheme + "://" +serverName + ":" + serverPort + uri + "/output";
		String urlOutput = url; //"http://localhost:8080/serviciosWeb/output";
		
		String repository = null; //"/Users/manuel/Projects/c0n3ct3l/temp";//"c:/repository";
		String webRepositiry = null; //"/Applications/glassfish3/glassfish/domains/domain1/eclipseApps/servicios/serviciosWeb_war/output";//"C:/Users/Manuel/Documents/conectel/entregas/glassfish3/glassfish/domains/domain1/eclipseApps/servicios/serviciosWeb_war/output";
	
		Properties prop = new Properties();
		try {
			//load a properties file
			prop.load(application.getResourceAsStream("/file.properties"));
			//get the property value and print it out
            System.out.println(prop.getProperty("repositoryPath"));
			System.out.println(prop.getProperty("webRepositiry"));
			repository = prop.getProperty("repositoryPath");
			webRepositiry = prop.getProperty("webRepositiry");
	
		} catch (IOException ex) {
			System.out.println("Error al cargar el archivo de propiedades.");
			repository = "c:/repository";
			webRepositiry = "C:/glassfish3/glassfish/domains/domain1/eclipse/servicios/serviciosWeb_war/output";
			ex.printStackTrace();
	    }

		String fileName = request.getParameter("document");
		
		if( !(fileName == null) ){
		String filePath = repository + "/" + fileName;
		String copyFilePath = webRepositiry + "/" + fileName;
		
		File sourceFile = new File( filePath );
		File destinationFile = new File( copyFilePath );
		/*
		FileChannel source = null;
		FileChannel destination = null;
		*/
		InputStream inStream = null;
		OutputStream outStream = null;

		
		try{
			inStream = new FileInputStream(sourceFile);
    	    outStream = new FileOutputStream(destinationFile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();

			/*
			if( !(sourceFile == null) && sourceFile.exists() ){
				if( !destinationFile.exists() ){
					destinationFile.createNewFile();
				}
				
				source = new FileInputStream( sourceFile ).getChannel();
				destination = new FileInputStream( destinationFile ).getChannel();
				
				long count = 0;
				long size = source.size();
				while( (count += destination.transferFrom( source, count, size-count)) < size );
			}else{
				out.println("No existe el archivo " + fileName);
			}
			*/
		}catch(Exception e){
			e.printStackTrace();
			out.println("No existe el archivo " + fileName);
		}
		/*
		finally{
			if( !(source == null) ){
				source.close();
			}
			if( !(destination == null) ){
				destination.close();
			}
		}
		*/
		}else{
			out.write("No existe nombre del archivo.");
		}
	%>
</body>
</html>