package intiformation.javajee.lynx.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/*Auteur(s):Vinh
 *Nom projet:Lynx
 *Date:26/04/2016
 *Package:intiformation.javajee.lynx.entites
 *Classe:Employe
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): List<Groupe>, List<Operation>
 * */

@Entity
public class Employe {

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="employe_groupe")
	private List<Groupe> listeGroupes;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="employe")
	private List<Operation> listeOperations = new ArrayList<Operation>();
	@OneToMany(fetch=FetchType.LAZY, mappedBy="employe")
	private List<Compte> listeComptes = new ArrayList<Compte>();
	
	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	
	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}
	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}
	public List<Operation> getListeOperations() {
		return listeOperations;
	}
	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}
	public List<Compte> getListeComptes() {
		return listeComptes;
	}
	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	///////////////////////
	/////constructeurs/////
	///////////////////////
	public Employe() {
	}
	public Employe(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	
}
