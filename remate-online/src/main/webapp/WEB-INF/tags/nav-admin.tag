<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<%@attribute name="body" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<html>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link href="${url}/css/bootstrap.min.css" rel="stylesheet" >
	    <link href="${url}/css/estilo.css" rel="stylesheet" >
	    <link href="${url}/css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	    <link href="${url}/js/bootstrap.min.js">
	    <link href="${url}/css/clases.css" rel="stylesheet" >
	    
	</head>
	<body>
         <nav class="navbar navbar-inverse">
			 <div class="container-fluid" style="background-color: #075C78">
			  <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="${url}/perfilAdmin" style="color: white">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" style="color: white" data-toggle="dropdown" href="#">Formularios
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${url}/abmVehiculo" style="color: #075C78">Vehiculo</a></li>
          <li><a href="${url}/abmInmueble" style="color: #075C78">Inmuebles</a></li>
          <li><a href="${url}/abmOtro" style="color: #075C78">Otro</a></li>
          <li><a href="${url}/abmUsuario" style="color: #075C78">Usuario</a></li>
          <li><a href="${url}/abmSubasta" style="color: #075C78">Subasta</a></li>
        </ul>
      </li>          
          </ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${url}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a></li>
				 </ul>
				 <br>
				 <br>
				 <br>
    </div>       
                 <br>
                 <br>
                 
		  </nav>
		  <div class="row">
				<div class="col-md-12">
					<jsp:invoke fragment="body"/>
				</div>
			</div>
	
		<script src="${url}/js/jquery-3.0.0.min.js"></script>
		<script src="${url}/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="${url}/js/jquery.dataTables.min.js" type="text/javascript"></script>
		<script src="${url}/js/datatable.js" type="text/javascript"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
		<jsp:invoke fragment="scripts"/>
	</body>
</html>

