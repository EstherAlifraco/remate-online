package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("subastaDao")
public class SubastaDaoImpl implements SubastaDao{
	

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarSubasta(Subasta subasta) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(subasta);

	}

	@Override
	public Subasta buscarSubasta(String nombre) {
		return (Subasta) (sessionFactory.getCurrentSession().createCriteria(Subasta.class)
				.add(Restrictions.eq("nombre", nombre)).uniqueResult());

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subasta> todosLasSubastas() {
		return (sessionFactory.getCurrentSession().createCriteria(Subasta.class).list());

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaDeUsuariosDao(){
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.isNotNull("id")).list());
		
	}	

}
