package ma.cnss.projetStage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idObservation;
	private String observationn;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="observatio")
	private List<ObservationAffectation> observationAffectation;
	public Long getIdObservation() {
		return idObservation;
	}
	public void setIdObservation(Long idObservation) {
		this.idObservation = idObservation;
	}
	public String getObservationn() {
		return observationn;
	}
	public void setObservationn(String observationn) {
		this.observationn = observationn;
	}
	
	public List<ObservationAffectation> getObservationAffectation() {
		return observationAffectation;
	}
	public void setObservationAffectation(List<ObservationAffectation> observationAffectation) {
		this.observationAffectation = observationAffectation;
	}
	public Observation(String observationn) {
		super();
		this.observationn = observationn;
	}
	public Observation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
