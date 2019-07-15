package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorABMUsuario {

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping("/abmUsuario")
	public ModelAndView abmUsuario(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("cliente", servicioUsuario.usuariosRol("cliente"));
				model.put("admin", servicioUsuario.usuariosRol("admin"));
				return new ModelAndView("/administrador/abmUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("/agregarUsuario")
	public ModelAndView agregarUsuario(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Usuario usuario = new Usuario();
				model.put("usuario", usuario);
				return new ModelAndView("/administrador/agregarUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/guardarUsuario", method = RequestMethod.POST)
	public ModelAndView guardarUsuario(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				if (servicioUsuario.consultarUsuarioPorEmail(usuario) == null) {
					servicioUsuario.nuevoUsuario(usuario);
					model.put("usuario", usuario);
					model.put("aviso", "Creacion Exitosa");
					model.put("mensaje",String.format("Se ha creado el usuario con el id %d de manera exitosa", usuario.getId()));
				} else {
					model.put("avisoError", "El E-mail ya se encuentra en uso");
					model.put("mensajeError", String.format("Otro usuario ya está usando este correo: %s", usuario.getEmail()));
				}
				return new ModelAndView("administrador/mensaje", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/modificarUsuario")
	public ModelAndView modificarUsuario(@RequestParam("idUsuario") Long idUsuario, HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
				model.put("Usuario", usuario);
				return new ModelAndView("/administrador/modificarUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping(path = "/actualizarUsuario", method = RequestMethod.POST)
	public ModelAndView actualizarUsuario(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				if (servicioUsuario.consultarUsuarioPorEmail(usuario) == null) {
					servicioUsuario.actualizarUsuario(usuario);
					model.put("aviso", "Creacion Exitosa");
					model.put("mensaje",String.format("Se ha creado el usuario con el id %d de manera exitosa", usuario.getId()));
				} else {
					model.put("avisoError", "El E-mail ya se encuentra en uso");
					model.put("mensajeError", String.format("Otro usuario ya está usando este correo: %s", usuario.getEmail()));
				}
				return new ModelAndView("administrador/mensaje", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}


	@RequestMapping("/eliminarUsuario")
	public ModelAndView eliminarUsuario(@RequestParam("idUsuario") Long idUsuario, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
				servicioUsuario.eliminarUsuario(usuario);
				model.put("aviso", "Eliminacion Exitosa");
				model.put("mensaje",
						String.format("El usuario se ha eliminado de manera exitosa", usuario.getId()));
				return new ModelAndView("administrador/mensaje", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
}
