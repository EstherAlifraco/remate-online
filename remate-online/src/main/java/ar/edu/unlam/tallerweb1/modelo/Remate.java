package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name= "REMATE")
public class Remate {
	 @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name= "ID")
	   private Long id;
	   @Column(name= "NOMBRE")
	   private String nombre;
	   @OneToMany(mappedBy="remate")
	   @Cascade(CascadeType.ALL)
	   private List<Subasta> subasta= new ArrayList <>();
	   
	   
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
	public List<Subasta> getSubasta() {
		return subasta;
	}
	public void setSubasta(List<Subasta> subasta) {
		this.subasta = subasta;
	} 
	
}
