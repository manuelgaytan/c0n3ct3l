package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoEntregableDO")]
	public class TipoEntregable
	{
		public static const ENTREGABLE_INGENIERIA:Number = 1;
		public static const SITE_SURVEY:Number = 2;
		public static const PLANOS:Number = 3;
		public static const INGENIERIA:Number = 4;
		public static const VISITA_FACTIBILIDAD:Number = 5;
		public static const CARPETA_ADMINISTRATIVA:Number = 6;
		public static const PROTOCOLO:Number = 7;
		public static const OT:Number = 8;
		public static const CLIENTE_SATISFECHO:Number = 9;
		public static const CHECKLIST_INSPECCION:Number = 10;
		public static const CHECKLIST_FOTOGRAFICO:Number = 11;
		public static const ASBUILD:Number = 12;
		public static const ENTREGABLE_X:Number = 13;
		public static const ENTREGABLE_Y:Number = 14;
		
		public var id:*;
		public var tipo:String;
		
		public function TipoEntregable( id:* = undefined, tipo:String = "")
		{
			this.id = id;
			this.tipo = tipo;
		}
	}
}