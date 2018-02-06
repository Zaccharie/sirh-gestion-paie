<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" import="java.time.ZonedDateTime, java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
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
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <h1>Liste des bulletins</h1>
            </div>
            
            <div class="float-right">
            	<a class="btn btn-dark" href="<c:url value='creer'/>" role="button">Créer un nouveau bulletin</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
							<th scope="col">Date/heure création</th>
							<th scope="col">Période</th>
							<th scope="col">Matricule</th>
							<th scope="col">Salaire brut</th>
							<th scope="col">Net imposable</th>
							<th scope="col">Net à payer</th>
							<th scope="col">Actions</th>
						</tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${buSalaire }" var="b">
                    	<tr>
                    		<td>${DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss").format(b.getKey().dateCreation) }</td>
                    		<td>${b.getKey().periode.dateDebut } - ${b.getKey().periode.dateFin }</td>
                    		<td>${b.getKey().remunerationEmploye.matricule }</td>
                    		<td>${b.getValue().salaireBrut }</td>
                    		<td>${b.value.netImposable }</td>
                    		<td>${b.value.netAPayer }</td>
                    		<td>Visualiser</td>
                    	</tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>

</html>