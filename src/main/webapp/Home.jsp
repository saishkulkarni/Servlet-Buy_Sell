<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Welcome to Buy_Sell</h1><br>

<%
Customer customer=(Customer)session.getAttribute("customer");
if(customer==null)
{
%>
<a href="Login.html"><button>Login</button></a><br><br>
<a href="Signup.html"><button>Signup</button></a><br><br>
<%} %>

<a><button>Buy</button></a><br><br>
<a href="sell"><button>Sell</button></a><br><br>

<%if(customer!=null){
%>
<a href="logout"><button>Logout</button></a><br><br>
<%} %>
</body>
</html>