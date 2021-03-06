package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Inmueble;
import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("servicioSubasta")
@SuppressWarnings("unused")
@Transactional
public class ServicioSubastaImpl implements ServicioSubasta{

	@Inject
	private SubastaDao servicioSubastaDao;

	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Inject
	private VehiculoDao servicioVehiculoDao;

	@Override
	public void guardarSubasta(Subasta subasta) {
		servicioSubastaDao.save(subasta);
	}

	@Override
	public Subasta getSubastaId(Long id) {
		return servicioSubastaDao.getSubastaId(id);
	}

	@Override
	public List<Subasta> todosLasSubastas() {
		return servicioSubastaDao.findAll();
	}

	@Override
	public Subasta consultarSubastaV(Long id) {
		return servicioSubastaDao.consultarSubastaVDao(id);
	}

	@Override
	public Subasta consultarSubastaO(Long id) {
		return servicioSubastaDao.consultarSubastaODao(id);
	}

	@Override
	public Subasta consultarSubastaIn(Long id) {
		return servicioSubastaDao.consultarSubastaInDao(id);
	}

	@Override
	public List<Subasta> getAll() {
		return servicioSubastaDao.getAll();
	}

	@Override
	public void actualizarSubasta(Subasta subasta) {
		servicioSubastaDao.actualizarSubasta(subasta);
	}

	@Override
	public void eliminarSubasta(Subasta subasta) {
		servicioSubastaDao.eliminarSubasta(subasta);
	}

	@Override
	public List<Subasta> consultarVehiculo(Long subastaVeId) {
		return servicioSubastaDao.consultarSubastaVeDao(subastaVeId);
	}

	@Override
	public Subasta getId(Long id) {
		return servicioSubastaDao.getIdDao(id);
	}
	
	@Override
	public Subasta modificarOferta(Double precioBase) {
		return servicioSubastaDao.setPrecioDao(precioBase);
	}
	
	@Override
	public Subasta getPrecioBase(Double precioBase) {
		return servicioSubastaDao.getPrecioDao(precioBase);
	}
	
	@Override
	public Subasta actualizarOfertar(Subasta subasta) {
		return servicioSubastaDao.actualizarOfertar(subasta);
	}

	@Override
	public Double sumarAlHacerClick(Long idSubasta, Subasta subasta) {
	    subasta = servicioSubastaDao.getIdDao(idSubasta);
		Double precio = 0.00D;
		precio = subasta.getPrecioBase()+ 5000;
		return precio;
	}
	
	@Override
	public Double precioTotal(Long idSubasta, Subasta subasta) {
	    subasta = servicioSubastaDao.getIdDao(idSubasta);
		Double newPrecio = subasta.getPrecioCierre().doubleValue() *
				(100 + 12)/100;
		subasta.setPrecioCierre(newPrecio);

		return newPrecio;
	}
}
