package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioCotizacionDO")]
	public class ComentarioCotizacion
	{
		public var id:*;
		public var cotizacion:Cotizacion;
		public var comentarioCompras:ComentarioCompras;
		
		public function ComentarioCotizacion()
		{
		}
	}
}