package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Otro;
public interface ServicioOtro {
	
    List<Otro> consultarSubCategoria(Long subOtroId);
	
	Otro getId(Long id);
	
	void guardarOtro(Otro otro);

    List<Otro> getAll();
    
    void actualizarOtro(Otro otro);
    
	void eliminarOtro(Otro otro);
	
	List <Otro> consultarOtro();
}
