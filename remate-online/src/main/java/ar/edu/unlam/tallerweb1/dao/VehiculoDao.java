package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface VehiculoDao {
	
	List<Vehiculo> findAll();
	
	void save(Vehiculo vehiculo);
	
	Vehiculo getIdDao(Long id);
	
	List<Vehiculo> mostrarVehiculosDao();
	
	List<Vehiculo> listarVehiculosDao();
	
	List<Vehiculo> consultarSubCategoriaDao(Long subVeId);
	
	List<Vehiculo> getAll();
	
	void actualizarVehiculo(Vehiculo vehiculo);
	
	void eliminarVehiculo(Vehiculo vehiculo);
	
	List<Vehiculo> consultarVehiculoDao();

}

