package sn.dsi.kermit.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.model.Role;
import sn.dsi.kermit.model.RoleName;
import sn.dsi.kermit.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {
  
   @Query("SELECT o  FROM Objectif o where o.indicateurId = :id ")
    List<Objectif> findObjectifByIndicateur(@Param("id") Long userId);

   /*@Query("SELECT o FROM Objectif o where o.user.id = :userId and v.structure.id = :structureId")
    Objectif findByUserIdAndPollId(@Param("userId") Long userId, @Param("structureId") Long structureId);

    @Query("SELECT COUNT(o.id) from Objectif o where o.user.id = :userId")
    long countByUserId(@Param("userId") Long userId);
*/
   
   Optional<Objectif> findByNom(String nom);


@Query("SELECT o  FROM Objectif o where o.userId = :id ")
List<Objectif> findObjectifByUserId(@Param("id") Long userId);

List<Objectif> findObjectifByUserIdAndEtat(long id, long i);


  
}

