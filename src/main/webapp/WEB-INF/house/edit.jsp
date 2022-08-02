<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>House Management</h2>
	</div>
	
	<div id=main class="card">

		<div id=about class="card">
			
			<form:form action='/house/edit' method='post' modelAttribute='house'>

				<form:input type="hidden"  path="id" />
		
				<div class="form-group">
					<form:label path="houseName" for="houseName">houseName</form:label>
					<form:input type="text" class="form-control" path="houseName"/>
					<p class="errorText"><form:errors path="houseName" />
					</p>
				</div>
				
				<div>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</form:form>
	
			<a href="/house/${house.id}"><button class="btn btn-secondary">Cancel</button></a>
			
		</div>
		
	</div>
 	
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>