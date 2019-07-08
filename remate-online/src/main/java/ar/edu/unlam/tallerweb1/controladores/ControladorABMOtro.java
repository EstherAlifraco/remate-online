package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.servicios.ServicioOtro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorABMOtro {
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioOtro servicioOtro;
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;
	
	@RequestMapping("abmOtro")
	public ModelAndView abmOtro(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("otro", servicioOtro.getAll());
				return new ModelAndView("/administrador/abmOtro", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/agregarOtro")
	public ModelAndView agregarOtro(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Otro otro = new Otro();
				List<SubCategoriaOtro> subCategoriaList = servicioSubCategoria.consultarSubCategoriaOtro();
				
				model.put("Otro", otro);
				model.put("subCategoriaList", subCategoriaList);

				return new ModelAndView("administrador/agregarOtro", model);
				} 
			else {
				model.put("avisoError", "Acceso denegado");
				model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
			return new ModelAndView("administrador/mensaje", model);}

			} else {
				return new ModelAndView("redirect:/login");
			}
		} 


	@RequestMapping(path = "/guardarOtro", method = RequestMethod.POST)
	public ModelAndView guardarOtro(@RequestParam("subOtroId") Long subOtroId,
		 @ModelAttribute("Otro") Otro otro,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				otro.setSubCategoria(servicioSubCategoria.getIdOtro(subOtroId));
					servicioOtro.guardarOtro(otro);

					model.put("aviso", "Creacion Exitosa");
					model.put("mensaje",
							String.format("Se ha guardado con el id %d de manera exitosa", otro.getId()));
					
					return new ModelAndView("administrador/mensaje", model);
				} 
			else {
					model.put("avisoError", "Creacion Fallida");
					model.put("mensajeError", String.format("No se ah podido crear"));
				}
				return new ModelAndView("administrador/mensaje", model);
			} else {
				return new ModelAndView("redirect:/login");
			}

	}

	@RequestMapping(path = "/actualizarOtro", method = RequestMethod.POST)
	public ModelAndView actualizarOtro(@ModelAttribute("otro") Otro otro, @RequestParam("subOtroId") Long subOtroId,
			HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				otro.setSubCategoria(servicioSubCategoria.getIdOtro(subOtroId));
				servicioOtro.actualizarOtro(otro);
				
				model.put("aviso", "Actualizacion Exitosa");
				model.put("mensaje", String.format("Otro con el id %d  se ha actualizado de manera exitosa",
						otro.getId()));
				return new ModelAndView("administrador/mensaje", model);
			} 
			else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/modificarOtro")
	public ModelAndView modificarOtro(@RequestParam("idOtro") Long idOtro, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Otro otro = servicioOtro.getId(idOtro);
				List<SubCategoriaOtro> subCategoriaList = servicioSubCategoria.consultarSubCategoriaOtro();
				model.put("otro", otro);
				model.put("subCategoriaList", subCategoriaList);
				return new ModelAndView("/administrador/modificarOtro", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/eliminarOtro")
	public ModelAndView eliminarOtro(@RequestParam("idOtro") Long idOtro, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				
				Otro otro = servicioOtro.getId(idOtro);

					servicioOtro.eliminarOtro(otro);
					
					model.put("aviso", "Eliminacion Exitosa");
					model.put("mensaje", "Se ha eliminado de manera exitosa");
			return new ModelAndView("administrador/mensaje", model);
				}
			else {
					model.put("avisoError", "Eliminacion Cancelada");
					model.put("mensajeError",
							String.format("Otro con el id %d  no pudo eliminarse"));

				}return new ModelAndView("administrador/mensaje", model);
		}
				
		     else {
				return new ModelAndView("redirect:/login");
			}
		}
	

}

