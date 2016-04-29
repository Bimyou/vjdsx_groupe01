<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">

<title>Client</title>
</head>
<body>
	<div style="background-color: rgb(24, 126, 188);">
		<h1 style="text-align: center;">
			LYNX<br /> <small>Compte Bancaire</small>
		</h1>
	</div>


	<div>
		<form method="post" action="ajouterClient">
			<p>
				<label for="client">Ajouter un client</label> : 
				<input type="text" name="prenomClient" id="client" placeholder="Prenom"/> 
				<input type="text" name="nomClient" id="client" placeholder="Nom"/> 
				<input type="text" name="dateNaissance" placeholder="jj/mm/aaaa" id="client" /> 
				<input type="text" name="adressClient" placeholder="Adresse" id="client" /> 
				
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>

	
	<div>
		<form method="post" action="rechercherClient">
			<p>
				<label for="client">Rechercher un client</label> : 
				<input type="text" name="motCle" id="client" placeholder="Mot Cle"/> 				
				<input type="submit"  class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>


	<table class="table table-striped">
	  <thead>
	  	<th>La liste des Clients est:</th>
	    <tr>
	      <th class="success">Identifiant du Client</th>
	      <th class="success">Nom du Client</th>
	      <th class="success">Prenom du Client</th>
	      <th class="success">Date de Naissance</th>
	       <th class="success">Adresse du Client</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${allCli}" var="cl"> <!-- pour chaque cl dans c -->
	    <tr>
	      <td>${cl.codeClient}</td>
	      <td>${cl.nomClient}</td>
	      <td>${cl.prenomClient}</td>
	       <td>${cl.dateNaissanceClient}</td>
	      <td>${cl.adresseClient}</td>
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	
	
	
	<!-- Essayer de demander a l utilisateur le type de compte pour lui envoyer le bon formulaire (si y a le temps)
	<div>
		<form method="post" action="/typeCompte">
			<p>
				<label for="compte">Ajouter un compte</label> : 
				<input type="text"	name="typeCompte" placeholder="Courant ou Epargne" id="compte" /> 						
				<input type="submit" value="Envoyer">
			</p>
		</form>
	</div> -->
	
	
	<div>
		<form method="post" action="ajouterCompteCourant">
			<p>
				<label for="compte">Ajouter un compte courant</label> : 
				<!-- <input type="text"	name="typeCompte" placeholder="Courant ou Epargne" id="compte" />  pas besoin car compte defini-->
				<input type="text" name="soldeCompte" placeholder="Solde" id="compte" />		<!-- Type number pour recuperer un double -->
				<input type="text" name="decouvert" placeholder="decouvert" id="compte" />
				<input type="number" name="idClient" placeholder="idClient" id="compte" />
				<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" />
						
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>


	<div>
		<form method="post" action="ajouterCompteEpargne">
			<p>
				<label for="compte">Ajouter un compte epargne</label> : 
				<!-- <input type="text"	name="typeCompte" placeholder="Courant ou Epargne" id="compte" />  pas besoin car compte defini-->
				<input type="text" name="soldeCompte" placeholder="Solde" id="compte" />		<!-- Type number pour recuperer un double -->
				<input type="text" name="interet" placeholder="Interet" id="compte" />
				<input type="number" name="idClient" placeholder="idClient" id="compte" />
				<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" />
						
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>


	<div>
		<form method="post" action="chercherCompteParClient">
			<p>
				<label for="compte">Chercher les comptes d'un client</label> : 
				<input type="number" name="idClient" placeholder="idClient" id="compte" />		
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>


	<div>
		<form method="post" action="chercherCompteParEmploye">
			<p>
				<label for="compte">Chercher les comptes cree par un employe</label> : 
				<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" />		
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>

	<div>
		<table class="table table-bordered">
   			<caption>Consulter les comptes</caption>
  			<tr>
       			<td class="success">Numero de compte</td>
       			<td class="success">Type de compte</td>
       			<td class="success">Solde compte</td>
       			<td class="success">Date de creation</td>
       			<td class="success">Nom du client</td>
       			<td class="success">Cree par</td>
       			<!-- Rajoute interet et decouvert? -->
  			</tr>
  			
  			
  			<c:forEach items="${allCmpt}" var="cmpt"> 
  				<tr>
  					<td> ${cmpt.numeroCompte}</td>
  					<td> ${cmpt.typeCompte}	</td>
  					<td> ${cmpt.soldeCompte}</td>
  					<td> ${cmpt.dateCreationCompte}</td>
  					<td> ${cmpt.client.nomClient}</td>
  					<td> ${cmpt.employe.nomEmploye}</td>
  				</tr>
  			</c:forEach>
		</table>
	</div>

<!-- Essayer de demander a l utilisateur le type de l operation (retrait versement)pour lui envoyer le bon formulaire (si y a le temps)
	<div>
		<form method="post" action="/ajouterOperation">
			<p>
				<label for="operation">Ajouter une operation</label> : <input
					type="text" name="queloperation" id="operation" /> <input
					type="submit" value="Envoyer">			
			</p>
		</form>
	</div> -->
	
	
	<div>
		<form method="post" action="effectuerVersement">
			<p>
				<label for="compte">Effectuer un versement</label> : 
				<input type="text" name="montant" placeholder="Montant" id="operation" />
				<input type="number" name="numeroCompte" placeholder="Numero de Compte" id="operation" />
				<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" />
						
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>
	
	
	<div>
		<form method="post" action="effectueRetrait">
			<p>
				<label for="compte">Effectuer un retrait</label> : 
				<input type="text" name="montant" placeholder="Montant" id="operation" />
				<input type="number" name="numeroCompte" placeholder="Numero de Compte" id="operation" />
				<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" />
						
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>
	
	<div>
		<form method="post" action="effectuerVirementBancaire">
		<p>
			<label>Effectuer un virement</label> :
			<input  type="text" name="montant" placeholder="Montant" id="operation"/>
			<input type="number"  name="numeroCompteCredite" placeholder="Numero de Compte Credite" id="operation"/>
			<input type="number"  name="numeroCompteDebite" placeholder="Numero de Compte Debite" id="operation"/>
			<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" />
			<input type="submit" value="Envoyer"/>
		</p>
		</form>
	</div>
<div >
	<img class="imagecentrer" src="<%=request.getContextPath()%>/resources/lynx_logo.png" alt="Lynx" width="100" height="100">
</div>
	
	<a type="button" href="accueil" class="btn btn-primary btn-xs">Retour
		au menu</a>
</body>
</html>