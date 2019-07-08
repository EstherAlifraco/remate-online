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

import ar.edu.unlam.tallerweb1.modelo.Inmueble;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.servicios.ServicioInmueble;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorABMInmueble {
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioInmueble servicioInmueble;
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;

		@RequestMapping("abmInmueble")
		public ModelAndView abmInmueble(HttpServletRequest request) {
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idUsuario != null) {
				if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
					model.put("inmueble", servicioInmueble.getAll());
					return new ModelAndView("/administrador/abmInmueble", model);
				} else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/agregarInmueble")
		public ModelAndView agregarInmueble(HttpServletRequest request) {
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idUsuario != null) {
				if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
					Inmueble inmueble = new Inmueble();
					List<SubCategoriaIn> subCategoriaList = servicioSubCategoria.consultarSubCategoriaIn();
					
					model.put("inmueble", inmueble);
					model.put("subCategoriaList", subCategoriaList);

					return new ModelAndView("administrador/agregarInmueble", model);
					} 
				else {
					model.put("avisoError", "Acceso denegado");
					model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("administrador/mensaje", model);}

				} else {
					return new ModelAndView("redirect:/login");
				}
			} 


		@RequestMapping(path = "/guardarInmueble", method = RequestMethod.POST)
		public ModelAndView guardarInmueble(@RequestParam("subInId") Long subInId,
			 @ModelAttribute("inmueble") Inmueble inmueble,
				HttpServletRequest request) {
			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					inmueble.setSubCategoria(servicioSubCategoria.getIdIn(subInId));
						servicioInmueble.guardarInmueble(inmueble);

						model.put("aviso", "Creacion Exitosa");
						model.put("mensaje",
								String.format("Se ha guardado con el id %d de manera exitosa", inmueble.getId()));
						
						return new ModelAndView("administrador/mensaje", model);
					} 
				else {
						model.put("avisoError", "Creacion Fallida");
						model.put("mensajeError", String.format("No se ha podido crear el inmueble"));
					}
					return new ModelAndView("administrador/mensaje", model);
				} else {
					return new ModelAndView("redirect:/login");
				}

		}

		@RequestMapping(path = "/actualizarInmueble", method = RequestMethod.POST)
		public ModelAndView actualizarInmueble(@ModelAttribute("inmueble") Inmueble inmueble, @RequestParam("subInId") Long subInId,
				HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					inmueble.setSubCategoria(servicioSubCategoria.getIdIn(subInId));
					servicioInmueble.actualizarInmueble(inmueble);
					
					model.put("aviso", "Actualizacion Exitosa");
					model.put("mensaje", String.format("El inmueble con el id %d  se a actualizado de manera exitosa",
							inmueble.getId()));
					return new ModelAndView("administrador/mensaje", model);
				} 
				else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/modificarInmueble")
		public ModelAndView modificarInmueble(@RequestParam("idInmueble") Long idInmueble, HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					Inmueble inmueble = servicioInmueble.getId(idInmueble);
					List<SubCategoriaIn> subCategoriaList = servicioSubCategoria.consultarSubCategoriaIn();
					model.put("inmueble", inmueble);
					model.put("subCategoriaList", subCategoriaList);
					return new ModelAndView("/administrador/modificarInmueble", model);
				} else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/eliminarInmueble")
		public ModelAndView eliminarInmueble(@RequestParam("idInmueble") Long idInmueble, HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					
					Inmueble inmueble = servicioInmueble.getId(idInmueble);

						servicioInmueble.eliminarInmueble(inmueble);
						
						model.put("aviso", "Eliminacion Exitosa");
						model.put("mensaje", "El inmueble se a eliminado de manera exitosa");
				return new ModelAndView("administrador/mensaje", model);
					}
				else {
						model.put("avisoError", "Eliminacion Cancelada");
						model.put("mensajeError",
								String.format("El inmueble con el id %d  no pudo eliminarse"));

					}return new ModelAndView("administrador/mensaje", model);
			}
					
			     else {
					return new ModelAndView("redirect:/login");
				}
			}

}
