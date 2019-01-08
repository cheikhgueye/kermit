package sn.dsi.kermit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import sn.dsi.kermit.model.audit.DateAudit;

@Entity
@Table(name = "indicateurs")
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

public class Indicateur extends DateAudit{
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     @NotBlank
	     @Size(max = 100)
	    private String nom;
	     @NotBlank
	     @Size(max = 300)
	    private String description;
	  
	    private long structId;
	   
	   
	    private long themeId;
	    
	  
	    private long typeId;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public long getStructId() {
			return structId;
		}
		public void setStructId(long structId) {
			this.structId = structId;
		}
		
		public long getThemeId() {
			return themeId;
		}
		public void setThemeId(long themeId) {
			this.themeId = themeId;
		}
		public long getTypeId() {
			return typeId;
		}
		public void setTypeId(long typeId) {
			this.typeId = typeId;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    

}
