package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "INMUEBLE")
public class Inmueble {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long id;
	@Column(name= "CALLE")
	private String calle;
	@Column(name= "NUMERO")
	private int numero;
	@Column(name= "HABITACIONES")
	private int habitaciones;
	@Column(name="BARRIO")
	private String barrio;
	
	@ManyToOne
	private Subasta subastaInmueble;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Subasta getSubastaInmueble() {
		return subastaInmueble;
	}

	public void setSubastaInmueble(Subasta subastaInmueble) {
		this.subastaInmueble = subastaInmueble;
	}
}

