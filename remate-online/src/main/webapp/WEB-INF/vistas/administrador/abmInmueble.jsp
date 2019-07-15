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
					<h1>Lista de Inmuebles</h1>
					<a class="btn btn-default btn-circle"
						href="${url}/agregarInmueble"><span
						class="glyphicon glyphicon"></span> Agregar Inmueble</a>
						
						<a class="btn btn-default btn-circle"
						href="${url}/agregarSubastaIn"><span
						class="glyphicon glyphicon"></span> Agregar Subasta</a>
						

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Calle</th>
								<th scope="col">Numero</th>
								<th scope="col">Habitaciones</th>
								<th scope="col">Localidad</th>
								<th scope="col">Ciudad</th>
								<th scope="col">N° de Subasta</th>
								<th scope="col">Fecha Cierre</th>
								<th scope="col">Precio</th>
								<th scope="col">Descripcion</th>
								<th scope="col">Editar</th>
								<th scope="col">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${inmueble}">
								<tr>
									<td><c:out value="${i.id}" /></td>
									<td><c:out value="${i.calle}" /></td>
									<td><c:out value="${i.numero}" /></td>
									<td><c:out value="${i.habitaciones}" /></td>
									<td><c:out value="${i.localidad}" /></td>
									<td><c:out value="${i.ciudad}" /></td>
									<td><c:out value="${i.subastaInmueble.id}" /></td>
									<td><c:out value="${i.subastaInmueble.fechaCierre}" /></td>
									<td><c:out value="${i.subastaInmueble.precioBase}" /></td>
									<td><c:out value="${i.subastaInmueble.descripcion}" /></td>
									<td><c:out value="" /><a
										class="btn btn-default btn-circle"
										href="${url}/modificarInmueble?idInmueble=${i.getId()}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/eliminarInmueble?idInmueble=${i.getId()}"><span
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
	