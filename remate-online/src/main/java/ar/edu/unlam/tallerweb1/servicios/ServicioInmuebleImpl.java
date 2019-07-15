package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.InmuebleDao;
import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.modelo.Inmueble;
import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("servicioInmueble")
@Transactional
@SuppressWarnings("unused")
public class ServicioInmuebleImpl implements ServicioInmueble{

	@Inject
	private InmuebleDao servicioInmuebleDao;

	@Inject
	private SubastaDao servicioSubastaDao;

	@Override
	public Inmueble getId(Long id) {
		return servicioInmuebleDao.getIdDao(id);
	}

	@Override
	public List<Inmueble> consultarSubCategoria(Long subInId) {
		return servicioInmuebleDao.consultarSubCategoriaDao(subInId);
	}

	@Override
	public void guardarInmueble(Inmueble inmueble) {
		servicioInmuebleDao.save(inmueble);
	}

	@Override
	public List<Inmueble> getAll() {
		return servicioInmuebleDao.getAllDao();
	}

	@Override
	public void actualizarInmueble(Inmueble inmueble) {
		servicioInmuebleDao.actualizarInmuebleDao(inmueble);
	}

	@Override
	public void eliminarInmueble(Inmueble inmueble) {
		servicioInmuebleDao.eliminarInmuebleDao(inmueble);
	}

	@Override
	public List <Inmueble> consultarSubasta(Long subastaId) {
		return servicioInmuebleDao.consultarSubastaDao(subastaId);
	}

	@Override
	public List <Inmueble> consultarInmueble() {
		return servicioInmuebleDao.consultarInmuebleDao();
	}
}
