package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;

public interface ServicioInmueble {
	
    List<Inmueble> consultarSubCategoria(Long subInId);
	
	Inmueble getId(Long id);

}
