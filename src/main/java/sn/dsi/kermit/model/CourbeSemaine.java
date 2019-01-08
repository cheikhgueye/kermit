package sn.dsi.kermit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "courbeSemaine")
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

public class CourbeSemaine {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Long lundi;
	    private Long mardi;
	    private Long mercredi;
	    private Long jeudi;
	    private Long vendredi;
	    private Long code;
	    
	    
		public Long getCode() {
			return code;
		}
		public void setCode(Long code) {
			this.code = code;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getLundi() {
			return lundi;
		}
		public void setLundi(Long lundi) {
			this.lundi = lundi;
		}
		public Long getMardi() {
			return mardi;
		}
		public void setMardi(Long mardi) {
			this.mardi = mardi;
		}
		public Long getMercredi() {
			return mercredi;
		}
		public void setMercredi(Long mercredi) {
			this.mercredi = mercredi;
		}
		public Long getJeudi() {
			return jeudi;
		}
		public void setJeudi(Long jeudi) {
			this.jeudi = jeudi;
		}
		public Long getVendredi() {
			return vendredi;
		}
		public void setVendredi(Long vendredi) {
			this.vendredi = vendredi;
		}
	    
	    

}
