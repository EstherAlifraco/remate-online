package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface SubastaDao {
	
	void save(Subasta subasta);
	
	Subasta getSubastaId(Long id);

	List<Subasta> findAll();
	
	List<Usuario> listaDeUsuariosDao();
	
	Subasta consultarSubastaDao(Long id);

}

