package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.entities.HerramientaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IHerramientaService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/HerramientaService")
public class HerramientaService implements IHerramientaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HerramientaDO> getAll() throws ConectelException {
		TypedQuery<HerramientaDO> query = entityManager.createNamedQuery(
				"HerramientaDO.findAll", HerramientaDO.class);
		List<HerramientaDO> herramientaList;
		try {
			herramientaList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Herramientas registradas.");
		}
		return herramientaList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			HerramientaDO current = entityManager.find(HerramientaDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		// TODO
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HerramientaDO save(HerramientaDO item) {
		
		List<DocumentoAlmacenDO> certificadoCalibracion =item.getCertificadoCalibracion();
		List<DocumentoAlmacenDO> polizaSeguro=item.getPolizaSeguro();
		List<DocumentoAlmacenDO> polizaGarantia=item.getPolizaGarantia();
		List<ComentariosDO> comentarios=item.getComentarios();
		
		for (ComentariosDO comentario : comentarios) {
			comentario.setAlmacen(item.getId());
			entityManager.persist(comentario);
		}
		
		for (DocumentoAlmacenDO documento : certificadoCalibracion) {
			documento.setFkAlmacen(item.getId());
			entityManager.persist(documento);
		}
		
		for (DocumentoAlmacenDO documento : polizaSeguro) {
			documento.setFkAlmacen(item.getId());
			entityManager.persist(documento);
		}
		
		for (DocumentoAlmacenDO documento : polizaGarantia) {
			documento.setFkAlmacen(item.getId());
			entityManager.persist(documento);
		}
		
		
		
		
		entityManager.persist(item);
		
		
		
		
		
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HerramientaDO update(HerramientaDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HerramientaDO getItem(Long id) throws ConectelException {
		HerramientaDO herramienta = entityManager.find(HerramientaDO.class, id);
		if (herramienta == null) {
			throw new ConectelException("La Herramienta no existe");
		}
		return herramienta;
	}

}
