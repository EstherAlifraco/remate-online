package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Subasta;

public interface ServicioSubasta {
	
	void guardarSubasta(Subasta subasta);
	
	Subasta getSubastaId(Long id);

	List<Subasta> todosLasSubastas();
	
	Subasta consultarSubasta(Long id);

}
