/**
 * 
 */
package intiformation.javajee.lynx.dao;

import java.util.List;

import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;

/**
 * @author Xavier Charef
 * nomProjet : Lynx
 * Interface  DAO
 * date 26/04/2016
 * Package : intiformation.javajee.lynx.dao
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: avec ImplMetier
 * 
 */
public interface InterfDAO {

	/** addClient ajoute un client a la base de donnee**/
	public void addClient(Client client);

	/** addEmploye ajoute un employe a la base de donnee**/
	public void addEmploye(Employe employe);

	/** addGroupe ajoute un groupe a la base de donnee**/
	public void addGroupe(Groupe groupe);

	/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**/
	public void addEmplToGroup (long idEmploye,long codeGroupe);
	
	/** addCompte ajoute un compte a la base de donnee**/
	public void addCompte (Compte c);
	
	/** addOperation ajoute un operation a la base de donnee**/
	public void addOperation (Operation o);
	
	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	public Compte getCompte (long idCompte);
	
	/** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**/
	public List<Compte> selectCompteWithClient (long idClient);
	
	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	public List<Compte> selectCompteWithEmploy (long IdEmploye);

	/** selectAllEmploye selectionne une liste de tout les employes de la base de donnee **/
	public List<Employe> selectAllEmploye ();

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	public List<Groupe> selectAllGroupe ();

	/** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **/
	public List<Employe> selectEmployOfGroup (long idGroupe);

	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	public List<Client> searchClient (String mc);

	/** doVersement effectue un versement v dans le compte d'identifiant 'idCompte' **/
	public void doVersement (Versement v, long idCompte);

	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	public void doRetrait (Retrait r, long idCompte);

	/** doVirement effectue un virement vers le compte d'identifiant 'idCompteCredite', par le compte d'identifiant 'idCompteDebite' d'un valeur de 'somme' **/
	public void doVirement (long idCompteCredite,long idCompteDebite, double somme);
	
}
