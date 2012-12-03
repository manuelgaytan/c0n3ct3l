package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TelefoniaMovilDO")]
	public class TelefoniaMovil
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaF:*;
		public var descripcion:String;
		public var noSerie:String;
		public var marca:String;
		public var modelo:String;
		public var imei:String;
		public var fkCompania:*;
		public var noTelefono:String;
		public var tipoPlanContratado:String;
		public var existencia:Number;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var fkEstatusB:*;
		
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var grupoFamiliaF:GrupoFamiliaF;
		public var compania:Compania;
		public var ubicacionB:UbicacionB;
		public var responsable:Colaborador;
		public var estatusB:EstatusB;
		
		public function TelefoniaMovil()
		{
		}
	}
}