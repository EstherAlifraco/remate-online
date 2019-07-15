package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{

	@Inject
	private UsuarioDao servicioUsuarioDao;

	@SuppressWarnings("unused")
	@Inject
	private SubastaDao servicioSubastaDao;

	@Override
	public Usuario login (String email, String password) {
		return servicioUsuarioDao.login(email,password);
	}

	@Override
	public Usuario buscarPorId(Long usuarioId) {
		return servicioUsuarioDao.findById(usuarioId);
	}

	@Override
	public void nuevoUsuario(Usuario usuario) {
		servicioUsuarioDao.nuevoUsuario(usuario);
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		return servicioUsuarioDao.consultarUsuario(usuario);
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		servicioUsuarioDao.save(usuario);
	}

	@Override
	public List<Usuario> todosLosUsuarios() {
		return servicioUsuarioDao.findAll();
	}

	@Override
	public List<Usuario> usuariosRol(String rol) {
		return servicioUsuarioDao.usuariosRol(rol);
	}

	@Override
	public Usuario consultarUsuarioPorEmail(Usuario usuario) {
		return servicioUsuarioDao.consultarUsuarioPorEmail(usuario);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		servicioUsuarioDao.actualizarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		servicioUsuarioDao.eliminarUsuario(usuario);
	}
}
