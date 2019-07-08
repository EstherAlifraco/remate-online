<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
	
<br>
<br>
<br>
<h1><span style="font-size:20px">
		Bienvenido</span> Administrador <span class="glyphicon glyphicon-heart" style="color:#075C78">
		</span></h1>
			<div  style="text-align: center">
			</div>
			<br>

	<div class="contenedor_principal">
	
	<a class="boton_personalizado_remate" href="${url}/abmVehiculo">Vehiculo</a>
	
	<a class="boton_personalizado_remate" href="${url}/abmInmueble">Inmueble</a>
	
	<a class="boton_personalizado_remate" href="${url}/abmOtro">Otro</a>
	
	<a class="boton_personalizado_remate" href="${url}/abmUsuario">Usuario</a>
	
	<br>
	<br>
	<br>
	<br>
	</div>
			
	</jsp:attribute>
</t:nav-admin>	
	