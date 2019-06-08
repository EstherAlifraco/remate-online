package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SubastaDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Subasta;

@Service("servicioSubasta")
@Transactional
public class ServicioSubastaImpl implements ServicioSubasta{
	
	@Inject
	private SubastaDao servicioSubastaDao;
	
	@SuppressWarnings("unused")
	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public void guardarSubasta(Subasta subasta) {
		servicioSubastaDao.guardarSubasta(subasta);
	}

	@Override
	public Subasta buscarSubasta(String nombre) {
		return servicioSubastaDao.buscarSubasta(nombre);

	}

	@Override
	public List<Subasta> todosLasSubastas() {
		return servicioSubastaDao.todosLasSubastas();
	}


}
