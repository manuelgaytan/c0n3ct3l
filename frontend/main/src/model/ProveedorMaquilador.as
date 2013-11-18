package model
{
	import flash.external.ExternalInterface;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO")]
	public class ProveedorMaquilador// extends Proveedor
	{
		public var id:*;
		
		public var proveedor:Proveedor;
		
		public var curp:String;
		
		public var fechaContrato:Date;
		
		public var categoriaProyecto:Categoria;
		
		public var datoBancario:DatoBancario;
		
		public var pago:Pago;
		
		public var tipoContrato:TipoContrato;
		
		public var vigenciaContrato:String;
		
		public var nss:String;
		
		public var documentosLiderProveedorMaquilador:ArrayCollection; 
		
		public function ProveedorMaquilador()
		{
		}
	}
}