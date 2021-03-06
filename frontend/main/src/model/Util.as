package model
{
	import components.TextInput;
	
	import flash.display.DisplayObject;
	import flash.events.TimerEvent;
	import flash.net.URLRequest;
	import flash.net.URLVariables;
	import flash.net.navigateToURL;
	import flash.utils.Timer;
	import flash.utils.getDefinitionByName;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.controls.Alert;
	import mx.controls.ComboBox;
	import mx.controls.List;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.Application;
	import mx.core.Container;
	import mx.formatters.CurrencyFormatter;
	import mx.formatters.DateFormatter;
	import mx.formatters.NumberFormatter;
	import mx.rpc.events.FaultEvent;
	import mx.utils.ObjectUtil;
	import mx.utils.StringUtil;
	

	public class Util
	{
		public function Util()
		{
		}
		
		public static const ID_CONECTEL_FORMAT:String = "CON00000";
		public static const RESTRICT_ALFABETICO:String = "0-9A-ZÑ .,ÁÉÍÓÚ";
		public static const RESTRICT_CLAVE_ALFANUMERICA:String = "0-9A-Z";
		public static const RESTRICT_CORREO_ELECTRONICO:String = "a-zA-Z.@0-9\\-_~";
		
		public static const currencyFormatter:CurrencyFormatter = new CurrencyFormatter();
		public static const numberFormatter:NumberFormatter = new NumberFormatter();
		
			/*
		public static function showMessage(message:MessageSACG, callBackFunction:Function = null):void{
			var title:String;
			switch(message.type)
			{
				case MessageSACG.ERROR:
				{
					title = ResourceManager.getInstance().getString("labels","error");
					break;
				}
				default:
				{
					break;
				}
			}
			Alert.show( message.textMessage, title, 4, null, callBackFunction);
		}
			*/
		
		public static function formatStringToDate(value:String):Date{
			if( value == null ){
				return null;
			}
			var date:Date = new Date();
			date.fullYear = Number(value.substr(0,4));
			date.month = Number(value.substr(5,2))-1;
			date.date = Number(value.substr(8,2));
			date.hours = 0;
			date.minutes = 0;
			date.seconds = 0;
			date.milliseconds = 0;
			return date;
		}
		
		public static function formatDateToString(value:Date):String{
			if( value == null ){
				return null;
			}
			var dateFormatter:DateFormatter = new DateFormatter();
			dateFormatter.formatString = "YYYY-MM-DD";
			return dateFormatter.format( value );
		}
		
		public static function selectedIDs(input:Array):ArrayCollection{
			var values:ArrayCollection = new ArrayCollection();
			for each (var i:Object in input) 
			{
				values.addItem( i["id"] );
			}
			return values.length==0?null:values;
		}
		
		public static function selectedIndexFromCombo(dataProvider:ArrayCollection, key:Object, property:String="id"):Number
		{
			if( dataProvider == null ){
				return -1;
			}
			var value:Number = -1;
			for(var i:Number = 0; i<dataProvider.length; i++) 
			{
				if( dataProvider[i][property] == key ){
					value = i;
					break;
				}
			}
			return value;
		}
		
		public static function numberToString(number:*, empty:Boolean = false):String
		{
			if( number == undefined || number == null || isNaN( number ) ){
				return empty ? "" : null;
			}
			return number.toString();
		}
		
		public static function stringToNumber(text:String, returnZero:Boolean = false):*
		{
			if( StringUtil.trim( text ) == "" ){
				if( returnZero ){
					return 0;
				}else{
					return undefined;
				}
			}
			return Number(text.replace(",",""));
		}
		
		public static function validateEmpty(text:String):String
		{
			if( text == null ){
				return null;
			}
			var value:String = StringUtil.trim( text );
			if( value == "" ){
				return null;
			}
			return value;
		}
		
		public static function formatDateTimeToString(value:Date):String
		{
			if( value == null ){
				return null;
			}
			var dateFormatter:DateFormatter = new DateFormatter();
			dateFormatter.formatString = "YYYY-MM-DD JJ:NN:SS";
			return dateFormatter.format( value );
		}
		
		public static function formatTimeToString(value:Date):String
		{
			if( value == null ){
				return null;
			}
			var dateFormatter:DateFormatter = new DateFormatter();
			dateFormatter.formatString = "JJ:NN:SS";
			return dateFormatter.format( value );
		}
		
		public static function addTimeToDate(time:Date, destino:Date):void
		{
			if( time == null ){
				return;
			}
			destino.hours = time.hours;
			destino.minutes = time.minutes;
			destino.seconds = time.seconds;
			destino.milliseconds = time.milliseconds;
		}
		
		public static function formatStringToDateTime(value:String):Date
		{
			if( value == null ){
				return null;
			}
			var date:Date = new Date();
			date.fullYear = Number(value.substr(0,4));
			date.month = Number(value.substr(5,2))-1;
			date.date = Number(value.substr(8,2));
			date.hours = Number(value.substr(11,2));
			date.minutes = Number(value.substr(14,2));
			date.seconds = Number(value.substr(17,2));
			date.milliseconds = 0;
			return date;
		}
		
		public static function compareOnlyDates(date1:Date, date2:Date):Boolean
		{
			if( date1 == null || date2 == null ){
				return false;
			}
			var same:Boolean = true;
			same &&= date1.fullYear == date2.fullYear;
			same &&= date1.month == date2.month;
			same &&= date1.date == date2.date;
			/*
			same &&= date.hours = Number(value.substr(11,2));
			same &&= date.minutes = Number(value.substr(14,2));
			same &&= date.seconds = Number(value.substr(17,2));
			same &&= date.milliseconds = 0;
			*/
			return same;
		}
		
		/**
		 * Compare dates.
		 * Returns 0 if both dates are the same.
		 * Returns -1 if date1 is greater than date2.
		 * Return 1 if date2 is greater than date1.
		 */
		public static function compareDates(date1:Date, date2:Date):Number
		{
			return ObjectUtil.dateCompare(date1, date2);
		}
		
		public static function cleanList(list:DisplayObject):void
		{
			if( list["dataProvider"] != null && list["dataProvider"] is ArrayCollection ){
				(list["dataProvider"] as ArrayCollection).removeAll();
				(list["dataProvider"] as ArrayCollection).refresh();
			}
			list["dataProvider"] = null;
			list["selectedIndex"] = -1;
		}
		
		public static function showMessageVerifyFields():void
		{
			var message:String = "Por favor, requisite los campos solicitados.";
			Util.showErrorMessage(message);
		}
		
		public static function setFocus(component:ComboBox):void
		{
			if( component == null ){
				return;
			}
			var timer:Timer = new Timer(500,1);
			timer.addEventListener(TimerEvent.TIMER,function(e:TimerEvent):void{
				component.setFocus();
			});
			timer.start();
		}
		
		/**
		 * Add an empty Catalog element in the array.
		 */
		public static function addEmptyCatalgo(array:ArrayCollection, property:String="etiqueta"):ArrayCollection{
			if( array != null ){
				var object:Object = new Object();
				object["id"] = 0;
				object[property] = "";
				array.addItemAt( object, 0 );
			}
			return array;
		}
		
		/**
		 * Add an empty Object element in the array, with any property.
		 */
		public static function addEmptyObject(array:Array, property:String):Array{
			var result:Array = new Array();
			var object:Object = new Object();
			object[property] = "";
			result.push( object );
			if( array != null ){
				return result.concat(array);
			}
			return result;
		}
		
		/**
		 * Remueve elementos de un arreglo a partir de otro.
		 */
		public static function removeItemsAt( elementos:ArrayCollection, arreglo:ArrayCollection):void{
			var ordenamientoNumerico:SortField = new SortField();
			ordenamientoNumerico.numeric = true;
			var ordenamiento:Sort = new Sort();
			ordenamiento.fields = [ordenamientoNumerico];
			elementos.sort = ordenamiento;
			elementos.refresh();
			for(var i:Number=arreglo.length-1; i>=0; i--){
				for(var j:Number=elementos.length-1; j>=0; j--){
					if( i == elementos.getItemAt( j ) ){
						arreglo.removeItemAt( i );
					}
				}
			}
		}
		
		/**
		 * Return the amount in currency format.
		 * If amount is undefined, return "";
		 */
		public static function formatCurrency(amount:*):String
		{
			var valueFormatted:String = "";
			if( amount != undefined ){
				currencyFormatter.precision = 2;
				valueFormatted = currencyFormatter.format( amount );
			}
			return valueFormatted;
		}
		
		public static function formatNumber(number:*):String
		{
			var valueFormatted:String = "";
			if( number != undefined ){
				numberFormatter.precision = 2;
				valueFormatted = numberFormatter.format( number );
			}
			return valueFormatted;
		}
		
		public static function removeItems(dataProvider:Object):void
		{
			if( dataProvider == null ){
				return;
			}
			if( dataProvider is Array ){
				var length:Number = (dataProvider as Array).length;
				for(var i:int=0; i<length; i++) 
				{
					(dataProvider as Array).pop();
				}
			}
			if( dataProvider is ArrayCollection ){
				(dataProvider as ArrayCollection).removeAll();
				(dataProvider as ArrayCollection).refresh();
			}
		}
		
		/**
		 * Rerturns id or correspondent property.
		 */
		public static function selectedId(comboBox:ComboBox,property:String="id"):*
		{
			if( !listBaseSelected(comboBox, property) ){
				return undefined;
			}
			return comboBox.selectedItem[property];
		}
		
		/**
		 * Returns if ComboBox has a selected item.
		 */
		public static function listBaseSelected(comboBox:ComboBox,property:String="id",cero:Boolean=false):Boolean
		{
			if( comboBox == null ||
				comboBox.selectedItem == null ||
				property == null ||
				comboBox.selectedItem[property] == null ||
				comboBox.selectedItem[property] == undefined ){
				return false;
			}
			if( cero && 
				!(comboBox == null) &&
				!(comboBox.selectedItem == null) &&
				!(comboBox.selectedItem[property] == null) &&
				comboBox.selectedItem[property] == 0 ){
				return false;
			}
			if( property == "id" && isNaN(comboBox.selectedItem[property]) ){
				return false;
			}
			return true;
		}
		
		public static function showErrorMessage(mensaje:String):void
		{
			if( mensaje == Constants.TRANSACTION_ABORTED ){
				mensaje = Constants.TRANSACTION_ABORTED_MESSAGE;
			}
			Alert.show(mensaje, Constants.ERROR);
		}
		
		public static function showInfoMessage(mensaje:String):void
		{
			Alert.show(mensaje, Constants.INFO);
		}
		
		public static function showProperties(object:Object):void
		{
			 //Alert.show( ObjectUtil.toString( object ), "Show Properties" );
		}
		
		public static function isFill(cmbProfile:ComboBox):Boolean
		{
			var value:Boolean = false;
			if( cmbProfile != null &&
				cmbProfile.dataProvider != null &&
				(cmbProfile.dataProvider is ArrayCollection) &&
				(cmbProfile.dataProvider as ArrayCollection).length > 0 ){
				value = true;
			}
			return value;
		}
		
		public static function extractObject(object:Object, property:String):Object
		{
			if( object == null || property == null ){
				return null;
			}
			var text:String = "";
			var properties:Array = property.split(".");
			var objectTemp:Object = object;
			var property:String = null;
			for ( var i:int = 0; i<properties.length; i++ ) 
			{
				property = properties[ i ];
				objectTemp = propertyOfObject( objectTemp, property );
			}
			return objectTemp;
		}
		
		public static function extractToText(object:Object, property:String):String
		{
			var objectResult:Object = extractObject( object, property );
			return ( objectResult == null ) ? "" : objectResult.toString();
		}
		
		public static function extractToBoolean(object:Object, property:String):Boolean
		{
			var objectResult:Object = extractObject( object, property );
			return ( objectResult == null ) ? false : Boolean( objectResult );
		}
		
		public static function propertyOfObject(object:Object, property:String):Object{
			if( object == null ){
				return null;
			}else{
				if( object.hasOwnProperty( property ) ){
					return object[ property ];
				}else{
					return null;
				}
			}
		}
		
		/**
		 * Set to null.
		 */
		public static function freeDataProvider( comboBox:ComboBox ):void{
			if( comboBox == null ||
				comboBox.dataProvider == null ||
				(comboBox.dataProvider is ArrayCollection) == false ||
				(comboBox.dataProvider as ArrayCollection) == null ){
				return;
			}
			(comboBox.dataProvider as ArrayCollection).removeAll();
			comboBox.dataProvider = null;
		}
		
		/**
		 * Set to null.
		 */
		public static function freeListDataProvider( list:List ):void{
			if( list == null ||
				list.dataProvider == null ||
				(list.dataProvider is ArrayCollection) == false ||
				(list.dataProvider as ArrayCollection) == null ){
				return;
			}
			(list.dataProvider as ArrayCollection).removeAll();
		}
		
		public static function getIDConectelFormat(value:*):String{
			if( value == null ||
				value == undefined ){
				return "";
			}
			var valueString:String = value.toString();
			var startIndex:Number = ID_CONECTEL_FORMAT.length - 3 - valueString.length;
			startIndex += 3;
			valueString = ID_CONECTEL_FORMAT.substr( 0, startIndex ) + valueString;
			return valueString;
		}
		
		public static function selectedLabel(comboBox:ComboBox, property:String="etiqueta"):*
		{
			return selectedId( comboBox, property );
		}
		
		public static function splitException( error:String ):String{
			var value:String = error.substring( error.indexOf(':') + 1 );
			if( value == null ){
				value = error;
			}
			return value;
		}
		
		public static function validateCombo(comboBox:ComboBox,property:String="id",cero:Boolean=false):Object
		{
			if( !listBaseSelected(comboBox, property, cero) ){
				return null;
			}
			return comboBox.selectedItem;
		}
		
		public static function extractId(object:Object, property:String = "id"):*
		{
			var object:Object = extractObject(object, property);
			return object == null ? undefined : object; 
		}
		
		public static function createPrefix( type:String, user:String, date:Date = null ):String{
			if( date == null ){
				date = new Date();
			}
			var prefix:String = date.time + "-" + type + "-" + user + "_";
			return prefix;
		}
		
		public static function getEntregables(entregables:ArrayCollection, tipoEntregable:Number):ArrayCollection{
			if( entregables == null || entregables.length == 0 ){
				return null;
			}
			var filterEntregables:ArrayCollection = new ArrayCollection();
			for each (var proyectoEntregable:ProyectoEntregable in entregables) 
			{
				if( !(proyectoEntregable == null) &&
					!(proyectoEntregable.entregable == null) &&
					proyectoEntregable.entregable.idTipoEntregable == tipoEntregable ){
					filterEntregables.addItem( proyectoEntregable );
				}
			}
			return filterEntregables;
		}
		
		/**
		 * The root URI (that is scheme + hierarchical part) of the server the application
		 * will connect to. <br/>
		 * If the application is executing locally, this is the #localServerRootURI. <br/>
		 * Else it is determined from the application #url. <br/>
		 */ 
		public static function rootServerURI() : String
		{
			var url:String = Application.application.url;
			var i:int = url.indexOf("serviciosWeb");
			if( !(i == -1) ){
				return url.substring( 0, i+ "serviciosWeb".length + 1 );
			}else{
				return null;
			}
		}
		
		public static function labelFunctionHidden(object:Object, column:DataGridColumn):String{
			return Constants.HIDDEN;
		}
		
		public static function labelFunctionCurrency(object:Object, column:DataGridColumn):String{
			return Util.formatCurrency(Util.extractObject(object,column.dataField));
		}
		
		public static function labelFunctionDate(object:Object, column:DataGridColumn):String{
			return Util.formatDateToString( Util.extractObject(object,column.dataField) as Date );
		}
		
		public static function labelFunctionGeneric(object:Object, column:DataGridColumn):String{
			return Util.extractToText(object,column.dataField);
		}
		
		public static function labelFunctionDateHour(object:Object, column:DataGridColumn):String{
			return Util.formatDateTimeToString( Util.extractObject(object,column.dataField) as Date );
		}
		
		public static function labelFunctionHour(object:Object, column:DataGridColumn):String{
			return Util.formatTimeToString( Util.extractObject(object,column.dataField) as Date );
		}
		
		public static function asArrayCollection(object:Object):ArrayCollection{
			if( object == null ){
				return null;
			}
			var arrayCollection:ArrayCollection = new ArrayCollection();
			arrayCollection.addItem( object );
			return arrayCollection;
		}

		public static function calculateIVA(subtotal:TextInput, iva:TextInput, total:TextInput, ivaPercent:Number ):void{
			if( subtotal == null || iva == null || total === null ){
				return;
			}
			var subtotalNumber:Number = Number( subtotal.text );
			if( isNaN( subtotalNumber ) ){
				return;
			}
			var ivaNumber:Number = subtotalNumber * ivaPercent;
			var totalNumber:Number = subtotalNumber + ivaNumber;
			subtotal.text = formatNumber( subtotalNumber );
			iva.text = formatNumber( ivaNumber );
			total.text = formatNumber( totalNumber );
		}

		public static function faultHandler(event:FaultEvent):void
		{
			Util.showErrorMessage( Util.splitException( event.fault.faultString ) );
		}
		
		public static function getComentariosTipoAlmacen( values:ArrayCollection, tipoAlmacen:TipoAlmacen):ArrayCollection{
			var transformTo:String = "model.Comentarios";
			if( transformTo == null || values == null || values.length == 0 || tipoAlmacen == null || tipoAlmacen.id == undefined ){
				return null;
			}
			var returnValues:ArrayCollection = new ArrayCollection();
			var objectType:Class = null;
			objectType = getDefinitionByName(transformTo) as Class;
			for each (var object:ComentarioGenerico in values) 
			{
				var item:Object = new(objectType)();
				item.tipoAlmacen = tipoAlmacen.id;
				item.comentario = object.comentario;
				item.fechaCaptura = object.fechaCaptura;
				item.usuario = object.usuario;
				returnValues.addItem( item );
			}
			return returnValues;
		}
		
		public static function getDocumentosAlmacen( values:ArrayCollection, tipoAlmacen:TipoAlmacen, tipoEntregable:TipoDocumentoAlmacen ):ArrayCollection{
			var transformTo:String = "model.DocumentoAlmacen";
			if( transformTo == null || values == null || values.length == 0 
				|| tipoAlmacen == null || tipoAlmacen.id == undefined 
				|| tipoEntregable == null || tipoEntregable.id == undefined ){
				return null;
			}
			var returnValues:ArrayCollection = new ArrayCollection();
			var objectType:Class = null;
			objectType = getDefinitionByName(transformTo) as Class;
			for each (var object:String in values) 
			{
				var item:Object = new(objectType)();
				item.fkTipoAlmacen = tipoAlmacen;
				item.fkTipoEntregable = tipoEntregable;
				item.nombreArchivo = object;
				returnValues.addItem( item );
			}
			return returnValues;
		}
		
		public static function setDocumentosAlmacen(values:ArrayCollection, propiedad:String = "nombreArchivo"):ArrayCollection{
			if( values == null || values.length == 0 ||
				propiedad == null ){
				return null;
			}
			var returnValues:ArrayCollection = new ArrayCollection();
			for each (var object:Object in values) 
			{
				var item:Object = object[propiedad];
				returnValues.addItem( item );
			}
			return returnValues;
		}
		
		public static function upScroll(view:Container):void{
			if( view == null ){
				return;
			}
			view.verticalScrollPosition = 0;
		}
		
		public static function launchReport(report:String, params:Array):void{
			if( report == null ){
				return;
			}
			var url:URLRequest = new URLRequest( report ); 
			var uv:URLVariables = new URLVariables(); 
			url.method = "POST";
			for each (var param:Object in params) 
			{
				uv[param.key] = param.value;     
			}
			url.data = uv;
			navigateToURL(url,"_blank"); 
		}
		
		public static function projectStateValidation(project:Proyecto, idState:Number):Boolean{
			if( project == null ||
				project.estado == null ||
				isNaN( idState ) ){
				return false;
			}
			var value:Boolean = false;
			if( idState == project.estado.id )
			{
				value = true;
			}
			return value;
		}
		
		public static function getGrandParentWidthLess(container:Container, pixels:Number=5):Number{
			if( container == null ||
				container.parent == null ||
				container.parent.parent == null ){
				return 0;
			}
			return container.parent.parent.width - pixels;
		}
		
		public static function getGreatGrandParentWidthLess(container:Container, pixels:Number=5):Number{
			if( container == null ||
				container.parent == null ||
				container.parent.parent == null ||
				container.parent.parent.parent == null ){
				return 0;
			}
			return container.parent.parent.parent.width - pixels;
		}
		
		public static function truncate(numberVal:Number, precision:int = 2):Number
		{
			var decimalPlaces:Number = Math.pow(10, precision);
			return int(decimalPlaces * numberVal) / decimalPlaces;
		}
		
		public static function truncateToString(numberVal:Number, precision:int = 2):String
		{
			var result:Number = truncate( numberVal, precision );
			if( isNaN( result ) ){
				return "";
			}else{
				return result.toString();
			}
		}
		
		public static function copyArrayCollectionToArrayCollection(source:ArrayCollection, destiny:ArrayCollection):void{
			if( destiny == null ){
				return;
			}
			if( source == null ){
				source = new ArrayCollection();
			}
			for each (var i:Object in destiny){
				source.addItem( i );
			}
		}
		
		public static function createDateFromAnother( dateSource:Date ):Date{
			var date:Date = null;
			if( dateSource == null ){
				return date;
			}
			date = new Date( dateSource.fullYear, dateSource.month, dateSource.date, dateSource.hours, dateSource.minutes, dateSource.seconds, dateSource.milliseconds );
			return date;
		}
	}
}