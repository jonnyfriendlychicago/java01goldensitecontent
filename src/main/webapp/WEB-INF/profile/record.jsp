<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid bg-primary" >
		<h2>User Profile</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div id="profileContainer" class="container col-sm-6"> 
			<div id="profileCard" class="card p-5 d-md-flex justify-content-start">
				<div class="row">
					<div class="col-3">
					<p class="text-danger">userID:</p>
					</div>
					<div class="col-4">
					<p class="text-danger"><c:out value="${userProfile.id}"></c:out></p>
					</div>
				</div>
				
				<div class="row">
					<div class="col-3">
					<p>username:</p>
					</div>
					<div class="col-4"><c:out value="${userProfile.userName}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col-3">
					<p>email:</p>
					</div>
					<div class="col-4"><c:out value="${userProfile.email}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col-3">
					<p>firstName:</p>
					</div>
					<div class="col-4"><c:out value="${userProfile.firstName}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col-3">
					<p>lastName:</p>
					</div>
					<div class="col-4"><c:out value="${userProfile.lastName}"></c:out></div>
				</div>
				
				<%-- <div class="row">
					<div class="col">
					<p>addressLineOne:</p>
					</div>
					<div class="col"><c:out value="${userProfile.addressLineOne}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>addressLineTwo:</p>
					</div>
					<div class="col"><c:out value="${userProfile.addressLineTwo}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>city:</p>
					</div>
					<div class="col"><c:out value="${userProfile.city}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>state:</p>
					</div>
					<div class="col"><c:out value="${userProfile.state}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>zipCode:</p>
					</div>
					<div class="col"><c:out value="${userProfile.zipCode}"></c:out></div>
				</div>
 --%>				
				<a href= "/profile/${userProfile.id}/edit"><button class="btn btn-primary">Edit Profile</button></a>

			</div> <!-- end profileCard -->
		</div> <!-- end profileContainer -->

	</div>
 
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>