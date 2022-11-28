package ma.cnss.projetStage.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.cnss.projetStage.entities.AffectationNumero;


public interface affectationNumeroRepository extends JpaRepository<AffectationNumero,Long> {

	@Query("select a from AffectationNumero a join a.personnelAffecter p where p.nom like %:x%")
	public List<AffectationNumero> chercher(@Param("x") String mc);
	@Query("select a from AffectationNumero a  join a.personnelAffecter p where p.nom like :x")
	public Page<AffectationNumero> chercherlist(@Param("x") String mc,Pageable pageable);
	
	
}
