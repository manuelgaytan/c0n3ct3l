package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionConfidencialColaboradorDO")]
	public class InformacionConfidencialColaborador
	{
		public var id:*;
		public var contratacion:Contratacion;
		public var foto:String;
		public var sueldo:*;
		public var tieneImss:Boolean;
		public var nss:String;
		public var altaImss:Date;
		public var bajaImss:Date;
		public var modificacionImss:Date;
		public var estadoColaborador:EstadoColaborador;
		public var enCasoAccidenteAvisar:String;
		public var telefonoEmergencia:String;
		public var bajoTratamiento:Boolean;
		public var medicamento:String;
		public var alergias:String;
		public var tipoSangre:String;
		public var numeroTarjetaNomina:String;
		public var correoElectronico:String;
		
		public function InformacionConfidencialColaborador()
		{
		}
	}
}