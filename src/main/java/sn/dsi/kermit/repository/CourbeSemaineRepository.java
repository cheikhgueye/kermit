package sn.dsi.kermit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.dsi.kermit.model.CourbeSemaine;
import sn.dsi.kermit.model.Image;
import sn.dsi.kermit.model.Objectif;

public interface CourbeSemaineRepository extends JpaRepository<CourbeSemaine, Long> {

	CourbeSemaine findTopByOrderByIdDesc();
	  
	


}
