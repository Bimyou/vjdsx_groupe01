package intiformation.javajee.lynx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import intiformation.javajee.metier.InterfMetier;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private InterfMetier metier;

	@RequestMapping(value = "/accueil")
	public String accueil(Model model) {
		return "acceuil";
	}

	@RequestMapping(value = "/client")
	public String client(Model model) {
		return "client";
	}

	@RequestMapping(value = "/employe")
	public String employe(Model model) {
		return "employe";

	}

}