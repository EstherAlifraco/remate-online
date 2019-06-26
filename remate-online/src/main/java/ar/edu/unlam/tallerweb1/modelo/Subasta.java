package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;


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
	   @Column(name= "PRECIO_BASE")
	   private Double precioBase;
	   @Column(name= "PRECIO_CIERRE")
	   private Double precioCierre;
	   @Column(name= "DESCRIPCION")
	   private String descripcion;
	   
	   @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "subastaUsuario",
	        joinColumns = {@JoinColumn(name = "subastaId", referencedColumnName = "id")},
	        inverseJoinColumns = {@JoinColumn(name = "usuarioId", referencedColumnName = "id")})
	    private Set<Usuario> usuario;
	   
	   @OneToOne
	   private Vehiculo vehiculo;
	 
    
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public Double getPrecioCierre() {
		return precioCierre;
	}

	public void setPrecioCierre(Double precioCierre) {
		this.precioCierre = precioCierre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}

