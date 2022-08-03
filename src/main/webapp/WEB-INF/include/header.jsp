<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<div id=header class="container-fluid" >
			<h1 id="siteTitle">java01goldensitecontent</h1>
			<div id="header-top-vert"  >
				<p class="header-profile-text">${user.userName}</p>
				<p class="header-profile-text">Email: ${user.email}</p>
				<a href="/logout">Logout</a>
			</div>
	</div>
	
	<div id="navBar" class="container-fluid">
		
		<a href= "/home">Home</a>
		<a href= "/house">House</a>
		<a href= "/twinone">Twinone</a>
		<a href= "/twintwo">Twintwo</a>
		
				
	</div>
<!-- 		<ul class="navbar-nav">
      		<li class="nav-item">
        		<a class="nav-link" href="#">Link 1</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">Link 2</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">Link 3</a>
      		</li>
    	</ul> -->