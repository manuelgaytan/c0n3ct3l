package mx.com.gahm.conenctel.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenceConfig {

	@PersistenceContext(unitName="ConectelPU")
	private EntityManager entityManager;

	@Produces
	public EntityManager obtenerEntityManager() {
		return entityManager;
	}
}
