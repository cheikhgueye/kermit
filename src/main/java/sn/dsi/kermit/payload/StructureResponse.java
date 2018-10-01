package sn.dsi.kermit.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

public class StructureResponse {
    private Long id;
    private String name;
    private String code_structure;
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
	public void setName(String name) {
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
