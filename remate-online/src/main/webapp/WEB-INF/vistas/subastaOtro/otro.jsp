<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	<link href="${url}/css/clases.css" rel="stylesheet" >
	    <br>
	    <div class="titulo"><h1>ARTICULO</h1>
	</div>
	<br>
	<br>
	<div class="contenedor_principal">
   <div class="texto">
	<br>
	El Modelo es: ${otro.modelo}
	<br>
	La Patente es: ${otro.patente}
	<br>
	El Color Es: ${otro.color}
	<br>
	<br>
	<br>
	<fmt:formatDate type = "date"  pattern="dd-MM-yyyy HH:mm:ss" value = "${subasta.fechaCierre}" />
	<br>
	</div>
<form:form >
	
     El Precio es:${subasta.precioBase}
     
     <br>
	 <br>

	  Descripción: "${subasta.descripcion}"
	 <br>
	  <br>
	   <br>
	 
	 
	<input type="hidden" id="vehiculo" value="${otro.id}"/>
	<input type="hidden" id="subasta" value="${subasta.id}" /> 
	
		<button  onClick="ShowSelected()" class="boton_personalizado" 
						>Ofertar</button>
			

	</form:form>

<br>
<br>

</div>
<br>
<br>
<script>
function ShowSelected(){
							
							var codV = document.getElementById("otro").value;
							var codS= document.getElementById("subasta").value;
							if((codV == null || codV == 0) && (codS == null || codS == 0) ){
									alert('No se hizo clic');
								}
								else{
									location.href="/botonActivo/"+codV/+codS;
								}
							
							}
</script>      							
							



	</jsp:attribute>
</t:nav-footer>
	
	