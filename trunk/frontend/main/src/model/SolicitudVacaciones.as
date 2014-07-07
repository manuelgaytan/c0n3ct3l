package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudVacacionesDO")]
	public class SolicitudVacaciones
	{
		public var id:*;
		public var contratacion:InformacionConfidencialColaborador;
		public var fecha:Date;
		public var variacion:Variacion;
		public var diasCorrespondientes:*;		
		public var fechaInicio:Date;		
		public var fechaFin:Date;		
		public var vistoBuenoJefeInmediato:Boolean;
		public var autorizacion:Boolean;		
		public var comentarios:ArrayCollection;
				
		public function SolicitudVacaciones()
		{
		}
	}
}