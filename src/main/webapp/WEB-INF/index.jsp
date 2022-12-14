<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/head.jsp" />

<body>
	<jsp:include page="include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Registration and Login</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div id=registerLogin class="container">
			
			<%-- <div id=registerLogin2 class="container">
				<div id="register" class="card p-3 d-md-flex justify-content-center align-items-center" >
					<h4>Register</h4>
					<form:form action='/register' method='post' modelAttribute='newUser'>
				
						<div class="form-floating mb-3">
							<form:input path="email" type="email" class="form-control" id="floatingEmail" placeholder="name@example.com"/>
							<form:label path="email" for="floatingEmail">Email</form:label>
							<p class="text-danger"><form:errors path="email" />
						</div>
						
						<div class="form-floating mb-3">
							<form:input path="password" type="password" class="form-control" id="floatingPassword" placeholder="Password"/> 
							<form:label path="password" for="floatingPassword">Password</form:label>
							<p class="text-danger"><form:errors path="password" />
						</div>

						
						<div class="form-floating mb-3">
							<form:input path="confirm" type="password" class="form-control" id="floatingConfirm" placeholder="Password"/> 
							<form:label path="confirm" for="floatingConfirm">Confirm Password</form:label>
							<p class="text-danger"><form:errors path="confirm" />
						</div>

						<button type="submit" class="w-100 btn btn-primary">Register</button>
					</form:form>
				</div>
 --%>

				<div id="login" class="card p-3 d-md-flex justify-content-center align-items-center" >
					<h1 class="h3 mb-3 fw-normal">Please Login</h1>
					<!-- <h4>Login</h4> -->
					<form:form action='/login' method='post' modelAttribute='newLogin'>
						
						<div class="form-floating w-80">
							<form:input path="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com"/>
							<form:label path="email" for="floatingInput">Email</form:label>
							<p class="text-danger"><form:errors path="email" />
						</div>

						<div class="form-floating mb-3">
							<form:input path="password" type="password" class="form-control" id="floatingPassword" placeholder="Password"/> 
							<form:label path="password" for="floatingPassword">Password</form:label>
							<p class="text-danger"><form:errors path="password" />
						</div>

						<button type="submit" class="w-100 btn btn-primary">Login</button>
						
						<p>New user? <a href="/register"><button type="button" class="btn btn-link">Create an account</button></a> 
						
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="include/footer.jsp"/>
			
			
</body>
</html>