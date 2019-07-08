package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Otro;
import ar.edu.unlam.tallerweb1.modelo.Subasta;

public interface ServicioSubasta {
	
	void guardarSubasta(Subasta subasta);
	
	Subasta getSubastaId(Long id);

	List<Subasta> todosLasSubastas();
	
	Subasta consultarSubastaV(Long id);
	
	Otro consultarSubastaO(Long id);


}
