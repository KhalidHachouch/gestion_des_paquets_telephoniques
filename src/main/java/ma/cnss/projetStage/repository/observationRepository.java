package ma.cnss.projetStage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.cnss.projetStage.entities.Observation;

public interface observationRepository extends JpaRepository<Observation,Long> {

}
