package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosGeneralesSolicitanteDO")]
	public class DatosGeneralesSolicitante
	{
		public var id:*;
		public var apellidoPaterno:String;
		public var apellidoMaterno:String;
		public var nombres:String;
		public var fechaNacimiento:Date;
		public var lugarNacimiento:String;
		public var edad:*;
		public var nacionalidad:Nacionalidad;
		public var identificacion:Identificacion;
		public var documentacionExtranjeros:DocumentacionExtranjeros;
		public var estadoCivil:EstadoCivil;
		public var sexo:Sexo;
		public var direccionSolicitante:DireccionSolicitante;
		public var telefono:String;
		public var celular:String;
		public var correoElectronico:String;
		public var rfc:String;
		public var nss:String;
		public var curp:String;
		public var licencia:Licencia;
		public var cartaAntecedentesPenales:CartaAntecedentesPenales;
		public var estadoSalud:EstadoSalud;
		public var enfermedadCronica:String;
		public var actividadTiempoLibre:ActividadTiempoLibre;
		
		public var reclutamientoSolicitudEmpleo:ReclutamientoSolicitudEmpleo;
		
		public function DatosGeneralesSolicitante()
		{
		}
	}
}