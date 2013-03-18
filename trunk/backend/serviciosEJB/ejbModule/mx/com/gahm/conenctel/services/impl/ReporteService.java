package mx.com.gahm.conenctel.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import mx.com.gahm.conenctel.services.IReporteService;
//import mx.com.gahm.conenctel.util.ManejadorReportes;

@Stateless(mappedName = "ejb/ReporteService")
public class ReporteService  implements IReporteService{

	@Override
	public Object getOrdenCompraMateriales() {
		Map<String, Object> parametros= new HashMap<String, Object>();
		List<Integer> datos = new ArrayList<Integer>();
		return null;
		//byte[] res=ManejadorReportes.ejecutaReporte(parametros, datos, "OrdenCompraMateriales.jasper");
		//return res;
	}

}
