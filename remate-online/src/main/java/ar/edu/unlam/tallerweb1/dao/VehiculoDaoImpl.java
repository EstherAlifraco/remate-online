package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Repository("VehiculoDao")
@SuppressWarnings("unchecked")
public class VehiculoDaoImpl implements VehiculoDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Vehiculo> findAll() {
		List<Vehiculo> vehiculo =  sessionFactory.getCurrentSession().createCriteria(Vehiculo.class).list();
		return vehiculo;

	}
	
	@Override
	public void save(Vehiculo vehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(vehiculo);

	}
	
	@Override
	public Vehiculo getIdDao(Long id) {
		  final Session session = sessionFactory.getCurrentSession();
		  return (Vehiculo) session.createCriteria(Vehiculo.class)
				  .add(Restrictions.eq("id",id))
				  .uniqueResult();

		   
	}
	
	@Override
	public List<Vehiculo> mostrarVehiculosDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Vehiculo.class)
				.add(Restrictions.isNotNull("Id"))
				.list();
	}
	
	@Override
	public List<Vehiculo> listarVehiculosDao() {
		final Session session = sessionFactory.getCurrentSession();
		List<Vehiculo> vehiculos = session.createCriteria(Vehiculo.class)
		.list();
		return vehiculos;
	}
	
	@Override
	public List<Vehiculo> consultarSubCategoriaDao(Long subVeId){
		final Session session = sessionFactory.getCurrentSession();
		List <Vehiculo> listaVehiculos = session.createCriteria(Vehiculo.class)
				.createAlias("subCategoria", "sub")
				.add(Restrictions.eq("sub.subVeId", subVeId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return listaVehiculos;
	}
	
	@Override
	public List<Vehiculo> getAll() {
		final Session session = sessionFactory.getCurrentSession();
		List<Vehiculo> Vehiculos = session.createCriteria(Vehiculo.class).list();
		return Vehiculos;
	}
	
	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(vehiculo);
	}
	
	@Override
	public List<Vehiculo> consultarVehiculoDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Vehiculo.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}
	
}
