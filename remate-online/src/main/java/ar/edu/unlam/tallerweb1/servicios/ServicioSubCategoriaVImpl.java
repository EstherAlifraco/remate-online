package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubCategoriaVDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.SubCategoriaV;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;


@Service("ServicioSubCategoriaVImpl")
@SuppressWarnings("unused")
@Transactional
public class ServicioSubCategoriaVImpl implements ServicioSubCategoriaV{
	
	@Inject
	private SubCategoriaVDao servicioSubCategoriaVDao;
	
	@Inject
	private VehiculoDao servicioVehiculoDao;
	
	@Override
	public List<SubCategoriaV> listarTiposVehiculos() {
		return servicioSubCategoriaVDao.listarTiposVehiculos();
	}
	
	@Override
	public SubCategoriaV getId(Long subVeId) {
		return servicioSubCategoriaVDao.getIdDao(subVeId);
	}
	
	@Override
	public List<SubCategoriaV> consultarSubCategoriaV(){
		return servicioSubCategoriaVDao.consultarSubCategoriaVDao();
	}

}

