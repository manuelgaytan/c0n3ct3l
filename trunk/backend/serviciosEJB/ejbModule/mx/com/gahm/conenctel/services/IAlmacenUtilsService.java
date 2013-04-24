package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Local;

import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;

@Local
public interface IAlmacenUtilsService {
	public void saveDocumentos(List<DocumentoAlmacenDO> documentos, Long id,Long idTipoEntregable);
}
