package NavBarController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavBarController {
	@GetMapping("/home")
	public String getHomePage(Model model) {
		model.addAttribute("activePage", "index");
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("activePage", "login");
		return "login";
	}
	
	@GetMapping("/holdings")
	public String getHoldingsPage(Model model) {
		model.addAttribute("activePage","stockholding");
		return "stockholding";
	}

}
