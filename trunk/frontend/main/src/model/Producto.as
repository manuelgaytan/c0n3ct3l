package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProductoDO")]
	public class Producto
	{
		public static const TIPO_SERVICIO_LOCAL:String = "LOCAL";
		public static const TIPO_SERVICIO_FORANEO:String = "FORANEO";
		
		public var id:*;
		public var cliente:Cliente;
		public var tipoProyecto:String;
		public var teconologia:String;
		public var equipo:String;
		public var actividadRealizar:String;
		public var modelo:String;
		public var descripcionServicio:String;
		public var tipoServicio:String;
		public var costoLocalCliente:Number;
		public var costoForaneoCliente:Number;
		public var costoLocalProveedor:Number;
		public var costoForaneoProveedor:Number;
		public var diasImplementacion:*;
		
		public function Producto()
		{
		}
	}
}