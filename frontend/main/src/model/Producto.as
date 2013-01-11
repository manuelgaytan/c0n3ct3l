package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProductoDO")]
	public class Producto
	{
		public var id:*;
		public var cliente:Cliente;
		public var tipoProyecto:String;
		public var teconologia:String;
		public var equipo:String;
		public var actividadRealizar:String;
		public var modelo:String;
		public var descripcionServicio:String;
		public var tipoServicio:String;
		public var costo:Number;
		public var diasImplementacion:*;
		
		public function Producto()
		{
		}
	}
}