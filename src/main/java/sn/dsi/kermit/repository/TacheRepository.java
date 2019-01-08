package sn.dsi.kermit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {

	List<Tache> findTacheByUserId(long id);


	List<Tache> findTacheByUserIdAndEtatAndStatu(long id, Boolean i, Long j);


	List<Tache> findByUserIdAndStatu(long id ,long s);


	List<Tache> findByUserIdAndStatuAndEtat(long id, long i, boolean b);


	List<Tache> findByObjecifIdAndStatuAndEtat(long id, long i, boolean b);

}
