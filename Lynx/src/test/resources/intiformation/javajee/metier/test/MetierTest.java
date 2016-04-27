package intiformation.javajee.metier.test;

import static org.junit.Assert.*;
import intiformation.javajee.lynx.dao.InterfDAO;
import intiformation.javajee.lynx.entity.Client;
import intiformation.javajee.lynx.entity.Compte;
import intiformation.javajee.lynx.entity.Employe;
import intiformation.javajee.lynx.entity.Groupe;
import intiformation.javajee.lynx.entity.Operation;
import intiformation.javajee.lynx.entity.Retrait;
import intiformation.javajee.lynx.entity.Versement;
import intiformation.javajee.metier.InterfMetier;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*  @author Xavier Charef , Jean Daniel Eymann
* 
 * nomProjet : Lynx
* Implementation  MetierTest
* date: 27/04/2016
* Package : intiformation.javajee.metier.test
* ref-Uml:1
* version 1
* Sprint : 1
* association: Interf
*/
public class MetierTest {

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
		public void testAddGroupe() {
			Groupe g = new Groupe("TestNomGroupe");
			metier.addGroupe(g);
			assertNotNull(g.getCodeGroupe());
		}

		/** addEmplToGroup ajoute un client a la liste d'emplouye d'un groupe d'employe**//*
		@Override
		public void addEmplToGroup(long idEmploye, long codeGroupe) {
			dao.addEmplToGroup(idEmploye, codeGroupe);
			
		}

		*//** addCompte ajoute un compte a la base de donnee**//*
		@Override
		public void addCompte(Compte c) {
			dao.addCompte(c);
			
		}

		*//** addOperation ajoute un operation a la base de donnee**//*
		@Override
		public void addOperation(Operation o) {
			dao.addOperation(o);
			
		}
		
		*//** getCompte ressort un compte de la base de donnee en fct de son id**//*
		@Override
		public Compte getCompte(long idCompte) {	
			return dao.getCompte(idCompte);
		}

		*//** selectCompteWithClient selectionne une liste de compte de la base de donnee en fct de l'id du client**//*
		@Override
		public List<Compte> selectCompteWithClient(long idClient) {
			return dao.selectCompteWithClient(idClient);
		}

		*//** selectCompteWithEmploy selectionne une liste de compte de la base de donnee en fct de l'id de l'employe qui l'a cree**//*
		@Override
		public List<Compte> selectCompteWithEmploy(long IdEmploye) {
			return dao.selectCompteWithEmploy(IdEmploye);
		}

		*//** selectAllEmploye selectionne une liste de tout les employes de la base de donnee **//*
		@Override
		public List<Employe> selectAllEmploye() {
			return dao.selectAllEmploye();
		}

		*//** selectAllGroupe selectionne une liste de tout les groupes de la base de donnee **//*
		@Override
		public List<Groupe> selectAllGroupe() {
			return dao.selectAllGroupe();
		}
		*//** selectEmployOfGroup selectionne une liste de tout les employes d'un groupe de la base de donnee **//*
		@Override
		public List<Employe> selectEmployOfGroup(long idGroupe) {
			return dao.selectEmployOfGroup(idGroupe);
		}
		*//** searchClient selectionne une liste de tout les client contenant le mot cles 'mc' **//*
		@Override
		public List<Client> searchClient(String mc) {
			return dao.searchClient(mc);
		}

		*//**
		 * doVersement effectue un versement v dans le compte d'identifiant
		 * 'idCompte'
		 **//*
		@Override
		public void doVersement(Versement v, long idCompte) {
			Compte cm = em.find(Compte.class, idCompte);
			cm.setSoldeCompte(cm.getSoldeCompte() + v.getMontantOperation());
			v.setCompte(cm);
			em.merge(cm);
			em.merge(v);
		}

		*//** doRetrait effectue un Retrait r dans le compte d'identifiant 'idCompte' **//*
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
			Date d = new Date();
			Retrait r = new Retrait(d, somme);
			Versement v = new Versement (d, somme);
			doVersement(v, idCompteCredite);
			doRetrait(r,idCompteDebite);
		}*/		
	}
