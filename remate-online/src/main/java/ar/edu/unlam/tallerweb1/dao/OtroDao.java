package ar.edu.unlam.tallerweb1.dao;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Otro;

public interface OtroDao {
	
    List<Otro> consultarSubCategoriaDao(Long subOtroId);
	
	Otro getIdDao(Long id);
	
	void save(Otro otro);
	
    List<Otro> getAll();
    
    void actualizarOtro(Otro otro);
    
    void eliminarOtro(Otro otro); 
	
    List<Otro> consultarOtroDao();

}
