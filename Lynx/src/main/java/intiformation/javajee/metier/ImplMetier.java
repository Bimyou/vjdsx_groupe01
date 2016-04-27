/**
 * 
 */
package intiformation.javajee.metier;

import java.util.List;

import intiformation.javajee.lynx.dao.InterfDAO;
import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;

/**
 *  @author Xavier Charef
 * 
  * nomProjet : Lynx
 * Implementation  Metier
 * date: 27/04/2016
 * Package : intiformation.javajee.lynx.metier
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: InterfDAO dao
 */
public class ImplMetier implements InterfMetier {

	private InterfDAO dao;
	/** addClient ajoute un client a la base de donnee**/
	@Override
	public void addClient(Client client) {
		dao.addClient(client);
	}

	/** addEmploye ajoute un employe a la base de donnee**/
	@Override
	public void addEmploye(Employe employe) {
		dao.addEmploye(employe);
		
	}

	/** addGroupe ajoute un groupe a la base de donnee**/
	@Override
	public void addGroupe(Groupe groupe) {
		dao.addGroupe(groupe);
		
	}

	/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**/
	@Override
	public void addEmplToGroup(long idEmploye, long codeGroupe) {
		dao.addEmplToGroup(idEmploye, codeGroupe);
		
	}

	/** addCompte ajoute un compte a la base de donnee**/
	@Override
	public void addCompte(Compte c) {
		dao.addCompte(c);
		
	}

	/** addOperation ajoute un operation a la base de donnee**/
	@Override
	public void addOperation(Operation o) {
		dao.addOperation(o);
		
	}
	
	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	@Override
	public Compte getCompte(long idCompte) {	
		return dao.getCompte(idCompte);
	}

	/** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**/
	@Override
	public List<Compte> selectCompteWithClient(long idClient) {
		return dao.selectCompteWithClient(idClient);
	}

	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	@Override
	public List<Compte> selectCompteWithEmploy(long IdEmploye) {
		return dao.selectCompteWithEmploy(IdEmploye);
	}

	/** selectAllEmploye selectionne une liste de tout les employes de la base de donnee **/
	@Override
	public List<Employe> selectAllEmploye() {
		return dao.selectAllEmploye();
	}

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	@Override
	public List<Groupe> selectAllGroupe() {
		return dao.selectAllGroupe();
	}
	/** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **/
	@Override
	public List<Employe> selectEmployOfGroup(long idGroupe) {
		return dao.selectEmployOfGroup(idGroupe);
	}
	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	@Override
	public List<Client> searchClient(String mc) {
		return dao.searchClient(mc);
	}
	/** doVersement effectue un versement v dans le compte d'identifiant 'idCompte' **/
	@Override
	public void doVersement(Versement v, long idCompte) {
		dao.doVersement(v, idCompte);
	}
	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	@Override
	public void doRetrait(Retrait r, long idCompte) {
		dao.doRetrait(r, idCompte);
	}

	/** doVirement effectue un virement vers le compte d'identifiant 'idCompteCredite', par le compte d'identifiant 'idCompteDebite' d'un valeur de 'somme' **/
	@Override
	public void doVirement(long idCompteCredite, long idCompteDebite,
			double somme) {
		dao.doVirement(idCompteCredite, idCompteDebite, somme);
		
	}

	
}
