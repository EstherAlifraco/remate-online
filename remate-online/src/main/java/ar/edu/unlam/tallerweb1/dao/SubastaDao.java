package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Subasta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface SubastaDao {
	
	void guardarSubasta(Subasta subasta);

	Subasta buscarSubasta(String nombre);

	List<Subasta> findAll();
	
	List<Usuario> listaDeUsuariosDao();

}

