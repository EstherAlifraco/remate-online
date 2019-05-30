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
		case "judicial":
			ModelMap model= new ModelMap();
			String judicial= remate.getNombre();
			model.put("judicial", judicial);
			return new ModelAndView("judicial", model);
			
		case "administrativo":
			ModelMap model1= new ModelMap();
			String administrativo= remate.getNombre();
			model1.put("administrativo", administrativo);
			return new ModelAndView("administrativo", model1);
			
		case "privado":
			ModelMap model2= new ModelMap();
			String privado= remate.getNombre();
			model2.put("privado", privado);
			return new ModelAndView("privado", model2);
		
		}
		return null;
	}
}

