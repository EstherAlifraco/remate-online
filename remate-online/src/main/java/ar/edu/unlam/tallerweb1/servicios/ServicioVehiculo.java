package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;


public interface ServicioVehiculo {
	
	void guardarVehiculo(Vehiculo vehiculo);

	Vehiculo getId(Long id);

	List<Vehiculo> todosLosVehiculos();
	
	List<Vehiculo> mostrarVehiculos();
	
	List<Vehiculo> listarVehiculos();
	
	List<Vehiculo> consultarSubCategoria(Long subVeId);
	
	List<Vehiculo> getAll();
	
	void actualizarVehiculo(Vehiculo vehiculo);
	
	void eliminarVehiculo(Vehiculo vehiculo);

}

