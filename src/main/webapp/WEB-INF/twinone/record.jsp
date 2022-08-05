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
					<!-- <div id="profileContainer" class="container col-sm-6"> --> 
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
								<div>
									<a href= "/twinone/${twinone.id}/edit"><button class="btn btn-primary mb-2">Edit</button></a>
								</div>
							</div>
			
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneName</p>
								<%-- <p class="m-0"><c:out value="${twinone.twinoneName}"></c:out></p> --%>
								<p class="m-0">${twinone.twinoneName}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">Created by</p>
								<p class="m-0">${twinone.userMdl.userName}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneDesc</p>
								<pre class="textAreaReadOut">${twinone.twinoneDesc}</pre>
							</div>

							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneFloat</p>
								<p class="m-0">
									<fmt:formatNumber type="number" pattern="0.00" value="${twinone.twinoneFloat}"/>
								</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneInt</p>
								<p class="m-0">${twinone.twinoneInt}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneLookup</p>
								<p class="m-0">${twinone.twinoneLookup}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">twinoneDate</p>
								<p class="m-0">
									<fmt:formatDate value="${twinone.twinoneDate}" pattern="EEEE"/>,
									<fmt:formatDate value="${twinone.twinoneDate}" pattern="MMMM dd"/>
									, 
									<fmt:formatDate value="${twinone.twinoneDate}" pattern="yyyy"/>
								</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">houseName</p>
								<p class="m-0">${twinone.houseMdl.houseName}</p>
							</div>

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
		

	</div>
 
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>