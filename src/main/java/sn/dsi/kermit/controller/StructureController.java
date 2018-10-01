package sn.dsi.kermit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.model.Structure;
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

/**
 * 
 */

@RestController
@RequestMapping("/api/structure")
public class StructureController {

    @Autowired
    private StructureRepository structureRepository;

    @Autowired
    private ObjectifRepository ObjectifRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StructureService structureService;

    private static final Logger logger = LoggerFactory.getLogger(StructureController.class);

    @GetMapping
    public PagedResponse<StructureResponse> getStructures(@CurrentUser UserPrincipal currentUser,
                                                @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return structureService.getAllStructures(currentUser, page, size);
    }

    @PostMapping
  //  @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createStructure(@Valid @RequestBody StructureRequest structureRequest) {
        Structure struc = structureService.createStructure(structureRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{strucId}")
                .buildAndExpand(struc.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Structure Created Successfully"));
    }

  
   

   

}
