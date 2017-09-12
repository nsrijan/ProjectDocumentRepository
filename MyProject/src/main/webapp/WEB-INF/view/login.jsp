<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
<fieldset >
<center><legend><b> Sign In </b></legend></center>
<form action="login-user" method="post">
	<table cellspacing="5" >
	<tr>
		<td>
			User Name: <td><input type="text" name="userEmail" placeholder="Email" ></td>
		</td>
	</tr>
	<tr>
		<td>
			Password:<td><input type="password" name="userPassword" placeholder="Password" ></td>
		</td>
	</tr>
	<tr><td></td>
		<td>
			<input type="submit" value="Login">
		</td>
	</tr>

	</table>
	</form>
</fieldset>
</center>
<jsp:include page="footer.jsp"></jsp:include>