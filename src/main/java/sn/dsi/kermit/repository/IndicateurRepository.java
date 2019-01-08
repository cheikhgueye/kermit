package sn.dsi.kermit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.Indicateur;
import sn.dsi.kermit.model.Objectif;

public interface IndicateurRepository extends JpaRepository<Indicateur, Long> {

}
