package sn.dsi.kermit.controller;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Indicateur;
import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.repository.ImageRepository;
import sn.dsi.kermit.repository.IndicateurRepository;
import sn.dsi.kermit.repository.ObjectifRepository;
import sn.dsi.kermit.repository.UserRepository;
import sn.dsi.kermit.service.StructureService;
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

@RestController
@RequestMapping("/indicateur")
public class IndicateurController {
	    @Autowired
	    private IndicateurRepository indiRepository;
	    private ObjectifRepository objRepository;

	    

	    private static final Logger logger = LoggerFactory.getLogger(StructureController.class);

	    @GetMapping("/all")

	    public List<Indicateur> getStructures() {
	        return   indiRepository.findAll();
	    }

	    @PostMapping("/add")
	    public ResponseEntity<?> createIndicateur(@Valid @RequestBody Indicateur indicateurRequest) {
	    	 Indicateur indicateur = indiRepository.save(indicateurRequest);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{strucId}")
	                .buildAndExpand(indicateur.getId()).toUri();

	        return ResponseEntity.created(location)
	                .body(new ApiResponse(true, "l indicateur est cree avec succe"));
	    }
	    @RequestMapping(value="/indicateur/{id}", method = RequestMethod.GET,headers="Accept=application/json" )

	    public Indicateur getIndicateur (@PathVariable("id") long id) {
			 

		      
	    	  Indicateur indicateur = indiRepository.findById(id)
	                  .orElseThrow(() -> new ResourceNotFoundException("indicateur", "id", id));

	        return indicateur;
	        
	    }
	    @PostMapping("/objectif/add")
	    public ResponseEntity<?> createObjectif(@Valid @RequestBody Objectif objRequest) {
	    	 Objectif obj = objRepository.save(objRequest);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{strucId}")
	                .buildAndExpand(obj.getId()).toUri();

	        return ResponseEntity.created(location)
	                .body(new ApiResponse(true, "l objectif est cree avec succe"));
	    }


}
