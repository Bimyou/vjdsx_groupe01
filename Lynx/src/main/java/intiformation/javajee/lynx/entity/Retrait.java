package intiformation.javajee.lynx.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur :
 * NomProjet: Lynx
 * Date : 26/04/2016
 * Package : intiformation.javajee.lynx.entity
 * Class : Retrait
 * Version : 1
 * Ref-UML : 
 * Sprint : 
 * ref-UserStory :
 * association :
 */

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, Double montantOperation) {
		super(dateOperation, montantOperation);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
