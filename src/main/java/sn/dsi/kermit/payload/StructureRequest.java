package sn.dsi.kermit.payload;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sn.dsi.kermit.model.Type;

import java.util.List;

public class StructureRequest {
    @NotBlank
    @Size(max = 140)
    private String name;
    @NotBlank
    @Size(max = 140)
    private String code_structure;
 
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id", nullable = false)
    @JsonIgnore
    private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
