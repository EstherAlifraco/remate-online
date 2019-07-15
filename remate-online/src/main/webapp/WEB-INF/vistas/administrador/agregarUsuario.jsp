<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
	
<br>

<div class="container">
	<h1>Agregar Usuario</h1>
	<form:form action="guardarUsuario" modelAttribute="Usuario" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">
					<label for="nombre">Nombre</label> <input type="text"
						required="required" class="form-control" id="nombre" name="nombre"
						placeholder="Nombre">
				</div>
				
				<div class="form-group col-md-12">
					<label for="email">Email</label> <input type="text"
						required="required" class="form-control" id="email" name="email"
						placeholder="info@pepeviajes.com.ar">
				</div>
				<div class="form-group col-md-12">
					<label for="password">Contraseña</label> <input type="password"
						required="required" class="form-control" id="password"
						name="password">
				</div>
				</div>

			<div class="form-group col-md-12">
				<label for="password">Rol</label> <select name="rol" id="rol"
					class="form-group ">
					<option value="cliente">Cliente</option>
					<option value="admin">Administrador</option>
				</select>
			</div>
			<input type="submit" class="btn btn-lg btn-block btn-info"  value="Guardar Usuario">
	</div>
	</form:form>
</div>

	</jsp:attribute>
</t:nav-admin>	
	