<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.nus.cs.util.Constants" %>
<%@ page session="false"%>
<html>
<head>
<title>Buffer Cache</title>
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
						<li><a href="afterlogin">Overall Database</a></li>
						<li><a href="sp">Shared Pool</a></li>
						<li class="active"><a href="bc">Buffer Cache</a></li>
						<li><a href="rlb">Redo Log Buffer</a></li>
						<li><a href="rlf">Redo Log Files</a></li>
						<li><a href="ma">Memory Area</a></li>
						<li><a href="rpt">Database Report</a></li>
						<li><a href="th">Threshold Setting</a></li>
						<li><a href="debug">Debug Mode</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<c:set var="HEALTHY" value="<%=Constants.HEALTHY %>" />
	<c:set var="MODERATE" value="<%=Constants.MODERATE %>" />
	<!--  display area -->
	<form method="post" action="/cs/bc3">
		<div class="container" align="center">
			<table width="800" cellspacing="0" cellpadding="0" border="0"
				align="center">
				<tbody>
					<tr>
						<td align="center" valign="middle"
							style="padding: 30px; width: 100%;">
							<h1>Buffer Cache</h1>
						</td>
					</tr>
					<tr>
						<td valign="middle" style="padding: 30px; width: 100%;">
							<div class="box_title">
								<h3>
									<span class="boxtitle"> <i>Second Level Details</i>
									</span>
								</h3>
							</div>
							<table border="0" width="100%">
								<tr align="center" bgcolor="#1B1B1B">
									<th><font color="#F2F2F2">Select</font></th>
									<th><font color="#F2F2F2">S/N</font></th>
									<th><font color="#F2F2F2">Start Time</font></th>
									<th><font color="#F2F2F2">End Time</font></th>
									<th><font color="#F2F2F2">Buffer Cache Hit Ratio</font></th>
									<th><font color="#F2F2F2">Status</font></th>
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
									<tr align="center" bgcolor="#FAFAFA">
										<%
											} else {
										%>
									
									<tr align="center" bgcolor="#F2F2F2">
										<%
											}
										%>
										<td><h5>
												<input type="radio" name="startend" checked="checked"
													value="${dbTO.startTime},${dbTO.endTime}">
											</h5></td>
										<td><h5><%=i%></h5></td>
										<td><h5>
												<c:out value="${dbTO.startTime}" />
											</h5></td>
										<td><h5>
												<c:out value="${dbTO.endTime}" />
											</h5></td>
										<td><h5>
												<fmt:formatNumber type="percent" minFractionDigits="2"
													maxFractionDigits="2" value="${dbTO.avgValue/100}" />
											</h5></td>
										<c:choose>
											<c:when test="${dbTO.status == HEALTHY}">
												<td style="color: #00FF00">
											</c:when>
											<c:when test="${dbTO.status == MODERATE}">
												<td style="color: #FFBF00">
											</c:when>
											<c:otherwise>
												<td style="color: #DF0101">
												<a href="advisor?attention=BufferCache" style="color: #DF0101">
											</c:otherwise>
										</c:choose>
										<h5>
											<c:out value="${dbTO.status}" />
										</h5>
										<c:choose>
											<c:when test="${dbTO.status == HEALTHY}">
												
											</c:when>
											<c:when test="${dbTO.status == MODERATE}">
												
											</c:when>
											<c:otherwise>
												</a>
											</c:otherwise>
										</c:choose>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="middle" style="padding: 30px; width: 100%;">
							<div class="box_title">
								<h4>
									<span class="boxtitle"> <i>Low Level Details</i>
									</span>
								</h4>
								<h5>(Please select one of the records above)</h5>
							</div>
							<table border="0" width="100%">
								<tr align="center">
									<td><h5>Interval Y (Min)</h5></td>
									<td><input type="text" name="y" value="15" /></td>
								</tr>
								<tr align="center">
									<td colspan="2"><input type="submit" name="Submit" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>