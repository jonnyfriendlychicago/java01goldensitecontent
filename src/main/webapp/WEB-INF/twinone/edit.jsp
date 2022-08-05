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
	
	<div id="main" class="container-fluid">
			<div class="row mt-3">
				<div class="col">
				</div> <!-- end col -->
				<div class="col-sm-6">
					<div id="profileContainer" class="container"> 
						<div id="profileCard" class="card p-3 d-md-flex justify-content-start">
							<div class="d-flex justify-content-between">
								
								<div class="card p-2 border-0">
									<p class="m-0 text-secondary" style="font-size: 0.8rem;">
										Created
										<fmt:formatDate value="${twinone.createdAt}" pattern="EEEE"/>,
										<fmt:formatDate value="${twinone.createdAt}" pattern="MMMM dd"/>
										, 
										<fmt:formatDate value="${twinone.createdAt}" pattern="yyyy"/>, 
										<fmt:formatDate value="${twinone.createdAt}" pattern="h:mm a"/>
										</p>
								</div>
								
								<a href="/twinone/${twinone.id}"><button class="btn btn-secondary  mb-2">Cancel</button></a>
								
								
							</div>
							<form:form action='/twinone/edit' method='post' modelAttribute='twinone'>
						
								<form:input type="hidden"  path="id" />
								
								<div class="form-floating mb-3">
									<form:input path="twinoneName" type="text" class="form-control" id="twinoneName" placeholder="twinoneName"/>
									<form:label path="twinoneName" for="twinoneName">twinoneName</form:label>
									<p class="text-danger"><form:errors path="twinoneName" />
								</div>							
								
								<div class="card p-2 border-0">
									<p class="m-0 text-secondary" style="font-size: 0.8rem;">Created by</p>
									<p class="m-0">${twinone.userMdl.userName}</p>
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
								
					
							<%-- <div class="form-group">
								<form:label path="twinoneName" for="twinoneName">twinoneName</form:label>
								<form:input type="text" class="form-control" path="twinoneName"/>
								<p class="errorText"><form:errors path="twinoneName" />
								</p>
							</div>
				 
							<div class="form-group">
								<form:label path="twinoneDesc" for="twinoneDesc">twinoneDesc</form:label>
								<form:textarea type="text" class="form-control" path="twinoneDesc" />
								<p class="errorText"><form:errors path="twinoneDesc" /></p>
							</div> 	
							
							<div class="form-group">
								<form:label path="twinoneDate" for="twinoneDate">twinoneDate</form:label>
								<form:input type="date" class="form-control" path="twinoneDate" />
								<p class="errorText"><form:errors path="twinoneDate" /></p>
							</div>
							
							<div class="form-group">
								<form:label path="twinoneFloat" for="twinoneFloat">twinoneFloat</form:label>
								<form:input type="number" class="form-control" path="twinoneFloat" min="0.00" step="0.01"/>
								<p class="errorText"><form:errors path="twinoneFloat" /></p>
							</div>
							
							<div class="form-group">
								<form:label path="twinoneInt" for="twinoneInt">twinoneInt</form:label>
								<form:input type="number" class="form-control" path="twinoneInt" min="0" step="1"/>
								<p class="errorText"><form:errors path="twinoneInt" /></p>
							</div>
							
							<div class="form-group">
								<form:label path="twinoneLookup" for="twinoneLookup">twinoneLookup</form:label>
								<form:select path="twinoneLookup">
									<form:option value="A" path="twinoneLookup">A</form:option>
									<form:option value="B" path="twinoneLookup">B</form:option>
									<form:option value="C" path="twinoneLookup">C</form:option>
								</form:select>
							</div>
							
							<div class="form-group">
								<form:label path="houseMdl" for="houseMdl">House:</form:label>
								<form:select path="houseMdl">
									<c:forEach var="record" items="${houseList}">
										<c:choose>
											<c:when test="${twinone.houseMdl.id == record.id}">	
												<option value="${record.id}" selected >
													<c:out value="${record.houseName}" />
												</option>
											</c:when>
											<c:otherwise>
												<option value="${record.id}">
													<c:out value="${record.houseName}" />
												</option>
											</c:otherwise>
										</c:choose>
											
									</c:forEach>
								</form:select>
							</div> --%>
							
							<div>
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form:form>
				
						<form action="/twinone/${twinone.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <button class="btn btn-danger">Delete this Twinone</button>
						</form>
						
					</div> <!-- end profileCard -->
				</div> <!-- end profileContainer -->
			</div> <!-- end col -->
			<div class="col">
				<%-- <form action="/twinone/${twinone.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <button class="btn btn-danger">Delete this Twinone</button>
				</form> --%>
			</div> <!-- end col -->
		</div> <!-- end row -->
		
		<div id=list class="card">
			<h3>Twintwo List</h3>

			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">twintwoName</th>
						<th scope="col">actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${assignedCategories}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/twintwo/${record.id}">${record.twintwoName}</a></td>
 								
							<td>
								<form action="/removeTwinoneTwintwoJoin" method="post">
								    
								    <input type="hidden" name="_method" value="delete">
								    <input type="hidden" name="twintwoId" value="${record.id}"/>
								    <input type="hidden" name="twinoneId" value="${twinone.id}"/>
								    <!-- <input type="hidden" name="origin" value="1"/> -->
								    
								    <button class="btn btn-danger">Delete</button>
								</form>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id=form class="card">
			<h2>Add a Twintwo:</h2>
			<form action='/twinone/${twinone.id}/editTwintwoJoins' method='post' >
				<div class="form-group">
					<select name="twintwoId"> 
						<c:forEach var="record" items="${unassignedCategories}">
							<option value="${record.id}" >
								<c:out value="${record.twintwoName}" />
							</option>
						</c:forEach>
					</select>
				</div>
 				
 				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>

		
	</div> <!-- end main -->
 	
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>