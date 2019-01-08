package sn.dsi.kermit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.dsi.kermit.model.ObjStatus;
import sn.dsi.kermit.model.Objectif;


public interface StatuRepository extends JpaRepository<	ObjStatus, Long>  {
	 
}
