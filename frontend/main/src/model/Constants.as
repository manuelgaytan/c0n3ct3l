package model
{
	import mx.collections.ArrayCollection;

	public class Constants
	{
		public static const IVA:Number = 0.16;
		
		public static const ERROR:String = "Error";
		public static const INFO:String = "Informativo";
		public static const REQUIRED_FIELD:String = "Por favor requisite los campos requeridos.";
		public static var REGISTRAR:String = "Registrar";
		public static var REGISTER_MODE:String = "register";
		public static var MODIFICAR:String = "Modificar";
		public static var UPDATE_MODE:String = "update";
		public static var DETALLE:String = "Detalle";
		public static var DETAIL_MODE:String = "detail";
		public static var DATE_FORMAT:String = "DD/MM/YYYY";
		
		public static const PROJECT_TYPE:String = "PROJECT";
		public static const IMPORT_PRODUCTS_TYPE:String = "IMPORT-PRODUCTS";
		public static const TEXT_FILES_FILTER_TEXT_SHOWED:String = "Archivos de Texto (*.doc, *.docx, *.xls, *.xlsx, *.pdf)";
		public static const TEXT_FILES_FILTER:String = "*.doc; *.docx; *.xls; *.xlsx; *.pdf";
		public static const CSV_FILES_FILTER_TEXT_SHOWED:String = "CSV (delimitado por comas) (*.csv)";
		public static const CSV_FILES_FILTER:String = "*.csv";
		public static const CSV_EXTENSION:String = ".csv";
		public static const EXPORT_PRODUCTS_TYPE:String = "EXPORT-PRODUCTS";
		
		public static const OC_UNIT:String = "PROYECTO";
		public static const OC_SITE:String = "SITIO";
		public static const OC_ADVANCE:String = "ANTICIPO";
		public static const OC_SETTLEMENT:String = "FINIQUITO";
		
		public static const TRANSACTION_ABORTED:String = " Transaction aborted";
		public static const TRANSACTION_ABORTED_MESSAGE:String = "Existen elementos asociados, por tanto, no se puede Eliminar.";
		
		public static var MAQUILADORES:String = "Servicios de Implementación";
		public static var CALIFICADOS:String = "Bienes y Servicios";
		public static var ID_MAQUILADORES:Number = 2;
		public static var ID_CALIFICADOS:Number = 1;
		
		public static const HIDDEN:String = "-------";
		
		public static function getAMPM():ArrayCollection{
			var data:ArrayCollection = new ArrayCollection();
			var item:Catalogo = null;
			item = new Catalogo();
			item.id = 1;
			item.etiqueta = "AM";
			data.addItem( item );
			item = new Catalogo();
			item.id = 2;
			item.etiqueta = "PM";
			data.addItem( item );
			return data;
		}
	}
}