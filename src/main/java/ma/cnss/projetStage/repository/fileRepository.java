package ma.cnss.projetStage.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import ma.cnss.projetStage.entities.AffectationFile;
@Repository
public interface fileRepository extends JpaRepository<AffectationFile, Long> {
	@Query("select p from AffectationFile p where p.matricule like %:x%")
	List<AffectationFile> listfiles(@Param("x")String mc);
	@Query("select a from AffectationFile a where a.matricule like :x")
	Page<AffectationFile>cherchelist(@Param("x")String mc,Pageable pageable);
	
}
