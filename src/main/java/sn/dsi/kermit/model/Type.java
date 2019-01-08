package sn.dsi.kermit.model;

import javax.persistence.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	 
	  @OneToMany(mappedBy="type")
	  private Set<Structure> structure;
	  
	  
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Structure> getStructure() {
		return structure;
	}
	public void setStructure(Set<Structure> structure) {
		this.structure = structure;
	}
	


}
