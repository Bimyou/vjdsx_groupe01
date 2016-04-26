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

import java.util.List;

/**
 *@author Xavier Charef
 * 
 * nomProjet : Lynx
 * Interface  DAO
 * date 26/04/2016
 * Package : intiformation.javajee.lynx.dao
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: avec ImplMetier
 */
public class ImplDAO implements InterfDAO {

	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmploye(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmplToGroup(long idEmploye, long codeGroupe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOperation(Operation o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte getCompte(long idCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> selectCompteWithClient(long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> selectCompteWithEmploy(long IdEmploye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> selectAllEmploye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groupe> selectAllGroupe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> selectEmployOfGroup(long idGroupe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchClient(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doVersement(Versement v, long idCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doRetrait(Retrait r, long idCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doVirement(long idCompteCredite, long idCompteDebite,
			double somme) {
		// TODO Auto-generated method stub
		
	}

}
