<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<fieldset>
<center>
<legend><center><b>Upload Project You Want To Share</b></center></legend>
<form action = "upload-project" method = "Post" enctype="multipart/form-data">

         <table cellspacing="5px">
         <tr><td>
         File: </td><td><input type="file" name="userProjectFile" ></td>
         </tr>

       	<tr><td>
         Title: </td><td><input type = "text" name = "userProjectTitle" placeholder="Give Tittle For Project" size="25px">
         </td></tr>

         <tr><td>
         Description:</td> <td><input type = "textarea" name = "userProjectDescription"  placeholder="Descibe your Project" size="25px"> 
         </td></tr>

         <tr><td>
         Tag: </td><td><input type="textarea" name="userProjectTag" size="25px" placeholder="Give Tags for Project">
         </td></tr>

         <tr><td></td><td>
         <input type = "submit" value = "Submit">
         </td></tr>
         </table>
      </form>
</center>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>