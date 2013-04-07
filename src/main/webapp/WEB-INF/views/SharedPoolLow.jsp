<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Shared Pool</title>
<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css"
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
						<li><a href="afterlogin">Home</a></li>
						<li><a href="dbi">Overall DataBase</a></li>
						<li class="active"><a href="sp">Shared Pool</a></li>
						<li><a href="bc">Buffer Cache</a></li>
						<li><a href="rl">Redo Log Buffer/Files</a></li>
						<li><a href="ma">Memory Area</a></li>
						<li><a href="db">Debug mode</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!--  display area -->
	<div class="container" align="center">
		<table width="800" cellspacing="0" cellpadding="0" border="0"
			align="center">
			<tbody>
				<tr>
					<td align="center" valign="middle"
						style="padding: 30px; width: 100%;">
						<h1>Shared Pool</h1>
					</td>
				<tr>
					<td valign="middle" style="padding: 30px; width: 100%;">
						<div class="box_title">
							<h3>
								<span class="boxtitle"> <i>Low Level Details</i>
								</span>
							</h3>
						</div>
						<table border="0" width="100%">
							<tr align="center">
								<th>S/N</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Average Value</th>
								<th>Status</th>
							</tr>
							<%
								int i = 0;
							%>
							<c:forEach items="${dbTOList}" var="dbTO">
								<%
									i++;
								%>
								<tr align="center">
									<td><%=i%></td>
									<td><c:out value="${dbTO.startTime}" /></td>
									<td><c:out value="${dbTO.endTime}" /></td>
									<td><c:out value="${dbTO.avgValue}" /></td>
									<td><c:out value="${dbTO.otherData}" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>