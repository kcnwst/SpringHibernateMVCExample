<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Add Book Form</title>
		
		<!-- Reference to style sheet -->
	
		<%-- <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /> --%>
		
	</head>
	
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>Books List Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Book</h3>
			
			<form:form action="saveBook" modelAttribute="book" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>ISBN:</label></td>
							<td><form:input path="isbn" /></td>
						</tr>
						<tr>
							<td><label>TITLE:</label></td>
							<td><form:input path="title" /></td>
						</tr>
						<tr>
							<td><label>AUTHOR:</label></td>
							<td><form:input path="author" /></td>
						</tr>
						<tr>
							<td><label>EDITION:</label></td>
							<td><form:input path="edition" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/book/list" >Back to book list</a>
			</p>
			
		</div>
	
	</body>
</html>