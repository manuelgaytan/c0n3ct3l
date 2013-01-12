package model
{
	import flash.external.ExternalInterface;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO")]
	public class ProveedorMaquilador extends Proveedor
	{
		
		public var curp:String;
		
		public var fechaContrato:Date;
		
		public var categoriaProyecto:Categoria;
		
		public var datoBancario:DatoBancario;
		
		public var pago:TipoPago;
		
		
		public var  tipoContrato:TipoContrato;
		
		public var  nss:String;
		
		public function ProveedorMaquilador()
		{
		}
	}
}