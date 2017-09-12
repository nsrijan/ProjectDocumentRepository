<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Project</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<div id="container">
		<div id="login">
			<form action="login" mehtod="get">

				<input type="submit" name="login" value="Log In or Sign up">

			</form>
		</div>
		<div id="header">
			<div id="title">
				<img src="${pageContext.request.contextPath}/photo/logo.jpg">
				<p class="head">Project Documet Repository
				<p>
				<p class="follow">Explore to change...</p>

			</div>
			<div id="menubar">
				<ul>

					<li><a href="${pageContext.request.contextPath}/index">Home</a></li>
					<li><a href="#">News</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">Queries</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<li><a href="${pageContext.request.contextPath}/home">Demo</a></li>
					<li
						style="position: absolute; left: 700px; right: 150px; top: 160px;">
						<form action="searchProject" method="get">
							<input type="text" name="search"
								placeholder="What are you looking for?" size="50%"> <input
								type="submit" name="searchButton" value="Search">

						</form>
					</li>
				</ul>
			</div>

		</div>