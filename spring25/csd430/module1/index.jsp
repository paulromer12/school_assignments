<!--Paul Romer, Module 1 CSD430-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <!-- Directive -->
<!DOCTYPE html>
<html>
<head>
    <title>JSP Scriptlet Example</title>
</head>
<body>
    <h1>Paul Romer - Module 1 Assignment</h1>
    <hr>
    <br>
    <h1>Number Loop in JSP</h1>
    <ul> <!-- A loop in java, creating a list from 1-5 -->
        <% 
            for (int i = 1; i <= 5; i++) { 
        %>
            <li>Number: <%= i %></li>
        <% 
            } 
        %>
    </ul>
</body>
</html>