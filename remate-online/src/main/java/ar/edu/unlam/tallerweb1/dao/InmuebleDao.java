package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;

public interface InmuebleDao {
	
	List<Inmueble> consultarSubCategoriaDao(Long subInId);
	
	Inmueble getIdDao(Long id);

}

