package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioProveedorDO")]
	public class ComentarioProveedor
	{
		public var id:*;
		public var proveedorCalificado:ProveedorCalificado;
		public var comentarioCompras:ComentarioCompras;
		
		public function ComentarioProveedor()
		{
		}
	}
}