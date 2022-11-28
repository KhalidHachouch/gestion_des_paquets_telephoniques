package ma.cnss.projetStage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import ma.cnss.projetStage.entities.Mobile;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class mobileController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	
	@RequestMapping("/mobile")
	public String index(Model model) {
		model.addAttribute("mobiles", ipMetierImp.listmobile());
		return"mobile";
	}
	@GetMapping("/mobile/new")
	public String form(Model model) {
		Mobile mobile=new Mobile();
		model.addAttribute("mobile",mobile);
		return"create_mobile";
	}
	@PostMapping("/mobile")
	public String saveMobile(@ModelAttribute("mobile") Mobile mobile) {
		ipMetierImp.Ajoutermobile(mobile);
		return "redirect:/mobile";
	}
	@GetMapping("/mobile/{id}")
	public String deleteMobile(@PathVariable Long id) {
		ipMetierImp.deletemobile(id);
		return"redirect:/mobile";
	}
	@GetMapping("/mobile/edit/{id}")
	public String editMobileForm(@PathVariable Long id,Model model) {
		model.addAttribute("mobile", ipMetierImp.getMobileById(id));
		return"edit_mobile";
	}
	@PostMapping("/mobile/{id}")
	public String updateMobile(@PathVariable Long id ,@ModelAttribute("mobile") Mobile mobile, Model model) {
		Mobile existingMobile=ipMetierImp.getMobileById(id);
		existingMobile.setIdMobile(id);
		existingMobile.setNomMobile(mobile.getNomMobile());
		//existingNumber.setAfNumero(telephone.getAfNumero());
		ipMetierImp.updatemobile(existingMobile);
		model.addAttribute("disabled", true);
		return"redirect:/mobile";
	}

}
