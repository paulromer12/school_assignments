<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Names</title>
</head>
<body>
    <%
        // Declare and initialize a string array
        String[] cars = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW"};
    %>
    <h2>List of Car Names:</h2>
    <ul>
        <% 
            // Use a for-each loop to iterate over the car array
            for(String car : cars) { 
        %>
            <li><%= car %></li>
        <% 
            } 
        %>
    </ul>
</body>
</html>