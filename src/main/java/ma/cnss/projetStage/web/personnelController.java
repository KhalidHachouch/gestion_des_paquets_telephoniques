package ma.cnss.projetStage.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.cnss.projetStage.entities.Personnel;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class personnelController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@RequestMapping(path = {"/personel","/search"})
	public String index(Model model,String mc) {
		if(mc !=null) {
			List<Personnel> personels=ipMetierImp.getBySearch(mc);
			model.addAttribute("personels", personels);
		}else
			model.addAttribute("personels", ipMetierImp.listPersonnel());
		return"personel";
	}
	@RequestMapping("/personnel/new")
	public String form(Model model){
		Personnel personel=new Personnel();
		personel.setDate_nomination(new Date());
		model.addAttribute("personel", personel);
		return"create_personel";
	}
	@PostMapping("/personel")
	public String savePersonnel(@ModelAttribute("personel") Personnel personel) {
		ipMetierImp.Ajouterpersonnel(personel);
		return "redirect:/personel";
	}
	@InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
	@GetMapping("/personel/{id}")
	public String deletePersonnel(@PathVariable Long id) {
		ipMetierImp.deletepersonnel(id);
		return"redirect:/personel";
	}
	@GetMapping("/personel/edit/{id}")
	public String updateForm(@PathVariable Long id,Model model) {
		model.addAttribute("personel", ipMetierImp.getPersonnelById(id));
		return"edit_personel";
	}
	@PostMapping("/personel/{id}")
	public String updatePersonnel(@PathVariable Long id,@ModelAttribute("personel") Personnel personel,Model model) {
		Personnel existingPersonnel=ipMetierImp.getPersonnelById(id);
		existingPersonnel.setIdPersonnel(id);
		existingPersonnel.setNom(personel.getNom());
		existingPersonnel.setPrenom(personel.getPrenom());
		existingPersonnel.setDate_naissance(personel.getDate_naissance());
		existingPersonnel.setDate_nomination(personel.getDate_nomination());
		existingPersonnel.setPoste(personel.getPoste());
		existingPersonnel.setUO_Principal(personel.getUO_Principal());
		existingPersonnel.setPoste_categorie(personel.getPoste_categorie());
		existingPersonnel.setMatricule(personel.getMatricule());
		ipMetierImp.updatepersonnel(existingPersonnel);
		model.addAttribute("disabled", true);
		return"redirect:/personel";
	}

}
