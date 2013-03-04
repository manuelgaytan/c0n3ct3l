package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO")]
	public class OrdenCompraMaquilado
	{
		public var id:*;
		public var fecha:Date;
		public var solicitudServicioMaquilado:SolicitudServicioMaquilado;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var claveValidacion:String;
		
		public function OrdenCompraMaquilado()
		{
		}
	}
}