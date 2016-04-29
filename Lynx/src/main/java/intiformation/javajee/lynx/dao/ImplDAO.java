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
 * nomProjet : Lynx
 * ImplDAO
 * date 26/04/2016
 * Package : intiformation.javajee.lynx.dao
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: avec ImplMetier
 * 
 */

public class ImplDAO implements InterfDAO {


	@PersistenceContext
    private EntityManager em;
	
	/** addClient ajoute un client a la base de donnee**/
	@Override
	public void addClient(Client client) {
		em.persist(client);
	}

	/**getClient renvoie un client grace a son id**/
	@Override
	public Client getClient(Long idClient) {
		Client c = em.find(Client.class, idClient);
		return c;
	}

	/** addEmploye ajoute un employe a la base de donnee **/
	@Override
	public void addEmploye(Employe employe) {
		em.persist(employe);
	}

	/** getEmploye revoie un employe grace a son id**/
	@Override
	public Employe getEmploye(Long idEmploye) {
		Employe e = em.find(Employe.class, idEmploye);
		return e;
	}

	/** addGroupe ajoute un groupe a la base de donnee**/
	@Override
	public void addGroupe(Groupe groupe) {
		em.persist(groupe);
	}
	
	/**getGroupe renvoie le groupe grace a son id**/
	@Override
	public Groupe getGroupe(Long idGroupe) {
		Groupe g = em.find(Groupe.class, idGroupe);
		return g;
	}

	/**addEmplToGroup ajoute un employe dans un groupe avec leurs id respectives**/
	@Override
	public void addEmplToGroup(Long idEmploye, Long codeGroupe) {
		Employe e = em.find(Employe.class, idEmploye);
		Groupe g = em.find(Groupe.class, codeGroupe);
		g.getListeEmployes().add(e);
		e.getListeGroupes().add(g);
	}


	/** addCompte ajoute un compte a la base de donnee**/
	@Override
	public void addCompte(Compte c, Long idClient, Long idEmploye) {
		Client cl = em.find(Client.class, idClient);
		Employe e = em.find(Employe.class, idEmploye);
		cl.getListeComptes().add(c);
		e.getListeComptes().add(c);
		c.setEmploye(e);
		c.setClient(cl);
		em.persist(c);
	}

	/** addOperation ajoute une operation a la base de donnee **/
	@Override
	public void addOperation(Operation o, Long idEmploye) {
		Employe e = em.find(Employe.class, idEmploye);
		e.getListeOperations().add(o);
		o.setEmploye(e);
		em.persist(o);
	}

	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	@Override
	public Compte getCompte(Long idCompte) {
		Compte c= em.find(Compte.class, idCompte);
		return c;
	}
	
	@Override
	public Operation getOperation(Long idOperation) {
		Operation o = em.find(Operation.class, idOperation);
		return o;
	}
	/**selectCompteWithClient renvoie la list de compte que possede un client, elle a besoin de l idClien**/
	@Override
	public List<Compte> selectCompteWithClient(Long idClient) {	
		Query query = em.createQuery("from Compte c where c.client.codeClient=:x");
		query.setParameter("x",idClient);
		return query.getResultList();
	}

	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	@Override
	public List<Compte> selectCompteWithEmploy(Long IdEmploye) {
		Query query = em.createQuery("from Compte c where c.employe.codeEmploye=:x");
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

	/** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **/
	@Override
	public List<Employe> selectEmployOfGroup(Long idGroupe) {
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
	
	
	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	@Override
	public void updateCompte(Compte compteModifie) {
		em.merge(compteModifie);
	}

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	@Override
	public List<Client> selectAllClient() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select c from Client c ");
		return query.getResultList();
	}

	/** selectAllCompte selectionne une liste de tous les Comptes **/
	@Override
	public List<Compte> selectAllCompte() {
		Query query = em.createQuery("SELECT c FROM Compte c");
		return query.getResultList();
	}

	/** selectAllOperation selectionne une liste de tous les Operations **/
	@Override
	public List<Operation> selectAllOperation() {
		Query query = em.createQuery("SELECT o FROM Operation o");
		return query.getResultList();
	}
}