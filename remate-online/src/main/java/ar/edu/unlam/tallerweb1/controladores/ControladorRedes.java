package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRedes {
	
	@RequestMapping(path = "//", method = RequestMethod.GET)
    public ModelAndView footer(){
		
		String facebook = null;
		String twitter= null;
		String instagram= null;
	
        ModelMap model = new ModelMap();
        model.put("facebook", facebook);
        model.put("twitter", twitter);
        model.put("instagram", instagram);
        
        return new ModelAndView("nav-footer", model);
	}
}
