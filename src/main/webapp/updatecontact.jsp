<%@page import="com.example.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navber.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/updatecontact.css">
</head>
<body>
<%Contact contact=(Contact) request.getAttribute("contact");%>
	<div class="updatecontact">
	<form id="myform" action="updatecontact" method="post">
	<h1>Edit Contact</h1>
        <table>
        <tr>
                <td><input type="text" name="contactid" value="<%=contact.getContactId()%>" hidden="true"></td>
            </tr>
            <tr>
                <td>Contact Name:</td>
                <td><input type="text" name="contactname" placeholder="Enter Contact Name" value="<%=contact.getContactName()%>"></td>
            </tr>
            <tr>
                <td>Contact Number:</td>
                <td><input type="number" name="contactnumber" placeholder="Enter Contact Number" value="<%=contact.getContactNumber()%>"></td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Update</button>
                </td>
            </tr>
        </table>
	</form>
	</div>
</body>
</html>