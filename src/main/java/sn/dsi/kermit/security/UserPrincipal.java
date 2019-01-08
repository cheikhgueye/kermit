package sn.dsi.kermit.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sn.dsi.kermit.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String numeroTel;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

 

    public UserPrincipal(Long id, String nom, String prenom, String adresse, String codePostal,String numeroTel,
			String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.numeroTel = numeroTel;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrincipal(
        		 user.getId(),
                 user.getNom(),
                 user.getPrenom(),
                 user.getAdresse(),
                 user.getCodePostal(),
                 user.getNumeroTel(),
                 user.getUsername(),
                 user.getEmail(),
                 user.getPassword(),
                 authorities
        );
    }

    public Long getId() {
        return id;
    }

   

    public String getEmail() {
        return email;
    }
    

    public String getNom() {
		return nom;
	}

	

	public String getPrenom() {
		return prenom;
	}

	
	public String getAdresse() {
		return adresse;
	}

	

	public String getNumeroTel() {
		return numeroTel;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	

	@Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
