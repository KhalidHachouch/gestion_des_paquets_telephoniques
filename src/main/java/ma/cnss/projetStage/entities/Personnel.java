package ma.cnss.projetStage.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Personnel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonnel;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	@Temporal(TemporalType.DATE)
	private Date date_nomination;
	private String poste;
	private String UO_Principal;
	private String poste_categorie;
	private String matricule;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="personnelAffecter")
	private List<AffectationNumero> affectationNumero;
	public Long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public Date getDate_nomination() {
		return date_nomination;
	}
	public void setDate_nomination(Date date_nomination) {
		this.date_nomination = date_nomination;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getUO_Principal() {
		return UO_Principal;
	}
	public void setUO_Principal(String uO_Principal) {
		UO_Principal = uO_Principal;
	}
	public String getPoste_categorie() {
		return poste_categorie;
	}
	public void setPoste_categorie(String poste_categorie) {
		this.poste_categorie = poste_categorie;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public List<AffectationNumero> getAffectationNumero() {
		return affectationNumero;
	}
	public void setAffectationNumero(List<AffectationNumero> affectationNumero) {
		this.affectationNumero = affectationNumero;
	}
	public Personnel(String nom, String prenom, Date date_naissance, Date date_nomination, String poste,
			String uO_Principal, String poste_categorie, String matricule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.date_nomination = date_nomination;
		this.poste = poste;
		UO_Principal = uO_Principal;
		this.poste_categorie = poste_categorie;
		this.matricule = matricule;
	}
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
