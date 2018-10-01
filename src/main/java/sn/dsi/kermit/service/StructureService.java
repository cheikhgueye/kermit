package sn.dsi.kermit.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sn.dsi.kermit.exception.BadRequestException;
import sn.dsi.kermit.exception.ResourceNotFoundException;
import sn.dsi.kermit.model.Structure;
import sn.dsi.kermit.model.User;
import sn.dsi.kermit.payload.PagedResponse;

import sn.dsi.kermit.payload.StructureRequest;
import sn.dsi.kermit.payload.StructureResponse;
import sn.dsi.kermit.repository.ObjectifRepository;
import sn.dsi.kermit.repository.StructureRepository;
import sn.dsi.kermit.repository.UserRepository;
import sn.dsi.kermit.security.UserPrincipal;
import sn.dsi.kermit.util.AppConstants;
import sn.dsi.kermit.util.ModelMapper;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StructureService {

    @Autowired
    private StructureRepository structureRepository;

    @Autowired
    private ObjectifRepository objectifRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    public PagedResponse<StructureResponse> getAllStructures(UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

      
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Structure> structures = structureRepository.findAll(pageable);

        if(structures.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), structures.getNumber(),
            		structures.getSize(), structures.getTotalElements(), structures.getTotalPages(), structures.isLast()) ;
        }
        return new PagedResponse<>(Collections.emptyList(), structures.getNumber(),
        		structures.getSize(), structures.getTotalElements(), structures.getTotalPages(), structures.isLast()) ;


    }

       
  

     


    public Structure createStructure(StructureRequest structureRequest) {
        Structure structure = new Structure();
        structure.setNameE(structureRequest.getName());
        structure.setCode_structure(structureRequest.getCode_structure());
        structure.setType(structureRequest.getType());

        return structureRepository.save(structure);
    }
    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

   
}
