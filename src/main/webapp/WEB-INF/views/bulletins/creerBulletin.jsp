<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" import="java.math.BigDecimal" %>

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
				<a class="nav-item nav-link active" href="<c:url value='/mvc/employes/lister'/>">
					Employés 
				</a> 
				<a class="nav-item nav-link" href="<c:url value='/mvc/bulletins/lister'/>">
					Bulletins
					<span class="sr-only">(current)</span>
				</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid">

		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<h1>Créer bulletin de salaire</h1>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="container">
				<form:form method="post" modelAttribute="bulletinSalaire" class="needs-validation" novalidate="novalidate">
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="periode.id" 
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Période</form:label>
						<div class="col-sm-12 col-md-7">
							<form:select path="periode.id" class="custom-select">
								<c:forEach items="${periodes}" var="p">
									<option value="${p.id }">${p.dateDebut } - ${p.dateFin }</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="remunerationEmploye.id"
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Matricule</form:label>
						<div class="col-sm-12 col-md-7">
							<form:select path="remunerationEmploye.id" class="custom-select">
								<c:forEach items="${employes}" var="e">
									<option value="${e.id }">${e.matricule }</option>
								</c:forEach>
							</form:select>
							<div class="invalid-feedback">
								Le matricule est obligatoire.
							</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="primeExceptionnelle"
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Prime exceptionnelle</form:label>
						<div class="col-sm-12 col-md-7">
							<form:input path="primeExceptionnelle" type="text" class="form-control form-control-lg"
								id="colFormLabelLg"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12">
							<div class="float-right">
								<form:button type="submit" class="btn btn-dark">Créer</form:button>
							</div>
						</div>
					</div>
				</form:form>
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
	<script>
		{
			var urlSearch = document.location.search;
			if (urlSearch === "?errors") {
				$('input').addClass('is-invalid');
			}
		}
	</script>
</body>

</html>