<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid p-2 bg-primary text-white text-center">
		<h2>Twinone Management</h2>
	</div>

	<div id="main" class="container-fluid">
		<div id="profileContainer" class="container col-sm-6"> 
			<div id="profileCard" class="card p-3 d-md-flex justify-content-start">
				<a href="/twinone"><button class="btn btn-secondary mb-2">Cancel</button></a>
				<form:form action='/twinone/new' method='post' modelAttribute='twinone'>
				
					<div class="form-floating mb-3">
						<form:input path="twinoneName" type="text" class="form-control" id="twinoneName" placeholder="twinoneName"/>
						<form:label path="twinoneName" for="twinoneName">twinoneName</form:label>
						<p class="text-danger"><form:errors path="twinoneName" />
					</div>
					
					<div class="form-floating mb-3">
						<form:textarea path="twinoneDesc" type="twinoneDesc" class="form-control" id="twinoneDesc" placeholder="twinoneDesc" style="height: 10rem;"/>
						<form:label path="twinoneDesc" for="twinoneDesc">twinoneDesc</form:label>
						<p class="text-danger"><form:errors path="twinoneDesc" />
					</div>
					
					<div class="form-floating mb-3">
						<%-- <form:input type="number" class="form-control" path="twinoneFloat" min="0.00" step="0.01" value="0.00"/> --%>
						<form:input path="twinoneFloat" type="number" class="form-control" id="twinoneFloat" placeholder="twinoneFloat" min="0.00" step="0.01" value="0.00"/>
						<form:label path="twinoneFloat" for="twinoneFloat">twinoneFloat</form:label>
						<p class="text-danger"><form:errors path="twinoneFloat" />
					</div>
					
					<div class="form-floating mb-3">
						<%-- <form:input type="number" class="form-control" path="twinoneInt" min="0" step="1" value="0"/> --%>
						<form:input path="twinoneInt" type="number" class="form-control" id="twinoneInt" placeholder="twinoneInt" min="0" step="1" value="0"/>
						<form:label path="twinoneInt" for="twinoneInt">twinoneInt</form:label>
						<p class="text-danger"><form:errors path="twinoneInt" />
					</div>

					<div class="form-floating mb-3">
						<form:select path="twinoneLookup" class="form-control" id="twinoneLookup" placeholder="A" >
							<form:option value="A" path="twinoneLookup">A</form:option>
							<form:option value="B" path="twinoneLookup">B</form:option>
							<form:option value="C" path="twinoneLookup">C</form:option>
						</form:select>
						<form:label path="twinoneLookup" for="twinoneLookup">twinoneLookup:</form:label>
					</div>
				
					<div class="form-floating mb-3">
						<form:input path="twinoneDate" type="date" class="form-control" id="twinoneDate" placeholder="twinoneDate"/>
						<form:label path="twinoneDate" for="twinoneDate">twinoneDate</form:label>
						<p class="errorText"><form:errors path="twinoneDate" /></p>
					</div>
					
					<div class="form-floating mb-3">
						<form:select path="houseMdl" class="form-control" id="houseMdl" placeholder="A">
							<c:forEach var="record" items="${houseList}">
								<form:option value="${record.id}" path="houseMdl">
									<c:out value="${record.houseName}" />
								</form:option>
							</c:forEach>
						</form:select>
						<form:label path="houseMdl" for="houseMdl">House:</form:label>
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary w-100">Save New Twinone</button>
					</div>
				</form:form>
	
				

			</div> <!-- end profileCard -->
		</div> <!-- end profileContainer -->
	</div> <!-- end main -->
	


	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
	<jsp:include page="/WEB-INF/include/footer.jsp"/>
	
</body>
</html>