/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sun.faces.config.DocumentOrderingWrapper;

import mx.com.gahm.conenctel.entities.AyudanteDO;
import mx.com.gahm.conenctel.entities.ColaboradorDO;
import mx.com.gahm.conenctel.entities.ComentarioProveedorDO;
import mx.com.gahm.conenctel.entities.DocumentoLiderProveedorMaquiladorDO;
import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;
import mx.com.gahm.conenctel.entities.ProveedorDO;
import mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO;
import mx.com.gahm.conenctel.entities.TipoColaboradorDO;
import mx.com.gahm.conenctel.entities.TipoPersonaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IProveedorMaquiladorService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * @author lespinosa
 *Session Bean implementation class IProveedorMaquiladorService
 */

@Stateless(mappedName = "ejb/ProveedorMaquiladorService")
public class ProveedorMaquiladorService implements IProveedorMaquiladorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProveedorMaquiladorDO> getProveedoresMaquiladores() {
		TypedQuery<ProveedorMaquiladorDO> query = entityManager
				.createNamedQuery("ProveedorMaquiladorDO.findAll",
						ProveedorMaquiladorDO.class);
		List<ProveedorMaquiladorDO> proveedor = query.getResultList();// TODO
																		// Auto-generated
																		// method
																		// stub
		return proveedor;	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ProveedorMaquiladorDO getProveedorMaquilador(Long id)
			throws ConectelException {
		ProveedorMaquiladorDO proveedor = entityManager.find(
				ProveedorMaquiladorDO.class, id);		
		return proveedor;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProveedorMaquiladorDO saveProveedorMaquilador(
			ProveedorMaquiladorDO proveedor) throws ConectelException {
		List<DocumentoLiderProveedorMaquiladorDO> documentos = proveedor.getDocumentosLiderProveedorMaquilador();
		List<AyudanteDO> ayudantes = proveedor.getAyudantes();
		proveedor.setAyudantes(null);
		if( documentos != null ){
			for (DocumentoLiderProveedorMaquiladorDO documento : documentos) {
				documento.setProveedorMaquilador(proveedor);
			}
		}
		entityManager.persist(proveedor);
		this.saveColaborador( proveedor );
		this.saveAyudantes( proveedor, ayudantes );
		return null;
	}

	private void saveAyudantes(ProveedorMaquiladorDO proveedorMaquilador,
			List<AyudanteDO> ayudantes) {
		if( !(ayudantes == null) ){
			for (AyudanteDO ayudanteDO : ayudantes) {
				ayudanteDO.setProveedorMaquilador(proveedorMaquilador);
				entityManager.persist( ayudanteDO );
			}
		}
	}

	private void saveColaborador(ProveedorMaquiladorDO proveedor) {
		if( proveedor == null ||
			proveedor.getProveedor() == null || 
			proveedor.getProveedor().getTipoPersona() == null ||
			proveedor.getProveedor().getTipoPersona().getId() != TipoPersonaDO.FISICA ){
			return;
		}
		ColaboradorDO colaborador = new ColaboradorDO();
		colaborador.setNombreCompleto( proveedor.getProveedor().getRazonSocial() );
		TipoColaboradorDO tipoColaborador = entityManager.find(
				TipoColaboradorDO.class, TipoColaboradorDO.PROVEEDORES);	
		colaborador.setTipoColaborador( tipoColaborador );
		entityManager.persist( colaborador );
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean deleteProveedoresMaquiladores(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ProveedorMaquiladorDO current = entityManager.find(ProveedorMaquiladorDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@Override
	public ProductoDO updateProveedorMaquilador(ProveedorMaquiladorDO proveedor)
			throws ConectelException {
		this.deleteDocumentos(proveedor);
		this.deleteAyudantes(proveedor);
		List<AyudanteDO> ayudantes = proveedor.getAyudantes();
		proveedor.setAyudantes(null);
		this.colocarProveedorMaquilador(proveedor);
		entityManager.merge(proveedor);
		this.saveAyudantes(proveedor, ayudantes);
		return null;
	}
	
	private void deleteAyudantes(ProveedorMaquiladorDO proveedor) {
		ProveedorMaquiladorDO proveedorMaquilador = entityManager.find( ProveedorMaquiladorDO.class,  proveedor.getId() ); 
		List<AyudanteDO> items = proveedorMaquilador.getAyudantes();
		if(items!=null){
			for (AyudanteDO item : items) {
				entityManager.remove( item );
			}
		}
	}

	private void colocarProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador){
		List<DocumentoLiderProveedorMaquiladorDO> documentos = proveedorMaquilador.getDocumentosLiderProveedorMaquilador();
		if(documentos!=null){
			for (DocumentoLiderProveedorMaquiladorDO documento : documentos) {
				documento.setProveedorMaquilador( proveedorMaquilador );
			}
		}
	}
	
	private void deleteDocumentos(ProveedorMaquiladorDO item){
		ProveedorMaquiladorDO proveedorMaquilador = entityManager.find( ProveedorMaquiladorDO.class,  item.getId() ); 
		List<DocumentoLiderProveedorMaquiladorDO> documentos = proveedorMaquilador.getDocumentosLiderProveedorMaquilador();
		if(documentos!=null){
			for (DocumentoLiderProveedorMaquiladorDO documento : documentos) {
				entityManager.remove( documento );
			}
		}
	}

}
