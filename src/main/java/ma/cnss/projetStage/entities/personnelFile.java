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
public class personnelFile implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="Pole_Directtion_Agence")
	private String poleDirecttionAgence;
	@Column(name="agnece_direction_generale")
	private String agneceDirectionGenrale;
	@Column(name="direction_agence")
	private String directionAgence;
	@Column(name="Affectation")
	private String affectation;
	@Column(name="Matricule")
	private String matricule;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="date_naissance")
	private String dateNaissance;
	@Column(name="enc1")
	private String enc1;
	@Column(name="rang")
	private String rang;
	@Column(name="poste")
	private String poste;
	@Column(name="file_type")
	private String fileType;
	@Transient
	private MultipartFile file;
	
	public personnelFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoleDirecttionAgence() {
		return poleDirecttionAgence;
	}

	public void setPoleDirecttionAgence(String poleDirecttionAgence) {
		this.poleDirecttionAgence = poleDirecttionAgence;
	}

	public String getAgneceDirectionGenrale() {
		return agneceDirectionGenrale;
	}

	public void setAgneceDirectionGenrale(String agneceDirectionGenrale) {
		this.agneceDirectionGenrale = agneceDirectionGenrale;
	}

	public String getDirectionAgence() {
		return directionAgence;
	}

	public void setDirectionAgence(String directionAgence) {
		this.directionAgence = directionAgence;
	}

	public String getAffectation() {
		return affectation;
	}

	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEnc1() {
		return enc1;
	}

	public void setEnc1(String enc1) {
		this.enc1 = enc1;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
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

	public personnelFile(String poleDirecttionAgence, String agneceDirectionGenrale, String directionAgence,
			String affectation, String matricule, String nom, String prenom, String dateNaissance, String enc1,
			String rang, String poste, String fileType) {
		super();
		this.poleDirecttionAgence = poleDirecttionAgence;
		this.agneceDirectionGenrale = agneceDirectionGenrale;
		this.directionAgence = directionAgence;
		this.affectation = affectation;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.enc1 = enc1;
		this.rang = rang;
		this.poste = poste;
		this.fileType = fileType;
	}


	
	



	

	
	
	
	
	
	

}
