package ma.cnss.projetStage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ma.cnss.projetStage.entities.User;
import ma.cnss.projetStage.service.IUserMetierImp;

@Controller
public class acceuilController {
	@Autowired
	private IUserMetierImp iusr;
	

	/*
	 * @Autowired private BCryptPasswordEncoder bp;
	 */
	@GetMapping("/")
	public String index() {
		return "acceuil";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/inscription")
	public String register() {
		return "inscription";
	}
	@PostMapping("/createUser")
	public String creatUser(@ModelAttribute User user,HttpSession session) {
		boolean f =iusr.checkEmail(user.getEmail());
		if(f) {
			session.setAttribute("errormessage", "Désolé email exist deja");
		}else {
			User user1=iusr.createUser(user);
			if(user1!=null) {
				session.setAttribute("successmessage", "Inscription réussie");
			}else {
				session.setAttribute("errormessage", "Désolé quelque chose ne va pas");
			}
		}
		
		return"inscription";
	}

	
	

	

}
