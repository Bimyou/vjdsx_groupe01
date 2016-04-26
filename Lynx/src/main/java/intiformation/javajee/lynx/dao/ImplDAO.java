/**
 * 
 */
package intiformation.javajee.lynx.dao;

import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Xavier Charef, Shéhérazade Taouza, Jean Daniel Eymann
 * 
 *         nomProjet : Lynx Interface DAO date 26/04/2016 Package :
 *         intiformation.javajee.lynx.dao ref-Uml:1 version 1 Sprint : 1
 *         association: avec ImplMetier
 */

public class ImplDAO implements InterfDAO {


	@PersistenceContext
    private EntityManager em;
	
	/** addClient ajoute un client a la base de donnee**/
	@Override
	public void addClient(Client client) {
		em.persist(client);

	}

	/** addEmploye ajoute un employe a la base de donnee **/
	@Override
	public void addEmploye(Employe employe) {
		em.persist(employe);

	}

	/** addGroupe ajoute un groupe a la base de donnee**/
	@Override
	public void addGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		em.persist(groupe);

	}

	@Override
	public void addEmplToGroup(long idEmploye, long codeGroupe) {		//Ajouter un employe dans un groupe avec leurs id respective
		Employe e = em.find(Employe.class, idEmploye);
		Groupe g = em.find(Groupe.class, codeGroupe);
		g.getListeEmployes().add(e);

		em.merge(g);
	}


	/** addCompte ajoute un compte a la base de donnee**/
	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub

	
		em.persist(c);
	}

	/** addOperation ajoute une operation a la base de donnee **/
	@Override
	public void addOperation(Operation o) {
		em.persist(o);

	}

	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	@Override
	public Compte getCompte(long idCompte) {
		// TODO Auto-generated method stub
		Compte c= em.find(Compte.class, idCompte);
		return c;
	}

	@Override
	public List<Compte> selectCompteWithClient(long idClient) {		//Obtenir une liste de compte d un client
		Client c = em.find(Client.class, idClient);
		return c.getListeComptes();
	}

	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	@Override
	public List<Compte> selectCompteWithEmploy(long IdEmploye) {
		Query query = em.createQuery("from Compte c where c.employe=:x");
		query.setParameter("x",IdEmploye);
		return query.getResultList();
	}

	/**
	 * selectAllEmploye selectionne une liste de tout les employes de la base de
	 * donnee
	 **/
	@Override
	public List<Employe> selectAllEmploye() {

		Query query = em.createQuery("from Employe");
		return query.getResultList();

	}

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	@Override
	public List<Groupe> selectAllGroupe() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select g from Groupe g ");
		return query.getResultList();
	}

	@Override
	public List<Employe> selectEmployOfGroup(long idGroupe) {
		Groupe g = em.find(Groupe.class, idGroupe);
		return g.getListeEmployes();
	}

	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	@Override
	public List<Client> searchClient(String mc) {
		Query query = em.createQuery("from Client c where c.nomClient like :x or c.prenomClient like :y");
		query.setParameter("x", "%"+mc+"%");
		query.setParameter("y", "%"+mc+"%");
		return query.getResultList();
	}

	/**
	 * doVersement effectue un versement v dans le compte d'identifiant
	 * 'idCompte'
	 **/
	@Override
	public void doVersement(Versement v, long idCompte) {
		Compte cm = em.find(Compte.class, idCompte);
		cm.setSoldeCompte(cm.getSoldeCompte() + v.getMontantOperation());
		em.merge(cm);

	}

	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	@Override
	public void doRetrait(Retrait r, long idCompte) {
		Compte c= em.find(Compte.class, idCompte);
		c.setSoldeCompte(c.getSoldeCompte()-r.getMontantOperation());
		r.setCompte(c);
		em.merge(c);
		em.merge(r);
	}

	@Override
	public void doVirement(long idCompteCredite, long idCompteDebite,		//Cree un versement sur le compte credite et un retrait de la meme somme sur le compte debite
			double somme) {
		Retrait r = new Retrait(new Date(), somme);
		Versement v = new Versement (new Date(), somme);
		doVersement(v, idCompteCredite);
		doRetrait(r,idCompteDebite);
		// TODO Auto-generated method stub

	}

}
