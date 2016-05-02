package intiformation.javajee.lynx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.CompteCourant;
import intiformation.javajee.lynx.entity.CompteEpargne;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;
import intiformation.javajee.metier.InterfMetier;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private InterfMetier metier;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping(value = "/")
	public String acceuil(Model model) {
		return "acceuil";
	}
	
	@RequestMapping(value = "/accueil")
	public String accueil(Model model) {
		return "acceuil";
	}

	@RequestMapping(value = "/client")
	public String client(Model model) {
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}

	@RequestMapping(value = "/employe")
	public String employe(Model model) {
		model.addAttribute("employe", metier.selectAllEmploye());
		model.addAttribute("groupe", metier.selectAllGroupe());
		return "employe";
	}

	@RequestMapping(value = "/ajouterEmploye")
	public String addEmploye(Model model,String nomEmploye) {
		metier.addEmploye(new Employe(nomEmploye));
		model.addAttribute("employe", metier.selectAllEmploye());
		model.addAttribute("groupe", metier.selectAllGroupe());
		return "employe";
	}
	
	@RequestMapping(value = "/ajouterGroupe")
	public String addGroupe(Model model, String nomGroupe) {
		metier.addGroupe(new Groupe(nomGroupe));
		model.addAttribute("groupe", metier.selectAllGroupe());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "employe";
	}
	
	@RequestMapping(value = "/ajouterE-G")
	public String addEG(Model model, Long codeEmploye, Long codeGroupe) {
		metier.addEmplToGroup(codeEmploye, codeGroupe);
		model.addAttribute("groupe", metier.selectAllGroupe());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "employe";
	}
	
	@RequestMapping(value = "/consulterListeE-G")
	public String listeEG(Model model, Long codeGroupe) {
		model.addAttribute("listg", metier.selectEmployOfGroup(codeGroupe));
		model.addAttribute("groupe", metier.selectAllGroupe());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "employe";
	}
	
	@RequestMapping(value="/ajouterClient")
	public String addClient (Model model , String nomClient, String prenomClient,
		String dateNaissance, String adressClient) throws ParseException{
		Date d = dateFormat.parse(dateNaissance);
		Client c = new Client(nomClient,prenomClient, d, adressClient);
		metier.addClient(c);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/rechercherClient")
	public String rechercherClient (Model model , String motCle){
		model.addAttribute("allCli",metier.searchClient(motCle));
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/typeCompte")
	public String typeCompte (Model model, String typeCompte){
		String type = typeCompte;
		model.addAttribute("typeCmpt", type);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}

	@RequestMapping(value="/ajouterCompteCourant")
	public String addCompteCourant (Model model, String soldeCompte, String decouvert, Long idClient, Long idEmploye) throws ParseException{
		double solde = Double.parseDouble(soldeCompte);
		double dec = Double.parseDouble(decouvert);
		CompteCourant c = new CompteCourant(solde, new Date());
		c.setDecouvert(dec);
		metier.addCompte(c, idClient, idEmploye);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/ajouterCompteEpargne")
	public String addCompteEpargne (Model model, String soldeCompte, String interet, Long idClient, Long idEmploye) throws ParseException{
		double solde = Double.parseDouble(soldeCompte);
		double taux = Double.parseDouble(interet);
		CompteEpargne c = new CompteEpargne(solde, new Date());
		c.setTauxInteret(taux);
		metier.addCompte(c, idClient, idEmploye);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/chercherCompteParClient")
	public String chercherCompteParClient (Model model, Long idClient){
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectCompteWithClient(idClient));
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/chercherCompteParEmploye")
	public String chercherCompteParEmploye (Model model, Long idEmploye){
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectCompteWithEmploy(idEmploye));
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";
	}
	
	@RequestMapping(value="/typeOperation")
	public String typeOperation (Model model, String typeOperation){
		String type = typeOperation;
		model.addAttribute("typeOpe", type);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
		return "client";	
	}
		
	@RequestMapping(value="/effectuerVersement")
	public String effectuerVersement (Model model, String montant, Long numeroCompte, Long idEmploye) throws ParseException{
		double somme = Double.parseDouble(montant);
	try {
		metier.verser(somme, numeroCompte, idEmploye);
		model.addAttribute("allCli", metier.selectAllClient());
		model.addAttribute("allCmpt", metier.selectAllCompte());
		model.addAttribute("allOpe", metier.selectAllOperation());
		model.addAttribute("employe", metier.selectAllEmploye());
	
	} catch (Exception e) {
		Operation o = new Versement();
		o.setException(e.getMessage());
		model.addAttribute("o",o);
	}
	return "client";
	}
	
	@RequestMapping(value="/effectueRetrait")
	public String effectuerRetrait (Model model, String montant, Long numeroCompte, Long idEmploye) throws ParseException{
		double somme = Double.parseDouble(montant);
		try {
			metier.doRetrait(somme, numeroCompte, idEmploye);
			model.addAttribute("allCli", metier.selectAllClient());
			model.addAttribute("allCmpt", metier.selectAllCompte());
			model.addAttribute("allOpe", metier.selectAllOperation());
			model.addAttribute("employe", metier.selectAllEmploye());
		} catch (Exception e) {
			Operation o = new Retrait();
			o.setException(e.getMessage());
			model.addAttribute("o",o);
		}
		return "client";
	}
	
	@RequestMapping(value="/effectuerVirementBancaire")
	public String effectuerVirement (Model model, String montant, Long numeroCompteCredite, Long numeroCompteDebite, Long idEmploye) throws ParseException{
		double somme = Double.parseDouble(montant);
		try {
			metier.doVirement(numeroCompteCredite, numeroCompteDebite, somme, idEmploye);
			model.addAttribute("allCli", metier.selectAllClient());
			model.addAttribute("allCmpt", metier.selectAllCompte());
			model.addAttribute("allOpe", metier.selectAllOperation());
			model.addAttribute("employe", metier.selectAllEmploye());
		} catch (Exception e) {
			Operation o = new Retrait();
			o.setException(e.getMessage());
			model.addAttribute("o",o);
		}
		return "client";
	}
	

	@RequestMapping(value="/Login")
	public String seconnecter(){
	return "Login";
	}
}