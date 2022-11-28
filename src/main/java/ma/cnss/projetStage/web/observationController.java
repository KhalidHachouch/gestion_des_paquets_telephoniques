package ma.cnss.projetStage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ma.cnss.projetStage.entities.Observation;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class observationController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@RequestMapping("/observation")
	public String index(Model model) {
		model.addAttribute("observations", ipMetierImp.listObservation());
		return"observation";
	}
	@RequestMapping("/observation/new")
	public String form(Model model) {
		Observation observation=new Observation();
		model.addAttribute("observation", observation);
		return"create_observation";
	}
	@PostMapping("/observation")
	public String saveObservation(@ModelAttribute("observation") Observation observation) {
		ipMetierImp.Ajouterobservation(observation);
		return "redirect:/observation";
	}
	@GetMapping("/observation/{id}")
	public String deleteObservation(@PathVariable Long id) {
		ipMetierImp.deleteObservation(id);
		return "redirect:/observation";	
	}
	@GetMapping("/observation/edit/{id}")
	public String editObservationForm(@PathVariable Long id,Model model) {
		model.addAttribute("observation", ipMetierImp.getObservationById(id));
		return "edit_observation";
	}
	@PostMapping("/observation/{id}")
	public String updateObservation(@PathVariable Long id ,@ModelAttribute("observation") Observation observation, Model model) {
		Observation existingObservation=ipMetierImp.getObservationById(id);
		existingObservation.setIdObservation(id);
		existingObservation.setObservationn(observation.getObservationn());
		//existingNumber.setAfNumero(telephone.getAfNumero());
		ipMetierImp.updateObservation(existingObservation);
		model.addAttribute("disabled", true);
		return"redirect:/observation";
	}
}
