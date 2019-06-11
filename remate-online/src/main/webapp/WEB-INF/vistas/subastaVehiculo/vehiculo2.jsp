<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   <style>
   #contenedor_principal{
width:1024px;
height:auto;
position:absolute;
margin:auto;
}
.contenedor_imagen_texto_vehiculo{
width:450px;
height:auto;
position:relative;
display:inline-block;
vertical-align:top;
overflow:hidden;
float:left;
}
.contenedor_imagen_texto_vehiculo_izq{
width:550px;
height:auto;
position:relative;
display:inline-block;
vertical-align:top;
overflow:hidden;
float:right;
}
p{

  text-align:center;
  font-size:50px;
  margin-right:40px;
}
.boton_personalizado{
    text-decoration:none;
    padding:20px;
    font-weight:600;
    font-size:20px;
    color:#ffffff;
    background-color:#075C78;
    border-radius:6px;
    border:3px double #006505;
  }
  .boton_personalizado:hover{
    color: black;
    background-color: #ffffff;
  }
   </style>
	    <br>
	    <div class="titulo"><h1>Ford Rural</h1>
	</div>
	<br>
	<div class="texto">Ford Rural 5 puertas Ecosport SE 1.6L MT N <br>Año 2016</div>
	<br>
	
<br>
<br>
<div class="contenedor_principal">
<div class="contenedor_imagen_texto_vehiculo">
<div class="w3-content" style="max-width:480px">
  <img class="mySlides" src="${url}/img/subasta/vehiculo/ford.jpg" style="width:100%;display:none">
  <img class="mySlides" src="${url}/img/subasta/vehiculo/ford1.jpg" style="width:100%;display:none">
  <img class="mySlides" src="${url}/img/subasta/vehiculo/ford2.jpg" style="width:100%;display:none">
  <img class="mySlides" src="${url}/img/subasta/vehiculo/ford3.jpg" style="width:100%;display:none">
  <img class="mySlides" src="${url}/img/subasta/vehiculo/ford4.jpg" style="width:100%;display:none">

  <div class="w3-row-padding w3-section">
    <div class="w3-col s4">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${url}/img/subasta/vehiculo/ford.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(1)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${url}/img/subasta/vehiculo/ford1.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(2)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${url}/img/subasta/vehiculo/ford2.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(3)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${url}/img/subasta/vehiculo/ford3.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(4)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-opacity w3-hover-opacity-off" src="${url}/img/subasta/vehiculo/ford4.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(5)">
    </div>
  </div>
</div>
</div>
<br>
<div class="contenedor_imagen_texto_vehiculo_izq">
<p id="demo"></p>
<br>
<a class="boton_personalizado" href="#">Ofertar</a>
<br>
<br>
<script>
function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-opacity-off";
}

//Establece la fecha.
var countDownDate = new Date("June 22, 2019 09:00:00").getTime();

// Actualiza cada un segundo.
var x = setInterval(function() {

  // Obtiene fecha y hora de hoy.
  var now = new Date().getTime();
    
  // Encuentra la distancia entre hora y fecha de cuenta regresiva.
  var distance = countDownDate - now;
    
  // Calculos de tiempo para día, hora minutos y segundos.
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
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
 </div>
 </div>
	<br>

	</jsp:attribute>
</t:nav-footer>