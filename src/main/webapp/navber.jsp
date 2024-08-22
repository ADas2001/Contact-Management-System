 <%@page import="com.example.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/navber.css">
</head>
<body>
<%
User user2=(User)session.getAttribute("user");
%>
	<nav class="navber">
        <div class="navber-title">Contact Management System</div>
        <div>
        	<%
       		if(user2!=null){
       		%>
        	<a href="manageprofile.jsp" class="navber-link"><%=user2.getUserName()%></a>
        	<%} %>
       		<a href="index.jsp" class="navber-link">Home</a>
       		<%
       		if(user2==null){
       		%>
            <a href="register.jsp" class="navber-link">Register</a>
            <a href="login.jsp" class="navber-link">Login</a>
            <%
       		} else {
            %>
            <a href="logoutuser" class="navber-link">Logout</a>
            <%
       		}
            %>
        </div>
    </nav>
</body>
</html>