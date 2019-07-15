<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	<link href="${url}/css/clases.css" rel="stylesheet" >
	    <br>
	    <div class="titulo"><h1>VEHÍCULOS</h1>
	</div>
	<br>
	<br>

							<label for="sel1">Seleccione Tipo de Vehículo:</label>
							<div class="form-group">
							
							<select	 id="subVeId" name="subVeId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="ve">
									<option value="${ve.subVeId}">${ve.tipo} ${ve.subVeId}</option>
								
								</c:forEach>
								
							</select>
						 	
						</div>
						
						
						<!-- pasamos el id por una funcion  -->
						<button class="btn btn-lg btn-primary btn-block btn-info" style="color: white" onclick="ShowSelected()"
						>Buscar Vehículo </button>
						
	<script type="text/javascript">
							function ShowSelected()
							{
							/* Para obtener el valor */
							var sub = document.getElementById("subVeId").value;
								if(sub == null || sub == 0){
									alert('Para continuar es necesario que seleccione una especialidad ¡Gracias!');
								}
								else{
									location.href="${url}/vehiculos/"+sub;
								}
						
							}
		</script>
		
			
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	</jsp:attribute>
</t:nav-footer>
	
	