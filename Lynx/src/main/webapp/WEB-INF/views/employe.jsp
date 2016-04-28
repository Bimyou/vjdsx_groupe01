<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap.css">

<title>Employe</title>
</head>
<body>
	<div style="background-color: rgb(24,126,188);">
		<h1 style="text-align: center;">LYNX<br /> <small>Compte Bancaire</small></h1>
	</div>

	
	
		<div>
<form method="post" action="/ajouterEmploye">
   <p>
       <label for="employe">Ajouter un employe</label> : <input type="text" name="nomemploye" id="employe" />
       <input type="submit" value="Envoyer" >
   </p>
</form>
	
	</div>
	
			<div>
<form method="post" action="/ajouterGroupe">
   <p>
       <label for="groupe">Ajouter un groupe</label> : <input type="text" name="nomgroupe" id="groupe" />
       <input type="submit" value="Envoyer" >
   </p>
</form>
	
	</div>
		<a type="button" href="accueil" class="btn btn-primary btn-xs">Retour au menu</a>
	
</body>
</html>