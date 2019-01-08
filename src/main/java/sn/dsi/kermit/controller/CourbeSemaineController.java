package sn.dsi.kermit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.CourbeSemaine;
import sn.dsi.kermit.model.Tache;
import sn.dsi.kermit.repository.CourbeSemaineRepository;
import sn.dsi.kermit.repository.TacheRepository;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")

@RestController
@RequestMapping("/courbe")
public class CourbeSemaineController {
	 @Autowired
     private  CourbeSemaineRepository courbeRepository;
	@GetMapping("{terminaison}")
    public CourbeSemaine tracerCourbe(@PathVariable(value = "terminaison") String pt) {
        CourbeSemaine courbe = courbeRepository.findTopByOrderByIdDesc();
        switch(pt) {
        case "lundi":
        	courbe.setLundi(courbe.getLundi()+1);
        	break;
        case "mardi":
        	courbe.setMardi(courbe.getMardi()+1);
        	break;
        case "mercredi":
        	courbe.setMercredi(courbe.getMercredi()+1);
        	break;
        case "jeudi":
        	courbe.setJeudi(courbe.getJeudi()+1);
        	break;
        case "vendredi":
        	courbe.setVendredi(courbe.getVendredi()+1);
        	break;
        }
        
        
        
                
    	
    	

    	
        CourbeSemaine updatedCourbe = courbeRepository.save(courbe);
        return updatedCourbe;
    } 
	@GetMapping("tracer")
    public CourbeSemaine solderTache() {
        CourbeSemaine courbe = courbeRepository.findTopByOrderByIdDesc();
         

        
        return courbe;
    } 

}
