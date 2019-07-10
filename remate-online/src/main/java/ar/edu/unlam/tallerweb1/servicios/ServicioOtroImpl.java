package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OtroDao;
import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.Subasta;

@Service("servicioOtro")
@Transactional
@SuppressWarnings("unused")
public class ServicioOtroImpl implements ServicioOtro {
	
	@Inject
	private OtroDao servicioOtroDao;
	
	@Inject
	private SubastaDao servicioSubastaDao;
	
	@Override
	public Otro getId(Long id) {
	return servicioOtroDao.getIdDao(id);
	}
	
	@Override
	public List<Otro> consultarSubCategoria(Long subOtroId) {
		return servicioOtroDao.consultarSubCategoriaDao(subOtroId);
	}
	
	@Override
    public void guardarOtro(Otro otro) {
    servicioOtroDao.save(otro);
	}

	@Override
	public List<Otro> getAll() {
		return servicioOtroDao.getAll();
	}
	
	@Override
	public void actualizarOtro(Otro otro) {
		servicioOtroDao.actualizarOtro(otro);
	}

	@Override
	public void eliminarOtro(Otro otro) {
		servicioOtroDao.eliminarOtro(otro);
	}
	
	@Override
	public List <Otro> consultarOtro() {
		return servicioOtroDao.consultarOtroDao();
	}
}
