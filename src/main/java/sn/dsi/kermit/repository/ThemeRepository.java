package sn.dsi.kermit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.model.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

}
