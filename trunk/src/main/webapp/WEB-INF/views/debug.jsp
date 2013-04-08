<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page import="java.util.*" %>
<html>
<head>
<title>DB</title>
<link
	href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css"
	rel="stylesheet">
<link
	href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="http://twitter.github.io/bootstrap/assets/css/docs.css"
	rel="stylesheet">
<link
	href="http://twitter.github.io/bootstrap/assets/js/google-code-prettify/prettify.css"
	rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="/cs">cs5226</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="afterlogin">Overall Database</a></li>
						<li><a href="sp">Shared Pool</a></li>
						<li><a href="bc">Buffer Cache</a></li>
						<li><a href="rlb">Redo Log Buffer</a></li>
						<li><a href="rlf">Redo Log Files</a></li>
						<li><a href="ma">Memory Area</a></li>
						<li><a href="rpt">Database Report</a></li>
						<li><a href="th">Threshold Setting</a></li>
						<li class="active"><a href="debug">Debug Mode</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	
	<div align="center">
		<table>
			<tr><td width="800" height="50" style="padding: 30px;">
				<div align="left"><h4>Debug Web Terminal:</h4></div>
				<form method="post" action="/cs/debug">
					<textarea rows="10" cols="300" name="query" style="width: 100%; height: 100%">${query}</textarea> <br/>
					<input type="submit" value="Execute"/>
				</form>
			</td></tr>
			
			<tr><td width="800" height="30" style="padding: 0px 30px 30px;">
				<div align="left"><h4>Error Information:</h4></div>
				<textarea readonly rows="3" cols="300" name="info" style="width: 100%; height: 100%">${error}</textarea>
			</td></tr>
			
			<tr><td style="padding: 0px 30px 30px;">
				<div align="left"><h4>Results:</h4></div>
				<div>
					<c:choose>
						<c:when test="${success == 'true'}">
							<table border="0" width="100%">
								<tr align="center" bgcolor="#1B1B1B">
									<c:forEach items="${theader}" var="hcol">
										<th><font color="#FAFAFA"><c:out value="${hcol}"></c:out></font></th>
									</c:forEach>
								</tr>
								<%
									int i = 0;
								%>
								<c:forEach items="${table}" var="row">
									<%
										i++;
									%>
									<%
										if ((i % 2) == 0) {
									%>
									<tr align="center" bgcolor="#FFFFFF">
										<%
											} else {
										%>
									
									<tr align="center" bgcolor="#FAFAFA">
										<%
											}
										%>
										<c:forEach items="${row}" var="col">
											<td>
												<c:out value="${col}"></c:out>
											</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</table>
						</c:when>
					</c:choose>
					
				</div>
				
			</td></tr>
		</table>
	</div>
</body>
</html>