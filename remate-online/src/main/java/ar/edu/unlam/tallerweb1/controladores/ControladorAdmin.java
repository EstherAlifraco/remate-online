package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("/perfilAdmin")
	public ModelAndView mostrarPerfilAdmin(HttpServletRequest request) {		
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model =new ModelMap();
		
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Usuario usuarioLogueado = servicioUsuario.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
				model.put("usuario", usuarioLogueado);
				model.put("id", usuarioLogueado);
				model.put("email", usuarioLogueado);	
		
	 return new ModelAndView ("/administrador/perfilAdmin",model);
			}
			else {
				model.put("aviso2", "Acceso denegado");
				model.put("aviso3", "Para acceder usted debe tener rol ADMINISTRADOR");
			return new ModelAndView("alerta", model);}
	}	
		else {
			return new ModelAndView("redirect:/login");}
		
	}

}
