<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.time.ZonedDateTime, java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body class="container-fluid">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Logo</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active"
					href="<c:url value='/mvc/employes/lister'/>"> Employés <span
					class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link"
					href="<c:url value="/mvc/bulletins/lister"/>">Bulletins</a>
			</div>
		</div>
	</nav>
	<br />
	<div class="container-fluid">
		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<h1>Bulletin de salaire</h1>
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col">
				<h3>Entreprise</h3>
			</div>
			<div class="col">
				<div class="float-right">
					<h3>Periode</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<c:forEach  items="${buSalaire }" var="b">
					<h4>${b.key.remunerationEmploye.entreprise.denomination}</h4>
				</c:forEach>
			</div>
			<div class="col">
				<div class="float-right">
					<h4>Du ${buSalaire.key.periode.dateDebut } au
						${buSalaire.key.periode.dateFin }</h4>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col">
				<h4>SIRET: ${buSalaire.key.remunerationEmploye.entreprise.siret }</h4>
			</div>
			<div class="col">
				<div class="float-right">
					<h4>Matricule: ${buSalaire.key.remunerationEmploye.matricule }</h4>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<span><h4>Salaire</h4></span>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cotisations patronales</th>
						</tr>
					</thead>
					<tbody>
					<tbody>
						<tr>
							<td>Salaire de base</td>
							<td>${buSalaire.value.salaireBrut}</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Prime Exceptionnelle</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>

					</tbody>

				</table>
			</div>
		</div>

		<div class="row">
			<span><h4>Cotisations</h4></span>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cotisations patronales</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<span><h4>NET Imposables:</h4></span>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cotisations patronales</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="float-right">
					<h4>NET A PAYER:</h4>
				</div>
			</div>
		</div>


	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>

</html>