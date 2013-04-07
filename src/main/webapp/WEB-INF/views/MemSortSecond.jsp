<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page import="java.util.*" %>
<%@ page import="com.nus.cs.domain.*" %>
<html>
<head>
<title>Memory Area Used For Sorting</title>
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
	<div align="left">
	<table width="800" cellspacing="0" cellpadding="0" border="2">
		<tbody>
			<tr>
				<td valign="top" style="padding: 0px; width: 100%;">
				<div class="box_title"><span class="boxtitle">Second Level Breakdown - Memory Area Used For Sorting</span></div>
				<table border="0" width="100%">
					<tr>
						<td width="100%">
							<table width="100%">
								<tr>
									<td>Metric Monitored:</td>
									<td>Memory Sorts Ratio</td>
								</tr>
								<tr>
									<td>Start Date:</td>
									<td>${startTime}</td>
								</tr>
								<tr>
									<td>End Date:</td>
									<td>${endTime}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="100%" align="center">
						<p>
							<div>
								<%
								List<DBTO> results;
								
								results =(List<DBTO>) request.getAttribute("results");
								%>
								<table border="2">
								<thead>
									<tr>
										<td>Row ID</td>
										<td>Time Interval</td>
										<td>Value</td>
									</tr>
								</thead>
								<%  
								Iterator<DBTO> iter = results.iterator();
								int rowCount = 0;
								while(iter.hasNext()) {
									DBTO dbTO = iter.next();
									String start = dbTO.getStartTime(), end = dbTO.getEndTime();
									double avg = dbTO.getAvgValue();
								%>
									<tr> 
										<td>
										<%= rowCount %>
										</td>
									
										<td> <a href="/cs/ma3?startTime=<%= start %>&endTime=<%= end %>">from <%= start %> to <%= end %></a></td> 
									
										<td> 
										<%= avg %>
										</td> 
									</tr>
								<%
									rowCount++;
								}
								%>
								</table>
							</div>
						</p>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>