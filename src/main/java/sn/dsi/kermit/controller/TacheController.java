package sn.dsi.kermit.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.model.Tache;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.repository.StatuRepository;
import sn.dsi.kermit.repository.TacheRepository;
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

@RestController
@RequestMapping("/tache")
public class TacheController {
	 @Autowired
     private  TacheRepository tacheRepository;
	 @GetMapping("mesTaches/{id}")
	    public List<Tache> getByIdU(@PathVariable(value = "id") long id) {
	        return tacheRepository.findTacheByUserIdAndEtatAndStatu(id,false,(long) 0);
	    } 
	 
	 @GetMapping("targetTaches/{id}")
	    public List<Tache> getTargetTache(@PathVariable(value = "id") long id) {
	        return tacheRepository.findTacheByUserIdAndEtatAndStatu(id,false,(long) 1);
	    } 
	 @GetMapping("reporter/{id}")
	    public Tache tacheReporter(@PathVariable(value = "id") long id) {
	        Tache tache = tacheRepository.findById(id)
	        	
	                .orElseThrow(() -> new ResourceNotFoundException("Tache", "id", id));
	    	tache.setStatu((long) 0);
	        Tache updatedTache = tacheRepository.save(tache);
	        return updatedTache;
	    } 
	 @GetMapping("weekChoise/{id}")
	    public Tache tacheChoisie(@PathVariable(value = "id") long id) {
	        Tache tache = tacheRepository.findById(id)
	        	
	                .orElseThrow(() -> new ResourceNotFoundException("Tache", "id", id));
	    	tache.setStatu((long) 1);
	        Tache updatedTache = tacheRepository.save(tache);
	        return updatedTache;
	    } 
	 @GetMapping("weekTache/{id}")
	    public List<Tache> tacheWeek(@PathVariable(value = "id") long id) {      
	        return tacheRepository.findByUserIdAndStatuAndEtat(id,1,false);
	    } 
	 @GetMapping("solder/{id}")
	    public Tache solderTache(@PathVariable(value = "id") long id) {
	        Tache tache = tacheRepository.findById(id)	
	                .orElseThrow(() -> new ResourceNotFoundException("Tache", "id", id));
	    	tache.setEtat(true);
	    	tache.setStatu((long) 2);
	        Tache updatedTache = tacheRepository.save(tache);
	        return updatedTache;
	    } 
	 @GetMapping("tacheSolde/{id}")
	    public List<Tache> tachesSolde(@PathVariable(value = "id") long id) {       
	        return tacheRepository.findByUserIdAndStatuAndEtat(id,1,true);
	    }
	  @PostMapping("/add")
	  public Tache createTache(@Valid @RequestBody Tache tacheRequest) {
	    	Tache tache =tacheRepository.save(tacheRequest);
	      
	        return tache ;
	    }
	  @GetMapping("tacheeffectue/{id}")
	    public List<Tache> tachesEfectue(@PathVariable(value = "id") long id) {       
	        return tacheRepository. findByObjecifIdAndStatuAndEtat(id,1,true);
	    }

}
