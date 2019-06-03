package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Subasta;

public interface ServicioSubasta {
	
	void guardarSubasta(Subasta subasta);

	Subasta buscarSubasta(String nombre);

	List<Subasta> todosLasSubastas();


}
