<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	     <br>
		<div class = "container" >
		
	<div style="text-align: center" class="texto">
		<h1>El total es:</h1>
	
		<h1>${subasta.precioCierre}</h1>
	</div>
	     </div>
	     <br>
	     <br>
	     <br>
	</jsp:attribute>
</t:nav-footer>
