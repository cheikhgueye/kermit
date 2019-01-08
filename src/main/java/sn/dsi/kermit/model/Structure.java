package sn.dsi.kermit.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sn.dsi.kermit.model.audit.UserDateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "structure")
public class Structure extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String nom;
    
    private String code_structure;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id", nullable = false)
    @JsonIgnore
    private Type type;
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
	public String getCode_structure() {
		return code_structure;
	}
	public void setCode_structure(String code_structure) {
		this.code_structure = code_structure;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
  
	
	

    
}
