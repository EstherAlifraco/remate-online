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
					<h1>Lista de Subastas</h1>

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
							<!--<th scope="col">Fecha Cierre</th>-->
								<th scope="col">Precio</th>
								<th scope="col">Descripcion</th>
								<th scope="col">Asignado Vehiculo</th>
								<th scope="col">Asignado Inmueble</th>
								<th scope="col">Asignado Otro</th>
								<th scope="col">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="s" items="${subasta}">
								<tr>
								
									<td><c:out value="${s.id}" /></td>
								<!--<td><c:out value="${s.fechaCierre}" /></td>-->
									<td><c:out value="${s.precioBase}" /></td>
									<td><c:out value="${s.descripcion}" /></td>
									<td><c:out value="${s.vehiculo.id}" /></td>
									<td><c:out value="${s.inmueble.id}" /></td>
									<td><c:out value="${s.otro.id}" /></td>
									
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${url}/eliminarSubasta?idSubasta=${s.getId()}"><span
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
	