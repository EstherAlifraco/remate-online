package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorSubasta {
	
	@SuppressWarnings("unused")
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@SuppressWarnings("unused")
	@Inject
	private ServicioSubasta servicioSubasta;
	
	@RequestMapping("/remate")
	public ModelAndView irARemate() {
		ModelMap model = new ModelMap();
		Subasta subasta = new Subasta();
		model.put("remate", subasta);
		return new ModelAndView("remate", model);
	}
	
	@RequestMapping (path="remate/{tipoRemate}")
	public ModelAndView remateNombre(@PathVariable String tipoRemate, @ModelAttribute Subasta remate) {
		
		switch (tipoRemate) {
		case "vehiculo":
			ModelMap model= new ModelMap();
			String vehiculo= remate.getTipo();
			model.put("vehiculo", vehiculo);
			return new ModelAndView("tipoVehiculo", model);
			
		case "inmueble":
			ModelMap model1= new ModelMap();
			String inmueble= remate.getTipo();
			model1.put("inmueble", inmueble);
			return new ModelAndView("tipoInmueble", model1);
			
		case "otro":
			ModelMap model2= new ModelMap();
			String otro= remate.getTipo();
			model2.put("otro", otro);
			return new ModelAndView("tipoOtro", model2);
		}
		return null;
	}
}
