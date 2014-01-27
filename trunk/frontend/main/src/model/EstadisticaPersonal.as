package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadisticaPersonalDO")]
	public class EstadisticaPersonal
	{
		public var id:*;
		public var trimestre:Trimestre;
		public var ano:Ano;
		public var rangoEstadisticaPersonalAusencia:RangoEstadisticaPersonal;
		public var rangoEstadisticaPersonalPuntualidad:RangoEstadisticaPersonal;		
		public var rangoEstadisticaPersonalRotacion:RangoEstadisticaPersonal;		
		public var rangoEstadisticaPersonalRetardo:RangoEstadisticaPersonal;		
				
		public function EstadisticaPersonal()
		{
		}
	}
}