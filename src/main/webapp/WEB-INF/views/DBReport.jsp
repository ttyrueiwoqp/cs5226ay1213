<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.nus.cs.util.Constants"%>
<%@ page session="false"%>
<html>
<head>
<title>Database Report</title>
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
						<li><a href="bc">Buffer Cache</a></li>
						<li><a href="rlb">Redo Log Buffer</a></li>
						<li><a href="rlf">Redo Log Files</a></li>
						<li><a href="ma">Memory Area</a></li>
						<li class="active"><a href="rpt">Database Report</a></li>
						<li><a href="th">Threshold Setting</a></li>
						<li><a href="debug">Debug Mode</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<c:set var="HEALTHY" value="<%=Constants.HEALTHY%>" />
	<c:set var="MODERATE" value="<%=Constants.MODERATE%>" />
	<!--  display area -->
	<div class="container" align="center">
		<table width="800" cellspacing="0" cellpadding="0" border="0"
			align="center">
			<tbody>
				<tr>
					<td align="center" valign="middle"
						style="padding: 30px; width: 100%;">
						<h1>Database Report</h1>
					</td>
				</tr>
				<tr>
					<td valign="middle" style="padding: 30px; width: 100%; background-color:#F2F2F2;">
						<form method="post" action="/cs/rpt2">
							<table border="0" width="100%">
								<tr align="center">
									<td><h4>Start Time (DD/MM/YYYY HH24:MI:SS)</h4></td>
									<td><input type="text" name="startTime"
										value="${startTime}" /></td>
								</tr>
								<tr align="center">
									<td><h4>End Time (DD/MM/YYYY HH24:MI:SS)</h4></td>
									<td><input type="text" name="endTime"
										value="${endTime}" /></td>
								</tr>
								<tr align="center">
									<td><h4>Interval (Min)</h4></td>
									<td><input type="text" name="x" value="60" /></td>
								</tr>
								<tr align="center">
									<td colspan="2"><input type="submit" value="Generate Report" /></td>
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