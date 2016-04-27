package intiformation.javajee.metier.test;

import static org.junit.Assert.*;
import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.CompteCourant;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.metier.InterfMetier;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetier {

	private static ClassPathXmlApplicationContext context;
	private static InterfMetier metier;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(InterfMetier) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	
	/** addClient ajoute un client a la base de donnee**/
	@Test
	public void testAddClient() {
		Client c = new Client("TestNom", "TestPrenom", new Date(), "TestAdresse");
		metier.addClient(c);
		assertNotNull(c.getCodeClient());
	}

	/** addEmploye ajoute un employe a la base de donnee**/
	@Test
	public void testAddEmploye() {
		Employe e = new Employe("TestNom");
		metier.addEmploye(e);
		assertNotNull(e.getCodeEmploye());
	}

	/** addGroupe ajoute un groupe a la base de donnee**/
	@Test
	public void testAddGroupe() {
		Groupe g = new Groupe("TestNomGroupe");
		metier.addGroupe(g);
		assertNotNull(g.getCodeGroupe());
	}

	/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**/
	@Test
	public void TestAddEmplToGroup() {
		metier.addEmplToGroup(1L, 1L);
		assertTrue(metier.getGroupe(1L).getListeEmployes().contains(metier.getClient(1L)));	
	}

	/** addCompte ajoute un compte a la base de donnee**/
	@Test
	public void TestAddCompte() {
		Compte c = new Compte(1000.00,new Date());
		metier.addCompte(c, 1L, 1L);
		assertNotNull(c.getNumeroCompte());
	}

	/** addOperation ajoute un operation a la base de donnee**/
	@Test
	public void testAddOperation() {
		Operation o = new Retrait(new Date(), 100.05);
		metier.addOperation(o, 1L);
		assertNotNull (o.getNumOperation());
	}
	
	/** getCompte ressort un compte de la base de donnee en fct de son id**/
	@Test
	public void testGetCompte() {	
		Compte c = metier.getCompte(1L);
		assertTrue(c.getNumeroCompte().equals(1L));
	}

/** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**/
	@Test
	public void testSelectCompteWithClient() {
		List<Compte> list = metier.selectCompteWithClient(1L);
		assertTrue(list.size() == metier.getClient(1L).getListeComptes().size());
	}

	/** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**/
	@Test
	public void testSelectCompteWithEmploy() {
		List<Compte> list = metier.selectCompteWithEmploy(1L);
		assertTrue(list.size() == metier.getEmploye(1L).getListeComptes().size());
	}

	/** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **/
	@Test
	public void testSelectAllGroupe() {
		List<Groupe> list= metier.selectAllGroupe();
		assertTrue(list.size()>0);
}
	
	/** selectAllEmploye selectionne une liste de tout les employes de la base de donnee **/
	@Test
	public void testSelectAllEmploye() {
		List<Employe> list= metier.selectAllEmploye();
		assertTrue(list.size()>0);
	}
	/** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **/
	@Test
	public void testSelectEmployOfGroup() {
		List<Employe> list = metier.selectEmployOfGroup(1L);
		assertTrue(list.size() == metier.getGroupe(1L).getListeEmployes().size());
	}
	
	/** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **/
	@Test
	public void testSearchClient() {
		List<Client> list = metier.searchClient("om");
		assertTrue (list.get(0).getNomClient().contains("om") || list.get(0).getPrenomClient().contains("om"));
	}

	/**
	 * doVersement effectue un versement v dans le compte d'identifiant
	 * 'idCompte'
	 **/
	@Test
	public void testDoVersement() {
		Compte cm = metier.getCompte(1L);
		Double soldeAnc = cm.getSoldeCompte();
		metier.doVersement(555.55, 1L);
		Double soldeNouv = cm.getSoldeCompte();
		assertTrue(soldeNouv - soldeAnc == 555.55);
	}

	/** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **/
	@Test
	public void testDoRetrait() {
		Compte cm = metier.getCompte(1L);
		Double soldeAnc = cm.getSoldeCompte();
		metier.doRetrait(555.55, 1L);
		Double soldeNouv = cm.getSoldeCompte();
		assertTrue(soldeAnc - soldeNouv == 555.55);
	}

	@Test
	public void TestDoVirement() {
		Compte cm1 =metier.getCompte(1L);
		double montAnc = cm1.getSoldeCompte();
		Compte cm2 = new CompteCourant(400.00,new Date());
		metier.doVirement(1L, cm2.getNumeroCompte(), 200.00);
		assertTrue(cm2.getSoldeCompte()==200.00 && cm1.getSoldeCompte()-montAnc==200.00);
	}
}
