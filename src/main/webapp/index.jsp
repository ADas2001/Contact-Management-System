<%@page import="com.example.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="navber.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="StyleSheets/index.css">
</head>
<body>

<% User user=(User)session.getAttribute("user"); 
String addContact=user != null ? "addcontact.jsp":"login.jsp";
String manageContact=user != null ? "managecontact":"login.jsp";
String manageProfile=user != null ? "manageprofile.jsp":"login.jsp";
if(user!=null){
%>
<h1 class="page-title">Welcome Back <%=user.getUserName()%></h1>
<%} %>
<a href="<%=addContact%>" class="menu-link">Add Contact</a>
<a href="<%=manageContact%>" class="menu-link">Manage Contact</a>
<a href="<%=manageProfile%>" class="menu-link">Manage Profile</a>
</body>
</html>