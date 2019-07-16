package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@SuppressWarnings("unchecked")
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Usuario findById(Long usuarioId) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("id", usuarioId)).uniqueResult();
	}

	@Override
	public void nuevoUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}
	
	//Comprobar las credenciales y retorna el usuario logeado, si las credenciales son incorrectas
	//o el usuario no existe retorna null
	@Override
	public Usuario login(String email, String password) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}

	@Override
	public void save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);		
	}

	@Override
	public List<Usuario> findAll() {
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class).list());

	}

	@Override
	public List<Usuario> usuariosRol(String rol) {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).add(Restrictions.eq("rol", rol)).list();
		return usuarios;
	}

	@Override // Se cambio "sessionFactory.getCurrentSession()" por "session"
	public Usuario consultarUsuarioPorEmail(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail())).uniqueResult();
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(usuario);
	}
}
