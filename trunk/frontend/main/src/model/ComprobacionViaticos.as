package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComprobacionViaticosDO")]
	public class ComprobacionViaticos
	{
		public var id:*;
		public var solicitudViaticos:SolicitudViaticos;
		public var totalAutorizado:Number;
		public var fechaSubidaDocumentos:Date;
		public var documentoFormato:String;
		public var estadoComprobacionViaticos:EstadoComprobacionViaticos;
		public var documentosComprobacionViaticos:ArrayCollection;
	}
}