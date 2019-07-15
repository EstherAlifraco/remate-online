<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-admin>
	<jsp:attribute name="body">
<div class="container">
	<h1>Agregar Subasta</h1>
	<form:form action="guardarSubastaIn" modelAttribute= "subasta" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
		<!-- 	    <div class="form-group col-md-12">
			    <label for="fechaCierre">Fecha Cierre</label>
					<form:input type="date" required="required" class="form-control"
						id="fechaCierre" path="fechaCierre" placeholder="fecha" />
				</div>
				-->
				
				<div class="form-group col-md-12">
					<label for="precioBase">Precio</label>
					<form:input type="number" required="required" class="form-control"
						id="precioBase" path="precioBase" placeholder="precio" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="descripcion">Descripcion</label>
					<form:input type="text" required="required" class="form-control"
						id="descripcion" path="descripcion" placeholder="descripcion" />
				</div>
				
				<div class="form-group col-md-12">
					<label for="inmueble">Inmueble</label> <select	 id="id" name="id" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${inmuebleList}" var="i">
									<option value="${i.id}">${i.calle} ${i.numero} ${i.id}</option>
								
								</c:forEach>
								
							</select>
				</div>

				<input type="submit" class="btn btn-lg btn-block btn-info" style= "color:white"
					value="Guardar Subasta">
			</div>
		</div>
	</form:form>
				
		</div>
			
	</jsp:attribute>
</t:nav-admin>	
			