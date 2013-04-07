<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Interval Settings</title>
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
	<form class="interval-settings" method="post" action="">
			<h2 class="interval-settings-header">Current Settings:</h2>
			<table>
			<tr>  
			<td>
			X (second level breakdown) = 
			</td>
			<td>
			<input type="text" class="interval-value" name="x" />
			</td>
			</tr>
			<tr>
			<td>
			Y (low level breakdown) = 
			</td>
			<td>
			<input type="text" class="interval-value" name="y" /> 	
			</td>
			</tr>	
			<tr>
			<td>
			</td>
			<td align="right">
			<input type="submit" value="Update" />
			</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>