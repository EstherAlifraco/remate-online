package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@Column(name="LOCALIDAD")
	private String localidad;
    @Column(name="CIUDAD")
    private String ciudad;
	
	@OneToOne
	private Subasta subastaInmueble;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "INMUEBLE_subCategoria", nullable = false)
	private SubCategoriaIn subCategoria;

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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Subasta getSubastaInmueble() {
		return subastaInmueble;
	}

	public void setSubastaInmueble(Subasta subastaInmueble) {
		this.subastaInmueble = subastaInmueble;
	}

	public SubCategoriaIn getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoriaIn subCategoria) {
		this.subCategoria = subCategoria;
	}
	
}

