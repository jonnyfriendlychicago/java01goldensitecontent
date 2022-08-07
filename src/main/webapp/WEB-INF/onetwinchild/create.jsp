<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid p-2 bg-primary text-white text-center">
		<h2>Onetwinchild Management</h2>
	</div>

	<div id="main" class="container-fluid">
			<div class="row mt-3">
				<div class="col">
				</div> <!-- end col -->
				<div class="col-sm-7">
					<div id="twinoneCard" class="card p-3 d-md-flex justify-content-start">
						
						<div class="card p-2 mb-2">
							<p class="m-0 text-secondary" style="font-size: 0.8rem;">
								twinoneName
							</p>
						
							<p class="m-0" style="font-size: 2rem;">
								<a href= "/twinone/${twinone.id}" style="text-decoration: none">${twinone.twinoneName}</a>
							</p>
						</div>
							
						<div class="d-flex justify-content-end">
							<%-- <a href="/twinone/${twinone.id}"><button class="btn btn-secondary  mb-2">Cancel</button></a> --%>
							<a href="/twinone"><button class="btn btn-secondary mb-2">Cancel New Onetwinchild</button></a>
						</div>
						
						<form:form action='/twinone/${twinone.id}/onetwinchild/create' method='post' modelAttribute='onetwinchild'>
						
							<div class="form-floating mb-3">
								<form:input path="onetwinchildName" type="text" class="form-control" id="onetwinchildName" placeholder="onetwinchildName"/>
								<form:label path="onetwinchildName" for="onetwinchildName">onetwinchildName</form:label>
								<p class="text-danger"><form:errors path="onetwinchildName" />
							</div>
							
							<div class="form-floating mb-3">
								<form:textarea path="onetwinchildDesc" type="onetwinchildDesc" class="form-control" id="onetwinchildDesc" placeholder="onetwinchildDesc" style="height: 10rem;"/>
								<form:label path="onetwinchildDesc" for="onetwinchildDesc">onetwinchildDesc</form:label>
								<p class="text-danger"><form:errors path="onetwinchildDesc" />
							</div>
							
							<div class="form-floating mb-3">
								<%-- <form:input type="number" class="form-control" path="onetwinchildFloat" min="0.00" step="0.01" value="0.00"/> --%>
								<form:input path="onetwinchildFloat" type="number" class="form-control" id="onetwinchildFloat" placeholder="onetwinchildFloat" min="0.00" step="0.01" value="0.00"/>
								<form:label path="onetwinchildFloat" for="onetwinchildFloat">onetwinchildFloat</form:label>
								<p class="text-danger"><form:errors path="onetwinchildFloat" />
							</div>
							
							<div class="form-floating mb-3">
								<%-- <form:input type="number" class="form-control" path="onetwinchildInt" min="0" step="1" value="0"/> --%>
								<form:input path="onetwinchildInt" type="number" class="form-control" id="onetwinchildInt" placeholder="onetwinchildInt" min="0" step="1" value="0"/>
								<form:label path="onetwinchildInt" for="onetwinchildInt">onetwinchildInt</form:label>
								<p class="text-danger"><form:errors path="onetwinchildInt" />
							</div>
		
							<div class="form-floating mb-3">
								<form:select path="onetwinchildLookup" class="form-control" id="onetwinchildLookup" placeholder="A" >
									<form:option value="A" path="onetwinchildLookup">A</form:option>
									<form:option value="B" path="onetwinchildLookup">B</form:option>
									<form:option value="C" path="onetwinchildLookup">C</form:option>
								</form:select>
								<form:label path="onetwinchildLookup" for="onetwinchildLookup">onetwinchildLookup:</form:label>
							</div>
						
							<div class="form-floating mb-3">
								<form:input path="onetwinchildDate" type="date" class="form-control" id="onetwinchildDate" placeholder="onetwinchildDate"/>
								<form:label path="onetwinchildDate" for="onetwinchildDate">onetwinchildDate</form:label>
								<p class="errorText"><form:errors path="onetwinchildDate" /></p>
							</div>
							
<%-- 							<div class="form-floating mb-3">
								<form:select path="houseMdl" class="form-control" id="houseMdl" placeholder="A">
									<c:forEach var="record" items="${houseList}">
										<form:option value="${record.id}" path="houseMdl">
											<c:out value="${record.houseName}" />
										</form:option>
									</c:forEach>
								</form:select>
								<form:label path="houseMdl" for="houseMdl">House:</form:label>
							</div> --%>
							
							<div>
								<button type="submit" class="btn btn-primary w-100">Save New Onetwinchild</button>
							</div>
						</form:form>
	
					</div> <!-- end twinoneCard -->
				<!-- </div> --> <!-- twinoneContainer -->
				</div> <!-- end col -->
				<div class="col">
				</div> <!-- end col -->
			</div> <!-- end row -->
	</div> <!-- end main -->

	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
	<jsp:include page="/WEB-INF/include/footer.jsp"/>
	
</body>
</html>