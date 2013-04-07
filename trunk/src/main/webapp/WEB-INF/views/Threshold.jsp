<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Thresholds Configuration</title>
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
<div>
<table width="800" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr>
			<td valign="top" style="padding: 0px; width: 100%;">
			<div>
				<table width="100%">
					<tr>
						<td align="left" valign="middle"
							style="padding: 20px; width: 100%;">
							<h1>Thresholds Setting</h1>
						</td>
					</tr>
				</table>
			</div>
			<div align="left">
			<form action="/cs/th" method="post">
			<table width="100%"> 
				<thead>
					<tr>
						<th align="left">Database Parameter</th>
						<th align="left">Metric Name</th>
						<th align="left">Warning</th>
						<th align="left">Alert</th>	
					</tr>								
				</thead>
				<!-- Shared Pool -->
				<tr>
					<td align="left" width="30%">Shared Pool</td>
					<td align="left" width="40%">Shared Pool Free %</td>
                    <td align="left" width="15%"><input type="text" value="75"/></td>
					<td align="left" width="15%"><input type="text" value="85"/></td>						
				</tr>
				<!-- Buffer Cache -->
				<tr>
					<td align="left" width="30%">Buffer Cache</td>
					<td align="left" width="40%">Buffer Cache Hit Ratio</td>
                    <td align="left" width="15%"><input type="text" value="65"/></td>
					<td align="left" width="15%"><input type="text" value="80"/></td>						
				</tr>
				<!-- Redo Log Buffer -->
				<tr>
					<td align="left" width="30%">Redo Log Buffer</td>
					<td align="left" width="40%">Redo Allocation Hit Ratio</td>
                    <td align="left" width="15%"><input type="text" value="65"/></td>
					<td align="left" width="15%"><input type="text" value="95"/></td>						
				</tr>
				<!-- Redo Log Files -->
				<tr>
					<td align="left" width="30%">Redo Log Files</td>
					<td align="left" width="40%">Redo Log Files Total Waits</td>
                    <td align="left" width="15%"><input type="text" value="1000"/></td>
					<td align="left" width="15%"><input type="text" value="7000"/></td>						
				</tr>
				<!-- Memory Area For Sort -->
				<tr>
					<td align="left" width="30%">Memory Area For Sort</td>
					<td align="left" width="40%">Memory Sorts Ratio</td>
                    <td align="left" width="15%"><input type="text" value="85"/></td>
					<td align="left" width="15%"><input type="text" value="60"/></td>						
				</tr>	
			</table>
				<div align="right"><input type="submit" value="Update"/></div>		
			</form>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>

