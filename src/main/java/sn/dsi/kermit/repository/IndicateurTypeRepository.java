package sn.dsi.kermit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.IndicateurType;
import sn.dsi.kermit.model.Objectif;

public interface IndicateurTypeRepository extends JpaRepository<IndicateurType, Long> {

}
