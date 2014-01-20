package components
{
	/*
	* @author				Hugo Na
	* @version				1.0.0
	* @fecha 				16 Ago 2010
	* @objetivo 			Contenedor de la consulta de Asignacion.
	* @Fecha Ultima M.		16 Feb 2011                                 
	* @Autor Ultima M.		Jaime Alberto de Alba Hernandez
	*/
	
	import flash.system.System;
	
	import model.Util;
	
	import mx.collections.ArrayCollection;
	import mx.collections.IViewCursor;
	import mx.formatters.Formatter;

	public class AMClipListado
	{
		private var obj:Object = new Object();
		private var objetoNodos:Object = new Object();
		private var inicio:int = 0;
		private var _customHeader:String = "";
		
		public function AMClipListado(){
		}
		
		public function set customHeader(customHeader:String):void {
			_customHeader = customHeader;	
		}
		
		public function createClip(dataProvider:*, columnasMostrar:Array, columnasOcultar:ArrayCollection = null, columnasFormato:Array = null, columnasFunciones:Array = null, htmlCallbackFormatter:Function = null):String{
			//var tmpString:String = "<html><head><style type=text/css>td {background-color:yellow; width:500 border:2px dotted #000;}</style></head><body><table>";
			var tmpString:String = "<html><head></head><body><table>";
			var filas:*;
			var objetoColumnas:Object = new Object();
			objetoColumnas.columnasMostrar = columnasMostrar;
			objetoColumnas.columnasOcultar = columnasOcultar;
			objetoColumnas.columnasFormato = columnasFormato;
			objetoColumnas.columnasFunciones = columnasFunciones;
			
			if(dataProvider != null){
				
				tmpString +="<tr><td colspan="+columnasMostrar.length+"><b>Total de Registros: "+dataProvider.length+"</b></td></tr>";
				tmpString +="<tr><td colspan="+columnasMostrar.length+">"+_customHeader+"</td></tr>";
				
				tmpString += "</table>"
				tmpString += "<table border='1'>"
				
				if(dataProvider is ArrayCollection){
					if(ArrayCollection(dataProvider).length > 0){
						var filas1:ArrayCollection = new ArrayCollection()
						filas1 = ArrayCollection(dataProvider);
						
						tmpString += creatHtmlArray(filas1, dataProvider, objetoColumnas, htmlCallbackFormatter);
					}
				}
				
				else if(dataProvider is Array){
					if(dataProvider.length > 0){
						var filas2:Array = new Array()
						filas2 = dataProvider;
						tmpString += creatHtmlArray(filas2, dataProvider, objetoColumnas)
					}
				}
/*				
				else if(dataProvider is HierarchicalCollectionView){
					if(HierarchicalCollectionView(dataProvider).length >0){
						var filas3:HierarchicalCollectionView = new HierarchicalCollectionView()
						filas3 = HierarchicalCollectionView(dataProvider);
						try{
							tmpString += creatHtmlGrupo(dataProvider, objetoColumnas);
						}
						catch(error:Error){}
					}
				}
*/
			}
			tmpString += "</table></body></html>"
			System.setClipboard(tmpString);
			return tmpString;
		}
		
		public function creatHtmlArray(filas:*, dataProvider:*, objetoColumnas:Object, htmlCallbackFormatter:Function = null):String{
			var tmpString:String = "";
			var columnasMostrar:Array = new Array();
			var columnasOcultar:ArrayCollection = new ArrayCollection();
			var columnasFormato:Array = new Array();
			var columnasFunciones:Array = new Array();
			
			columnasMostrar = objetoColumnas.columnasMostrar;
			columnasOcultar = objetoColumnas.columnasOcultar;
			columnasFormato = objetoColumnas.columnasFormato;
			columnasFunciones = objetoColumnas.columnasFunciones;
			
			if ((filas != null) && (filas != null)){
				for (var i:int; i < filas.length; i++){
					var objeto:Object = new Object() 
					objeto = filas.getItemAt(i);
					if(columnasMostrar != null){
						if(columnasMostrar.length){
							//header
							if(i == 0){
								tmpString += "<tr>";
								for (var z:int=0; z < columnasMostrar.length; z++){
									var columnaActual:Object = new Object();
									columnaActual = columnasMostrar[z];
									var width:String = columnaActual.hasOwnProperty("width") ? "width='"+columnaActual.width+"'" : "";
									try{
										//Columnas Ocultar
										var mostrarColumna:Boolean = true;
										if( (columnasOcultar != null) && (columnasOcultar.length>0) && (columnasOcultar.getItemIndex(z) > -1) ) mostrarColumna = false;
										if(mostrarColumna) tmpString += "<td style='text-align:center; color: #000000; font-size: 12pt; font-weight:bold;' "+width+">" + columnaActual.headerText + "</td>";
									}
									catch(error:Error){}
								}
								tmpString += "</tr>";
							}
							
							tmpString += "<tr>";
					
							for (var y:int=0; y < columnasMostrar.length; y++){
								var columnaActual1:Object = new Object();
								columnaActual1 = columnasMostrar[y];
								try{
									//Columnas Ocultar
									var mostrarColumna1:Boolean = true;
									if( (columnasOcultar != null) && (columnasOcultar.length>0) && (columnasOcultar.getItemIndex(y) > -1) ) mostrarColumna1 = false;
									if(mostrarColumna1){
										if (( Util.extractObject( objeto, columnaActual1.dataField) != "undefined") && ( Util.extractObject( objeto, columnaActual1.dataField ) != undefined)) tmpString += obtenerValorTD(objeto, columnaActual1, columnasFormato, y, columnasFunciones, htmlCallbackFormatter);
										else tmpString += "<td></td>";
									}
								}
								catch(error:Error){
									tmpString += "<td></td>";
								}
							}
							tmpString += "</tr>";
						}
					}
				}
			}
			return tmpString;
		}
		
		private function obtenerValorTD(objeto:Object, columnaActual:Object, columnasFormato:Array, indiceActual:int, columnasFunciones:Array, htmlCallbackFormatter:Function = null):String{
			var tmpString:String = "";
			var valorTd:* = Util.extractObject( objeto, columnaActual.dataField );
			var formatoActual:Object = new Object();
			var funcionActual:Object = new Object();
			var align:String = "ALIGN='LEFT'";
			
			//formatter Asignado por la propiedad formatter de la columna.
			if(columnaActual.hasOwnProperty('formatter')){
			 	if(columnaActual.formatter != null){
			 		valorTd =  Formatter(columnaActual.formatter).format(valorTd);
			 		align = "ALIGN='RIGHT'";
			 	}
			}
		 	
		 	//formatter Asignado por columnas
		 	if(columnasFormato != null){
				for (var y:int=0; y < columnasFormato.length; y++){
			 		formatoActual = columnasFormato[y];
			 		if(formatoActual.idColumna == indiceActual){
			 			try{
			 				valorTd = Formatter(formatoActual.fomatter).format(valorTd);
					 		align = "ALIGN='RIGHT'";
			 			}
			 			catch(error:Error){}
			 			break;
					} 
			 	}
			}
			//Ejecutar Funciones
			if(columnasFunciones != null){
				for (var z:int=0; z < columnasFunciones.length; z++){
			 		funcionActual = columnasFunciones[z];
			 		if(funcionActual.idColumna == indiceActual){
			 			try{
			 				var functionEjecutada:Function = new Function();
			 				functionEjecutada = funcionActual.fomatter;
			 				valorTd = functionEjecutada(valorTd, objeto);
			 			}
			 			catch(error:Error){}
			 			break;
					} 
			 	}
			}
			
			if(columnaActual.hasOwnProperty("labelFunction") && columnaActual.labelFunction != null && columnaActual.labelFunction is Function) {
				var labelFunction:Function = columnaActual.labelFunction as Function;
				valorTd = labelFunction(objeto, columnaActual);
			}
			
			var textAlign:String = "left";
			var backgroundColor:String = "#FFFFFF";
/*
			if(columnaActual is AdvancedDataGridColumn) {
				var advColumn:AdvancedDataGridColumn = columnaActual as AdvancedDataGridColumn;
				textAlign = advColumn.getStyle("textAlign") != "" ? advColumn.getStyle("textAlign") : textAlign;
				backgroundColor = advColumn.getStyle("backgroundColor") != "" ? advColumn.getStyle("backgroundColor") : backgroundColor;
			}
*/			
			var htmlFormatterObj:Object = new Object();
			htmlFormatterObj.htmlString = "";
			htmlFormatterObj.htmlTd = valorTd;
			htmlFormatterObj.width = columnaActual.hasOwnProperty("width") ? columnaActual.width : "120%";
			htmlFormatterObj.textAlign = textAlign;
			htmlFormatterObj.backgroundColor = backgroundColor;
			
			var columnWidth:String = columnaActual.hasOwnProperty("width") ? columnaActual.width : "120%";
			
			if(htmlCallbackFormatter != null) htmlFormatterObj = htmlCallbackFormatter(valorTd, columnaActual.dataField, objeto, htmlFormatterObj);
			
		 	tmpString += "<td width='" +  columnWidth +"' style='text-align:"+ htmlFormatterObj.textAlign +"; background-color:"+ htmlFormatterObj.backgroundColor +"'" + " " + htmlFormatterObj.htmlString + ">" + htmlFormatterObj.htmlTd + "</td>";
		 	//tmpString += "<td width='" +  columnWidth +"' style='text-align:"+ htmlFormatterObj.textAlign +";' " + htmlFormatterObj.htmlString + ">" + htmlFormatterObj.htmlTd + "</td>";
		 	return tmpString; 
		}
		
		public function creatHtmlGrupo(dataProvider:*, objetoColumnas:Object):String{
/*		
			var groupingCollection:GroupingCollection = GroupingCollection(HierarchicalCollectionView(dataProvider).source);
			var grouping:Grouping = groupingCollection.grouping;
*/
			var agrupados:Array = new Array();
			var columnasMostrar:Array = new Array();
			var columnasOcultar:ArrayCollection = new ArrayCollection();
			var columnasFormato:Array = new Array();
			var columnasFunciones:Array = new Array();
			
			columnasMostrar = objetoColumnas.columnasMostrar;
			columnasOcultar = objetoColumnas.columnasOcultar;
			columnasFormato = objetoColumnas.columnasFormato;
			columnasFunciones = objetoColumnas.columnasFunciones;
/*			
			agrupados = grouping.fields;
*/			
			var tmpString:String = "";
			if(columnasMostrar != null){
				if(columnasMostrar.length){
					tmpString += "<tr>";
					for (var j:int=0; j < columnasMostrar.length; j++){
						var columnaActual2:Object = new Object();
						columnaActual2 = columnasMostrar[j];
						try{
							tmpString += "<td width='120%' style='text-align:center; color: #000000; font-size: 12pt; font-weight:bold;'>" + columnaActual2.headerText + "</td>";
						}
						catch(error:Error){}
					}
					tmpString += "</tr>";
/*					
					var nodeCursor:IViewCursor =  HierarchicalCollectionView(dataProvider).createCursor();
*/					
					var nodeCursor:IViewCursor = null;  
					while (nodeCursor.current){
						var grupos1:Object = new Object();
						grupos1 = nodeCursor.current;
						var ingresarGrupo:Boolean = new Boolean(false);
						try{ 
							ingresarGrupo = grupos1.hasOwnProperty("GroupLabel");
						}
						catch(error:Error){} 
						if(ingresarGrupo){
							if(grupos1.GroupLabel != null){
								var nombreGrupo:String = grupos1.GroupLabel;
								tmpString += "<tr>";
								tmpString += "<td width='120%' style='color: #000000; font-size: 11pt; font-weight:bold;'>" + nombreGrupo + "</td>";
								tmpString += "</tr>"
								var filas4:ArrayCollection = new ArrayCollection();
								filas4 = grupos1.children;
								if ((filas4 != null) && (filas4 != null)){
									for (var k:int=0; k < filas4.length; k++){
										var objetoFila:Object = new Object() 
										objetoFila = filas4.getItemAt(k);
										
										tmpString += "<tr>";
										for (var y:int=0; y < columnasMostrar.length; y++){
											var columnaActual1:Object = new Object();
											columnaActual1 = columnasMostrar[y];
											try{
												if ((objetoFila[columnaActual1.dataField] != "undefined") && (objetoFila[columnaActual1.dataField] != undefined)) tmpString += obtenerValorTD(objetoFila, columnaActual1, columnasFormato, y, columnasFunciones)
												else tmpString += "<td></td>";
											}
											catch(error:Error){
												tmpString += "<td></td>";
											}
										}
										tmpString += "</tr>";
									}
								}
							}
						}
						nodeCursor.moveNext();
					}
				}
			}
			return tmpString;
		}
		
	}
}