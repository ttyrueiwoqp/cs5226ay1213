<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.nus.cs.util.Constants"%>
<%@ page session="false"%>
<html>
<head>
<title>Overall Database</title>
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
						<li class="active"><a href="afterlogin">Overall Database</a></li>
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
	<c:set var="HEALTHY" value="<%=Constants.HEALTHY%>" />
	<c:set var="MODERATE" value="<%=Constants.MODERATE%>" />
	<c:set var="ATTENTION" value="<%=Constants.ATTENTION%>" />
	<!--  display area -->
	<div class="container" align="center">
		<table width="800" cellspacing="0" cellpadding="0" border="0"
			align="center">
			<tbody>
				<tr>
					<td align="center" valign="middle"
						style="padding: 30px; width: 100%;">
						<h1>Overall Database</h1>
					</td>
				</tr>
				<tr>
					<td valign="middle"
						style="padding: 30px; width: 100%; background-color: #FAFAFA;">
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
										<c:out value="${spTO.startTime}" />
									</h4></td>
							</tr>
							<tr align="center">
								<td><h4>End Time</h4></td>
								<td><h4>
										<c:out value="${spTO.endTime}" />
									</h4></td>
							</tr>
							<tr align="center">
								<td><h4>Shared Pool</h4></td>
								<c:choose>
									<c:when test="${spTO.status == HEALTHY}">
										<td style="color: #00FF00">
									</c:when>
									<c:when test="${spTO.status == MODERATE}">
										<td style="color: #FFBF00">
									</c:when>
									<c:otherwise>
										<td style="color: #DF0101"><a
											href="advisor?attention=SharedPool" style="color: #DF0101">
									</c:otherwise>
								</c:choose>
								<h4>
									<c:out value="${spTO.status}" />
								</h4>
								<c:if test="${spTO.status == ATTENTION}">
									</a>
								</c:if>
								</td>
							</tr>
							<tr align="center">
								<td><h4>Buffer Cache</h4></td>
								<c:choose>
									<c:when test="${bcTO.status == HEALTHY}">
										<td style="color: #00FF00">
									</c:when>
									<c:when test="${bcTO.status == MODERATE}">
										<td style="color: #FFBF00">
									</c:when>
									<c:otherwise>
										<td style="color: #DF0101"><a
											href="advisor?attention=BufferCache" style="color: #DF0101">
									</c:otherwise>
								</c:choose>
								<h4>
									<c:out value="${bcTO.status}" />
								</h4>
								<c:if test="${bcTO.status == ATTENTION}">
									</a>
								</c:if>
								</td>
							</tr>
							<tr align="center">
								<td><h4>Redo Log Buffer</h4></td>
								<c:choose>
									<c:when test="${rlbTO.status == HEALTHY}">
										<td style="color: #00FF00">
									</c:when>
									<c:when test="${rlbTO.status == MODERATE}">
										<td style="color: #FFBF00">
									</c:when>
									<c:otherwise>
										<td style="color: #DF0101"><a
											href="advisor?attention=RedoLogBuffer" style="color: #DF0101">
									</c:otherwise>
								</c:choose>
								<h4>
									<c:out value="${rlbTO.status}" />
								</h4>
								<c:if test="${rlbTO.status == ATTENTION}">
									</a>
								</c:if>
								</td>
							</tr>
							<tr align="center">
								<td><h4>Redo Log Files</h4></td>
								<c:choose>
									<c:when test="${rlfTO.status == HEALTHY}">
										<td style="color: #00FF00">
									</c:when>
									<c:when test="${rlfTO.status == MODERATE}">
										<td style="color: #FFBF00">
									</c:when>
									<c:otherwise>
										<td style="color: #DF0101"><a
											href="advisor?attention=RedoLogFiles" style="color: #DF0101">
									</c:otherwise>
								</c:choose>
								<h4>
									<c:out value="${rlfTO.status}" />
								</h4>
								<c:if test="${rlfTO.status == ATTENTION}">
									</a>
								</c:if>
								</td>
							</tr>
							<tr align="center">
								<td><h4>Memory Area</h4></td>
								<c:choose>
									<c:when test="${maTO.status == HEALTHY}">
										<td style="color: #00FF00">
									</c:when>
									<c:when test="${maTO.status == MODERATE}">
										<td style="color: #FFBF00">
									</c:when>
									<c:otherwise>
										<td style="color: #DF0101"><a
											href="advisor?attention=MemoryArea" style="color: #DF0101">
									</c:otherwise>
								</c:choose>
								<h4>
									<c:out value="${maTO.status}" />
								</h4>
								<c:if test="${maTO.status == ATTENTION}">
									</a>
								</c:if>
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