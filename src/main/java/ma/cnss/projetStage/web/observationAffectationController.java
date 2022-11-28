package ma.cnss.projetStage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.cnss.projetStage.entities.AffectationNumero;
import ma.cnss.projetStage.entities.Observation;
import ma.cnss.projetStage.entities.ObservationAffectation;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class observationAffectationController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@RequestMapping("/observation_affectation")
	public String index(Model model) {
		model.addAttribute("observationaffectations", ipMetierImp.listObservationAffectation());
		return"observation_affectation";
	}
	@RequestMapping("/observationaffectation/new")
	public String form(Model model) {
		ObservationAffectation observationaffectation=new ObservationAffectation();
		model.addAttribute("observationaffectation", observationaffectation);
		List<AffectationNumero>listaffecations=ipMetierImp.listAffectation();
		model.addAttribute("listaffecations", listaffecations);
		List<Observation>listobservations=ipMetierImp.listObservation();
		model.addAttribute("listobservations", listobservations);
		return"create_observation_affectation";
		
	}
	@PostMapping("/observation_affectation")
	public String saveObservationAffectation(@ModelAttribute("observationaffectation") ObservationAffectation obseraffectation) {
		ipMetierImp.Ajouterobservationaffectation(obseraffectation);
		return"redirect:/observation_affectation";
	}
	@GetMapping("/observation_affectation/{id}")
	public String deleteobservationAffectation(@PathVariable Long id) {
		ipMetierImp.deleteobservationaffectation(id);
		return"redirect:/observation_affectation";
	}
	@GetMapping("/observation_affectation/edit/{id}")
	public String updateobservationAffectation(@PathVariable Long id, Model model) {
		model.addAttribute("observationaffectation", ipMetierImp.getObservationaffectationById(id));

		List<AffectationNumero>listaffecations=ipMetierImp.listAffectation();
		model.addAttribute("listaffecations", listaffecations);
		List<Observation>listobservations=ipMetierImp.listObservation();
		model.addAttribute("listobservations", listobservations);
		
		return"create_observation_affectation";
	}

}
