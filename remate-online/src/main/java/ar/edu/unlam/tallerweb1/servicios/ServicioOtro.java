package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Otro;

public interface ServicioOtro {
	
    List<Otro> consultarSubCategoria(Long subOtroId);
	
	Otro getId(Long id);

}

