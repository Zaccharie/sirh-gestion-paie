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
				<a class="nav-item nav-link active" href="index.html">Employés <span
					class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link" href="#">Bulletins</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid">

		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<h1>Ajouter un employé</h1>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="container">
				<form:form method="post" modelAttribute="remunerationEmploye" class="needs-validation" novalidate="novalidate">
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="matricule" 
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Matricule</form:label>
						<div class="col-sm-12 col-md-7">
							<form:input path="matricule" type="text" class="form-control form-control-lg"
								id="colFormLabelLg" required="required"/>
							<div class="invalid-feedback">Le matricule est obligatoire.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="entreprise"
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Entreprise</form:label>
						<div class="col-sm-12 col-md-7">
							<form:select path="entreprise.id" class="custom-select">
								<c:forEach items="${entreprises}" var="e">
									<option value="${e.id }">${e.denomination }</option>
								</c:forEach>
							</form:select>
							<div class="invalid-feedback">
								L'Entreprise est obligatoire.
							</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="profilRemuneration"
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Profile</form:label>
						<div class="col-sm-12 col-md-7">
							<form:select class="custom-select" path="profilRemuneration.id">
								<c:forEach items="${profiles}" var="p">
									<option value="${p.id }">${p.code }</option>
								</c:forEach>
							</form:select>
							<div class="invalid-feedback">Le profil est obligatoire.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="colFormLabelLg" path="grade"
							class="col-md-5 col-sm-12 col-form-label col-form-label-lg">Grade</form:label>
						<div class="col-sm-12 col-md-7">
							<form:select class="custom-select" path="grade.id">
								<c:forEach items="${grades}" var="g">
									<option value="${g.id }">${g.code} - ${((g.nbHeuresBase * g.tauxBase)*12)} € / an</option>
								</c:forEach>
							</form:select>
							<div class="invalid-feedback">Le grade est obligatoire</div>
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