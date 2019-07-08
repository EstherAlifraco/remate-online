<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
	
	<br>
	<div class="container">
	<h1>Modificar Vehiculo</h1>
	<form:form action="actualizarVehiculo" modelAttribute="vehiculo"
		method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">

					<form:input type="hidden" id="id" name="id" path="id" />
					<label for="marca">Marca</label>
					<form:input type="text" required="required" class="form-control"
						id="marca" name="marca" path="marca" />
				</div>
				<div class="form-group col-md-12">
					<label for="modelo">Modelo</label>
					<form:input type="text" required="required" class="form-control"
						id="modelo" name="modelo" path="modelo" />
				</div>

				<div class="form-group col-md-12">
					<label for="patente">Patente</label>
					<form:input type="text" required="required" class="form-control"
						id="patente" name="patente" path="patente" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="color">Color</label>
					<form:input type="text" required="required" class="form-control"
						id="color" name="color" path="color" />
				</div>


				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Vehiculo</label> <select	 id="subVeId" name="subVeId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="v">
									<option value="${v.subVeId}">${v.tipo} ${v.subVeId}</option>
								
								</c:forEach>
								
							</select>
				</div>
				
				<input type="submit"  class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Actualizar Vehiculo">
			</div>
		</div>
	</form:form>
</div>

			
	</jsp:attribute>
</t:nav-admin>	
	