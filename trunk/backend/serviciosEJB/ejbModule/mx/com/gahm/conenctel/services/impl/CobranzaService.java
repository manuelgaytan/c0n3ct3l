/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.CobranzaDO;
import mx.com.gahm.conenctel.entities.ComentarioCobranzaDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;
import mx.com.gahm.conenctel.services.ICobranzaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/CobranzaService")
public class CobranzaService implements ICobranzaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<CobranzaDO> getAll() {
		List<CobranzaDO> datos= null;
		TypedQuery<CobranzaDO>  query =null;
		query = entityManager.createNamedQuery("CobranzaDO.findAll",CobranzaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		CobranzaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public CobranzaDO save(CobranzaDO item) {
		List<ComentarioCobranzaDO> comentarios = item.getComentariosCobranza();
		item.setComentariosCobranza( null ); 
		entityManager.persist(item);
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void saveComentarios(CobranzaDO item,List<ComentarioCobranzaDO> comentarios){
		if( comentarios == null ){
			return;
		}
		for (ComentarioCobranzaDO dato : comentarios) {
			entityManager.persist(dato.getComentarioTesoreria());
			dato.setCobranza(item);
			entityManager.persist(dato);
		}
		item.setComentariosCobranza(comentarios);
	}
	
	@Override
	public CobranzaDO update(CobranzaDO item) {
		deleteComentarios(item);
		List<ComentarioCobranzaDO> comentarios = item.getComentariosCobranza();
		item.setComentariosCobranza(null);
		entityManager.merge(item);
		saveComentarios(item,comentarios);
		return item;
	}

	private void deleteComentarios(CobranzaDO itemParam) {
		CobranzaDO cobranzaDO = entityManager.find(CobranzaDO.class, itemParam.getId());
		if( cobranzaDO.getComentariosCobranza() != null ){
			for (ComentarioCobranzaDO comentario : cobranzaDO.getComentariosCobranza()) {
				entityManager.remove( comentario );
			}
		}
	}

	@Override
	public CobranzaDO getItem(Integer id) {
		CobranzaDO cotizacion = entityManager.find(CobranzaDO.class,id);
		return cotizacion;
	}

	@Override
	public List<NotaCreditoClienteDO> getAllByFiltro(long idCliente ){
		List<NotaCreditoClienteDO> datos= null;
		TypedQuery<NotaCreditoClienteDO>  query =null;
		query = entityManager.createNamedQuery("NotaCreditoClienteDO.NotasCrediByCliente",NotaCreditoClienteDO.class);
		datos = query.getResultList();
		
		return datos;
	}
	
	@Override
	public List<InformacionFacturacionDO> getInformacionFacturacionByCliente(long idCliente ){
		
		List<InformacionFacturacionDO> datos= null;
		TypedQuery<InformacionFacturacionDO>  query =null;
		query = entityManager.createNamedQuery("InformacionFacturacionDO.NotasCrediByCliente",InformacionFacturacionDO.class);
		query.setParameter("idCliente", "idCliente");
		datos = query.getResultList();
		return datos;
	}
}
