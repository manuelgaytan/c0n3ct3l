package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MoviemientoFondoFijoCajaChicaDO")]
	public class MovimientoFondoFijoCajaChica
	{
		public var id:*;
		public var fecha:Date;
		public var descripcionFondoFijoCajaChica:DescripcionFondoFijoCajaChica;
		public var entrega:Colaborador;
		public var colaborador:Colaborador;
		public var ingreso:*;
		public var egreso:*;
		public var comentariosMoviemientoFondoFijoCajaChica:ArrayCollection;
	}
}