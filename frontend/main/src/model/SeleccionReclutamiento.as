package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.SeleccionReclutamientoDO")]
	public class SeleccionReclutamiento
	{
		public var id:*;
		public var reclutamientoSolicitudEmpleo:ReclutamientoSolicitudEmpleo;
		public var tipoCandidato:TipoCandidato;
		public var examenPsicometrico:ExamenPsicometrico;
		public var perfilEscala:PerfilEscala;
		public var examenTecnico:Number;
		public var faseContratacion:FaseContratacion;
		
		public function SeleccionReclutamiento()
		{
		}
	}
}