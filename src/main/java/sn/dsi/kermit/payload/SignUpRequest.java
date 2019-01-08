package sn.dsi.kermit.payload;

import javax.validation.constraints.*;

import org.hibernate.annotations.NaturalId;



public class SignUpRequest {
	    @NotBlank
	    @Size(max = 20)
	    private String nom;
	    @NotBlank
	    @Size(max = 20)
	    private String prenom;
	    @NotBlank
	    @Size(max = 90)
	    private String adresse;
	    @NotBlank
	    @Size(max = 100)
	    private String codePostal;
	    @NotBlank
	    @Size(max = 100)
	    private String numeroTel;
	    @NotBlank
	    @Size(max = 30)
	    private String username;

	    @NaturalId
	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;

	    @NotBlank
	    @Size( min=6 ,max = 90)
	    private String password;

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getCodePostal() {
			return codePostal;
		}

		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}

		public String getNumeroTel() {
			return numeroTel;
		}

		public void setNumeroTel(String numeroTel) {
			this.numeroTel = numeroTel;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
}
