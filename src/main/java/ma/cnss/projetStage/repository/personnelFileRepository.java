package ma.cnss.projetStage.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ma.cnss.projetStage.entities.personnelFile;
@Repository
public interface personnelFileRepository extends JpaRepository<personnelFile, Long> {
	@Query("select a from personnelFile a where a.matricule like :x or a.prenom like :x")
	Page<personnelFile>cherchelist(@Param("x")String mc,Pageable pageable);
	
}
