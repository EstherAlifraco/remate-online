<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	<link href="${url}/css/clases.css" rel="stylesheet" >
	    <br>
	    <div class="titulo"><h1>VEHICULOS</h1>
	</div>
	<br>
	<br>

							<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<br>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">N°</th>
									<th scope="col">Marca</th>
									<th scope="col">Modelo</th>
									<th scope="col">Patente</th>
									<th scope="col">Color</th>
									<th scope="col">N° de Subasta</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ve" items="${listaVehiculos}">
									<tr>
										<td><c:out value="${ve.id}" /></td>	
										<td><c:out value="${ve.marca}" /></td>
										<td><c:out value="${ve.modelo}" /></td>
										<td><c:out value="${ve.patente}" /></td>
										<td><c:out value="${ve.color}" /></td>
										<td><c:out value="${ve.subastaVehiculo.id}" /></td>
										<td><a class="boton_personalizado_remate" href="${url}/vehiculo/<c:out value="${ve.id}/ ${ve.subastaVehiculo.id }" />"> Ingresar</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	</jsp:attribute>
</t:nav-footer>
	