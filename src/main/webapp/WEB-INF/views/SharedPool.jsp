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
								<span class="boxtitle"> <i>Overview</i>
								</span>
							</h3>
						</div>
						<table border="0" width="100%">
							<tr align="center">
								<td><h4>Start Time</h4></td>
								<td><h4>
										<c:out value="${dbTO.startTime}" />
									</h4></td>
							</tr>
							<tr align="center">
								<td><h4>End Time</h4></td>
								<td><h4>
										<c:out value="${dbTO.endTime}" />
									</h4></td>
							</tr>
							<tr align="center">
								<td><h4>Average Value</h4></td>
								<td><h4>
										<fmt:formatNumber type="percent" maxFractionDigits="2"
											value="${dbTO.avgValue/100}" />
									</h4></td>
							</tr>
							<tr align="center">
								<td><h4>Current Status</h4></td>
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
								<h4>
									<c:out value="${dbTO.status}" />
								</h4>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="middle" style="padding: 30px; width: 100%;">
						<div class="box_title">
							<h4>
								<span class="boxtitle"> <i>Second Level Details</i>
								</span>
							</h4>
						</div>
						<form method="get" action="/cs/sp2">
							<table border="0" width="100%">
								<tr align="center">
									<td><h5>Start Time (DD/MM/YYYY HH24:MI:SS)</h5></td>
									<td><input type="text" name="startTime"
										value="${dbTO.startTime}" /></td>
								</tr>
								<tr align="center">
									<td><h5>End Time (DD/MM/YYYY HH24:MI:SS)</h5></td>
									<td><input type="text" name="endTime"
										value="${dbTO.endTime}" /></td>
								</tr>
								<tr align="center">
									<td><h5>Interval X (Min)</h5></td>
									<td><input type="text" name="x" value="60" /></td>
								</tr>
								<tr align="center">
									<td colspan="2"><input type="submit" name="Submit" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>