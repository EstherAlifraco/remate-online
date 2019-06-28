package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "SUB_CATEGORIA_OTRO")
public class SubCategoriaOtro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long subOtroId;
	@Column(name= "TIPO")
	private String tipo;
	public Long getSubOtroId() {
		return subOtroId;
	}
	public void setSubOtroId(Long subOtroId) {
		this.subOtroId = subOtroId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
