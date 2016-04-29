<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Employé</title>
</head>
<body>
	<div style="background-color: rgb(24, 126, 188);">
		<h1 style="text-align: center;">
			LYNX<br /> <small>Compte Bancaire</small>
		</h1>
	</div>

	<form method="post" action="ajouterEmploye" class="form-inline">
		<div class="form-group">
			<label>Ajouter un employé:</label>
		</div>
		<div class="form-group">
			<label class="sr-only">Nom</label> <input type="text"
				class="form-control" placeholder="Nom" name="nomEmploye">
		</div>
		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form>


	<form method="post" action="ajouterGroupe" class="form-inline">
		<div class="form-group">
			<label for="groupe">Ajouter un groupe:</label>
		</div>
		<div class="form-group">
			<label class="sr-only" for="nomGroupe">Nom</label> <input type="text"
				class="form-control" id="nomGroupe" placeholder="Nom groupe"
				name="nomGroupe">
		</div>


		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form>

	<form method="post" action="ajouterE-G" class="form-inline">
		<div class="form-group">
			<label>Ajouter un employé à un groupe:</label> <label class="sr-only">Code
				Employe</label> 
			<select name="codeEmploye" class="form-control">
				<c:forEach items="${employe}" var="e">
					<option value="${e.codeEmploye}">${e.nomEmploye}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label class="sr-only">Code Groupe</label>
			<select name="codeGroupe" class="form-control">
				<c:forEach items="${groupe}" var="g">
					<option value="${g.codeGroupe}">${g.nomGroupe}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form>

	<br />

	<div>
		<h2>Liste des employés</h2>
		<table class="table table-bordered">
			<th class="success">Code employé</th>
			<th class="success">Nom employé</th>
			<c:forEach items="${employe}" var="e">
				<tr>
					<td>${e.codeEmploye}</td>
					<td>${e.nomEmploye}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<h2>Liste des groupes</h2>
		<table class="table table-bordered">
			<th class="success">Code Groupe</th>
			<th class="success">Nom groupe</th>
			<c:forEach items="${groupe}" var="g">

				<tr>
					<td>${g.codeGroupe}</td>
					<td>${g.nomGroupe}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	

	<h2>Liste des employés appartenant à un groupe</h2>
		<div>
		<form method="post" action="consulterListeE-G" class="form-inline">
			<div class="form-group">
				<label>Chercher les employés appartenant à un groupe:</label> <label
					class="sr-only">Code Groupe</label> 
				<select name="codeGroupe" class="form-control">
					<c:forEach items="${groupe}" var="g">
						<option value="${g.codeGroupe}">${g.nomGroupe}</option>
					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Chercher</button>
		</form>
	</div>
<br/>
<div>

	<ul  class="list-group">
		<c:forEach items="${listg}" var="g">
			<li class="list-group-item">${g.nomEmploye}</li>
		</c:forEach>
	</ul>
</div>


<h2>Liste des comptes appartenant à un employé</h2>
		<div>
		<form method="post" action="listeCompteEmploye" class="form-inline">
			<div class="form-group">
				<label>Chercher les comptes appartenant à un employe:</label> <label
					class="sr-only">Code Employe</label>
				<select name="codeEmploye" class="form-control">
					<c:forEach items="${employe}" var="e">
						<option value="${e.codeEmploye}">${e.nomEmploye}</option>
					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Chercher</button>
		</form>
	</div>
<br/>
	<div>
		<table class="table table-bordered">
			<th class="success">Numero Compte</th>
			<th class="success">Solde Compte</th>
			<th class="success">Date de création</th>
			<c:forEach items="${compteL}" var="cL">
				<tr>
					<td>${cL.numeroCompte}</td>
					<td>${cL.soldeCompte}</td>
					<td>${cL.dateCreationCompte}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
<div >
	<img class="imagecentrer" src="<%=request.getContextPath()%>/resources/lynx_logo.png" alt="Lynx" width="100" height="100">
</div>
	<a type="button" href="accueil" class="btn btn-primary btn-xs">Retour
		au menu</a>
</body>
</html>