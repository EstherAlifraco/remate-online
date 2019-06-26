package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

public interface SubCategoriaVDao {
	
	List<SubCategoriaV> listarTiposVehiculos();
	
	SubCategoriaV getIdDao(Long subVeId);
	
	List<SubCategoriaV> consultarSubCategoriaVDao();
	

}
