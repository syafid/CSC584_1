<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Student</title>
    </head>
    <body>
        <table>
        <tr>
            <th>Service Id</th>
            <th>Service Name</th>
        </tr>
        <tr>
          <c:forEach var="studentList" items="${studentList}">
		        <tr>  
		            <td>${studentList.getID()}</td>
		            <td>${studentList.getName()}</td>
		        </tr>
    	</c:forEach>
        </tr>
        </table>
    </body>
</html>