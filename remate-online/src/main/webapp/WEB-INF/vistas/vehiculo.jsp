<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	    <br>
	    <div class="titulo"><h1>VEHICULOS</h1>
	</div>
	<br>
	<link href="${url}/css/clases.css" rel="stylesheet" >
<div class="contenedor_principal">	
<div class="contenedor_imagen_texto">
<div class="imagen"><a title="Ram" href="${url}//vehiculo/vehiculo1"><img src="${url}/img/subasta/vehiculo/ram.jpg" alt="Vehiculo" width="160" height="120"></a>${vehiculo1}</div>
<div class="texto"><p>M20-RAM Pick up </p><p>cabina doble Ram 1500 </p>5.7 V8 <p>Laramie 4x4 </p><p>Año 2015</p></div>
</div>

<div class="contenedor_imagen_texto">
<div class="imagen"><a title="Ford" href="${url}//vehiculo/vehiculo2"><img src="${url}/img/subasta/vehiculo/ford.jpg" alt="Vehiculo" width="160" height="120"></a>${vehiculo2}</div>
<div class="texto"><p>Ford Rural 5 puertas Ecosport </p><p>SE 1.6L MT N</p><p> Año 2016</p></div>
</div>

<div class="contenedor_imagen_texto">
<div class="imagen"><a title="Volkswagen" href="${url}//vehiculo/vehiculo3"><img src="${url}/img/subasta/vehiculo/amarok.jpg" alt="Vehiculo" width="160" height="120"></a>${vehiculo3}</div>
<div class="texto"><p>Volkswagen Pick up Amarok DC 2.0L</p><p> TDI 140 CV 646</p><p> Año 2017</p></div>
</div>

<div class="contenedor_imagen_texto">
<div class="imagen"><a title="Renault" href="${url}//vehiculo/vehiculo4"><img src="${url}/img/subasta/vehiculo/renault.jpg" alt="Vehiculo" width="160" height="120"></a>${vehiculo4}</div>
<div class="texto"><p>Renault Furgón Kangoo </p><p>PH3 Confort 1.6 1p</p><p> Año 2017</p></div>
</div>
</div>
	<br>
	<br>
	


	</jsp:attribute>
</t:nav-footer>