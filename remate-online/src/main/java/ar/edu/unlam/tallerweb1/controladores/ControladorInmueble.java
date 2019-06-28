package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.servicios.ServicioInmueble;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;

@Controller
@SuppressWarnings("unused")
public class ControladorInmueble {
	

	@Inject
	private ServicioSubasta servicioSubasta;
	
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;
	
	@Inject
	private ServicioInmueble servicioInmueble;
	

	@RequestMapping("/remate/inmuebleTipo")
	public ModelAndView consultarTipo() {
		
		ModelMap model =new ModelMap();
		List<SubCategoriaIn> subCategoriaList = servicioSubCategoria.consultarSubCategoriaIn();
	
		model.put("subCategoriaList", subCategoriaList);
		
		return new ModelAndView ("subastaInmueble/tipoInmueble",model);
	}
    
	@RequestMapping(path="/inmuebles/{subInId}")
	public ModelAndView listaInmuebles(@PathVariable Long subInId) {
		
		ModelMap model = new ModelMap();
		List<Inmueble> listaInmueble = servicioInmueble.consultarSubCategoria(subInId);
		
		model.put("listaInmuebles", listaInmueble);
		
		return new ModelAndView("subastaInmueble/inmuebles", model);	
   }
	
	@RequestMapping(path="/inmueble/{id}")
	public ModelAndView inmuebleSubasta(@PathVariable Long id) {
		
		ModelMap model = new ModelMap();
		Inmueble inmueble = new Inmueble();
		
		model.put("inmueble", servicioInmueble.getId(id));
		
		
		
		return new ModelAndView("subastaInmueble/inmueble", model);	
   }
}

