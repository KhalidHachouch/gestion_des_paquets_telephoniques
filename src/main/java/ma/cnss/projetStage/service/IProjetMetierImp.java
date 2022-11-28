package ma.cnss.projetStage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ma.cnss.projetStage.entities.AffectationNumero;
import ma.cnss.projetStage.entities.CategorieFlotte;
import ma.cnss.projetStage.entities.Mobile;
import ma.cnss.projetStage.entities.Observation;
import ma.cnss.projetStage.entities.ObservationAffectation;
import ma.cnss.projetStage.entities.Personnel;
import ma.cnss.projetStage.entities.numeroTelephone;
import ma.cnss.projetStage.repository.affectationNumeroRepository;
import ma.cnss.projetStage.repository.categorieFlotteRepository;
import ma.cnss.projetStage.repository.mobileRepository;
import ma.cnss.projetStage.repository.numeroRepository;
import ma.cnss.projetStage.repository.observationAffectationRepository;
import ma.cnss.projetStage.repository.observationRepository;
import ma.cnss.projetStage.repository.personnelRepository;
@Service
public class IProjetMetierImp implements IProjetMetier {
	@Autowired
	private numeroRepository numRepository;
	@Autowired
	private mobileRepository mobRepository;
	@Autowired
	private observationRepository obsRepository;
	@Autowired
	private categorieFlotteRepository catRepository;
	@Autowired
	private personnelRepository persRepository;
	@Autowired
	private affectationNumeroRepository affRepository;
	@Autowired
	private observationAffectationRepository obserAffectationRepository;
	@Override
	public numeroTelephone Ajouternumero(numeroTelephone tele) {
		// TODO Auto-generated method stub
		return numRepository.save(tele);
	}

	@Override
	public numeroTelephone updatenumero(numeroTelephone tele) {
		// TODO Auto-generated method stub
		return numRepository.save(tele);
	}

	@Override
	public void deletenumero(Long id) {
		// TODO Auto-generated method stub
		numRepository.deleteById(id);
		
	}

	@Override
	public numeroTelephone getNumeroById(Long id) {
		// TODO Auto-generated method stub
		return numRepository.findById(id).get();
	}

	@Override
	public List<numeroTelephone> listnumero() {
		// TODO Auto-generated method stub
		return numRepository.findAll();
	}
	@Override
	public List<numeroTelephone> listnums() {
		// TODO Auto-generated method stub
		return numRepository.listnums();
	}
	

	@Override
	public Mobile Ajoutermobile(Mobile mobile) {
		// TODO Auto-generated method stub
		return mobRepository.save(mobile);
	}



	@Override
	public Mobile updatemobile(Mobile mobile) {
		// TODO Auto-generated method stub
		return mobRepository.save(mobile);
	}

	@Override
	public void deletemobile(Long id) {
		// TODO Auto-generated method stub
		mobRepository.deleteById(id);
	}

	@Override
	public Mobile getMobileById(Long id) {
		// TODO Auto-generated method stub
		return mobRepository.findById(id).get();
	}

	@Override
	public List<Mobile> listmobile() {
		// TODO Auto-generated method stub
		return mobRepository.findAll();
	}

	@Override
	public Observation Ajouterobservation(Observation observation) {
		// TODO Auto-generated method stub
		return obsRepository.save(observation);
	}

	@Override
	public Observation updateObservation(Observation observation) {
		// TODO Auto-generated method stub
		return obsRepository.save(observation);
	}

	@Override
	public void deleteObservation(Long id) {
		// TODO Auto-generated method stub
		obsRepository.deleteById(id);
	}

	@Override
	public Observation getObservationById(Long id) {
		// TODO Auto-generated method stub
		return obsRepository.findById(id).get();
	}

	@Override
	public List<Observation> listObservation() {
		// TODO Auto-generated method stub
		return obsRepository.findAll();
	}

	@Override
	public CategorieFlotte Ajoutercategorie(CategorieFlotte categorieFlotte) {
		// TODO Auto-generated method stub
		return catRepository.save(categorieFlotte);
	}

	@Override
	public CategorieFlotte updatecategorie(CategorieFlotte categorieFlotte) {
		// TODO Auto-generated method stub
		return catRepository.save(categorieFlotte);
	}

	@Override
	public void deleteCategorie(Long id) {
		// TODO Auto-generated method stub
		catRepository.deleteById(id);
	}

	@Override
	public CategorieFlotte getCategorieById(Long id) {
		// TODO Auto-generated method stub
		return catRepository.findById(id).get();
	}

	@Override
	public List<CategorieFlotte> listCategorie() {
		// TODO Auto-generated method stub
		return catRepository.findAll();
	}

	@Override
	public Personnel Ajouterpersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return persRepository.save(personnel);
	}

	@Override
	public Personnel updatepersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return persRepository.save(personnel);
	}

	@Override
	public void deletepersonnel(Long id) {
		// TODO Auto-generated method stub
		persRepository.deleteById(id);
	}

	@Override
	public Personnel getPersonnelById(Long id) {
		// TODO Auto-generated method stub
		return persRepository.findById(id).get();
	}

	@Override
	public List<Personnel> listPersonnel() {
		// TODO Auto-generated method stub
		return persRepository.findAll();
	}
	
	public List<Personnel> getBySearch(String mc){
		return persRepository.chercherPersonnel(mc);
	}
	@Override
	public List<Personnel> listpers() {
		// TODO Auto-generated method stub
		return persRepository.listpers();
	}

	@Override
	public AffectationNumero Ajouteraffectation(AffectationNumero affection) {
		// TODO Auto-generated method stub
		return affRepository.save(affection);
	}

	@Override
	public AffectationNumero updateaffection(AffectationNumero affection) {
		// TODO Auto-generated method stub
		return affRepository.save(affection);
	}

	@Override
	public void deleteaffection(Long id) {
		// TODO Auto-generated method stub
		affRepository.deleteById(id);
	}

	@Override
	public AffectationNumero getAffectationById(Long id) {
		// TODO Auto-generated method stub
		return affRepository.findById(id).get();
	}

	@Override
	public List<AffectationNumero> listAffectation() {
		// TODO Auto-generated method stub
		return affRepository.findAll();
	}
	
	public List<AffectationNumero> getBySearchA(String mc){
		return affRepository.chercher(mc);
	}
	
	@Override
	public Page<AffectationNumero> chercherlist(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return affRepository.chercherlist(mc, pageable);
	}

	@Override
	public ObservationAffectation Ajouterobservationaffectation(ObservationAffectation observationaff) {
		// TODO Auto-generated method stub
		return obserAffectationRepository.save(observationaff);
	}

	@Override
	public ObservationAffectation updateobservationaffectation(ObservationAffectation observationaff) {
		// TODO Auto-generated method stub
		return obserAffectationRepository.save(observationaff);
	}

	@Override
	public void deleteobservationaffectation(Long id) {
		// TODO Auto-generated method stub
		obserAffectationRepository.deleteById(id);
	}

	@Override
	public ObservationAffectation getObservationaffectationById(Long id) {
		// TODO Auto-generated method stub
		return obserAffectationRepository.findById(id).get();
	}

	@Override
	public List<ObservationAffectation> listObservationAffectation() {
		// TODO Auto-generated method stub
		return obserAffectationRepository.findAll();
	}

	

	



	

}
