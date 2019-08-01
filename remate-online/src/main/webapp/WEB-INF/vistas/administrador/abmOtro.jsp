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
					<h1>Lista de Otros Articulos</h1>
					<a class="btn btn-default btn-circle"
						href="${url}/agregarOtro"><span
						class="glyphicon glyphicon"></span> Agregar Otro</a>
						
						

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Nombre</th>
								<th scope="col">Descripcion</th>
								<th scope="col">N° de Subasta</th>
								<th scope="col">Fecha Cierre</th>
								<th scope="col">Precio</th>
								<th scope="col">Descripcion</th>
								<th scope="col">Editar</th>
								<th scope="col">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="o" items="${otro}">
								<tr>
									<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
									<td><c:out value="${o.id}" /></td>
									<td><c:out value="${o.nombre}" /></td>
									<td><c:out value="${o.descripcion}" /></td>
									<td><c:out value="${o.subastaOtro.id}" /></td>
									<td><c:out value="${o.subastaOtro.fechaCierre}" /></td>
									<td><c:out value="${o.subastaOtro.precioBase}" /></td>
									<td><c:out value="${o.subastaOtro.descripcion}" /></td>
									<td><c:out value="" /><a
										class="btn btn-default btn-circle"
										href="${url}/modificarOtro?idOtro=${o.getId()}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/eliminarOtro?idOtro=${o.getId()}"><span
											class="glyphicon glyphicon-trash"></span> </a></td>
											<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/agregarSubastaOtro?idOtro=${o.getId()}"><span
											class="glyphicon glyphicon">Agregar Subasta</span> </a></td>
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
	