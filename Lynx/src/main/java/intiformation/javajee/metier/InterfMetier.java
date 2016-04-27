/**
 * 
 */
package intiformation.javajee.metier;

import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;

import java.util.List;

/**
 * @author Xavier Charef
 * 
  * nomProjet : Lynx
 * Interface  Metier
 * date 27/04/2016
 * Package : intiformation.javajee.lynx.metier
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: 
 */
public interface InterfMetier {

	/** addClient ajoute un client a la base de donnee**/
	public void addClient(Client client);
	
	/**getClient renvoie un client grace a son identifiant**/
	public Client getClient (Long idClient);

	/** addEmploye ajoute un employe a la base de donnee**/
	public void addEmploye(Employe employe);
	
	/**getemploye renvoie un employe grace a son identifiant**/
	public Employe getEmploye (Long idEmploye);

	/** addGroupe ajoute un groupe a la base de donnee**/
	public void addGroupe(Groupe groupe);
	
	/**getGroupe renvoie un Groupe grace a son identifiant**/
	public Groupe getGroupe (Long idGroupe);

	/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**/
	public void addEmplToGroup (Long idEmploye,Long codeGroupe);
	
	/** addCompte ajoute un compte a la base de donnee**/
	public void addCompte (Compte c, Long idClient, Long idEmploye);
	
	/** addOperation ajoute un operation a la base de donnee**/
	public void addOperation (Operation o, Long idEmploye);
	
	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	public Compte getCompte (Long idCompte);
	
	/**getOperation renvoie un Operation grace a son identifiant**/
	public Operation getOperation (Long idOperation);
	
	/** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**/
	public List<Compte> selectCompteWithClient (Long idClient);
	
	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	public List<Compte> selectCompteWithEmploy (Long IdEmploye);

	/** selectAllEmploye selectionne une liste de tout les employes de la base de donnee **/
	public List<Employe> selectAllEmploye ();

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	public List<Groupe> selectAllGroupe ();

	/** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **/
	public List<Employe> selectEmployOfGroup (Long idGroupe);

	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	public List<Client> searchClient (String mc);

	/** doVersement effectue un versement v dans le compte d'identifiant 'idCompte' **/
	public void verser (Double mont, Long idCompte, Long idEmploye);
	
	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	public void doRetrait (Double mont, Long idCompte, Long idEmploye);

	/** doVirement effectue un virement vers le compte d'identifiant 'idCompteCredite', par le compte d'identifiant 'idCompteDebite' d'un valeur de 'somme' **/
	public void doVirement (Long idCompteCredite,Long idCompteDebite, double somme, Long idEmploye);
	
}
