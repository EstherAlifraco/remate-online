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

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorABMVehiculo {
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	
	@Inject
	private ServicioSubCategoria servicioSubCategoria;

		@RequestMapping("abmVehiculo")
		public ModelAndView abmVehiculo(HttpServletRequest request) {
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idUsuario != null) {
				if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
					model.put("vehiculo", servicioVehiculo.getAll());
					return new ModelAndView("/administrador/abmVehiculo", model);
				} else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/agregarVehiculo")
		public ModelAndView agregarVehiculo(HttpServletRequest request) {
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idUsuario != null) {
				if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
					Vehiculo vehiculo = new Vehiculo();
					List<SubCategoriaV> subCategoriaList = servicioSubCategoria.consultarSubCategoriaV();
					
					model.put("Vehiculo", vehiculo);
					model.put("subCategoriaList", subCategoriaList);

					return new ModelAndView("administrador/agregarVehiculo", model);
					} 
				else {
					model.put("avisoError", "Acceso denegado");
					model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("administrador/mensaje", model);}

				} else {
					return new ModelAndView("redirect:/login");
				}
			} 


		@RequestMapping(path = "/guardarVehiculo", method = RequestMethod.POST)
		public ModelAndView guardarVehiculo(@RequestParam("subVeId") Long subVeId,
			 @ModelAttribute("Vehiculo") Vehiculo vehiculo,
				HttpServletRequest request) {
			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					vehiculo.setSubCategoria(servicioSubCategoria.getId(subVeId));
						servicioVehiculo.guardarVehiculo(vehiculo);

						model.put("aviso", "Creacion Exitosa");
						model.put("mensaje",
								String.format("Se ha guardado con el id %d de manera exitosa", vehiculo.getId()));
						
						return new ModelAndView("administrador/mensaje", model);
					} 
				else {
						model.put("avisoError", "Creacion Fallida");
						model.put("mensajeError", String.format("No se ah podido crear el vehiculo"));
					}
					return new ModelAndView("administrador/mensaje", model);
				} else {
					return new ModelAndView("redirect:/login");
				}

		}

		@RequestMapping(path = "/actualizarVehiculo", method = RequestMethod.POST)
		public ModelAndView actualizarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo, @RequestParam("subVeId") Long subVeId,
				HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					vehiculo.setSubCategoria(servicioSubCategoria.getId(subVeId));
					servicioVehiculo.actualizarVehiculo(vehiculo);
					
					model.put("aviso", "Actualizacion Exitosa");
					model.put("mensaje", String.format("El vehiculo con el id %d  se a actualizado de manera exitosa",
							vehiculo.getId()));
					return new ModelAndView("administrador/mensaje", model);
				} 
				else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/modificarVehiculo")
		public ModelAndView modificarVehiculo(@RequestParam("idVehiculo") Long idVehiculo, HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					Vehiculo vehiculo = servicioVehiculo.getId(idVehiculo);
					List<SubCategoriaV> subCategoriaList = servicioSubCategoria.consultarSubCategoriaV();
					model.put("vehiculo", vehiculo);
					model.put("subCategoriaList", subCategoriaList);
					return new ModelAndView("/administrador/modificarVehiculo", model);
				} else {
					return new ModelAndView("redirect:/login");
				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		}

		@RequestMapping("/eliminarVehiculo")
		public ModelAndView eliminarVehiculo(@RequestParam("idVehiculo") Long idVehiculo, HttpServletRequest request) {

			Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			if (idAdmin != null) {
				if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
					
					Vehiculo vehiculo = servicioVehiculo.getId(idVehiculo);

						servicioVehiculo.eliminarVehiculo(vehiculo);
						
						model.put("aviso", "Eliminacion Exitosa");
						model.put("mensaje", "El vehiculo con se ha eliminado de manera exitosa");
				return new ModelAndView("administrador/mensaje", model);
					}
				else {
						model.put("avisoError", "Eliminacion Cancelada");
						model.put("mensajeError",
								String.format("El vehiculo con el id %d  no pudo eliminarse"));

					}return new ModelAndView("administrador/mensaje", model);
			}
					
			     else {
					return new ModelAndView("redirect:/login");
				}
			}

}
