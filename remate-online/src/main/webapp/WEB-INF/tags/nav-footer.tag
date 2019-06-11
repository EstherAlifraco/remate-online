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
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	    <link href="${url}/js/bootstrap.min.js">
	    <link href="${url}/css/clases.css" rel="stylesheet" >
	    
	</head>
	<body>
         <nav class="navbar navbar-inverse">
			 <div class="container-fluid" style="background-color: #075C78">
			 <div align="center"><img width="30%" height="30%" src ="${url}/img/remates.gif"/>
			  <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="${url}/" style="color: white">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" style="color: white" data-toggle="dropdown" href="#">Remates
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${url}/remate/vehiculo" style="color: #075C78">Vehiculos</a></li>
          <li><a href="${url}/remate/inmueble" style="color: #075C78">Inmueble</a></li>
          <li><a href="${url}/remate/otro" style="color: #075C78">Otro</a></li>
        </ul>
      </li>
      <li class="dropdown">
       <a class="dropdown-toggle" style="color: white" data-toggle="dropdown" href="#">Atención Clientes
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#" style="color: #075C78">Contacto por Mail</a></li>
          <li><a href="#" style="color: #075C78">Preguntas Frecuentes</a></li>
          <li><a href="#" style="color: #075C78">Servicio Técnico</a></li>
          </ul>
          </ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${url}/registro"><span class="glyphicon glyphicon-user"
							style="color: white"></span> Registrarse</a></li>
					<li><a href="${url}/login"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Login</a></li>
					<li><a href="${url}/cerrar-sesion"><span class="glyphicon glyphicon-log-in"
							style="color: white"></span> Logout</a></li>
				 </ul>
				 <br>
					<span class="nav navbar-nav navbar-center" style="color: white">logeado como: ${sessionScope.usuarioNombre}</span>
    </div>
     </div>
		  </nav>
		  <div class="row">
				<div class="col-md-12">
					<jsp:invoke fragment="body"/>
				</div>
			</div>
	<footer>		
     <div class="Pie-pagina">
                Telefono: 5555-5555<br>
<a title="facebook" href="https://www.facebook.com/"><img src="${url}/img/footer/facebook.png" width="40" height="40"></a>
${facebook}
<a title="twitter" href="https://www.twitter.com/"><img src="${url}/img/footer/twitter.png" width="40" height="40"></a>
${twitter}
<a title="instagram" href="https://www.instagram.com/"><img src="${url}/img/footer/instagram.png" width="40" height="40"></a>
${instagram}
      </div>
      </footer>
		<script src="${url}/js/jquery-3.0.0.min.js"></script>
		<script src="${url}/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="${url}/js/jquery.dataTables.min.js" type="text/javascript"></script>
		<script src="${url}/js/datatable.js" type="text/javascript"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
		<jsp:invoke fragment="scripts"/>
	</body>
</html>
