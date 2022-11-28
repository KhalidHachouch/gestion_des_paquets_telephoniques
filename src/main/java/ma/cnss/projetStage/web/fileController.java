package ma.cnss.projetStage.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.cnss.projetStage.entities.AffectationFile;
import ma.cnss.projetStage.repository.fileRepository;
import ma.cnss.projetStage.service.IFileMetierImp;

@Controller
public class fileController {
	@Autowired
	private IFileMetierImp ifile;
	@Autowired
	private fileRepository filerep;
	@GetMapping("/affectationfile")
	public String index(Model model,@RequestParam(name = "page",defaultValue = "0")int p,
			@RequestParam(name = "size",defaultValue = "8")int s,
			@RequestParam(name = "motCle",defaultValue = "")String mc) {
		 model.addAttribute("affectationfile", new AffectationFile());
		 Page<AffectationFile> pageProduits=filerep.cherchelist("%"+mc+"%",PageRequest.of(p, s));
		 model.addAttribute("listfiles",pageProduits.getContent());
		 int [] pages = new int[pageProduits.getTotalPages()];
		 model.addAttribute("pages",pages);
		 model.addAttribute("size", s);
		 model.addAttribute("pageCourante", p);
		 model.addAttribute("motCle", mc);
		
		return"affectationfile";
	}
	
	/*@GetMapping("/page/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber") int currentPage) {
		model.addAttribute("affectationfile", new AffectationFile());
		Page<AffectationFile> page = ifile.listfiles(currentPage);
		int totalPages=page.getTotalPages();
		Long totalItems=page.getTotalElements();
		List<AffectationFile> listfiles=page.getContent();
		model.addAttribute("listfiles", listfiles);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("currentPage", currentPage);
		return"affectationfile";
	}*/
	
	
	@PostMapping("/fileupload")
	public String uploadFile(@ModelAttribute AffectationFile affectationfile,RedirectAttributes redirectAttributes ) {
		boolean isFlag = ifile.saveDataFromUploadfile(affectationfile.getFile());
		if(isFlag) {
			redirectAttributes.addFlashAttribute("successmessage", "file uploaded succefully");
		}else {
			redirectAttributes.addFlashAttribute("errormessage", "file uploaded not done please try again");
		}
		return "redirect:/affectationfile";	
	}


}
