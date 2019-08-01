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
	</div>
<form:form >
	<div class="texto"> 
<p id="demo"></p>
<br>

     El Precio es:${subasta.precioBase}
     
     <br>
	 <br>

	  Descripción: "${subasta.descripcion}"
	 <br>
	 
	 
	 
	<input type="hidden" id="vehiculo" value="${vehiculo.id}"/>
	<input type="hidden" id="subasta" value="${subasta.id}" /> 
	
		<button  onClick="ShowSelected()" class="boton_personalizado" 
						>Ofertar</button>
			</div>

	</form:form>

<br>
<br>
</div>

<br>
<br>
<script>
function ShowSelected(){
							
							var codV = document.getElementById("vehiculo").value;
							var codS= document.getElementById("subasta").value;
							if((codV == null || codV == 0) && (codS == null || codS == 0) ){
									alert('No se hizo clic');
								}
								else{
									location.href="/botonActivo/"+codV/+codS;
								}
							
							}
</script>      							
							


<script>
//Establece la fecha.
var countDownDate = new Date("${subasta.fechaCierre}" ).getTime();

// Actualiza cada un segundo.
var x = setInterval(function() {

  // Obtiene fecha y hora de hoy.
  var now = new Date().getTime();
    
  // Encuentra la distancia entre hora y fecha de cuenta regresiva.
  var distance = countDownDate - now;
    
  // Calculos de tiempo para día, hora minutos y segundos.
  var days = Math.floor(distance % (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Muestra el resultado.
  document.getElementById("demo").innerHTML = days + "d " + hours + "h "
  + minutes + "m " + seconds + "s ";
    
  // Si la cuenta atras termino escribe un texto.
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "FINALIZADO";
  }
}, 1000);

</script>
	</jsp:attribute>
</t:nav-footer>
	
	