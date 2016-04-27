package intiformation.javajee.lynx.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur : Jean Daniel Eymann
 * NomProjet: Lynx
 * Date : 26/04/2016
 * Package : intiformation.javajee.lynx.entity
 * Class : Operation
 * Version : 1
 * Ref-UML : 
 * Sprint : 
 * ref-UserStory :
 * association : Employe(Many to One)
 */



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type", discriminatorType=DiscriminatorType.STRING)		//Creation d'une colone supplementaire pour preciser le type d'operation
public abstract class Operation {							//Class abstraite Operation qui donnera ses valeur a retrait et versement

	/**Attribut**/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long numOperation;
	@Temporal(TemporalType.TIME)
	protected Date dateOperation;
	protected Double montantOperation;
	
	/**Association**/
	@ManyToOne
	@JoinColumn (name="id_Employe")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn (name="id_Compte")
	private Compte compte;
	
	
	/**Constructor**/
	public Operation() {
	}
	
	public Operation(Date dateOperation, Double montantOperation) {
		super();
		this.dateOperation = dateOperation;
		this.montantOperation = montantOperation;
	}
	
	/**Getter et Setter**/
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public Double getMontantOperation() {
		return montantOperation;
	}
	public void setMontantOperation(Double montantOperation) {
		this.montantOperation = montantOperation;
	}
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
