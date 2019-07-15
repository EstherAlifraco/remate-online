package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	public Usuario buscarPorId(Long usuarioId);
	
	public Usuario login(String email, String password);
	
	public void nuevoUsuario(Usuario usuario);
	
	Usuario consultarUsuario(Usuario usuario);
	
	void guardarUsuario(Usuario usuario);
	
	List<Usuario> todosLosUsuarios();
	
	List<Usuario> usuariosRol(String rol);
	
	Usuario consultarUsuarioPorEmail(Usuario usuario);
	
	void actualizarUsuario(Usuario usuario);
	
	void eliminarUsuario(Usuario usuario);
}
