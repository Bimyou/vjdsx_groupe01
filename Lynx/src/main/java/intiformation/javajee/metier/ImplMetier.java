/**
 * 
 */
package intiformation.javajee.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

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

	private final Logger LOG=Logger.getLogger("ImplMetier");
	private InterfDAO dao;
	private EntityManager em;
	
	/** Le Setter de dao qui assure l'injection et le lien du bean **/
	public void setDao(InterfDAO dao) {
		this.dao = dao;
		LOG.info("dao injected");
	}

	
	/** addClient ajoute un client a la base de donnee**/
	@Override
	public void addClient(Client client) {
		dao.addClient(client);
	}
	
	/**getClient renvoie un client grace a son identifiant**/
	@Override
	public Client getClient(Long idClient) {
		return dao.getClient(idClient);
	}

	/** addEmploye ajoute un employe a la base de donnee**/
	@Override
	public void addEmploye(Employe employe) {
		dao.addEmploye(employe);
	}

	/**getemploye renvoie un employe grace a son identifiant**/
	@Override
	public Employe getEmploye(Long idEmploye) {
		return dao.getEmploye(idEmploye);
	}
	
	/** addGroupe ajoute un groupe a la base de donnee**/
	@Override
	public void addGroupe(Groupe groupe) {
		dao.addGroupe(groupe);
	}
	
	/**getemploye renvoie un employe grace a son identifiant**/
	@Override
	public Groupe getGroupe(Long idGroupe) {
		return dao.getGroupe(idGroupe);
	}

	/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**/
	@Override
	public void addEmplToGroup(Long idEmploye, Long codeGroupe) {
		dao.addEmplToGroup(idEmploye, codeGroupe);	
	}

	/** addCompte ajoute un compte a la base de donnee**/
	@Override
	public void addCompte(Compte c, Long idClient, Long idEmploye) {
		dao.addCompte(c, idClient, idEmploye);
	}
	
	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	@Override
	public Compte getCompte(Long idCompte) {	
		return dao.getCompte(idCompte);
	}

	/** addOperation ajoute un operation a la base de donnee**/
	@Override
	public void addOperation(Operation o, Long idEmploye) {
		dao.addOperation(o, idEmploye);
	}

	/**getOperation renvoie un Operation grace a son identifiant**/
	@Override
	public Operation getOperation(Long idOperation) {
		return dao.getOperation(idOperation);
	}
	
	/** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**/
	@Override
	public List<Compte> selectCompteWithClient(Long idClient) {
		return dao.selectCompteWithClient(idClient);
	}

	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	@Override
	public List<Compte> selectCompteWithEmploy(Long IdEmploye) {
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
	public List<Employe> selectEmployOfGroup(Long idGroupe) {
		return dao.selectEmployOfGroup(idGroupe);
	}
	
	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	@Override
	public List<Client> searchClient(String mc) {
		return dao.searchClient(mc);
	}

	/**
	 * doVersement effectue un versement v dans le compte d'identifiant
	 * 'idCompte'
	 **/
	@Override
	public void doVersement(Double mont, Long idCompte) {
		Compte c= em.find(Compte.class, idCompte);
		Versement v = new Versement(new Date(), mont);
		c.setSoldeCompte(c.getSoldeCompte() + mont);
		v.setCompte(c);
		em.merge(c);
		em.persist(v);
	}

	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	@Override
	public void doRetrait(Double mont, Long idCompte) {
		Compte c= em.find(Compte.class, idCompte);
		Versement v = new Versement(new Date(), mont);
		c.setSoldeCompte(c.getSoldeCompte() - mont);
		v.setCompte(c);
		em.merge(c);
		em.persist(v);
	}

	@Override
	public void doVirement(Long idCompteCredite, Long idCompteDebite,		//Cree un versement sur le compte credite et un retrait de la meme somme sur le compte debite
			double montant) {
		Date d = new Date();
		doVersement(montant, idCompteCredite);
		doRetrait(montant,idCompteDebite);
	}

	
			
}
