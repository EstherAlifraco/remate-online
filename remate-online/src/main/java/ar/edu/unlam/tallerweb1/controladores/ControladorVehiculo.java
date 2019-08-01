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
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
@SuppressWarnings("unused")
public class ControladorVehiculo {
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	
	@Inject
	private ServicioSubasta servicioSubasta;
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;
	
	@Inject
	private ServicioUsuario servicioUsuario;
		

	@RequestMapping("/remate/vehiculoTipo")
	public ModelAndView consultarTipo() {
		
		ModelMap model =new ModelMap();
		List<SubCategoriaV> subCategoriaList = servicioSubCategoria.consultarSubCategoriaV();
	
		model.put("subCategoriaList", subCategoriaList);
		
		return new ModelAndView ("subastaVehiculo/tipoVehiculo",model);
	}
    
	@RequestMapping(path="/vehiculos/{subVeId}")
	public ModelAndView listaVehiculos(@PathVariable Long subVeId) {
		
		ModelMap model = new ModelMap();
		List<Vehiculo> listaVehiculo = servicioVehiculo.consultarSubCategoria(subVeId);
		Subasta subasta = new Subasta();
		
		model.put("listaVehiculos", listaVehiculo);
		model.put("subasta", subasta);
		
		return new ModelAndView("subastaVehiculo/vehiculos", model);	
   }

	@RequestMapping(path="/vehiculo/{id}/{idSubasta}")
	public ModelAndView vehiculoSubasta(@PathVariable Long id,  @PathVariable Long idSubasta ,@ModelAttribute("subasta") 
	Subasta subasta, HttpServletRequest request) {
		
		
		Long idCliente = (Long) request.getSession().getAttribute("idUsuario");

		ModelMap model = new ModelMap();
		if (idCliente != null) {
			if (servicioUsuario.buscarPorId(idCliente).getRol().equals("cliente")) {
				
		model.put("vehiculo", servicioVehiculo.getId(id));
		model.put("subasta", servicioSubasta.getId(idSubasta));

		
		
		return new ModelAndView("subastaVehiculo/vehiculo", model);	
   }

			else
			{
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
}	