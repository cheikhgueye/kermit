package sn.dsi.kermit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.payload.PagedResponse;
import sn.dsi.kermit.payload.StructureRequest;
import sn.dsi.kermit.payload.StructureResponse;
import sn.dsi.kermit.repository.ObjectifRepository;
import sn.dsi.kermit.repository.StructureRepository;
import sn.dsi.kermit.repository.UserRepository;
import sn.dsi.kermit.security.CurrentUser;
import sn.dsi.kermit.security.UserPrincipal;
import sn.dsi.kermit.service.StructureService;
import sn.dsi.kermit.util.AppConstants;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 
 */

@RestController
@RequestMapping("/structure")
public class StructureController {

    @Autowired
    private StructureRepository structureRepository;

 

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StructureService structureService;

    private static final Logger logger = LoggerFactory.getLogger(StructureController.class);

    @GetMapping("/all")

    public List<Structure> getStructures() {
        return   structureRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createStructure(@Valid @RequestBody Structure structureRequest) {
    	 Structure struc = structureRepository.save(structureRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{strucId}")
                .buildAndExpand(struc.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "La structure est cree avec succe"));
    }

  

   

}
