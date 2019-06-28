package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubCategoriaDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaIn;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaOtro;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;


@Service("ServicioSubCategoria")
@SuppressWarnings("unused")
@Transactional
public class ServicioSubCategoriaImpl implements ServicioSubCategoria {
	
	@Inject
	private SubCategoriaDao servicioSubCategoriaDao;
	
	@Inject
	private VehiculoDao servicioVehiculoDao;
	
	@Override
	public List<SubCategoriaV> listarTiposVehiculos() {
		return servicioSubCategoriaDao.listarTiposVehiculos();
	}
	
	@Override
	public SubCategoriaV getId(Long subVeId) {
		return servicioSubCategoriaDao.getIdDao(subVeId);
	}
	
	@Override
	public List<SubCategoriaV> consultarSubCategoriaV(){
		return servicioSubCategoriaDao.consultarSubCategoriaVDao();
	}
	
	@Override
	public List<SubCategoriaIn> consultarSubCategoriaIn(){
		return servicioSubCategoriaDao.consultarSubCategoriaInDao();
	}
	
	@Override
	public List<SubCategoriaOtro> consultarSubCategoriaOtro(){
		return servicioSubCategoriaDao.consultarSubCategoriaOtroDao();
	}

}

