package ma.cnss.projetStage.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class AffectationFile implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="Matricule")
	private String matricule;
	@Column(name="nom_prenom")
	private String NomPrenom;
	@Column(name="feuil1_post")
	private String Feuil1_Poste;
	@Column(name="uo_principallib")
	private String UO_principaleLib;
	@Column(name="poste_categorie_poste")
	private String poste_categorie_Poste;
	@Column(name="categorie_poste")
	private String Categorie_Poste;
	@Column(name="categorie_flotte")
	private String Categorie_Flotte;
	@Column(name="mobile")
	private String Mobile;
	@Column(name="numero_appel")
	private String Numero_Appel;
	@Column(name="observation")
	private String Observation;
	@Column(name="date_sortie")
	private String date_Sortie;
	@Column(name="nomination")
	private String nomination;
	@Column(name="date_nomination")
	private String date_Nomination;
	@Column(name="file_type")
	private String fileType;
	@Transient
	private MultipartFile file;
	
	public AffectationFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectationFile(String matricule, String nomPrenom, String feuil1_Poste, String uO_principaleLib,
			String poste_categorie_Poste, String categorie_Poste, String categorie_Flotte, String mobile,
			String numero_Appel, String observation, String date_Sortie, String nomination, String date_Nomination,
			String fileType) {
		super();
		this.matricule = matricule;
		this.NomPrenom = nomPrenom;
		this.Feuil1_Poste = feuil1_Poste;
		this.UO_principaleLib = uO_principaleLib;
		this.poste_categorie_Poste = poste_categorie_Poste;
		this.Categorie_Poste = categorie_Poste;
		this.Categorie_Flotte = categorie_Flotte;
		this.Mobile = mobile;
		this.Numero_Appel = numero_Appel;
		this.Observation = observation;
		this.date_Sortie = date_Sortie;
		this.nomination = nomination;
		this.date_Nomination = date_Nomination;
		this.fileType = fileType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNomPrenom() {
		return NomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		NomPrenom = nomPrenom;
	}

	public String getFeuil1_Poste() {
		return Feuil1_Poste;
	}

	public void setFeuil1_Poste(String feuil1_Poste) {
		Feuil1_Poste = feuil1_Poste;
	}

	public String getUO_principaleLib() {
		return UO_principaleLib;
	}

	public void setUO_principaleLib(String uO_principaleLib) {
		UO_principaleLib = uO_principaleLib;
	}

	public String getPoste_categorie_Poste() {
		return poste_categorie_Poste;
	}

	public void setPoste_categorie_Poste(String poste_categorie_Poste) {
		this.poste_categorie_Poste = poste_categorie_Poste;
	}

	public String getCategorie_Poste() {
		return Categorie_Poste;
	}

	public void setCategorie_Poste(String categorie_Poste) {
		Categorie_Poste = categorie_Poste;
	}

	public String getCategorie_Flotte() {
		return Categorie_Flotte;
	}

	public void setCategorie_Flotte(String categorie_Flotte) {
		Categorie_Flotte = categorie_Flotte;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getNumero_Appel() {
		return Numero_Appel;
	}

	public void setNumero_Appel(String numero_Appel) {
		Numero_Appel = numero_Appel;
	}

	public String getObservation() {
		return Observation;
	}

	public void setObservation(String observation) {
		Observation = observation;
	}

	public String getDate_Sortie() {
		return date_Sortie;
	}

	public void setDate_Sortie(String date_Sortie) {
		this.date_Sortie = date_Sortie;
	}

	public String getNomination() {
		return nomination;
	}

	public void setNomination(String nomination) {
		this.nomination = nomination;
	}

	public String getDate_Nomination() {
		return date_Nomination;
	}

	public void setDate_Nomination(String date_Nomination) {
		this.date_Nomination = date_Nomination;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	



	

	
	
	
	
	
	

}
