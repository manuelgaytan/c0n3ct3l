/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.AcuerdoMinutaDO;
import mx.com.gahm.conenctel.entities.MinutaDO;
import mx.com.gahm.conenctel.entities.ParticipanteMinutaDO;
import mx.com.gahm.conenctel.services.IMinutaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/MinutaService")
public class MinutaService  implements IMinutaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<MinutaDO> getAll() {
		List<MinutaDO> datos= null;
		TypedQuery<MinutaDO>  query =null;
		query = entityManager.createNamedQuery("MinutaDO.findAll",MinutaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		MinutaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public MinutaDO save(MinutaDO item) {
		this.asignarMinuta(item);
		entityManager.persist(item);
		return item;
	}
	
	private void asignarMinuta(MinutaDO item){
		if( item.getParticipanteMinuta() != null ){
			for (ParticipanteMinutaDO participanteMinutaDO : item.getParticipanteMinuta() ) {
				participanteMinutaDO.setMinuta(item);
			}
		}
		if( item.getAcuerdoMinuta() != null ){
			for (AcuerdoMinutaDO acuerdoMinutaDO : item.getAcuerdoMinuta() ) {
				acuerdoMinutaDO.setMinuta(item);
			}
		}
	}

	@Override
	public MinutaDO update(MinutaDO item) {
		this.deleteAcuerdosAnteriores(item);
		List<AcuerdoMinutaDO> acuerdos = item.getAcuerdoMinuta();
		item.setAcuerdoMinuta(null);
		this.asignarMinuta(item);
		entityManager.merge(item);
		this.saveAcuerdos(item, acuerdos);
		return item;
	}

	private void saveAcuerdos(MinutaDO item, List<AcuerdoMinutaDO> acuerdos) {
		if( acuerdos != null ){
			for (AcuerdoMinutaDO comentario : acuerdos) {
				comentario.setMinuta( item );
				entityManager.persist(comentario);
			}
		}
		item.setAcuerdoMinuta(acuerdos);
	}

	private void deleteAcuerdosAnteriores(MinutaDO item) {
		List<AcuerdoMinutaDO> acuerdos = this.getItem( item.getId() ).getAcuerdoMinuta();
		if( acuerdos != null ){
			for (AcuerdoMinutaDO acuerdoMinutaDO : acuerdos ) {
				entityManager.remove( acuerdoMinutaDO );
			}
		}
	}

	@Override
	public MinutaDO getItem(Integer id) {
		MinutaDO cotizacion = entityManager.find(MinutaDO.class,id);
		return cotizacion;
	}

}
