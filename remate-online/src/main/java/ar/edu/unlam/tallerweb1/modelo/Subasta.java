package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name= "SUBASTA")
public class Subasta {
	 @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name= "ID")
	   private Long id;
	   @Temporal(TemporalType.TIMESTAMP) //Esta anotación hace posible mapear las fechas con la bas de datos, tipo fecha y hora.
	   private Date fechaInicio;
	   private Date fechaCierre;
	   @Column(name= "TIPO")
	   private String tipo;
	   @Column(name= "NOMBRE")
		private String nombre;
	   @Column(name= "PRECIO")
	   private Double precio;
	   @Column(name= "DESCRIPCION")
	   private String descripcion;
	 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

