<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
						<div id="onetwinchildCard" class="card p-3 d-md-flex justify-content-start">
							
							<div class="card p-2 m-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">
									twinoneName
								</p>
							
								<p class="m-0" style="font-size: 2rem;">
								<a href= "/twinone/${twinone.id}" style="text-decoration: none">${onetwinchild.twinoneMdl.twinoneName}</a>
								</p>
							</div>
							
							<div class="d-flex justify-content-between">
								<div class="card p-2 border-0">
									<p class="m-0 text-secondary" style="font-size: 0.8rem;">
										Created
										<fmt:formatDate value="${onetwinchild.createdAt}" pattern="EEEE"/>,
										<fmt:formatDate value="${onetwinchild.createdAt}" pattern="MMMM dd"/>
										, 
										<fmt:formatDate value="${onetwinchild.createdAt}" pattern="yyyy"/>, 
										<fmt:formatDate value="${onetwinchild.createdAt}" pattern="h:mm a"/>
										</p>
								</div>
								<div>
									<a href= "/onetwinchild/${onetwinchild.id}/edit"><button class="btn btn-primary mb-2">Edit</button></a>
								</div>
							</div>
			
							<div class="card p-2 m-0 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildName</p>
								<%-- <p class="m-0"><c:out value="${onetwinchild.onetwinchildName}"></c:out></p> --%>
								<p class="m-0" style="font-size: 2rem;">${onetwinchild.onetwinchildName}</p>
							</div>
							
							<div class="card p-2 m-0 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">Created by</p>
								<p class="m-0">${onetwinchild.userMdl.userName}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildDesc</p>
								<pre class="textAreaReadOut">${onetwinchild.onetwinchildDesc}</pre>
							</div>

							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildFloat</p>
								<p class="m-0">
									<fmt:formatNumber type="number" pattern="0.00" value="${onetwinchild.onetwinchildFloat}"/>
								</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildInt</p>
								<p class="m-0">${onetwinchild.onetwinchildInt}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildLookup</p>
								<p class="m-0">${onetwinchild.onetwinchildLookup}</p>
							</div>
							
							<div class="card p-2 border-0">
								<p class="m-0 text-secondary" style="font-size: 0.8rem;">onetwinchildDate</p>
								<p class="m-0">
									<fmt:formatDate value="${onetwinchild.onetwinchildDate}" pattern="EEEE"/>,
									<fmt:formatDate value="${onetwinchild.onetwinchildDate}" pattern="MMMM dd"/>
									, 
									<fmt:formatDate value="${onetwinchild.onetwinchildDate}" pattern="yyyy"/>
								</p>
							</div>
							

					</div> <!-- end onetwinchildCard -->
			</div> <!-- end col -->
			<div class="col">
			</div> <!-- end col -->
		</div> <!-- end row -->
	</div><!-- end main -->
 
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>