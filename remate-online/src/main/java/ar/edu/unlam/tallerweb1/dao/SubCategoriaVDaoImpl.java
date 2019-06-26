package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

@Repository("SubCategoriaVDao")
@SuppressWarnings("unchecked")
public class SubCategoriaVDaoImpl implements SubCategoriaVDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<SubCategoriaV> listarTiposVehiculos() {
		final Session session = sessionFactory.getCurrentSession();
		List<SubCategoriaV> tipoVehiculos = session.createCriteria(SubCategoriaV.class).list();
		return tipoVehiculos;

}  
	@Override
	public SubCategoriaV getIdDao(Long subVeId){
		final Session session = sessionFactory.getCurrentSession();
		return (SubCategoriaV) session.createCriteria(SubCategoriaV.class)				
				.add(Restrictions.eq("subVeId",subVeId))
				.uniqueResult();

	}
	
	@Override
	public List<SubCategoriaV> consultarSubCategoriaVDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(SubCategoriaV.class)
				.add(Restrictions.isNotNull("subVeId"))
				.list();
	}
	
}