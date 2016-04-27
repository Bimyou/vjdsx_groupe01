package intiformation.javajee.lynx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur:Sheherazade TAOUZA
 * nom Projet:Lynx
 *date:2/04/2016
 *Package:intiformation.javajee.lynx.entity
 *Class:CompteEpargne.
 *version:1.
 *ref-UML:1
 *sprint:1
 *ref-userStories:15f21.
 * */
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable {
	/* attribut */
	private double tauxInteret;

	/* get and set */

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(double soldeCompte, Date dateCreationCompte) {
		super(soldeCompte, dateCreationCompte);
	}
	
	
	

}
