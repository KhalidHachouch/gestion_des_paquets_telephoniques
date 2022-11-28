package ma.cnss.projetStage.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ma.cnss.projetStage.entities.AffectationNumero;
import ma.cnss.projetStage.entities.CategorieFlotte;
import ma.cnss.projetStage.entities.Mobile;
import ma.cnss.projetStage.entities.Observation;
import ma.cnss.projetStage.entities.ObservationAffectation;
import ma.cnss.projetStage.entities.Personnel;
import ma.cnss.projetStage.entities.numeroTelephone;

public interface IProjetMetier {
	public numeroTelephone Ajouternumero(numeroTelephone tele);
	public numeroTelephone updatenumero(numeroTelephone tele);
	public void deletenumero(Long id);
	public numeroTelephone getNumeroById(Long id);
	public List<numeroTelephone>listnumero();
	public List<numeroTelephone>listnums();
	
	public Mobile Ajoutermobile(Mobile mobile);
	public Mobile updatemobile(Mobile mobile);
	public void deletemobile(Long id);
	public Mobile getMobileById(Long id);
	public List<Mobile>listmobile();
	
	public Observation Ajouterobservation(Observation observation);
	public Observation updateObservation(Observation observation);
	public void deleteObservation(Long id);
	public Observation getObservationById(Long id);
	public List<Observation>listObservation();
	
	public CategorieFlotte Ajoutercategorie(CategorieFlotte categorieFlotte);
	public CategorieFlotte updatecategorie(CategorieFlotte categorieFlotte);
	public void deleteCategorie(Long id);
	public CategorieFlotte getCategorieById(Long id);
	public List<CategorieFlotte>listCategorie();
	
	public Personnel Ajouterpersonnel(Personnel personnel);
	public Personnel updatepersonnel(Personnel personnel);
	public void deletepersonnel(Long id);
	public Personnel getPersonnelById(Long id);
	public List<Personnel>listPersonnel();
	public List<Personnel>getBySearch(String mc);
	public List<Personnel>listpers();
	
	
	public AffectationNumero Ajouteraffectation(AffectationNumero affection);
	public AffectationNumero  updateaffection(AffectationNumero affection);
	public void deleteaffection(Long id);
	public AffectationNumero getAffectationById(Long id);
	public List<AffectationNumero>listAffectation();
	public List<AffectationNumero> getBySearchA(String mc);
	public Page<AffectationNumero> chercherlist(String mc,Pageable pageable);
	
	public ObservationAffectation Ajouterobservationaffectation(ObservationAffectation observationaff);
	public ObservationAffectation updateobservationaffectation(ObservationAffectation observationaff);
	public void deleteobservationaffectation(Long id);
	public ObservationAffectation getObservationaffectationById(Long id);
	public List<ObservationAffectation>listObservationAffectation();
}
