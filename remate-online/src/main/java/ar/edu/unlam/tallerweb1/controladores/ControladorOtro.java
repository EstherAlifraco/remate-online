package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.servicios.ServicioOtro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;

@Controller
@SuppressWarnings("unused")
public class ControladorOtro {
	
	@Inject
	private ServicioSubasta servicioSubasta;
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;
	
	@Inject
	private ServicioOtro servicioOtro;
	
	@RequestMapping("/remate/otroTipo")
	public ModelAndView consultarTipo() {
		ModelMap model =new ModelMap();
		List<SubCategoriaOtro> subCategoriaList = servicioSubCategoria.consultarSubCategoriaOtro();
		model.put("subCategoriaList", subCategoriaList);
		return new ModelAndView ("subastaOtro/tipoOtro",model);
	}
    
	@RequestMapping(path="/otros/{subOtroId}")
	public ModelAndView listaOtros(@PathVariable Long subOtroId) {
		ModelMap model = new ModelMap();
		List<Otro> listaOtro = servicioOtro.consultarSubCategoria(subOtroId);
		model.put("listaOtros", listaOtro);
		return new ModelAndView("subastaOtro/otros", model);	
   }
	
	@RequestMapping(path="/otro/{id}")
	public ModelAndView otroSubasta(@PathVariable Long id) {
		ModelMap model = new ModelMap();
		Otro otro = new Otro();
		model.put("otro", servicioOtro.getId(id));
		return new ModelAndView("subastaOtro/otro", model);	
   }
}
