<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
	
<br>

<div class="container" style="margin-top: 60px !important">
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<h1>Lista de Vehiculos</h1>
					<a class="btn btn-default btn-circle"
						href="${url}/agregarVehiculo"><span
						class="glyphicon glyphicon"></span> Agregar Vehiculo</a>
						
					<a class="btn btn-default btn-circle"
						href="${url}/agregarSubastaV"><span
						class="glyphicon glyphicon"></span> Agregar Subasta</a>

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Marca</th>
								<th scope="col">Modelo</th>
								<th scope="col">Patente</th>
								<th scope="col">Color</th>
								<th scope="col">N° de Subasta</th>
								<th scope="col">Fecha Cierre</th>
								<th scope="col">Precio</th>
								<th scope="col">Descripcion</th>
								<th scope="col">Editar</th>
								<th scope="col">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="v" items="${vehiculo}">
								<tr>
									<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
									<td><c:out value="${v.id}" /></td>
									<td><c:out value="${v.marca}" /></td>
									<td><c:out value="${v.modelo}" /></td>
									<td><c:out value="${v.patente}" /></td>
									<td><c:out value="${v.color}" /></td>
									<td><c:out value="${v.subastaVehiculo.id}" /></td>
									<td><c:out value="${v.subastaVehiculo.fechaCierre}" /></td>
									<td><c:out value="${v.subastaVehiculo.precioBase}" /></td>
									<td><c:out value="${v.subastaVehiculo.descripcion}" /></td>
									<td><c:out value="" /><a
										class="btn btn-default btn-circle"
										href="${url}/modificarVehiculo?idVehiculo=${v.getId()}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/eliminarVehiculo?idVehiculo=${v.getId()}"><span
											class="glyphicon glyphicon-trash"></span> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>


		</div>
	</div>
</div>
			
	</jsp:attribute>
</t:nav-admin>	
	