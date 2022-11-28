package ma.cnss.projetStage.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.cnss.projetStage.entities.numeroTelephone;

public interface numeroRepository extends JpaRepository<numeroTelephone, Long> {
	@Query("select n from numeroTelephone n where n.numero like:x")
	public Page<numeroTelephone>cherchernum(@Param("x") Long numero,Pageable pageable);
	@Query("select n from numeroTelephone n where n.idNumeroTelephone not in (select numeroTelephoneAffecter from AffectationNumero)")
	public List<numeroTelephone>listnums();
	
	
}
