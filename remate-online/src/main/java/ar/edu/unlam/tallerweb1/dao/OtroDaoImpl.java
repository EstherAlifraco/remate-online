package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Otro;

@Repository("OtroDao")
@SuppressWarnings("unchecked")
public class OtroDaoImpl implements OtroDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Otro> consultarSubCategoriaDao(Long subOtroId){
		final Session session = sessionFactory.getCurrentSession();
		List <Otro> listaOtros = session.createCriteria(Otro.class)
				.createAlias("subCategoria", "sub")
				.add(Restrictions.eq("sub.subOtroId", subOtroId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return listaOtros;
	}
	
	@Override
	public Otro getIdDao(Long id) {
		  final Session session = sessionFactory.getCurrentSession();
		  return (Otro) session.createCriteria(Otro.class)
				  .add(Restrictions.eq("id",id))
				  .uniqueResult();
	   
	}
	
	@Override
	public void save(Otro otro) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(otro);

	}
	
	@Override
	public List<Otro> getAll() {
		final Session session = sessionFactory.getCurrentSession();
		List<Otro> otros = session.createCriteria(Otro.class).list();
		return otros;
	}
	
	@Override
	public void actualizarOtro(Otro otro) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(otro);
	}

	@Override
	public void eliminarOtro(Otro otro) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(otro);
	}
	
	@Override
	public List<Otro> consultarOtroDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Otro.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}
	
}
