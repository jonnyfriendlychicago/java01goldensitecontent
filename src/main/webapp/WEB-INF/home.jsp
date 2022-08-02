<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/head.jsp" />

<body>
	<jsp:include page="include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Home</h2>
	</div>

	<div id=main class="container-fluid mainContainer">	
		<div id="welcome" class="container listContainerStyle" style="width: 80rem">
			<h2>Welcome, ${user.userName}</h2>
			<h3>Thanks for being part of our growing community.</h3> 
		</div>

		<c:choose>
			<c:when test="${errorMsg != null}">
				<div id="errorMsg" class="container listContainerStyle" style="width: 80rem">
					<p class="errorText">${errorMsg}</p>
				</div>	
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose> 

<%-- 				
		<div id="listContainer" class="container listContainerStyle" style="width: 80rem"> 
			<div id="houseList">
				<h3>House List</h3>
				<a href= "/house/new"><button class="btn btn-primary">Add House</button></a>

				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Name</th>
							<th scope="col">Created By</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${houseList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/house/${record.id}">${record.houseName}</a></td>
								<td>${record.userMdl.userName} </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div id="twinoneList">
			
				<h3>Twinone List</h3>
				<a href= "/twinone/new"><button class="btn btn-primary">Add Twinone</button></a>
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Name</th>
							<th scope="col">Created By</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${twinoneList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>
								<td>${record.userMdl.userName} </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div id="twintwoList">
			
				<h3>Twintwo List</h3>
				<a href= "/twintwo/new"><button class="btn btn-primary">Add Twintwo</button></a>
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${twintwoList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/twintwo/${record.id}">${record.twintwoName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div id="userList">
			
				<h3>User List</h3>
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">userName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${userList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/profile/${record.id}">${record.userName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>
--%>

	</div>
	
	<jsp:include page="include/footerbuffer.jsp"/>
	<jsp:include page="include/footer.jsp"/>
			
			
</body>
</html>