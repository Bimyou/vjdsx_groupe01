package intiformation.javajee.lynx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur(s):Vinh
 *Nom projet:Lynx
 *Date:26/04/2016
 *Package:intiformation.javajee.lynx.entites
 *Classe:Client
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): List<Compte>
 * */

@Entity
public class Client {

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	private String prenomClient;
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceClient;
	private String adresseClient;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="client")
	private List<Compte> listeComptes = new ArrayList<Compte>();

	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public Date getDateNaissanceClient() {
		return dateNaissanceClient;
	}

	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
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
	public Client() {
	}
	public Client(String nomClient, String prenomClient,
			Date dateNaissanceClient, String adresseClient) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.adresseClient = adresseClient;
	}
	
}
