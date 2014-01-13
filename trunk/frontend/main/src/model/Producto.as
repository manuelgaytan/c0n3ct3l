package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProductoDO")]
	public class Producto
	{
		public static const TIPO_SERVICIO_LOCAL:String = "LOCAL";
		public static const TIPO_SERVICIO_FORANEO:String = "FORANEO";
		
		public static const TIPOS_SERVICIO:ArrayCollection = new ArrayCollection( [{id:TIPO_SERVICIO_LOCAL}, {id:TIPO_SERVICIO_FORANEO}] );
		
		public var id:*;
		public var cliente:Cliente;
		public var tipoProyecto:String;
		public var teconologia:String;
		public var equipo:String;
		public var actividadRealizar:String;
		public var modelo:String;
		public var descripcionServicio:String;
		//public var tipoServicio:String;
		public var costoLocalCliente:*;
		public var costoForaneoCliente:*;
		public var costoLocalProveedor:*;
		public var costoForaneoProveedor:*;
		public var diasImplementacion:*;
		public var alcances:String;
		
		public function Producto()
		{
		}
	}
}