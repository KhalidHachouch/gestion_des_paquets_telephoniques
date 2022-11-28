package ma.cnss.projetStage.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class AffectationNumero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffectation;
	@ManyToOne
	@JoinColumn(name = "id_personnel")
	private Personnel personnelAffecter;
	@ManyToOne
	@JoinColumn(name = "id_numero_telephone")
	private numeroTelephone numeroTelephoneAffecter;
	@ManyToOne
	@JoinColumn(name = "id_mobile")
	private Mobile mobileAffecter;
	@ManyToOne
	@JoinColumn(name = "id_categorie_flotte")
	private CategorieFlotte categorieFlotteAffecter;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="affecNumero")
	private List<ObservationAffectation> observationAffectationAffecter;
	@Temporal(TemporalType.DATE)
	private Date dateAffecation;
	public Long getIdAffectation() {
		return idAffectation;
	}
	public void setIdAffectation(Long idAffectation) {
		this.idAffectation = idAffectation;
	}
	public Personnel getPersonnelAffecter() {
		return personnelAffecter;
	}
	public void setPersonnelAffecter(Personnel personnelAffecter) {
		this.personnelAffecter = personnelAffecter;
	}
	public numeroTelephone getNumeroTelephoneAffecter() {
		return numeroTelephoneAffecter;
	}
	public void setNumeroTelephoneAffecter(numeroTelephone numeroTelephoneAffecter) {
		this.numeroTelephoneAffecter = numeroTelephoneAffecter;
	}
	public Mobile getMobileAffecter() {
		return mobileAffecter;
	}
	public void setMobileAffecter(Mobile mobileAffecter) {
		this.mobileAffecter = mobileAffecter;
	}
	public CategorieFlotte getCategorieFlotteAffecter() {
		return categorieFlotteAffecter;
	}
	public void setCategorieFlotteAffecter(CategorieFlotte categorieFlotteAffecter) {
		this.categorieFlotteAffecter = categorieFlotteAffecter;
	}
	public List<ObservationAffectation> getObservationAffectationAffecter() {
		return observationAffectationAffecter;
	}
	public void setObservationAffectationAffecter(List<ObservationAffectation> observationAffectationAffecter) {
		this.observationAffectationAffecter = observationAffectationAffecter;
	}
	public Date getDateAffecation() {
		return dateAffecation;
	}
	public void setDateAffecation(Date dateAffecation) {
		this.dateAffecation = dateAffecation;
	}
	public AffectationNumero(Personnel personnelAffecter, numeroTelephone numeroTelephoneAffecter,
			Mobile mobileAffecter, CategorieFlotte categorieFlotteAffecter, Date dateAffecation) {
		super();
		this.personnelAffecter = personnelAffecter;
		this.numeroTelephoneAffecter = numeroTelephoneAffecter;
		this.mobileAffecter = mobileAffecter;
		this.categorieFlotteAffecter = categorieFlotteAffecter;
		this.dateAffecation = dateAffecation;
	}
	public AffectationNumero() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
