package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("SubastaDao")
@SuppressWarnings("unchecked")
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

	@Override
	public List<Subasta> findAll() {
		return (sessionFactory.getCurrentSession().createCriteria(Subasta.class).list());

	}
	
	@Override
	public List<Usuario> listaDeUsuariosDao(){
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.isNotNull("id")).list());
		
	}
	@Override
	public Subasta consultarSubastaVDao(Long id){
		final Session session = sessionFactory.getCurrentSession();
		  return (Subasta) session.createCriteria(Subasta.class)
				.createAlias("vehiculo", "ve")
				.add(Restrictions.eq("ve.id", id))
				.uniqueResult();
	}
	
	@Override
	public Otro consultarSubastaODao(Long id){
		final Session session = sessionFactory.getCurrentSession();
		  return (Otro) session.createCriteria(Otro.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	
}
