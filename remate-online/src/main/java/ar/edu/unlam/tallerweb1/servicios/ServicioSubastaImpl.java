package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Subasta;

@Service("servicioSubasta")
@SuppressWarnings("unused")
@Transactional
public class ServicioSubastaImpl implements ServicioSubasta{

	@Inject
	private SubastaDao servicioSubastaDao;

	@Inject
	private UsuarioDao servicioUsuarioDao;
	
	@Inject
	private VehiculoDao servicioVehiculoDao;

	@Override
	public void guardarSubasta(Subasta subasta) {
		servicioSubastaDao.save(subasta);
	}
	
	@Override
	public Subasta getSubastaId(Long id) {
		return servicioSubastaDao.getSubastaId(id);

	}

	@Override
	public List<Subasta> todosLasSubastas() {
		return servicioSubastaDao.findAll();
	}
	
	@Override
	public Subasta consultarSubasta(Long id) {
		return servicioSubastaDao.consultarSubastaDao(id);
	}

}
