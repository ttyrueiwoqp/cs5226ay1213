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
	<div align="left">
	<table width="800" cellspacing="0" cellpadding="0" border="2">
		<tbody>
			<tr>
				<td valign="top" style="padding: 0px; width: 100%;">
				<div class="box_title"><span class="boxtitle">Low Level Breakdown - Shared Pool</span></div>
				<table border="0" width="100%">
					<tr>
						<td width="100%">
							<table width="100%">
								<tr>
									<td>Metric Monitored:</td>
									<td> Here we need to put the metric name</td>
								</tr>
								<tr>
									<td>Start Date:</td>
									<td> Here we need to put the start time of the interval</td>
								</tr>
								<tr>
									<td>End Date:</td>
									<td>Here we need to put the start time of the interval</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="100%" align="center">
						<p>This area is to draw the table for breakdown intervals.</p>
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