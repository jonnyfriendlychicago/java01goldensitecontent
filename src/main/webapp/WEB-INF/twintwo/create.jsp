<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	
	<div id=pageHeader class="container-fluid">
		<h2>Twintwo Management</h2>
	</div>

	<div id=main class="container-fluid">
		<div id=form class="container-fluid">
			<h3>Add a Twintwo</h3>
			<form:form action='/twintwo/new' method='post' modelAttribute='twintwo'>
				
				<div class="form-group">
					<form:label path="twintwoName" for="twintwoName">twintwoName</form:label>
					<form:input type="text" class="form-control" path="twintwoName"/>
					<p class="errorText"><form:errors path="twintwoName" />
					</p>
				</div>

 				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
<%-- 			
			<c:choose>
				<c:when test="${onErrorPath == 'yep' }">
					<a href= "/publication"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 			
 --%>		
 </div>

	
	</div>
	
	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
	<jsp:include page="/WEB-INF/include/footer.jsp"/>
	
</body>
</html>