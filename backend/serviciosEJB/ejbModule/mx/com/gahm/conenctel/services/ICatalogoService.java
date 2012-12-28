package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.AplicaDO;
import mx.com.gahm.conenctel.entities.AreaSolicitanteDO;
import mx.com.gahm.conenctel.entities.ColaboradorDO;
import mx.com.gahm.conenctel.entities.CompaniaDO;
import mx.com.gahm.conenctel.entities.DescripcionAlmacenDO;
import mx.com.gahm.conenctel.entities.EstatusADO;
import mx.com.gahm.conenctel.entities.EstatusBDO;
import mx.com.gahm.conenctel.entities.EstatusCDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaADO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaBDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaCDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaDDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaEDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaFDO;
import mx.com.gahm.conenctel.entities.ImputableDO;
import mx.com.gahm.conenctel.entities.PrioridadDO;
import mx.com.gahm.conenctel.entities.SeguimientoDO;
import mx.com.gahm.conenctel.entities.ServicioSolicitadoDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoMantenimientoDO;
import mx.com.gahm.conenctel.entities.TipoPersonaDO;
import mx.com.gahm.conenctel.entities.UbicacionADO;
import mx.com.gahm.conenctel.entities.UbicacionBDO;
import mx.com.gahm.conenctel.entities.UbicacionCDO;
import mx.com.gahm.conenctel.entities.UnidadADO;
import mx.com.gahm.conenctel.entities.UnidadBDO;
import mx.com.gahm.conenctel.entities.UnidadCDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface ICatalogoService extends Serializable {

	public List<AplicaDO> getAplica() throws ConectelException;

	public List<SeguimientoDO> getSeguimiento() throws ConectelException;

	public List<ImputableDO> getImputable() throws ConectelException;

	public List<TipoAlmacenDO> getTipoAlmacen() throws ConectelException;

	public List<GrupoFamiliaADO> getGrupoFamiliaA() throws ConectelException;

	public List<UnidadADO> getUnidadA() throws ConectelException;

	public List<UbicacionADO> getUbicacionA() throws ConectelException;

	public List<ColaboradorDO> getColaborador() throws ConectelException;

	public List<EstatusADO> getEstatusA() throws ConectelException;

	public List<TipoMantenimientoDO> getTipoMantenimiento()
			throws ConectelException;

	public List<UbicacionBDO> getUbicacionB() throws ConectelException;

	public List<GrupoFamiliaBDO> getGrupoFamiliaB() throws ConectelException;

	public List<EstatusBDO> getEstatusB() throws ConectelException;

	public List<GrupoFamiliaCDO> getGrupoFamiliaC() throws ConectelException;

	public List<UnidadBDO> getUnidadB() throws ConectelException;

	public List<EstatusCDO> getEstatusC() throws ConectelException;

	public List<GrupoFamiliaDDO> getGrupoFamiliaD() throws ConectelException;

	public List<UbicacionCDO> getUbicacionC() throws ConectelException;

	public List<GrupoFamiliaEDO> getGrupoFamiliaE() throws ConectelException;

	public List<UnidadCDO> getUnidadC() throws ConectelException;

	public List<GrupoFamiliaFDO> getGrupoFamiliaF() throws ConectelException;

	public List<CompaniaDO> getCompania() throws ConectelException;

	public List<PrioridadDO> getPrioridad() throws ConectelException;

	public List<AreaSolicitanteDO> getAreaSolicitante()
			throws ConectelException;

	public List<ServicioSolicitadoDO> getServicioSolicitado()
			throws ConectelException;

	public List<DescripcionAlmacenDO> getDescripcionAlmacen()
			throws ConectelException;
	
	public List<TipoPersonaDO> getTipoPersona() throws ConectelException ;
	List<UnidadOrdenCompraDO> getUnidadOrdenCompra()
			throws ConectelException;
}
