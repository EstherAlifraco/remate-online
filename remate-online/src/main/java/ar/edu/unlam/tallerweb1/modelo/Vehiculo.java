package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "VEHICULO")
public class Vehiculo{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long id;
	@Column(name= "MARCA")
	private String marca;
	@Column(name= "MODELO")
	private String modelo;
	@Column(name= "PATENTE")
	private String patente;
	@Column(name= "COLOR")
	private String color;
	
	@ManyToOne
	private Subasta subastaVehiculo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Subasta getSubastaVehiculo() {
		return subastaVehiculo;
	}
	public void setSubastaVehiculo(Subasta subastaVehiculo) {
		this.subastaVehiculo = subastaVehiculo;
	}
	
}
