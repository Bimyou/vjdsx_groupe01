package intiformation.javajee.lynx.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur :
 * NomProjet: Lynx
 * Date : 26/04/2016
 * Package : intiformation.javajee.lynx.entity
 * Class : Versement
 * Version : 1
 * Ref-UML : 
 * Sprint : 
 * ref-UserStory :
 * association :
 */


@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation{

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, Double montantOperation) {
		super(dateOperation, montantOperation);
		// TODO Auto-generated constructor stub
	}

	
	
}
