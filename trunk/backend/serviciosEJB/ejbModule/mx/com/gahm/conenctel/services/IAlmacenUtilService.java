/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Local;

import mx.com.gahm.conenctel.entities.ComentariosDO;
import mx.com.gahm.conenctel.entities.DocumentoAlmacenDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author SEVEN
 *
 */
@Local
public interface IAlmacenUtilService {
	
	public List<DocumentoAlmacenDO> getDocumentosByTipo(Long id,Long tipoDocumento,Long tipoAlmacen) throws ConectelException;
	
	public void saveComentarios(List<ComentariosDO> comentarios, Long id, Long idTipoAlmacen );
	
	public List<DocumentoAlmacenDO> getAllDocumentosById(Long id) throws ConectelException ;
	
	public void deleteDocumentos(Long idAlmacen) throws ConectelException;
	
	public void deleteComentarios(Long idAlmacen,Long idTipoAlmacen) throws ConectelException;
	
	public List<ComentariosDO> getAllComentariosById(Long id,Long tipoAlmacen) throws ConectelException ;
	public void saveDocumentos(List<DocumentoAlmacenDO> documentos, Long id,Long idTipoEntregable);
}
