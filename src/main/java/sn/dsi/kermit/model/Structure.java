package sn.dsi.kermit.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import sn.dsi.kermit.model.audit.UserDateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Entity
@Table(name = "structures")
public class Structure extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 140)
    private String code_structure;
    @NotBlank
    @Size(max = 140)
    private String type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNameE(String name) {
		this.name = name;
	}
	public String getCode_structure() {
		return code_structure;
	}
	public void setCode_structure(String code_structure) {
		this.code_structure = code_structure;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

    
}
