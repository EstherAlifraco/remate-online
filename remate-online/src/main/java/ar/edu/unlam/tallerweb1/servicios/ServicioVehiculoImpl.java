package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("servicioVehiculo")
@Transactional
@SuppressWarnings("unused")
public class ServicioVehiculoImpl implements ServicioVehiculo{
	
	@Inject
	private VehiculoDao servicioVehiculoDao;
	
	@Inject
	private SubastaDao servicioSubastaDao;
	
	@Override
    public void guardarVehiculo(Vehiculo vehiculo) {
    servicioVehiculoDao.save(vehiculo);
	}

	@Override
	public Vehiculo getId(Long id) {
	return servicioVehiculoDao.getIdDao(id);
	}
	
	@Override
	public List<Vehiculo> todosLosVehiculos(){
	return servicioVehiculoDao.findAll();
	}
	
	@Override
	public List<Vehiculo> mostrarVehiculos(){
		return servicioVehiculoDao.mostrarVehiculosDao();
		
	}
	
	@Override
	public List<Vehiculo> listarVehiculos() {
		return servicioVehiculoDao.listarVehiculosDao();
	}
	
	@Override
	public List<Vehiculo> consultarSubCategoria(Long subVeId) {
		return servicioVehiculoDao.consultarSubCategoriaDao(subVeId);
	}
	
	@Override
	public List<Vehiculo> getAll() {
		return servicioVehiculoDao.getAll();
	}
	
	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		servicioVehiculoDao.actualizarVehiculo(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		servicioVehiculoDao.eliminarVehiculo(vehiculo);
	}

	
}
