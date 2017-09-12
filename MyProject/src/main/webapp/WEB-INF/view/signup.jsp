<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
<fieldset>
<center><legend><b>Sign Up</b></legend></center>
<form action="add-user" method="post">
	<table cellspacing="10px;" ">
	<tr>
		<td><input  placeholder="First Name" type="text" name="userFirstName">

			<input placeholder="Last Name" type="text"  name="userLastName" ></td>
	</tr>
	<tr>
		<td><input placeholder="Email" type="text"  name="userEmail" size="45px"></td>
	</tr>
	<tr>
		<td><input placeholder="Password" type="password"  name="userPassword"  size="45px"></td>
	</tr>
	<tr>
	<td><input type="submit" name="Submit" value="Sign Up"></td>
	</tr>
	</table>
</form>
</fieldset>
</center>
<jsp:include page="footer.jsp"></jsp:include>