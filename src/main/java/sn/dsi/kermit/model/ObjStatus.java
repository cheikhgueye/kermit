package sn.dsi.kermit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import sn.dsi.kermit.model.audit.DateAudit;

@Entity
@Table(name = "statu")
public class ObjStatus extends DateAudit{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NaturalId
	    @Column(length = 60)
	    private String statu;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatu() {
			return statu;
		}

		public void setStatu(String statu) {
			this.statu = statu;
		}

	

	
       

}
