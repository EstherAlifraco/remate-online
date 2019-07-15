<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    
					 <h6 class="form-signin-heading">Ingrese sus datos para loguearse</h6>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<label for="email">Email:</label>
					<form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
					<br>
					<label for="email">Password:</label>
					<form:input path="password" type="password" id="password" class="form-control" placeholder="Password" />     		  
					<br>
					<button class="btn btn-lg btn-block btn-info" style="color: white" Type="Submit"> Ingresar</button>

				</form:form>
				
				<div class="alert alert-warning">
                 Si aún no te has registrado hazlo <a href="${url}/registro"><strong>aquí</strong></a></div>
				
				<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
	</div>
	</div>
	<br>
	<br>
	<br>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
