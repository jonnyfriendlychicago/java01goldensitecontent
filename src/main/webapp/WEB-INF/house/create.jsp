<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid p-5 bg-primary text-white text-center">
		<h2>House Management</h2>
	</div>

	<div id=main class="container-fluid">
		
		<c:choose>
			<c:when test="${errorMsg != null}">
				<div id="errorMsg" class="container">
					<p class="errorText">${errorMsg}</p>
				</div>	
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<div id=form class="container">
			<h3>Create a House</h3>
			<form:form action='/house/new' method='post' modelAttribute='house'>
				
				<div class="form-group">
					<form:label path="houseName" for="houseName">houseName</form:label>
					<form:input type="text" class="form-control" path="houseName"/>
					<p class="errorText"><form:errors path="houseName"/>
					</p>
				</div>
				
				<div class="form-group">
					<form:label path="houseDesc" for="houseDesc">houseDesc</form:label>
					<form:textarea type="text" class="form-control" path="houseDesc" />
					<p class="errorText"><form:errors path="houseDesc" /></p>
				</div> 				

				<div class="form-group">
					<form:label path="houseDate" for="houseDate">houseDate</form:label>
					<form:input type="date" class="form-control" path="houseDate" />
					<p class="errorText"><form:errors path="houseDate" /></p>
				</div>
				
				<div class="form-group">
					<form:label path="houseFloat" for="houseFloat">houseFloat</form:label>
					<form:input type="number" class="form-control" path="houseFloat" min="0.00" step="0.01" value="0.00"/>
					<p class="errorText"><form:errors path="houseFloat" /></p>
				</div>
				
				<div class="form-group">
					<form:label path="houseInt" for="houseInt">houseInt</form:label>
					<form:input type="number" class="form-control" path="houseInt" min="0" step="1" value="0"/>
					<p class="errorText"><form:errors path="houseInt" /></p>
				</div>
				
				<div class="form-group">
					<form:label path="houseLookup" for="houseLookup">houseLookup:</form:label>
					<form:select path="houseLookup">
						<form:option value="A" path="houseLookup">A</form:option>
						<form:option value="B" path="houseLookup">B</form:option>
						<form:option value="C" path="houseLookup">C</form:option>
					</form:select>
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		
			<c:choose>
				<c:when test="${path == 'errorOnCreate' }">
					<a href= "/house"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 			
		
 </div>

	
	</div>
	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
	<jsp:include page="/WEB-INF/include/footer.jsp"/>
	
</body>
</html>