package intiformation.javajee.lynx.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*Auteur(s):Vinh
 *Nom projet:Lynx
 *Date:26/04/2016
 *Package:intiformation.javajee.lynx.entites
 *Classe:Groupe
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): List<Employe>
 * */

@Entity
public class Groupe {

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeGroupe;
	private String nomGroupe;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="listeGroupes")
	private List<Employe> listeEmployes = new ArrayList<Employe>();

	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Employe> getListeEmployes() {
		return listeEmployes;
	}

	public void setListeEmployes(List<Employe> listeEmployes) {
		this.listeEmployes = listeEmployes;
	}

	
	///////////////////////
	/////constructeurs/////
	///////////////////////
	public Groupe() {
	}
	public Groupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

}
