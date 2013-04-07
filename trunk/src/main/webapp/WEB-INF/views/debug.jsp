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
						<li class="active"><a href="afterlogin">Home</a></li>
						<li><a href="dbi">Overall DataBase</a></li>
			              <li><a href="sp">Shared Pool</a></li>
			              <li><a href="bc">Buffer Cache</a></li>
			              <li><a href="rl">Redo Log Buffer/Files</a></li>
			              <li><a href="ma">Memory Area</a></li>
			              <li><a href="debug">Debug mode</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	
	<div align="center">
		<table>
			<tr><td width="800" height="50">
				<div align="left"><h5>Debug Web Terminal:</h5></div>
				<form method="post" action="/cs/debug">
					<textarea rows="10" cols="300" name="query" style="width: 100%; height: 100%">${query}</textarea> <br/>
					<input type="submit" value="Execute"/>
				</form>
			</td></tr>
			
			<tr><td width="800" height="30">
				<div align="left"><h5>Error Information:</h5></div>
				<textarea rows="10" cols="300" name="info" style="width: 100%; height: 100%">${error}</textarea>
			</td></tr>
			
			<tr><td>
				<div align="left"><h5>Results:</h5></div>
				<div>
					<%
					List<List<String>> table;
					
					table =(List<List<String>>) request.getAttribute("table");
					int num = table.size();
					%>
					<table border="2">
					<%  
					Iterator<List<String>> iter = table.iterator();
					while(iter.hasNext()) {
					%>
						<tr> 
					<%
						List<String> row = iter.next();
						int cols = row.size();
						for(int i=0; i<cols; i++) {
					%>
							<td> 
					<%= 
							row.get(i)
					%> 
							</td> 
					<%
						}
						%>
						</tr>
						<%
					}
						%>
					</table>
					
				</div>
				
			</td></tr>
		</table>
	</div>
</body>
</html>