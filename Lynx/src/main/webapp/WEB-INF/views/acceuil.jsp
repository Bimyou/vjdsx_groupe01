<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Home</title>
</head>
<body>
	<div>
		<div style="background-color: rgb(24,126,188);">
			<h1 style="text-align: center;">
				LYNX<br/><small>Compte Bancaire</small>
			</h1>
		</div>
	</div>
	<div style="background-color: rgb(219,245,247);">
		<h2 style="margin-left: 10%;">Menu</h2>
		<a style="margin-left: 10%;" class="btn btn-default" href="client" role="button">Client</a> <a
			class="btn btn-default" href="employe" role="button">Employe</a>

	</div>
	<div style="background-color: rgb(219,245,247);">
	<br/>
	</div>
	<br/>

	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="imagecentrer"
					src="<%=request.getContextPath()%>/resources/java.jpg"
					alt="ImageJava" width="404" height="300">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img class="imagecentrer"
					src="<%=request.getContextPath()%>/resources/soleil.jpg"
					alt="Soleil" width="304" height="236">
				<div class="carousel-caption"></div>
			</div>


			<div class="item">
				<img class="imagecentrer"
					src="<%=request.getContextPath()%>/resources/Futurama.jpg"
					alt="Futurama" width="304" height="236">
				<div class="carousel-caption"></div>
			</div>

		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<br/>
	<div>
		<table class="table table-striped" >
			<tr>
				<td><u>Auteurs</u></td>
				<td>Shéhérazade TAOUZA, Xavier CHAREF, Jean Daniel EYMANN, Vinh
					NGUYEN</td>
			</tr>
			<tr>
				<td><u>Nom Projet</u></td>
				<td>Projet <strong>LYNX</strong>
				</td>
			</tr>
			<tr>
				<td><u>Date de lancement</u></td>
				<td>Vendredi 29 Avril 2016</td>
			</tr>
			<tr>
				<td><u>Version</u></td>
				<td>1.0.0</td>
			</tr>
		</table>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>