package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	public Usuario buscarPorId(Long usuarioId);
	public Usuario login(String email, String nombre,String password);
	public void nuevoUsuario(Usuario usuario);
	Usuario consultarUsuario(Usuario usuario);
	void guardarUsuario(Usuario usuario);
	List<Usuario> todosLosUsuarios();
}
