package mx.com.gahm.conenctel.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.persistence.sessions.Session;

import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SolicitanteRequisicionDO;
import mx.com.gahm.conenctel.entities.SolicitanteSolicitudViaticosDO;
import mx.com.gahm.conenctel.entities.SolicitudViaticosDO;
import mx.com.gahm.conenctel.services.ISolicitudViaticosService;

@Stateless(mappedName = "ejb/SolicitudViaticosService")
public class SolicitudViaticosService implements ISolicitudViaticosService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudViaticosDO> getAll() {
		List<SolicitudViaticosDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("SolicitudViaticosDO.findAll");
		datos = query.getResultList();

		return datos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudViaticosDO> getAllByWithOutPayment() {
		List<SolicitudViaticosDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("SolicitudViaticosDO.getAllByWithOutPayment");
		datos = query.getResultList();

		return datos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudViaticosDO> getAllByPerfil( long idPerfil ) {
		List<SolicitudViaticosDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("SolicitudViaticosDO.findAllByPerfil");
		query.setParameter("idPerfil",idPerfil);
		datos = query.getResultList();
		
		return datos;
	}
	
	@Override
	public void deleteItems(List<Integer> idsItems) {
		SolicitudViaticosDO solicitudViaticosDO = null;
		for (Integer id : idsItems) {
			solicitudViaticosDO = entityManager.find(
					SolicitudViaticosDO.class, id);

			if (solicitudViaticosDO != null) {
				this.deleteSolicitantes(solicitudViaticosDO);
				entityManager.remove(solicitudViaticosDO);
			}
		}

	}

	@Override
	public SolicitudViaticosDO save(SolicitudViaticosDO item) {
		try {
			List<SolicitanteSolicitudViaticosDO> solicitantes = item.getSolicitantes();
			item.setSolicitantes(null);
			entityManager.persist(item);
			this.saveSolicitantes(item, solicitantes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	private void saveSolicitantes(SolicitudViaticosDO solicitudViaticos,List<SolicitanteSolicitudViaticosDO> solicitantes){
		if( solicitantes == null ){
			return;
		}
		for (SolicitanteSolicitudViaticosDO dato : solicitantes) {
			dato.setSolicitudViaticos(solicitudViaticos);
			entityManager.persist(dato);
		}
		
	}
	
	private void deleteSolicitantes(SolicitudViaticosDO solicitudViaticos ){
		SolicitudViaticosDO item = entityManager.find(SolicitudViaticosDO.class, solicitudViaticos.getId());
		if( item == null || item.getSolicitantes() == null){
			return;
		}
		for (SolicitanteSolicitudViaticosDO solicitante : item.getSolicitantes()) {
			if(solicitante!=null){
				entityManager.remove(solicitante);
			}
		}
	}

	@Override
	public SolicitudViaticosDO update(SolicitudViaticosDO item) {
		this.deleteSolicitantes(item);
		List<SolicitanteSolicitudViaticosDO> solicitantes = item.getSolicitantes();
		item.setSolicitantes(null);
		entityManager.merge(item);
		this.saveSolicitantes(item, solicitantes);
		return item;
	}


	@Override
	public SolicitudViaticosDO getItem(Integer id) {
		SolicitudViaticosDO SolicitudViaticosDO = null;
		try {
			SolicitudViaticosDO = entityManager.find(
					SolicitudViaticosDO.class, id);
		} catch (Exception e) {
			SolicitudViaticosDO = null;
		}

		return SolicitudViaticosDO;
	}

	@Override
	@Deprecated
	public long getSiguienteId(){
		// interesante referencia: http://dev.mysql.com/doc/refman/5.0/en/innodb-locking-reads.html
		// una opcion
		// SELECT counter_field FROM child_codes FOR UPDATE;
		// UPDATE child_codes SET counter_field = counter_field + 1;
		
		// UPDATE child_codes SET counter_field = LAST_INSERT_ID(counter_field + 1);
		// SELECT LAST_INSERT_ID();
		
		//Number valor = entityManager.unwrap(Session.class).getNextSequenceNumberValue(SolicitudViaticosDO.class);
		//return valor.longValue();
		
		Query q = entityManager.createNativeQuery("SELECT id FROM SolicitudViaticos FOR UPDATE");
		Long result=(Long)q.getSingleResult();   
		return result.longValue() + 1;
	}
}
