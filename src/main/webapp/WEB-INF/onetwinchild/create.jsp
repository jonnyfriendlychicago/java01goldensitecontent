<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Onetwinchild Management</h2>
	</div>

	<div id=main class="container-fluid">
		<div id="recordHeader"> 
			<h3>twinone Name: <c:out value="${twinone.twinoneName}"></c:out></h3>
        </div>
		<div id=about class="card">
			<p>Created by: <c:out value="${twinone.userMdl.userName}"></c:out>
		</div>
	</div>
	
	<div id=main class="container-fluid">
		<div id=form class="container-fluid">
			<h3>Add a Onetwinchild</h3>
			<form:form action='/twinone/${twinone.id}/onetwinchild' method='post' modelAttribute='onetwinchild'>
				
				<div class="form-group">
					<form:label path="onetwinchildName" for="onetwinchildName">onetwinchildName</form:label>
					<form:input type="text" class="form-control" path="onetwinchildName"/>
					<p class="errorText"><form:errors path="onetwinchildName"/>
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