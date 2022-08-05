<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid p-2 bg-primary text-white text-center">
		<h2>Twinone Management</h2>
	</div>
		
	<div id=main class="container-fluid">
		
		<c:choose>
			<c:when test="${errorMsg != null}">
				<div id="errorMsg" class="alert-danger alert-dismissible">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<p class="errorText">${errorMsg}</p>
				</div>	
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<div id="twinoneList" class="container my-5 ">
			<h3>Twinone List</h3>
			<a href= "/twinone/new"><button class="btn btn-primary">Create New Twinone</button></a>
			<table class="table table-striped table-dark table-hover table-bordered table-responsive my-2">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">twinoneName</th>
						<th scope="col">createdBy</th>
						<th scope="col">created</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${twinoneList}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>
							<td><a href="/profile/${record.userMdl.id}">${record.userMdl.userName}</a></td>
							<td>
								<fmt:formatDate value="${record.createdAt}" pattern="MMMM dd"/>, <fmt:formatDate value="${record.createdAt}" pattern="yyyy"/>, <fmt:formatDate value="${record.createdAt}" pattern="h:mm a"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> <!-- end twinoneList -->
		
<%-- 		<div id="twinoneForm" class="container">
			<h3>Quick Twinone Entry</h3>
			<form:form action='/twinone/newFromList' method='post' modelAttribute='twinone'>
				
				<div class="form-group">
					<form:label path="twinoneName" for="twinoneName">twinoneName</form:label>
					<form:input type="text" class="form-control" path="twinoneName"/>
					<p class="errorText"><form:errors path="twinoneName"/>
					</p>
				</div>
				
				<div class="form-group">
					<form:label path="twinoneDesc" for="twinoneDesc">twinoneDesc</form:label>
					<form:textarea type="text" class="form-control" path="twinoneDesc" />
					<p class="errorText"><form:errors path="twinoneDesc" /></p>
				</div> 				
		
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		
			<c:choose>
				<c:when test="${path == 'errorOnCreate' }">
					<a href= "/twinone"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 			
		</div> <!-- end twinoneForm -->

 --%>	
	</div> <!-- end main -->  
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>