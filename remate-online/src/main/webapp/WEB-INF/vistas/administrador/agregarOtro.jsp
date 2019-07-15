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
	<h1>Agregar Otro Articulo</h1>
	<form:form action="guardarOtro" modelAttribute="Otro" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
			    <div class="form-group col-md-12">
					<label for="nombre">Nombre</label>
					<form:input type="text" required="required" class="form-control"
						id="nombre" path="nombre" placeholder="nombre" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="descripcion">Descripción</label>
					<form:input type="text" required="required" class="form-control"
						id="descripcion" path="descripcion" placeholder="descripcion" />
				</div>

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo de Articulos</label> <select	 id="subOtroId" name="subOtroId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="o">
									<option value="${o.subOtroId}">${o.tipo} ${o.subOtroId}</option>
								
								</c:forEach>
								
							</select>
				</div>

				<input type="submit" class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Guardar Otro">
			</div>
		</div>
	</form:form>
</div>
			
	</jsp:attribute>
</t:nav-admin>	
	