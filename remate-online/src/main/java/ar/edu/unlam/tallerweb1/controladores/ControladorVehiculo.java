package ar.edu.unlam.tallerweb1.controladores;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;
import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoriaV;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
@SuppressWarnings("unused")
public class ControladorVehiculo {
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	
	
	@Inject
	private ServicioSubasta servicioSubasta;
	
	
	@Inject
	private ServicioSubCategoriaV servicioSubCategoriaV;
	
	/*@RequestMapping (path="/vehiculo/{tipoVehiculo}")
	public ModelAndView vehiculoNombre(@PathVariable SubCategoriaV tipoVehiculo, String tipoVehiculos) {
		
		switch (tipoVehiculos) {
		case "pickUp":
			ModelMap model= new ModelMap();
			Long id= tipoVehiculo.getSubVeId();
			String pickUp= tipoVehiculo.getTipo();
			model.put("pickUp", pickUp);
			model.put("id", id);
			return new ModelAndView("subastaVehiculo/vehiculo1", model);
			
		case "utilitario":
			ModelMap model1= new ModelMap();
			Long id1= tipoVehiculo.getSubVeId();
			String utilitario= tipoVehiculo.getTipo();
			model1.put("utilitario", utilitario);
			model1.put("id", id1);
			return new ModelAndView("subastaVehiculo/vehiculo1", model1);
			
		case "auto":
			ModelMap model2= new ModelMap();
			Long id2= tipoVehiculo.getSubVeId();
			String auto= tipoVehiculo.getTipo();
			model2.put("auto", auto);
			model2.put("id", id2);
			return new ModelAndView("subastaVehiculo/vehiculo1", model2);
			
		case "moto":
			ModelMap model3= new ModelMap();
			Long id3= tipoVehiculo.getSubVeId();
			String moto= tipoVehiculo.getTipo();
			model3.put("moto", moto);
			model3.put("id", id3);
			return new ModelAndView("subastaVehiculo/vehiculo1", model3);
		} 
		return null;
	
}*/
	
	@RequestMapping("/remate/vehiculoTipo")
	public ModelAndView consultarTipo() {
		
		ModelMap model =new ModelMap();
		List<SubCategoriaV> subCategoriaList = servicioSubCategoriaV.consultarSubCategoriaV();
	
		model.put("subCategoriaList", subCategoriaList);
		
		return new ModelAndView ("subastaVehiculo/tipoVehiculo",model);
	}
    
	@RequestMapping(path="/vehiculos/{subVeId}")
	public ModelAndView listaVehiculos(@PathVariable Long subVeId) {
		
		ModelMap model = new ModelMap();
		List<Vehiculo> listaVehiculo = servicioVehiculo.consultarSubCategoria(subVeId);
		
		model.put("listaVehiculos", listaVehiculo);
		
		return new ModelAndView("subastaVehiculo/vehiculos", model);	
   }
	
	@RequestMapping(path="/vehiculo/{id}")
	public ModelAndView vehiculoSubasta(@PathVariable Long id) {
		
		ModelMap model = new ModelMap();
		Vehiculo vehiculo = new Vehiculo();
		
		model.put("vehiculo", servicioVehiculo.getId(id));
		//model.put("subasta", servicioSubasta.consultarSubasta(id));
		
		
		
		return new ModelAndView("subastaVehiculo/vehiculo", model);	
   }
}
