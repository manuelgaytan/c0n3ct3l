package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO")]
	public class ConfiguracionPruebaEntrega
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var comisionado:String;
		public var puertosEntregados:String;
		public var alineacion:String;
		public var slotEntregado:String;
		public var tarjetasEntregadas:String;
		public var claveAceptacion:String;
		public var fechaEntrega:Date;
		public var observaciones:ArrayCollection;
		public var entregablesCompletos:Boolean;
		public var estadoValidacionOperativa:EstadoValidacionOperativa;
		public var fechaValidacionOperativa:Date;
		public var siteSurvey:ArrayCollection;
		public var planos:ArrayCollection;
		public var ingenieria:ArrayCollection;
		public var visitaFactibilidad:ArrayCollection;
		public var carpetaAdministrativa:ArrayCollection;
		public var protocolo:ArrayCollection;
		public var ot:ArrayCollection;
		public var clienteSatisfecho:ArrayCollection;
		public var checklistInspeccion:ArrayCollection;
		public var checklistFotografico:ArrayCollection;
		public var asBuild:ArrayCollection;
		public var entregableX:ArrayCollection;
		public var entregableY:ArrayCollection;
		
		public function ConfiguracionPruebaEntrega()
		{
		}
	}
}