package sn.dsi.kermit.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.dsi.kermit.model.Objectif;

import java.util.List;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {
  
   /* @Query("SELECT o  FROM Objectif o where o.user.id = :userId and o.structure.id in :structureIds")
    List<Objectif> findByUserIdAndStructureIdIn(@Param("userId") Long userId, @Param("structureIds") List<Long> structureIds);

    @Query("SELECT o FROM Objectif o where o.user.id = :userId and v.structure.id = :structureId")
    Objectif findByUserIdAndPollId(@Param("userId") Long userId, @Param("structureId") Long structureId);

    @Query("SELECT COUNT(o.id) from Objectif o where o.user.id = :userId")
    long countByUserId(@Param("userId") Long userId);
*/
  
}

