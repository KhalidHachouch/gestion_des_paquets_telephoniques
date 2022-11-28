package ma.cnss.projetStage.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ma.cnss.projetStage.entities.AffectationNumero;
import ma.cnss.projetStage.entities.CategorieFlotte;
import ma.cnss.projetStage.entities.Mobile;
import ma.cnss.projetStage.entities.Personnel;
import ma.cnss.projetStage.entities.numeroTelephone;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class affectationController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@GetMapping("/affectation")
	public String index(Model model,@RequestParam(name = "page",defaultValue = "0")int p,
			@RequestParam(name = "size",defaultValue = "8")int s,
			@RequestParam(name = "motCle",defaultValue = "")String mc) {
		Page<AffectationNumero> pageProduits=ipMetierImp.chercherlist("%"+mc+"%",PageRequest.of(p, s));
		 model.addAttribute("affectations",pageProduits.getContent());
		 int [] pages = new int[pageProduits.getTotalPages()];
		 model.addAttribute("pages",pages);
		 model.addAttribute("size", s);
		 model.addAttribute("pageCourante", p);
		 model.addAttribute("motCle", mc);
		
		return"affectation";
	}
	@RequestMapping("/affectation/new")
	public String form(Model model) {
		AffectationNumero affectation=new AffectationNumero();
		affectation.setDateAffecation(new Date());
		model.addAttribute("affectation", affectation);
		List<Personnel> listPersonnels=ipMetierImp.listpers();
		model.addAttribute("listPersonnels", listPersonnels);
		List<Mobile> listMobiles=ipMetierImp.listmobile();
		model.addAttribute("listMobiles", listMobiles);
		List<numeroTelephone> listTelephones=ipMetierImp.listnums();
		model.addAttribute("listTelephones", listTelephones);
		List<CategorieFlotte> listCategories=ipMetierImp.listCategorie();
		model.addAttribute("listCategories", listCategories);
		return"create_affectation";
	}
	@PostMapping("/affectation")
	public String saveAffectation(@ModelAttribute("affectation") AffectationNumero affectation) {
		ipMetierImp.Ajouteraffectation(affectation);
		return"redirect:/affectation";
	}
	@InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
	@GetMapping("/affectation/{id}")
	public String deleteAffectation(@PathVariable Long id) {
		ipMetierImp.deleteaffection(id);
		return"redirect:/affectation";
	}
	@GetMapping("/affectation/edit/{id}")
	public String showEditForm(@PathVariable Long id,Model model) {
		model.addAttribute("affectation", ipMetierImp.getAffectationById(id));
		
		List<Personnel> listPersonnels=ipMetierImp.listPersonnel();
		model.addAttribute("listPersonnels", listPersonnels);
		List<Mobile> listMobiles=ipMetierImp.listmobile();
		model.addAttribute("listMobiles", listMobiles);
		List<numeroTelephone> listTelephones=ipMetierImp.listnums();
		model.addAttribute("listTelephones", listTelephones);
		List<CategorieFlotte> listCategories=ipMetierImp.listCategorie();
		model.addAttribute("listCategories", listCategories);
		
		return"create_affectation";
	}
	
}
