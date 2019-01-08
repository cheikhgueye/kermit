package sn.dsi.kermit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import sn.dsi.kermit.model.audit.DateAudit;
@Entity
@Table(name = "activite")

public class Tache extends DateAudit {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String libelle;
	    private String description;
	    private Long   objecifId;
	    private Long   userId;
	    private Long statu;
	    private Boolean etat;
	    
	   
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		
		public Long getObjecifId() {
			return objecifId;
		}
		public void setObjecifId(Long objecifId) {
			this.objecifId = objecifId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Boolean getEtat() {
			return etat;
		}
		public void setEtat(Boolean etat) {
			this.etat = etat;
		}
		public Long getStatu() {
			return statu;
		}
		public void setStatu(Long statu) {
			this.statu = statu;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		
	    
	    
	    

}
