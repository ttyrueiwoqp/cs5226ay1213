<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
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
	<div class="container">
		<h1>Hello DB!</h1>
		
		<P>The status on the server is ${status}.</P>
		<p>${welcomeMessage}</p>
		<table>
			<c:forEach items="${someResult}" var="abc">
				<tr>
					<td><c:out value="${abc.x}"/></td>
					<td>table table </td>
					<td><c:out value="${abc.y}"/></td>
				</tr>		
			</c:forEach>
		</table>
		<form method="post" action="/cs/db">
			<textarea rows="10" cols="30" name="status" ></textarea>
			<input type="submit" value="Add Status"/>
		</form>
	</div>
</body>
</html>