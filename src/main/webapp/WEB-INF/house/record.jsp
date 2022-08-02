<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>House Management</h2>
	</div>
	
	<c:choose>
		<c:when test="${errorMsg != null}">
			<div id="welcome" class="container listContainerStyle" style="width: 80rem">
				<%-- <p>${errorMsg}</p> --%>
				<p class="errorText">${errorMsg}</p>
			</div>	
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
		
	<div id=main class="container-fluid">
		<div id="recordHeader"> 
			<h3><c:out value="${house.houseName}"></c:out></h3>
<%-- 
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
--%>			
			<a href= "/house/${house.id}/edit"><button class="btn btn-primary">Edit</button></a>
<%-- 
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
--%>
		
<%-- 
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
--%>
					<form action="/house/${house.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <button class="btn btn-danger">Delete this House</button>
					</form>
<%-- 
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
--%>
		</div>
		<div id=about class="card">
			<p>Created by: <c:out value="${house.userMdl.userName}"></c:out>
			<p>Created on: 
			<fmt:formatDate value="${house.createdAt}" pattern="EEEE"/>,
			<fmt:formatDate value="${house.createdAt}" pattern="MMMM dd"/>
			, 
			<fmt:formatDate value="${house.createdAt}" pattern="yyyy"/>, 
			<fmt:formatDate value="${house.createdAt}" pattern="h:mm a"/>
			</p>
		</div>
		
		<div id=list class="card">
			<h3>Twinone List</h3>
			<a href= "/twinone/new"><button class="btn btn-primary">Create New Twinone</button></a>
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">twinoneName</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${childTwinone}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		

	</div>
 
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>