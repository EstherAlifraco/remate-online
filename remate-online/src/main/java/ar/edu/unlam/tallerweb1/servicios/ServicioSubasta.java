package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Subasta;

public interface ServicioSubasta {
	
	void guardarSubasta(Subasta subasta);
	
	Subasta getSubastaId(Long id);

	List<Subasta> todosLasSubastas();
	
	Subasta consultarSubastaV(Long id);
	
	Subasta consultarSubastaO(Long id);
	
	Subasta consultarSubastaIn(Long id);
	
	List<Subasta> getAll();
	
	void actualizarSubasta(Subasta subasta);
	
	void eliminarSubasta(Subasta subasta);
	
	 List<Subasta> consultarVehiculo(Long subastaVeId);
	 
	 Subasta getId(Long id);

}
