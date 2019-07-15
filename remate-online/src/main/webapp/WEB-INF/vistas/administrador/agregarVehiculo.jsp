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
	<h1>Agregar Vehiculo</h1>
	<form:form action="guardarVehiculo" modelAttribute="Vehiculo" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
			    <div class="form-group col-md-12">
					<label for="marca">Marca</label>
					<form:input type="text" required="required" class="form-control"
						id="marca" path="marca" placeholder="marca" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="modelo">Modelo</label>
					<form:input type="text" required="required" class="form-control"
						id="modelo" path="modelo" placeholder="modelo" />
				</div>

				<div class="form-group col-md-12">
					<label for="patente">Patente</label>
					<form:input type="text" required="required" class="form-control"
						id="patente" path="patente" placeholder="patente" />
				</div>

				<div class="form-group col-md-12">
					<label for="color">Color</label>
					<form:input type="text" required="required" class="form-control"
						id="color" path="color" placeholder="color" />
				</div>

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Vehiculo</label> <select	 id="subVeId" name="subVeId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="v">
									<option value="${v.subVeId}">${v.tipo} ${v.subVeId}</option>
								
								</c:forEach>
								
							</select>
				</div>

				<input type="submit" class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Guardar Vehiculo">
			</div>
		</div>
	</form:form>
</div>

	</jsp:attribute>
</t:nav-admin>	
	