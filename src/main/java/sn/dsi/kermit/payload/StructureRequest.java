package sn.dsi.kermit.payload;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StructureRequest {
    @NotBlank
    @Size(max = 140)
    private String name;
    @NotBlank
    @Size(max = 140)
    private String code_structure;
    @NotBlank
    @Size(max = 140)
    private String type;
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
