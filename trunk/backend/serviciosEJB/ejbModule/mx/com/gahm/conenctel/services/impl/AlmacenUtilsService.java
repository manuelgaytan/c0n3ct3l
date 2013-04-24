/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.services.IAlmacenUtilsService;

/**
 * @author manuel
 *
 */
@Stateless(mappedName = "ejb/AlmacenUtilsService")
public class AlmacenUtilsService implements IAlmacenUtilsService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public void saveDocumentos(List<DocumentoAlmacenDO> documentos, Long id,Long idTipoEntregable){
		if( documentos == null || id == null ){
			return;
		}
		for (DocumentoAlmacenDO doc : documentos) {
			doc.setAlmacen(id);
			entityManager.persist(doc);
		}
	}

}
