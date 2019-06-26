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
	    <div class="titulo"><h1>Vehiculo</h1>
	</div>
	<br>
	<br>
	<div class="contenedor_principal">
   <div class="texto">El Número de Vehiculo es: ${vehiculo.id}
	<br>
	El Modelo es: ${vehiculo.modelo}
	<br>
	La Patente es: ${vehiculo.patente}
	<br>
	El Color Es: ${vehiculo.color}
	<br>
	<br>
	<br>
	<br>
	</div>
	<div class="texto">
<p id="demo"></p>
<br>
     ${subasta.precioBase}
	 ${subasta.descripcion}
	<a class="boton_personalizado" href="#">Ofertar</a>
<br>
<br>
</div>
</div>
<br>
<br>
<script>

//Establece la fecha.
var countDownDate = new Date("${subasta.fechaInicio}").getTime();

// Actualiza cada un segundo.
var x = setInterval(function() {

  // Obtiene fecha y hora de hoy.
  var now = new Date().getTime();
    
  // Encuentra la distancia entre hora y fecha de cuenta regresiva.
  var distance = countDownDate - now;
    
  // Calculos de tiempo para día, hora minutos y segundos.
  var year = Math.floor(distance / (1000 * 60 * 60 * 24 * 30 * 365)) / (1000 * 60 * 60 * 24 *30));
  var months = Math.floor(distance / (1000 * 60 * 60 * 24 * 30)) / (1000 * 60 * 60 * 24));
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Muestra el resultado.
  document.getElementById("demo").innerHTML = year + "a" + months + "m" + days + "d " + hours + "h "
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
	
	