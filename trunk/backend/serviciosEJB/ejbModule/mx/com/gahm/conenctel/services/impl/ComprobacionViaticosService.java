package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion1DO;
import mx.com.gahm.conenctel.entities.ComprobacionViaticosDO;
import mx.com.gahm.conenctel.entities.DocumentoComprobacionViaticosDO;
import mx.com.gahm.conenctel.services.IComprobacionViaticosService;

@Stateless(mappedName = "ejb/ComprobacionViaticosService")
public class ComprobacionViaticosService implements IComprobacionViaticosService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ComprobacionViaticosDO> getAll() {
		List<ComprobacionViaticosDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("ComprobacionViaticosDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ComprobacionViaticosDO ComprobacionViaticosDO = null;
		for (Integer id : idsItems) {
			ComprobacionViaticosDO = entityManager.find(
					ComprobacionViaticosDO.class, id);

			if (ComprobacionViaticosDO != null) {
				entityManager.remove(ComprobacionViaticosDO);
			}
		}

	}

	@Override
	public ComprobacionViaticosDO save(ComprobacionViaticosDO item) {
		try {

			List<DocumentoComprobacionViaticosDO> documentos =item.getDocumentosComprobacionViaticos();
			item.setDocumentosComprobacionViaticos(null);
			entityManager.persist(item);
			this.saveDocumentos(item, documentos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}


	private void saveDocumentos(ComprobacionViaticosDO item,
			List<DocumentoComprobacionViaticosDO> documentos) {
		if(documentos != null){
			for (DocumentoComprobacionViaticosDO doc : documentos) {
				doc.setComprobacionViaticos(item);
				entityManager.persist( doc );
			}
			item.setDocumentosComprobacionViaticos(documentos);
		}
	}

	@Override
	public ComprobacionViaticosDO update(ComprobacionViaticosDO item) {
		deleteDocumentos(item);
		List<DocumentoComprobacionViaticosDO> documentos =item.getDocumentosComprobacionViaticos();
		item.setDocumentosComprobacionViaticos(null);
		entityManager.merge(item);
		saveDocumentos(item, documentos);
		return item;
	}


	private void deleteDocumentos(ComprobacionViaticosDO itemParam) {
		ComprobacionViaticosDO item = entityManager.find(ComprobacionViaticosDO.class, itemParam.getId());
		if( item == null || item.getDocumentosComprobacionViaticos() == null){
			return;
		}
		for ( DocumentoComprobacionViaticosDO documento: item.getDocumentosComprobacionViaticos() ) {
			if(documento!=null){
				entityManager.remove(documento);
			}
		}
	}

	@Override
	public ComprobacionViaticosDO getItem(Integer id) {
		ComprobacionViaticosDO comprobacionViaticosDO = null;
		try {
			comprobacionViaticosDO = entityManager.find(
					ComprobacionViaticosDO.class, id);
		} catch (Exception e) {
			comprobacionViaticosDO = null;
		}

		return comprobacionViaticosDO;
	}
}
