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
import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioInmueble;
import ar.edu.unlam.tallerweb1.servicios.ServicioOtro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorABMSubasta {

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioSubasta servicioSubasta;

	@Inject
	private ServicioVehiculo servicioVehiculo;

	@Inject
	private ServicioInmueble servicioInmueble;

	@Inject
	private ServicioOtro servicioOtro;


	@RequestMapping("abmSubasta")
	public ModelAndView abmSubasta(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("subasta", servicioSubasta.getAll());
				return new ModelAndView("/administrador/abmSubasta", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/agregarSubastaV")
	public ModelAndView agregarSubastaV(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Subasta subasta = new Subasta();
				List<Vehiculo> vehiculoList = servicioVehiculo.consultarVehiculo();

				model.put("subasta", subasta);
				model.put("vehiculoList", vehiculoList);

				return new ModelAndView("administrador/agregarSubastaV", model);
			} else {
				model.put("avisoError", "Acceso denegado");
				model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("administrador/mensaje", model);}

		} else {
			return new ModelAndView("redirect:/login");
		}
	} 


	@RequestMapping(path = "/guardarSubastaV", method = RequestMethod.POST)
	public ModelAndView guardarSubastaV(@RequestParam("id") Long id,
			@ModelAttribute("Subasta") Subasta subasta,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				subasta.setVehiculo(servicioVehiculo.getId(id));
				servicioSubasta.guardarSubasta(subasta);

				model.put("aviso", "Creación Exitosa");
				model.put("mensaje",
						String.format("Se ha guardado con el id %d de manera exitosa", subasta.getId()));

				return new ModelAndView("administrador/mensaje", model);
			} else {
				model.put("avisoError", "Creacion Fallida");
				model.put("mensajeError", String.format("No se ha podido crear la subasta"));
			}
			return new ModelAndView("administrador/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("/agregarSubastaIn")
	public ModelAndView agregarSubastaIn(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Subasta subasta = new Subasta();
				List<Inmueble> inmuebleList = servicioInmueble.consultarInmueble();

				model.put("subasta", subasta);
				model.put("inmuebleList", inmuebleList);

				return new ModelAndView("administrador/agregarSubastaIn", model);
			} else {
				model.put("avisoError", "Acceso denegado");
				model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("administrador/mensaje", model);}
		} else {
			return new ModelAndView("redirect:/login");
		}
	} 


	@RequestMapping(path = "/guardarSubastaIn", method = RequestMethod.POST)
	public ModelAndView guardarSubastaIn(@RequestParam("id") Long id,
			@ModelAttribute("Subasta") Subasta subasta,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				subasta.setInmueble(servicioInmueble.getId(id));
				servicioSubasta.guardarSubasta(subasta);

				model.put("aviso", "Creación exitosa");
				model.put("mensaje",
						String.format("Se ha guardado con el id %d de manera exitosa", subasta.getId()));

				return new ModelAndView("administrador/mensaje", model);
			} 
			else {
				model.put("avisoError", "Creacion Fallida");
				model.put("mensajeError", String.format("No se ha podido crear la subasta"));
			}
			return new ModelAndView("administrador/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}


	@RequestMapping("/agregarSubastaOtro")
	public ModelAndView agregarSubastaIOtro(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Subasta subasta = new Subasta();
				List<Otro> otroList = servicioOtro.consultarOtro();

				model.put("subasta", subasta);
				model.put("otroList", otroList);

				return new ModelAndView("administrador/agregarSubastaOtro", model);
			} else {
				model.put("avisoError", "Acceso denegado");
				model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("administrador/mensaje", model);}

		} else {
			return new ModelAndView("redirect:/login");
		}
	} 


	@RequestMapping(path = "/guardarSubastaOtro", method = RequestMethod.POST)
	public ModelAndView guardarSubastaOtro(@RequestParam("id") Long id,
			@ModelAttribute("Subasta") Subasta subasta,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				subasta.setOtro(servicioOtro.getId(id));
				servicioSubasta.guardarSubasta(subasta);

				model.put("aviso", "Creación exitosa");
				model.put("mensaje",
						String.format("Se ha guardado con el id %d de manera exitosa", subasta.getId()));

				return new ModelAndView("administrador/mensaje", model);
			} else {
				model.put("avisoError", "Creacion Fallida");
				model.put("mensajeError", String.format("No se ha podido crear la subasta"));
			}
			return new ModelAndView("administrador/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("/eliminarSubasta")
	public ModelAndView eliminarSubasta(@RequestParam("idSubasta") Long idSubasta, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Subasta subasta = servicioSubasta.getId(idSubasta);
				servicioSubasta.eliminarSubasta(subasta);
				model.put("aviso", "Eliminacion Exitosa");
			} else {
				model.put("avisoError", "Eliminación cancelada");
			}
			return new ModelAndView("administrador/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

}
