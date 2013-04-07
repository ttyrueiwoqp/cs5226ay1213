<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Shared Pool</title>
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
						<li class="active"><a href="afterlogin">Home</a></li>
						<li><a href="dbi">Overall DataBase</a></li>
			              <li><a href="sp">Shared Pool</a></li>
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
	<div align="center" class="container"><h1>Shared Pool</h1></div>
	
	<div class="container" align="center">
	<table width="800" cellspacing="0" cellpadding="0" border="2" align="center">
		<tbody>
			<tr>
				<td valign="middle" style="padding: 50px; width: 100%;">
				<div class="box_title"><span class="boxtitle"><h4><i>Overview</i></h4></span></div>
				
				<table border="0" width="100%">
					
					<tr align="center">
						<td>Start Time</td>
						<td>
							<c:out value="${dbTO.startTime}"/>
						</td>
						
					</tr>
					
					<tr align="center">
						<td>End Time</td>
						<td>
							<c:out value="${dbTO.endTime}"/>
						</td>
					</tr>
					
					<tr align="center">
						<td>Average Value</td>
						<td><c:out value="${dbTO.avgValue}"/></td>
					</tr>
					
					<tr align="center">
						<td>Current State</td>
						<td><c:out value="${state}"/></td>
					</tr>
					
					<tr>
						<td align="left"><a href="/cs/sp2?startTime=${dbTO.startTime}&endTime=${dbTO.endTime}">Second</a></td>
					</tr>
				</table>
				
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	
	<div class="container">
		<form method="get" action="/cs/sp2">
			<table width="800" cellspacing="0" cellpadding="0" border="0" align="center">
				<tr>
					<td colspan="2"><h4>Detailed Report</h4></td>
				</tr>
				<tr>
					<td><h4>Start Time (DD/MM/YYYY HH24:MI:SS)</h4></td>
					<td><input type="text" name="startTime" value="${dbTO.startTime}"/></td>
				</tr>
				<tr>
					<td><h4>End Time (DD/MM/YYYY HH24:MI:SS)</h4></td>
					<td><input type="text" name="endTime" value="${dbTO.endTime}"/></td>
				</tr>
				<tr>
					<td><h4>Interval (Min)</h4></td>
					<td><input type="text" name="x" value="60"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" name="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>