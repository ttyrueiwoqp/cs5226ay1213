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
						<li><a href="afterlogin">Overall Database</a></li>
						<li><a href="sp">Shared Pool</a></li>
						<li><a href="bc">Buffer Cache</a></li>
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
<div>
<!--  display area -->
<div class="container" align="center">
<table width="800" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr>
			<td valign="top" style="padding: 0px; width: 100%;">
			<div>
				<table width="100%">
					<tr>
						<td align="center" valign="middle"
							style="padding: 30px; width: 100%;">
							<h1>Threshold Setting</h1>
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
                    <td align="left" width="15%"><input name="sp1" type="text" value="<c:out value="${thredTO.sp1}" />"/></td>
					<td align="left" width="15%"><input name="sp2" type="text" value="<c:out value="${thredTO.sp2}" />"/></td>						
				</tr>
				<!-- Buffer Cache -->
				<tr>
					<td align="left" width="30%">Buffer Cache</td>
					<td align="left" width="40%">Buffer Cache Hit Ratio</td>
                    <td align="left" width="15%"><input name="bc1" type="text" value="<c:out value="${thredTO.bc1}" />"/></td>
					<td align="left" width="15%"><input name="bc2" type="text" value="<c:out value="${thredTO.bc2}" />"/></td>						
				</tr>
				<!-- Redo Log Buffer -->
				<tr>
					<td align="left" width="30%">Redo Log Buffer</td>
					<td align="left" width="40%">Redo Allocation Hit Ratio</td>
                    <td align="left" width="15%"><input name="rlb1" type="text" value="<c:out value="${thredTO.rlb1}" />"/></td>
					<td align="left" width="15%"><input name="rlb2" type="text" value="<c:out value="${thredTO.rlb2}" />"/></td>						
				</tr>
				<!-- Redo Log Files -->
				<tr>
					<td align="left" width="30%">Redo Log Files</td>
					<td align="left" width="40%">Redo Log Files Total Waits</td>
                    <td align="left" width="15%"><input name="rlf1" type="text" value="<c:out value="${thredTO.rlf1}" />"/></td>
					<td align="left" width="15%"><input name="rlf2" type="text" value="<c:out value="${thredTO.rlf2}" />"/></td>						
				</tr>
				<!-- Memory Area For Sort -->
				<tr>
					<td align="left" width="30%">Memory Area For Sort</td>
					<td align="left" width="40%">Memory Sorts Ratio</td>
                    <td align="left" width="15%"><input name="ma1" type="text" value="<c:out value="${thredTO.ma1}" />"/></td>
					<td align="left" width="15%"><input name="ma2" type="text" value="<c:out value="${thredTO.ma2}" />"/></td>						
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

