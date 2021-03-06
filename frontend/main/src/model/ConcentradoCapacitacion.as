package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConcentradoCapacitacionDO")]
	public class ConcentradoCapacitacion
	{
		public var id:*;
		public var colaborador:Colaborador;
		public var tipoFormacion:TipoFormacion;
		public var estado:EstadoConcentradoCapacitacion;
		public var tipoCapacitacion:TipoCapacitacion;
		public var nombreCapacitacion:String;
		public var fechaInicioCapacitacion:Date;
		public var fechaTerminoCapacitacion:Date;
		public var lugarCapacitacion:String;
		public var nombreInstructor:String;
		public var calificacion:*;
		public var constancia:String;
		public var estatusConcentradoCapacitacion:EstatusConcentradoCapacitacion;
		public var resultadoSeguimiento:String;
		public var perfil:Perfil;
		
		public function ConcentradoCapacitacion()
		{
		}
	}
}