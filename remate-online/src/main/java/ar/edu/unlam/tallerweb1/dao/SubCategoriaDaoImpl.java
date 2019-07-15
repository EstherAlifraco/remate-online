package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

@Repository("SubCategoriaDao")
@SuppressWarnings("unchecked")
public class SubCategoriaDaoImpl implements SubCategoriaDao {

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

	@Override
	public SubCategoriaIn getIdInDao(Long subInId){
		final Session session = sessionFactory.getCurrentSession();
		return (SubCategoriaIn) session.createCriteria(SubCategoriaIn.class)				
				.add(Restrictions.eq("subInId",subInId))
				.uniqueResult();
	}

	@Override
	public List<SubCategoriaIn> consultarSubCategoriaInDao(){
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(SubCategoriaIn.class)
				.add(Restrictions.isNotNull("subInId"))
				.list();
	}

	@Override
	public List<SubCategoriaOtro> consultarSubCategoriaOtroDao(){
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(SubCategoriaOtro.class)
				.add(Restrictions.isNotNull("subOtroId"))
				.list();
	}

	@Override
	public SubCategoriaOtro getIdOtroDao(Long subOtroId){
		final Session session = sessionFactory.getCurrentSession();
		return (SubCategoriaOtro) session.createCriteria(SubCategoriaOtro.class)				
				.add(Restrictions.eq("subOtroId",subOtroId))
				.uniqueResult();
	}
}
