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
	    <div class="titulo"><h1>INMUEBLES</h1>
	</div>
	<br>
	<br>

							<label for="sel1">Seleccione Tipo de Inmueble:</label>
							<div class="form-group">
							
							<select	 id="subInId" name="subInId" class="form-control">
								<option value="0">Seleccione Tipo</option>
								<c:forEach items="${subCategoriaList}" var="in">
									<option value="${in.subInId}">${in.tipo} ${in.subInId}</option>
								
								</c:forEach>
								
							</select>
						 	
						</div>
						
						
						<!-- pasamos el id por una funcion  -->
						<button class="btn btn-lg btn-primary btn-block btn-info" style="color: white" onclick="ShowSelected()"
						>Buscar Inmueble </button>
						
	<script type="text/javascript">
							function ShowSelected()
							{
							/* Para obtener el valor */
							var sub = document.getElementById("subInId").value;
								if(sub == null || sub == 0){
									alert('Para continuar es necesario que seleccione una especialidad  ¡GRACIAS!');
								}
								else{
									location.href="${url}/inmuebles/"+sub;
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
	
	