<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Homes</title>
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
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="/cs">CS5226</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="">Home</a></li>
              <li><a href="dbi">Overall DataBase</a></li>
              <li><a href="sp">Shared Pool</a></li>
              <li><a href="bc">Buffer Cache</a></li>
              <li><a href="rl">Redo Log Buffer/Files</a></li>
              <li><a href="ma">Memory Area</a></li>
              <li><a href="db">Debug mode</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
		<h1>
			Welcome to DBDB!  
		</h1>
		

	</div>
</body>
</html>

