package sn.dsi.kermit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.Type;
import sn.dsi.kermit.model.User;

public interface TypeRepository extends JpaRepository<Type, Long>  {

}
