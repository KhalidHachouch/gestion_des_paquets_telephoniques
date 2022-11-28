package ma.cnss.projetStage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.cnss.projetStage.entities.AffectationNumero;
import ma.cnss.projetStage.entities.CategorieFlotte;
import ma.cnss.projetStage.entities.Mobile;
import ma.cnss.projetStage.entities.Observation;
import ma.cnss.projetStage.entities.ObservationAffectation;
import ma.cnss.projetStage.entities.Personnel;
import ma.cnss.projetStage.entities.User;
import ma.cnss.projetStage.entities.numeroTelephone;
import ma.cnss.projetStage.repository.affectationNumeroRepository;
import ma.cnss.projetStage.repository.categorieFlotteRepository;
import ma.cnss.projetStage.repository.mobileRepository;
import ma.cnss.projetStage.repository.numeroRepository;
import ma.cnss.projetStage.repository.observationAffectationRepository;
import ma.cnss.projetStage.repository.observationRepository;
import ma.cnss.projetStage.repository.personnelRepository;
import ma.cnss.projetStage.repository.userRepository;

@SpringBootApplication
public class ProjetStageApplication implements CommandLineRunner {
	@Autowired
	private personnelRepository personnelRepository;
	@Autowired
	private observationRepository observationRepository;
	@Autowired
	private observationAffectationRepository observationAffectationRepository;
	@Autowired
	private numeroRepository numeroRepository;
	@Autowired
	private mobileRepository mobileRepository;
	@Autowired
	private categorieFlotteRepository categorieFlotteRepository;
	@Autowired
	private affectationNumeroRepository affectationNumeroRepository;
	@Autowired
	private userRepository usr;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetStageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		 /*Personnel p = new Personnel("khalid", "hachouch", new Date(), new Date(),
		  "test", "test", "test", "test"); personnelRepository.save(p);
		  
		  numeroTelephone nt= new numeroTelephone("0662889900");
		  numeroRepository.save(nt);
		  
		  Mobile m = new Mobile("samsung"); mobileRepository.save(m);
		  
		  Observation o = new Observation("good"); observationRepository.save(o);
		  
		  CategorieFlotte c = new CategorieFlotte("bureau", 3);
		  categorieFlotteRepository.save(c);
		  
		  AffectationNumero af= new AffectationNumero(p, nt, m, c, new Date());
		  affectationNumeroRepository.save(af);
		  
		  ObservationAffectation oa= new ObservationAffectation(af, o, "boy");
		  observationAffectationRepository.save(oa);*/
		 
		
		
		 
		
		
	}

}
