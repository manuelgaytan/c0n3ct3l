package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MoviemientoFondoFijoCajaChicaDO")]
	public class MovimientoFondoFijoCajaChica
	{
		public var id:*;
		public var fecha:Date;
		public var descripcionFondoFijoCajaChica:DescripcionPagoContableServicio;
		public var entrega:String;
		public var colaborador:Colaborador;
		public var ingreso:*;
		public var egreso:*;
		public var comentariosMoviemientoFondoFijoCajaChica:ArrayCollection;
	}
}