package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.ReclutamientoSolicitudEmpleoDO")]
	public class ReclutamientoSolicitudEmpleo
	{
		public var id:*;
		public var datosPrincipalesSolicitante:DatosPrincipalesSolicitante;
		public var datosGeneralesSolicitante:DatosGeneralesSolicitante;
		public var datosFamiliaresSolicitante:DatosFamiliaresSolicitante;
		public var datosEscolaresHabilidades:DatosEscolaresHabilidades;
		public var datosUltimoEmpleoSolicitante:DatosUltimoEmpleoSolicitante;
		public var datosSobreConectelSolicitante:DatosSobreConectelSolicitante;
		public var seleccionReclutamiento:SeleccionReclutamiento;
		public var informacionConfidencialColaborador:InformacionConfidencialColaborador;
		
		public function ReclutamientoSolicitudEmpleo()
		{
		}
	}
}