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
			<div id="profileCard" class="card p-3 d-md-flex justify-content-start">
				<form:form action='/profile/edit' method='post' modelAttribute='userProfile'>
					
					<form:input type="hidden"  path="id" />
				
					<div class="form-floating mb-3">
						<form:input path="userName" type="text" class="form-control" id="floatingUserName" placeholder="userName"/>
						<form:label path="userName" for="floatingUserName">userName</form:label>
						<p class="text-danger"><form:errors path="userName" />
					</div>
					
					<div class="form-floating mb-3">
						<form:input path="email" type="email" class="form-control" id="floatingEmail" placeholder="name@example.com"/>
						<form:label path="email" for="floatingEmail">Email</form:label>
						<p class="text-danger"><form:errors path="email" />
					</div>
					
					<div class="form-floating mb-3">
						<form:input path="firstName" type="text" class="form-control" id="floatingfirstName" placeholder="firstName"/>
						<form:label path="firstName" for="floatingfirstName">firstName</form:label>
						<p class="text-danger"><form:errors path="firstName" />
					</div>
					<div class="form-floating mb-3">
						<form:input path="lastName" type="text" class="form-control" id="floatinglastName" placeholder="lastName"/>
						<form:label path="lastName" for="floatinglastName">lastName</form:label>
						<p class="text-danger"><form:errors path="lastName" />
					</div>
					
<%-- 					<div class="form-floating mb-3">
						<form:input path="addressLineOne" type="text" class="form-control" id="floatingaddressLineOne" placeholder="addressLineOne"/>
						<form:label path="addressLineOne" for="floatingaddressLineOne">addressLineOne</form:label>
						<p class="text-danger"><form:errors path="addressLineOne" />
					</div>
					<div class="form-floating mb-3">
						<form:input path="addressLineTwo" type="text" class="form-control" id="floatingaddressLineTwo" placeholder="addressLineTwo"/>
						<form:label path="addressLineTwo" for="floatingaddressLineTwo">addressLineTwo</form:label>
						<p class="text-danger"><form:errors path="addressLineTwo" />
					</div>
					<div class="form-floating mb-3">
						<form:input path="city" type="text" class="form-control" id="floatingcity" placeholder="city"/>
						<form:label path="city" for="floatingcity">city</form:label>
						<p class="text-danger"><form:errors path="city" />
					</div>
					<div class="form-floating mb-3">
						<form:input path="state" type="text" class="form-control" id="floatingstate" placeholder="state"/>
						<form:label path="state" for="floatingstate">state</form:label>
						<p class="text-danger"><form:errors path="state" />
					</div>
					<div class="form-floating mb-3">
						<form:input path="zipCode" type="email" class="form-control" id="floatingzipCode" placeholder="zipCode"/>
						<form:label path="zipCode" for="floatingzipCode">zipCode</form:label>
						<p class="text-danger"><form:errors path="zipCode" />
					</div> --%>
					
					<div>
						<button type="submit" class="btn btn-primary w-100">Update</button>
					</div>
				</form:form>
	
			<a href="/profile/${userProfile.id}"><button class="btn btn-secondary">Cancel</button></a>
				
<%-- 				<div class="row">
					<div class="col">
					<p>username:</p>
					</div>
					<div class="col"><c:out value="${userProfile.userName}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>email:</p>
					</div>
					<div class="col"><c:out value="${userProfile.email}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>firstName:</p>
					</div>
					<div class="col"><c:out value="${userProfile.firstName}"></c:out></div>
				</div>
				
				<div class="row">
					<div class="col">
					<p>lastName:</p>
					</div>
					<div class="col"><c:out value="${userProfile.lastName}"></c:out></div>
				</div>
				
				<div class="row">
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
			</div> <!-- end profileCard -->
		</div> <!-- end profileContainer -->

	</div>
 
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>