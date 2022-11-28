package ma.cnss.projetStage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.cnss.projetStage.repository.userRepository;

@Controller
public class adminsController {
	@Autowired
	private userRepository usr;
	@RequestMapping("/admins")
	public String index(Model model) {
		model.addAttribute("listadmins", usr.findAll());
		return "admins";
	}

}
