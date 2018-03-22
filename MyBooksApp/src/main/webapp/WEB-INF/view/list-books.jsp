<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Book List</title>

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
		<div id="content">
			
			<!-- Button: Add book -->
			
			<input type="button"
				   value="Add Book"
				   onclick="window.location.href='showBookFormForAdd'; return flase;"
				   class="add-button" />
		
			<!-- THE BOOK TABLE -->
			<table>
				<tr>
					<th>ISBN</th>
					<th>TITLE</th>
					<th>AUTHOR</th>
					<th>EDITION</th>
				</tr>
				
				<c:forEach var="tempBook" items="${books}">
				
					<c:url var="updateLink" value="/book/showBookFormForUpdate">
						<c:param name="bookIsbn" value="${tempBook.isbn}" />
					</c:url>
					
					<c:url var="deleteLink" value="/book/delete">
						<c:param name="bookIsbn" value="${tempBook.isbn}" />
					</c:url>
				
					<tr>
						<td>${tempBook.isbn}</td>
						<td>${tempBook.title}</td>
						<td>${tempBook.author}</td>
						<td>${tempBook.edition}</td>
					
						<td>
							<!-- The update link -->
							<a href="${updateLink}" >Update</a>
						</td>
						
						<td>
							<!-- The update link -->
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false" >Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>	
	</div>
	
</body>

</html>