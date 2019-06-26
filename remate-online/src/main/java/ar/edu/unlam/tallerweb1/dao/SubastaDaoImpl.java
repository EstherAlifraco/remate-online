package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("SubastaDao")
public class SubastaDaoImpl implements SubastaDao{
	

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void save(Subasta subasta) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(subasta);

	}
	

	@Override
	public Subasta getSubastaId(Long id) {
		return (Subasta) (sessionFactory.getCurrentSession().createCriteria(Subasta.class)
				.add(Restrictions.eq("id", id)).uniqueResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subasta> findAll() {
		return (sessionFactory.getCurrentSession().createCriteria(Subasta.class).list());

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaDeUsuariosDao(){
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.isNotNull("id")).list());
		
	}
	@Override
	public Subasta consultarSubastaDao(Long id){
		final Session session = sessionFactory.getCurrentSession();
		  return (Subasta) session.createCriteria(Subasta.class)
				.createAlias("vehiculo", "ve")
				.add(Restrictions.eq("ve.id", id))
				.uniqueResult();
	}

}
