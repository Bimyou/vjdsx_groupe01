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
	
	/**getClient renvoie un client grace a son identifiant**/
	public Client getClient (Long idClient);

	/** addEmploye ajoute un employe a la base de donnee**/
	public void addEmploye(Employe employe);
	
	/**getmploye renvoie un employe grace a son identifiant**/
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

	/** updateCompte met à jour un compte dans la base de donnees **/
	public void updateCompte(Compte compteModifie);
	
	/** searchClient selectionne une liste de tous les clients **/
	public List<Client> selectAllClient ();
	
	/** selectAllCompte selectionne une liste de tous les Comptes **/
	public List<Compte> selectAllCompte ();
	
	/** selectAllOperation selectionne une liste de tous les Operations **/
	public List<Operation> selectAllOperation();
	
}
