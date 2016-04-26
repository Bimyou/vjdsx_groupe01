package intiformation.javajee.lynx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



/*Auteur:Sheherazade TAOUZA
 * nom Projet:Lynx
 *date:2/04/2016
 *Package:intiformation.javajee.lynx.entity
 *Class:Compte.
 *version:1.
 *ref-UML:1
 *sprint:1
 *ref-userStories:15f21.
 *association:List<Client>
 * association:Employe
 * association:ListOperation
 * 
 * */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte", discriminatorType=DiscriminatorType.STRING)
public class Compte implements Serializable {

	/* attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long numeroCompte;
	protected double soldeCompte;
	protected Date dateCreationCompte;

	/* association */

	@ManyToOne
	/* employe */
	@JoinColumn(name = "id_Employe")
	private Employe employe;
	
	@OneToMany(mappedBy="compte")
	/* operation */

	private List<Operation> listeOperation = new ArrayList<Operation>();

	@ManyToOne
	/* client */
	@JoinColumn(name = "id_Client")
	private Client client;

	/* getEtSet */

	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

	/* constructor */
	public Compte() {
	}

	public Compte(double soldeCompte, Date dateCreationCompte) {
		this.soldeCompte = soldeCompte;
		this.dateCreationCompte = dateCreationCompte;
	}

}
