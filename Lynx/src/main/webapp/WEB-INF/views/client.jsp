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
		<form method="post" action="/ajouterClient">
			<p>
				<label for="client">Ajouter un client</label> : <input type="text"
					name="nomclient" id="client" /> <input type="submit"
					value="Envoyer">
			
			</p>
		</form>

	</div>

	<div>
		<form method="post" action="/ajouterCompte">
			<p>
				<label for="compte">Ajouter un compte</label> : <input type="text"
					name="numerocompte" id="compte" /> <input type="submit"
					value="Envoyer">
			
			</p>
		</form>

	</div>

	<div>

		<form method="post" action="/ajouterOperation">
			<p>
				<label for="operation">Ajouter une operation</label> : <input
					type="text" name="queloperation" id="operation" /> <input
					type="submit" value="Envoyer">
				
			</p>
		</form>

	</div>
	
	
	<div>
	<table class="table table-bordered">
   <caption>Consulter les comptes</caption>

   <tr>
       <td>Nom Client</td>
       <td>Numero de compte</td>
       <td>Solde compte</td>
       <td>Date de creation</td>
   </tr>
   <tr>
       <td>Carmen</td>
       <td>1</td>
       <td>2000</td>
       <td>20/10/2015</td>
   </tr>
   <tr>
       <td>Michelle</td>
       <td>2</td>
       <td>150</td>
        <td>16/02/2010</td>
   </tr>
</table>
	
	</div>

	<a type="button" href="accueil" class="btn btn-primary btn-xs">Retour
		au menu</a>
</body>
</html>