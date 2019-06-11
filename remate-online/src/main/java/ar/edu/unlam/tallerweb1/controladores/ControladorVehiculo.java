package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;

@Controller
public class ControladorVehiculo {
	
	@SuppressWarnings("unused")
	@Inject
	private ServicioSubasta servicioSubasta;
	
	@RequestMapping (path="/vehiculo/{tipoVehiculo}")
	public ModelAndView vehiculoNombre(@PathVariable String tipoVehiculo, @ModelAttribute Vehiculo vehiculo) {
		
		switch (tipoVehiculo) {
		case "vehiculo1":
			ModelMap model= new ModelMap();
			String vehiculo1= vehiculo.getMarca();
			model.put("vehiculo1", vehiculo1);
			return new ModelAndView("subastaVehiculo/vehiculo1", model);
			
		case "vehiculo2":
			ModelMap model1= new ModelMap();
			String vehiculo2= vehiculo.getMarca();
			model1.put("vehiculo2", vehiculo2);
			return new ModelAndView("subastaVehiculo/vehiculo2", model1);
			
		case "vehiculo3":
			ModelMap model2= new ModelMap();
			String vehiculo3= vehiculo.getMarca();
			model2.put("vehiculo3", vehiculo3);
			return new ModelAndView("subastaVehiculo/vehiculo3", model2);
			
		case "vehiculo4":
			ModelMap model3= new ModelMap();
			String vehiculo4= vehiculo.getMarca();
			model3.put("vehiculo4", vehiculo4);
			return new ModelAndView("subastaVehiculo/vehiculo4", model3);
		}
		return null;
	}

}
