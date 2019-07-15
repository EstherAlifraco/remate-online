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
	<h1>Modificar Inmueble</h1>
	<form:form action="actualizarInmueble" modelAttribute="inmueble"
		method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">

					<form:input type="hidden" id="id" name="id" path="id" />
					<label for="calle">Calle</label>
					<form:input type="text" required="required" class="form-control"
						id="calle" name="calle" path="calle" />
				</div>
				<div class="form-group col-md-12">
					<label for="numero">Numero</label>
					<form:input type="text" required="required" class="form-control"
						id="numero" name="numero" path="numero" />
				</div>

				<div class="form-group col-md-12">
					<label for="habitaciones">Habitaciones</label>
					<form:input type="text" required="required" class="form-control"
						id="habitaciones" name="habitaciones" path="habitaciones" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="localidad">Localidad</label>
					<form:input type="text" required="required" class="form-control"
						id="localidad" name="localidad" path="localidad" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="ciudad">Ciudad</label>
					<form:input type="text" required="required" class="form-control"
						id="ciudad" name="ciudad" path="ciudad" />
				</div>

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Inmueble</label> <select	 id="subInId" name="subInId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="i">
									<option value="${i.subInId}">${i.tipo} ${i.subInId}</option>
								
								</c:forEach>
								
							</select>
				</div>
				
				<input type="submit"  class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Actualizar Inmueble">
			</div>
		</div>
	</form:form>
</div>

			
	</jsp:attribute>
</t:nav-admin>	
	