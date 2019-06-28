package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

public interface SubCategoriaDao {
	
    List<SubCategoriaV> listarTiposVehiculos();
	
	SubCategoriaV getIdDao(Long subVeId);
	
	List<SubCategoriaV> consultarSubCategoriaVDao();
	
	List<SubCategoriaIn> consultarSubCategoriaInDao();
	
	List<SubCategoriaOtro> consultarSubCategoriaOtroDao();

}
