package sn.dsi.kermit.model;

import org.hibernate.annotations.NaturalId;
import org.springframework.web.bind.annotation.CrossOrigin;

import sn.dsi.kermit.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
   /* @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private Image image;*/


   



	public User() {

    }

   


    public User(Long id, @NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 90) String adresse, @NotBlank @Size(max = 90) String numeroTel,
			@NotBlank @Size(max = 15) String username, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password, Set<Role> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}




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

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }




	public String getCodePostal() {
		return codePostal;
	}




	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}




	/*public Image getImage() {
		return image;
	}




	public void setImage(Image image) {
		this.image = image;
	}
	*/

    
}