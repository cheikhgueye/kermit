package sn.dsi.kermit.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.dsi.kermit.model.Structure;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Repository
public interface StructureRepository extends JpaRepository<Structure, Long> {

    Optional<Structure> findById(Long structureId);

    Page<Structure> findByCreatedBy(Long userId, Pageable pageable);

    long countByCreatedBy(Long userId);

    List<Structure> findByIdIn(List<Long> pollIds);

    List<Structure> findByIdIn(List<Long> pollIds, Sort sort);
}
