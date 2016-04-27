package intiformation.javajee.lynx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur:Sheherazade TAOUZA
 * nom Projet:Lynx
 *date:2/04/2016
 *Package:intiformation.javajee.lynx.entity
 *Class:CompteCourant
 *version:1.
 *ref-UML:1
 *sprint:1
 *ref-userStories:15f21.

 * */
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable {
	/* attributs */

	private double decouvert;

	/* getEtSet */
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
	}

	public CompteCourant(double soldeCompte, Date dateCreationCompte) {
		super(soldeCompte, dateCreationCompte);
	}

	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}


	

	

}
