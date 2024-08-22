<%@page import="com.example.entity.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navber.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
margin: auto;
color: black;
}
a
{
text-decoration: none;
}
a:hover {
	cursor: pointer;
	text-decoration: underline;
	color: red;
}
</style>
</head>
<body>
	<%
	List<Contact> contacts=(List<Contact>)request.getAttribute("contacts");%>
	<table border="2">
	<tr>
	<th colspan="4" align="center">All Contacts</th>
	</tr>
	<tr>
	<th>Name</th>
	<th>Phone Number</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	<%if(contacts!=null){
	for(Contact contact:contacts)
	{%>
		<tr>
		<td><%=contact.getContactName() %></td>
		<td><%=contact.getContactNumber()%></td>
		<td><a href="findcontact?id=<%=contact.getContactId()%>">Edit</a></td>
		<td><a href="deletecontact?id=<%=contact.getContactId()%>">Delete</a></td>
		</tr>
	<%}
		}
	%>
	</table>
</body>
</html>