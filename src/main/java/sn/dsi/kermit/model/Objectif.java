package sn.dsi.kermit.model;

import javax.persistence.*;

import sn.dsi.kermit.model.audit.DateAudit;

@Entity
@Table(name = "objecti")
public class Objectif extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    private String mois;
    private Long statuId;
    private String datEcheance;
    private Long  taux;
    private Long structureId;
    private Long themeId;
    private Long userId;
    private Long indicateurId;
    private String dateAnnulation;
    private String dernierCommentaireReport;
    private String commentaireAnnulation;
    private String NombreReport;
    private String description;
    private Long etat;
 
    
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
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getDatEcheance() {
		return datEcheance;
	}
	public void setDatEcheance(String datEcheance) {
		this.datEcheance = datEcheance;
	}
	public Long getStructureId() {
		return structureId;
	}
	public void setStructureId(Long structureId) {
		this.structureId = structureId;
	}
	public Long getThemeId() {
		return themeId;
	}
	public void setThemeId(Long themeId) {
		this.themeId = themeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getIndicateurId() {
		return indicateurId;
	}
	public void setIndicateurId(Long indicateurId) {
		this.indicateurId = indicateurId;
	}
	public Long getTaux() {
		return taux;
	}
	public void setTaux(Long taux) {
		this.taux = taux;
	}
	public Long getStatuId() {
		return statuId;
	}
	public void setStatuId(long statuId) {
		this.statuId = statuId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setStatuId(Long statuId) {
		this.statuId = statuId;
	}
	public String getDateAnnulation() {
		return dateAnnulation;
	}
	public void setDateAnnulation(String dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}
	public String getDernierCommentaireReport() {
		return dernierCommentaireReport;
	}
	public void setDernierCommentaireReport(String dernierCommentaireReport) {
		this.dernierCommentaireReport = dernierCommentaireReport;
	}
	public String getCommentaireAnnulation() {
		return commentaireAnnulation;
	}
	public void setCommentaireAnnulation(String commentaireAnnulation) {
		this.commentaireAnnulation = commentaireAnnulation;
	}
	public String getNombreReport() {
		return NombreReport;
	}
	public void setNombreReport(String nombreReport) {
		NombreReport = nombreReport;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getEtat() {
		return etat;
	}

	public void setEtat(long etat) {
		this.etat = etat;
		
	}
	
	
   
    
}
