package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

public interface ServicioSubCategoriaV {
	
	List<SubCategoriaV> listarTiposVehiculos();
	
	SubCategoriaV getId(Long subVeId);
	
	List<SubCategoriaV> consultarSubCategoriaV();

}
