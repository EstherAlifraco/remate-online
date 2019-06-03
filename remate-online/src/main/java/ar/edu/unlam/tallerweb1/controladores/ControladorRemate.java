package ar.edu.unlam.tallerweb1.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Remate;


@Controller
public class ControladorRemate {
	
	
	@RequestMapping("/remate")
	public ModelAndView irARemate() {
		ModelMap model = new ModelMap();
		Remate remate = new Remate();
		model.put("remate", remate);
		return new ModelAndView("remate", model);
	}
	
	
	@RequestMapping (path="remate/{tipoRemate}")
	public ModelAndView remateNombre(@PathVariable String tipoRemate, @ModelAttribute Remate remate ) {
		
		switch (tipoRemate) {
		case "vehiculo":
			ModelMap model= new ModelMap();
			String vehiculo= remate.getNombre();
			model.put("vehiculo", vehiculo);
			return new ModelAndView("vehiculo", model);
			
		case "inmueble":
			ModelMap model1= new ModelMap();
			String inmueble= remate.getNombre();
			model1.put("inmueble", inmueble);
			return new ModelAndView("inmueble", model1);
			
		case "otro":
			ModelMap model2= new ModelMap();
			String otro= remate.getNombre();
			model2.put("otro", otro);
			return new ModelAndView("otro", model2);
		
		}
		return null;
	}
}

