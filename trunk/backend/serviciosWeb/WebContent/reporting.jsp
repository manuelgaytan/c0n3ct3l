<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.engine.JREmptyDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporting...</title>
</head>
<body>
	<%=request.getParameter("item")%>
	<%=request.getParameter("id")%>
	<%
		/*
		HashMap<String, Object> response = new HashMap<String, Object>();
		String fileName = "/Users/manuel/temp/EjemploiReport.jxrml";
		String pdfFile = "C:\\temp\\";
		JasperReport mainReport;
		JasperDesign mainReportDesign;

		try {
			mainReportDesign = JRXmlLoader.load(fileName);
			mainReport = JasperCompileManager.compileReport(mainReportDesign);
			pdfFile = pdfFile + "report.pdf";
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					mainReport, response, new JREmptyDataSource());

			if (reportFormat.equalsIgnoreCase("PDF"))
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						pdfFile);
			else if (reportFormat.equalsIgnoreCase("CSV")) {
				JRExporter exporter = new JRCsvExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						pdfFile);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporter.exportReport();
			}

		} catch (JRException e) {
			e.printStackTrace();
		}
		*/		
	%>
</body>
</html>