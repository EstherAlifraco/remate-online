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
	    <div class="titulo"><h1>VEHICULO</h1>
	</div>
	<br>
	<br>
	<div class="contenedor_principal">
   <div class="texto">
	<br>
	El Modelo es: ${vehiculo.modelo}
	<br>
	La Patente es: ${vehiculo.patente}
	<br>
	El Color Es: ${vehiculo.color}
	<br>
	<br>
	<br>
	<fmt:formatDate type = "date"  pattern="dd-MM-yyyy HH:mm:ss" value = "${subasta.fechaCierre}" />
	<br>
	
<form:form >
	
     El Precio es:${subasta.precioBase}
     
     <br>
	 <br>

	  Descripción: "${subasta.descripcion}"
	 <br>
	  <br>
	   <br>
	 
	 
	<input type="hidden" id="vehiculo" value="${vehiculo.id}"/>
	<input type="hidden" id="subasta" value="${subasta.id}" /> 
	<input type="hidden" id="total" value="${subasta.precioCierre}" /> 
	
		<button  onClick="ShowSelected()" class="boton_personalizado" 
						>Ofertar</button>
			

	</form:form>

<br>
<br>
</div>
</div>
<br>
<br>
<script>
function ShowSelected(){
	uno();
	dos();
}
		function uno(){					
							var codV = document.getElementById("vehiculo").value;
							var codS= document.getElementById("subasta").value;
							var codT= document.getElementById("total").value;
							if((codV == null || codV == 0) && (codS == null || codS == 0) ){
									alert('No se hizo clic');
								}
								else{
									location.href="/botonActivo/"+codV/+codS;
								}
							
							}
		function dos(){
			          var codS= document.getElementById("subasta").value; 
			          var codT= document.getElementById("total").value;
			          if ((codS == null || codS == 0)&& (codT == null || codT == 0)) {
							alert('No se hizo clic');
						}
						else{
							location.href="/precioTotal/"+codS;
						}
		}
</script>      							
							



	</jsp:attribute>
</t:nav-footer>
	
	