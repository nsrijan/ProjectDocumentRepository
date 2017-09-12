<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Project</h1>
	<table>
		<c:forEach items="${userProject}" var="project">
		System.out.println("=====>>>>Display"+userProject);
			<tr><td><img alt="" src="<c:url value='/document/${project.userProjectFile }'/>" /></td></tr>
		</c:forEach>
	</table>
</body>
</html>