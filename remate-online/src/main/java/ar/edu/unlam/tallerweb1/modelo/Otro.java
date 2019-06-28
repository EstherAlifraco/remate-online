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
import javax.persistence.Table;

@Entity
@Table(name= "OTRO")
public class Otro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long id;
	@Column(name= "NOMBRE")
	private String nombre;
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@ManyToOne
	private Subasta subastaOtro;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "OTRO_subCategoria", nullable = false)
	private SubCategoriaOtro subCategoria;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Subasta getSubastaOtro() {
		return subastaOtro;
	}

	public void setSubastaOtro(Subasta subastaOtro) {
		this.subastaOtro = subastaOtro;
	}

	public SubCategoriaOtro getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoriaOtro subCategoria) {
		this.subCategoria = subCategoria;
	}
	
}

