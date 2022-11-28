package ma.cnss.projetStage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.cnss.projetStage.entities.CategorieFlotte;
import ma.cnss.projetStage.service.IProjetMetierImp;

@Controller
public class categorieFlotteController {
	@Autowired
	private IProjetMetierImp ipMetierImp;
	@RequestMapping("/categorieflotte")
	public String index(Model model) {
		model.addAttribute("categories", ipMetierImp.listCategorie());
		return"categorieflotte";
	}
	@GetMapping("/categorieflotte/new")
	public String formCategorieFlotte(Model model) {
		CategorieFlotte categorie=new CategorieFlotte();
		model.addAttribute("categorie", categorie);
		return"create_categorieflotte";
	}
	@PostMapping("/categorieflotte")
	public String saveCategorie(@ModelAttribute("categorie") CategorieFlotte categorie) {
		ipMetierImp.Ajoutercategorie(categorie);
		return"redirect:/categorieflotte";
	}
	@GetMapping("/categorieflotte/{id}")
	public String deleteCategorie(@PathVariable Long id) {
		ipMetierImp.deleteCategorie(id);
		return "redirect:/categorieflotte";
	}
	@GetMapping("/categorieflotte/edit/{id}")
	public String editCategorieForm(@PathVariable Long id,Model model) {
		model.addAttribute("categorie", ipMetierImp.getCategorieById(id));
		return "edit_categorieflotte";
	}
	@PostMapping("/categorieflotte/{id}")
	public String updateCategorie(@PathVariable Long id ,@ModelAttribute("categorie") CategorieFlotte categorie, Model model) {
		CategorieFlotte existingCategorie=ipMetierImp.getCategorieById(id);
		existingCategorie.setIdCategorie(id);
		existingCategorie.setCategorieFlotte(categorie.getCategorieFlotte());
		existingCategorie.setFlotteNumero(categorie.getFlotteNumero());
		//existingNumber.setAfNumero(telephone.getAfNumero());
		ipMetierImp.updatecategorie(existingCategorie);
		model.addAttribute("disabled", true);
		return"redirect:/categorieflotte";
	}
}
