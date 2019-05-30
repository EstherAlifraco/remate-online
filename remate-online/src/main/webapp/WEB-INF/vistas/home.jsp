<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="url" value="${pageContext.request.contextPath}"/>
  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:nav-footer>
	<jsp:attribute name="body">
	 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 70%;
    margin: auto;
  }
  .item {
      display: block;
      width: 100%;
      height: 500px;
  }
  </style>
    <div class="container">
     <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
  </ol>
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="${url}/img/home/remates.jpg" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
    <div class="item">
      <img src="${url}/img/home/remates1.jpg" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
    <div class="item">
      <img src="${url}/img/home/remates2.jpg" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
    <div class="item">
      <img src="${url}/img/home/remates3.jpg" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
    <div class="item">
      <img src="${url}/img/home/remates4.jpg" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
    <div class="item">
      <img src="${url}/img/home/remates5.png" alt="Remates" width="460" height="345">
      <div class="carousel-caption">
    </div>
    </div>
  </div>
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Anterior</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Siguiente</span>
  </a>
</div>
</div>
	
	</jsp:attribute>
</t:nav-footer>