package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;

@Repository("InmuebleDao")
@SuppressWarnings("unchecked")
public class InmuebleDaoImpl implements InmuebleDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Inmueble> consultarSubCategoriaDao(Long subInId){
		final Session session = sessionFactory.getCurrentSession();
		List <Inmueble> listaInmuebles = session.createCriteria(Inmueble.class)
				.createAlias("subCategoria", "sub")
				.add(Restrictions.eq("sub.subInId", subInId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return listaInmuebles;
	}
	
	@Override
	public Inmueble getIdDao(Long id) {
		  final Session session = sessionFactory.getCurrentSession();
		  return (Inmueble) session.createCriteria(Inmueble.class)
				  .add(Restrictions.eq("id",id))
				  .uniqueResult();
	   
	}
	
	@Override
	public void save(Inmueble inmueble) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(inmueble);

	}
	
	@Override
	public List<Inmueble> getAllDao() {
		final Session session = sessionFactory.getCurrentSession();
		List<Inmueble> inmuebles = session.createCriteria(Inmueble.class).list();
		return inmuebles;
	}
	
	@Override
	public void actualizarInmuebleDao(Inmueble inmueble) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(inmueble);
	}

	@Override
	public void eliminarInmuebleDao(Inmueble inmueble) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(inmueble);
	}
	

}
