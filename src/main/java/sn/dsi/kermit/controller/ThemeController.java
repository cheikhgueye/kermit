package sn.dsi.kermit.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.Theme;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.repository.ThemeRepository;
import sn.dsi.kermit.repository.UserRepository;
import sn.dsi.kermit.service.StructureService;

@RestController
@RequestMapping("/theme")
public class ThemeController {
	

	 

    @Autowired
    private ThemeRepository themeRepository;



    private static final Logger logger = LoggerFactory.getLogger(ThemeController.class);

    @GetMapping("/all")

    public List<Theme> getStructures() {
        return   themeRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createStructure(@Valid @RequestBody Theme themeRequest) {
    	 Theme theme = themeRepository.save(themeRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{strucId}")
                .buildAndExpand(theme.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Le Theme est cree avec succe"));
    }

  

}
