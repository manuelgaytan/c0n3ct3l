package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.CursoDO")]
	public class Curso
	{
		public var id:*;
		public var contratacion:Contratacion;
		public var fechaEnc:Date;
		public var resultadoEnc:*;
		public var enc:Boolean;
		public var cursoTecnico:String;
		public var capacitadorInternoCt:String;
		public var capacitadorExternoCt:String;
		public var autorizacionCt:Boolean;
		public var fechaCt:Date;
		public var resultadoCt:*;
		public var cursoGeneral:String;
		public var capacitadorInternoCg:String;
		public var capacitadorExternoCg:String;
		public var autorizacionCg:Boolean;
		public var fechaCg:Date;
		public var resultadoCg:*;
		
		public function Curso()
		{
		}
	}
}