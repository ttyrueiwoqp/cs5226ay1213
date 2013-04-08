<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.nus.cs.util.Constants"%>
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
	<div align="center">
		<c:choose> 
		<c:when test="${metric == 'SharedPool'}">
		<table width="800">
		<tr align="left">
			<td>
			<div> <h3><B>Shared Pool</B></h3></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>In init.ora, the parameter <a href="http://docs.oracle.com/cd/B19306_01/server.102/b14237/initparams197.htm">SHARED_POOL_SIZE</a> needs to be increased.</h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>See official Oracle documentation for <a href="http://docs.oracle.com/cd/B19306_01/server.102/b14211/memory.htm#i30970">shared pool memory management.</a></h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div><h4>The table below is the result from Oracle Shared Pool Advisor:</h4></div>
			</td>
		</tr>
		</table>
		
		<table border="1" width="800">
			<tr align="center" bgcolor="#1B1B1B">
				<c:forEach items="${theader}" var="hcol">
					<th><font color="#FAFAFA"><c:out value="${hcol}"></c:out></font></th>
				</c:forEach>
			</tr>
			<%
				int i = 0;
			%>
			<c:forEach items="${table}" var="row">
				<%
					i++;
				%>
				<%
					if ((i % 2) == 0) {
				%>
				<tr align="center" bgcolor="#FFFFFF">
					<%
						} else {
					%>
				
				<tr align="center" bgcolor="#FAFAFA">
					<%
						}
					%>
					<c:forEach items="${row}" var="col">
						<td>
							<c:out value="${col}"></c:out>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		</c:when>
		<c:when test="${metric == 'MemSort'}">
		<table width="800">
		<tr align="left">
			<td>
			<div> <h3><B>Memory Area Used For Sorting</B></h3></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>In init.ora, the parameter <a href="http://docs.oracle.com/cd/B12037_01/server.101/b10755/initparams200.htm">SORT_AREA_SIZE</a> needs to be increased.</h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>See official Oracle documentation for <a href="http://docs.oracle.com/cd/B12037_01/server.101/b10752/memory.htm#49321">PGA memory management.</a></h4></div>
			</td>
		</tr>
		</table>
		</c:when>
		<c:when test="${metric == 'RedoLogBuffer'}">
		<table width="800">
		<tr align="left">
			<td>
			<div> <h3><B>Redo Log Buffer</B></h3></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>In init.ora, the parameter <a href="http://docs.oracle.com/cd/B19306_01/server.102/b14237/initparams108.htm">LOG_BUFFER</a> needs to be increased.</h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>See official Oracle documentation for <a href="http://docs.oracle.com/cd/B12037_01/server.101/b10752/memory.htm#38479"> reasonable estimation of log buffer size.</a></h4></div>
			</td>
		</tr>
		</table>
		</c:when>
		<c:when test="${metric == 'BufferCache'}">
		<table width="800">
		<tr align="left">
			<td>
			<div> <h3><B>Buffer Cache</B></h3></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>In init.ora, the parameter <a href="http://docs.oracle.com/cd/B19306_01/server.102/b14237/initparams043.htm">DB_CACHE_SIZE</a> needs to be increased.</h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div> <h4>See official Oracle documentation for <a href="http://docs.oracle.com/cd/B19306_01/server.102/b14211/memory.htm#i29118">buffer cache management.</a></h4></div>
			</td>
		</tr>
		<tr align="left">
			<td>
			<div><h4>The table below is the result from Oracle Buffer Cache Advisor:</h4></div>
			</td>
		</tr>
		</table>
		
		<table border="1" width="800">
			<tr align="center" bgcolor="#1B1B1B">
				<c:forEach items="${theader}" var="hcol">
					<th><font color="#FAFAFA"><c:out value="${hcol}"></c:out></font></th>
				</c:forEach>
			</tr>
			<%
				int i = 0;
			%>
			<c:forEach items="${table}" var="row">
				<%
					i++;
				%>
				<%
					if ((i % 2) == 0) {
				%>
				<tr align="center" bgcolor="#FFFFFF">
					<%
						} else {
					%>
				
				<tr align="center" bgcolor="#FAFAFA">
					<%
						}
					%>
					<c:forEach items="${row}" var="col">
						<td>
							<c:out value="${col}"></c:out>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
	
	</div>
</body>
</html>