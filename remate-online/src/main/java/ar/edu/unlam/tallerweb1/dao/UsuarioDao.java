package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	public Usuario findById(Long usuarioId);
	
	public void nuevoUsuario (Usuario usuario);
	
	public Usuario login(String email, String password);
	
	Usuario consultarUsuario(Usuario usuario);
	
	void save(Usuario usuario);
	
	List<Usuario> findAll();
	
	List<Usuario> usuariosRol(String rol);
	
	Usuario consultarUsuarioPorEmail(Usuario usuario);
	
	void actualizarUsuario(Usuario usuario);
	
	void eliminarUsuario(Usuario usuario);
	
}
