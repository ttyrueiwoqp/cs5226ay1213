<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<tr align="center" bgcolor="#1B1B1B">
								<th><font color="#FAFAFA">S/N</font></th>
								<th><font color="#FAFAFA">Start Time</font></th>
								<th><font color="#FAFAFA">End Time</font></th>
								<th><font color="#FAFAFA">Average Value</font></th>
								<th><font color="#FAFAFA">Status</font></th>
							</tr>
							<%
								int i = 0;
							%>
							<c:forEach items="${dbTOList}" var="dbTO">
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
									%><td><h5><%=i%></h5></td>
									<td><h5>
											<c:out value="${dbTO.startTime}" />
										</h5></td>
									<td><h5>
											<c:out value="${dbTO.endTime}" />
										</h5></td>
									<td><h5>
											<fmt:formatNumber type="percent" maxFractionDigits="2"
												value="${dbTO.avgValue/100}" />
										</h5></td>
									<c:choose>
										<c:when test="${dbTO.status == 'HEALTHY'}">
											<td style="color: #00FF00">
										</c:when>
										<c:when test="${dbTO.status == 'MODERATE'}">
											<td style="color: #FFBF00">
										</c:when>
										<c:otherwise>
											<td style="color: #DF0101">
										</c:otherwise>
									</c:choose>
									<h5>
										<c:out value="${dbTO.status}" />
									</h5>
									</td>
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