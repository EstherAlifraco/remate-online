package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;

public interface ServicioSubCategoria {
	
List<SubCategoriaV> listarTiposVehiculos();
	
	SubCategoriaV getId(Long subVeId);
	
	List<SubCategoriaV> consultarSubCategoriaV();
	
	List<SubCategoriaIn> consultarSubCategoriaIn();
	
	List<SubCategoriaOtro> consultarSubCategoriaOtro();

}

