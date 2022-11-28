package ma.cnss.projetStage.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.cnss.projetStage.entities.numeroTelephone;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class telephoneController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@RequestMapping("/telephone")
	public String index(Model model) {
		model.addAttribute("telephones", ipMetierImp.listnumero());
		return"telephone";
	}
	@GetMapping("/telephone/new")
	public String form(Model model) {
		numeroTelephone telephone=new numeroTelephone();
		model.addAttribute("telephone",telephone);
		return"create_telephone";
	}
	@PostMapping("/telephone")
	public String saveNumero(@ModelAttribute("telephone") numeroTelephone telephone) {
		ipMetierImp.Ajouternumero(telephone);
		return"redirect:/telephone";
	}
	@GetMapping("/telephone/{id}")
	public String deleteTelephone(@PathVariable Long id) {
		ipMetierImp.deletenumero(id);
		return"redirect:/telephone";
	}
	@GetMapping("/telephone/edit/{id}")
	public String editTelephoneForm(@PathVariable Long id,Model model) {
		model.addAttribute("telephone", ipMetierImp.getNumeroById(id));
		return"edit_telephone";
	}
	@PostMapping("/telephone/{id}")
	public String updateTelephone(@PathVariable Long id ,@ModelAttribute("telephone") numeroTelephone telephone, Model model) {
		numeroTelephone existingNumber=ipMetierImp.getNumeroById(id);
		existingNumber.setIdNumeroTelephone(id);
		existingNumber.setNumero(telephone.getNumero());
		//existingNumber.setAfNumero(telephone.getAfNumero());
		ipMetierImp.updatenumero(existingNumber);
		model.addAttribute("disabled", true);
		return"redirect:/telephone";
	}
	
	
}
