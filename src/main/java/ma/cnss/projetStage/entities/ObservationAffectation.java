package ma.cnss.projetStage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ObservationAffectation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idObservationAffectation;
	@ManyToOne
	@JoinColumn(name = "id_affecation_numero")
	private AffectationNumero affecNumero;
	@ManyToOne
	@JoinColumn(name = "id_observation")
	private Observation observatio;
	private String remarque;
	
	
	public Long getIdObservationAffectation() {
		return idObservationAffectation;
	}
	public void setIdObservationAffectation(Long idObservationAffectation) {
		this.idObservationAffectation = idObservationAffectation;
	}
	public AffectationNumero getAffecNumero() {
		return affecNumero;
	}
	public void setAffecNumero(AffectationNumero affecNumero) {
		this.affecNumero = affecNumero;
	}
	public Observation getObservatio() {
		return observatio;
	}
	public void setObservatio(Observation observatio) {
		this.observatio = observatio;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public ObservationAffectation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObservationAffectation(AffectationNumero affecNumero, Observation observatio, String remarque) {
		super();
		this.affecNumero = affecNumero;
		this.observatio = observatio;
		this.remarque = remarque;
	}
	
	

}
