package ma.cnss.projetStage.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.cnss.projetStage.entities.Personnel;


public interface personnelRepository extends JpaRepository<Personnel, Long>{
	@Query("select p from Personnel p where p.nom like %:x% OR p.prenom like %:x%")
	public List<Personnel> chercherPersonnel(@Param("x") String mc);
	@Query("select p from Personnel p where p.idPersonnel not in (select personnelAffecter from AffectationNumero)")
	public List<Personnel>listpers();
	
}
