<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	    <br>
	    <div class="titulo"><h1>REMATES</h1>
	</div>
	<br>
	<link href="${url}/css/clases.css" rel="stylesheet" >
	<div class="contenedor_principal">
	
	<a class="boton_personalizado_remate" href="${url}/remate/vehiculoTipo">Vehiculo</a>
	
	<a class="boton_personalizado_remate" href="${url}/remate/inmuebleTipo">Inmueble</a>
	
	<a class="boton_personalizado_remate" href="${url}/remate/otroTipo">Otro</a>
	
	<br>
	<br>
	</div>

	<br>
	<br>
	<br>
	<br>
	


	</jsp:attribute>
</t:nav-footer>