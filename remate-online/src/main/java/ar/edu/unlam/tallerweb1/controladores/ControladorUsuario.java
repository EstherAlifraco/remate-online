package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSubasta;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioUsuario servicioUsuario;

	@SuppressWarnings("unused")
	@Inject
	private ServicioSubasta servicioSubasta;

	//muestra la pagina principal
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String irAHome() {
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioUsuario.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			request.getSession().setAttribute("usuarioNombre", usuarioBuscado.getNombre());

			if (usuarioBuscado.getRol().equals("admin")) {
				return new ModelAndView("/administrador/perfilAdmin");
			}
			if (usuarioBuscado.getRol().equals("cliente")) {
				return new ModelAndView("redirect:/");
			}
			return new ModelAndView("redirect:/");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	//muestra la pagina de registro
	@RequestMapping("/registro")
	public ModelAndView irARegistro() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registro", modelo);
	}

	@RequestMapping(path="/registrar-usuario",method=RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute ("usuario") Usuario usuario,HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if(servicioUsuario.consultarUsuario(usuario) == null) {
			servicioUsuario.guardarUsuario(usuario);
			modelo.put("aviso", "�Se cre� el Usuario correctamente!");
		} else {
			modelo.put("aviso1", "El Usuario ya Existe");
		}
		return new ModelAndView("alerta",modelo);
	}

	@RequestMapping("cerrar-sesion")
	public ModelAndView cerrarSession(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("home");
	}
}
