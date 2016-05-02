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
		<form method="post" action="ajouterClient" class="form-inline">
			<p>
				<label for="client">Ajouter un client</label> : 
				<input type="text" name="prenomClient" id="client" placeholder="Prenom" class="form-control"/> 
				<input type="text" name="nomClient" id="client" placeholder="Nom" class="form-control"/> 
				<input type="text" name="dateNaissance" placeholder="jj/mm/aaaa" id="client" class="form-control"/> 
				<input type="text" name="adressClient" placeholder="Adresse" id="client" class="form-control"/> 
				
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>

	
	<div>
		<form method="post" action="rechercherClient" class="form-inline">
			<p>
				<label for="client">Rechercher un client</label> : 
				<input type="text" name="motCle" id="client" placeholder="Mot Cle" class="form-control"/> 				
				<input type="submit" class="btn btn-primary" value="Envoyer">
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
	
	
	<!-- Demander a l utilisateur le type de compte (Courant Epargne)qu il souhaite creer pour lui envoyer le bon formulaire-->	
	<div>
		<form name="order" action="typeCompte" method="post" class="form-inline">
			<label for="compte">Quelle type de compte souhaitez vous creer?</label>
			<select name="typeCompte">
				<option value="default" selected></option>
				<option value="Courant">Courant</option>
				<option value="Epargne">Epargne</option>
			</select>
			<input type="submit" class="btn btn-primary" value="Envoyer">
		</form>

		<c:if test="${typeCmpt=='Courant'}">
			<form method="post" action="ajouterCompteCourant" class="form-inline">
				<p>
					<label for="compte">Ajouter un compte courant</label>
					<input type="text" name="soldeCompte" placeholder="Solde" id="compte" class="form-control"/>
					<input type="text" name="decouvert" placeholder="decouvert" id="compte" class="form-control"/>
					<input type="number" name="idClient" placeholder="idClient" id="compte" class="form-control"/>
					<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" class="form-control"/>
						
					<input type="submit" class="btn btn-primary" value="Envoyer">
				</p>
			</form>
		</c:if>

		<c:if test="${typeCmpt=='Epargne'}">
			<form method="post" action="ajouterCompteEpargne" class="form-inline">
				<p>
					<label for="compte">Ajouter un compte epargne</label> : 
					<input type="text" name="soldeCompte" placeholder="Solde" id="compte" class="form-control"/>		
					<input type="text" name="interet" placeholder="Interet" id="compte" class="form-control"/>
					<input type="number" name="idClient" placeholder="idClient" id="compte" class="form-control"/>
					<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" class="form-control"/>
						
					<input type="submit" class="btn btn-primary" value="Envoyer">
				</p>
			</form>
		</c:if>
	</div>


	<div>
		<form method="post" action="chercherCompteParClient" class="form-inline">
			<p>
				<label for="compte">Chercher les comptes d'un client</label> : 
				<input type="number" name="idClient" placeholder="idClient" id="compte" class="form-control"/>		
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>


	<div>
		<form method="post" action="chercherCompteParEmploye" class="form-inline">
			<p>
				<label for="compte">Chercher les comptes cree par un employe</label> : 
				<input type="number" name="idEmploye" placeholder="idEmploye" id="compte" class="form-control"/>		
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div>

	<div>
		<table class="table table-bordered">
   			<caption>Consulter les comptes</caption>
  			<tr>
       			<th class="success">Numero de compte</th>
       			<th class="success">Type de compte</th>
       			<th class="success">Solde compte</th>
       			<th class="success">Date de creation</th>
       			<th class="success">Nom du client</th>
       			<th class="success">Cree par</th>
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

	
<!-- Demander a l utilisateur le type de l operation (retrait versement)pour lui envoyer le bon formulaire-->	
	<div>
	<form name="order" action="typeOperation" method="post" class="form-inline">
		<label for="operation">Quelle opération souhaitez vous faire</label>
		<select name="typeOperation">
			<option value="default" selected></option>
			<option value="versement">Versement</option>
			<option value="retrait">Retrait</option>
			<option value="virement">Virement</option>
		</select>
		<input type="submit" class="btn btn-primary" value="Envoyer">
	</form>

			<c:if test="${typeOpe=='retrait'}">
				<form method="post" action="effectueRetrait" class="form-inline">
					<p>
						<label for="compte">Effectuer un retrait</label> : 
						<input type="text" name="montant" placeholder="Montant" id="operation" class="form-control"/>
						<input type="number" name="numeroCompte" placeholder="Numero de Compte" id="operation" class="form-control"/>
						<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" class="form-control"/>
						
						<input type="submit" class="btn btn-primary" value="Envoyer">
					</p>
				</form>
			</c:if>
			<c:if test="${typeOpe=='versement'}">
				<form method="post" action="effectuerVersement" class="form-inline">
					<p>
						<label for="compte">Effectuer un versement</label> : 
						<input type="text" name="montant" placeholder="Montant" id="operation" class="form-control"/>
						<input type="number" name="numeroCompte" placeholder="Numero de Compte" id="operation" class="form-control"/>
						<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" class="form-control"/>
						
						<input type="submit" class="btn btn-primary" value="Envoyer">
					</p>
				</form>
				
			</c:if>
			<c:if test="${typeOpe=='virement'}">
				<form method="post" action="effectuerVirementBancaire" class="form-inline">
					<p>
						<label>Effectuer un virement</label> :
						<input  type="text" name="montant" placeholder="Montant" id="operation" class="form-control"/>
						<input type="number"  name="numeroCompteCredite" placeholder="Numero de Compte Credite" id="operation" class="form-control"/>
						<input type="number"  name="numeroCompteDebite" placeholder="Numero de Compte Debite" id="operation" class="form-control"/>
						<input type="number" name="idEmploye" placeholder="idEmploye" id="operation" class="form-control"/>
						<input type="submit" value="Envoyer"/>
					</p>
				</form>
			</c:if>
	</div>
		
	<p>${o.exception}</p>
	<div >
	<img class="imagecentrer" src="<%=request.getContextPath()%>/resources/lynx_logo.png" alt="Lynx" width="100" height="100">
	</div>
	
	<a type="button" href="accueil" class="btn btn-primary btn-xs">Retour
		au menu</a>
</body>
</html>