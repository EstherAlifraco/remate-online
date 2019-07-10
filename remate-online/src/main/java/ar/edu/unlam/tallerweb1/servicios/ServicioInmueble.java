package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;

public interface ServicioInmueble {
	
    List<Inmueble> consultarSubCategoria(Long subInId);
    
    void guardarInmueble(Inmueble inmueble);
	
	Inmueble getId(Long id);
	
	List<Inmueble> getAll();
	
	void actualizarInmueble(Inmueble inmueble);
	
	void eliminarInmueble(Inmueble inmueble);
	
	List <Inmueble> consultarSubasta(Long subastaId);
	
	List <Inmueble> consultarInmueble();

}
