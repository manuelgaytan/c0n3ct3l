package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ArchivoCotizacionDO")]
	public class ArchivoCotizacion
	{
		public var id:*;
		public var cotizacion:Cotizacion;
		public var nombreArchivo:String;
		
		public function ComentarioCotizacion()
		{
		}
	}
}