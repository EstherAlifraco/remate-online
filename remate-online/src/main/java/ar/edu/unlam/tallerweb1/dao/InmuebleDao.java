package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Inmueble;

public interface InmuebleDao {
	
	List<Inmueble> consultarSubCategoriaDao(Long subInId);
	
	Inmueble getIdDao(Long id);
	
	void save(Inmueble inmueble);
	
	List<Inmueble> getAllDao();
	
	void actualizarInmuebleDao(Inmueble inmueble);
	
	void eliminarInmuebleDao(Inmueble inmueble);

}
