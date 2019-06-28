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
	    <div class="titulo"><h1>INMUEBLES</h1>
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
									<th scope="col">Calle</th>
									<th scope="col">N°</th>
									<th scope="col">Habitaciones</th>
									<th scope="col">Localidad</th>
									<th scope="col">Ciudad</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="in" items="${listaInmuebles}">
									<tr>
										<td><c:out value="${in.id}" /></td>	
										<td><c:out value="${in.calle}" /></td>
										<td><c:out value="${in.numero}" /></td>
										<td><c:out value="${in.habitaciones}" /></td>
										<td><c:out value="${in.localidad}" /></td>
										<td><c:out value="${in.ciudad}" /></td>
										<td><a class="boton_personalizado_remate" href="${url}/inmueble/<c:out value="${in.id}" />"> Ingresar</a></td>
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
	