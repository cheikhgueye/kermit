package sn.dsi.kermit.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.Type;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.repository.RoleRepository;
import sn.dsi.kermit.repository.TypeRepository;


@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeRepository typeRepository;
  
    
    @GetMapping("/all")
    public List<Type> getStructures() {
        return   typeRepository.findAll();
    }
	 @PostMapping("/add")
	  //  @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> createStructure(@Valid @RequestBody Type typeRequest) {
          Type type = typeRepository.save(typeRequest);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{strucId}")
	                .buildAndExpand(type.getId()).toUri();

	        return ResponseEntity.created(location)
	                .body(new ApiResponse(true, "La structure est cree avec succe"));
	    }

}
