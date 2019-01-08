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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Indicateur;
import sn.dsi.kermit.model.ObjStatus;
import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.payload.UserProfile;
import sn.dsi.kermit.repository.IndicateurRepository;
import sn.dsi.kermit.repository.ObjectifRepository;
import sn.dsi.kermit.repository.StatuRepository;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

@RestController
@RequestMapping("/objectif")
public class ObjectifController {
	 @Autowired
	    private ObjectifRepository objectifRepository;
	 @Autowired
	     private  StatuRepository statuRepository;
	 
	
	    

	    private static final Logger logger = LoggerFactory.getLogger(ObjectifController.class);

	    @GetMapping("/all")

	    public List<Objectif> getStructures() {
	        return   objectifRepository.findAll();
	    }
	    @GetMapping("/objectifs/{id}")

	    public List<Objectif> getObjectifs(@PathVariable("id") long id) {
	        return   objectifRepository.findObjectifByIndicateur((long) id);
	    }
	
	    @PostMapping("/add")
	    public ResponseEntity<?> createStructure(@Valid @RequestBody Objectif objectifRequest) {
	    	objectifRequest.setStatuId((long) 1);
	    	objectifRequest.setEtat((long) 2 );
	    	Objectif objectif = objectifRepository.save(objectifRequest);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{strucId}")
	                .buildAndExpand(objectif.getId()).toUri();

	        return ResponseEntity.created(location)
	                .body(new ApiResponse(true, "l objectif est cree avec succe"));
	    }
	    @GetMapping("/all/statu")

	    public List<ObjStatus> getStatu() {
	        return   statuRepository.findAll();}

	  
	    @PutMapping("/update/{id}/{uid}")
	    public Objectif updateObjectif(@PathVariable(value = "id") Long objId ,@PathVariable(value = "uid") Long userId) {

	        Objectif objectif = objectifRepository.findById(objId)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	        objectif.setUserId(userId);
	        objectif.setStatuId(2);
	        Objectif updatedObj =objectifRepository.save(objectif);
	        return updatedObj;
	    }

	    @GetMapping("/{nom}")
	    public Objectif getByName(@PathVariable(value = "nom") String nom) {
	        Objectif objectif = objectifRepository.findByNom(nom)
	                .orElseThrow(() -> new ResourceNotFoundException("Objectif", "nom", nom));

	       
	        return objectif;
	    } 
	    @GetMapping("mesObjectifs/{id}")
	    public List<Objectif> getByIdU(@PathVariable(value = "id") long id) {
	        return objectifRepository.findObjectifByUserId(id);
	    } 
	    @GetMapping("nonrenseigne/{id}")
	    public List<Objectif> getNonRenseigne(@PathVariable(value = "id") long id) {
	        return objectifRepository.findObjectifByUserIdAndEtat(id,2);
	    } 
	    @GetMapping("atteint/{id}")
	    public List<Objectif> getAtteint(@PathVariable(value = "id") long id) {
	        return objectifRepository.findObjectifByUserIdAndEtat(id,1);
	    } 
	    @GetMapping("nonatteint/{id}")
	    public List<Objectif> getNonAtteint(@PathVariable(value = "id") long id) {
	        return objectifRepository.findObjectifByUserIdAndEtat(id,0);
	    } 
	    
	    
	    @PutMapping("/atteindre/{id}")
	    public Objectif atteindreObjectif(@PathVariable(value = "id") Long objId ) {

	        Objectif objectif = objectifRepository.findById(objId)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", objId));
	       
	        objectif.setEtat(1);
	        Objectif updatedObj =objectifRepository.save(objectif);
	        return updatedObj;
	    }  

}
