<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Paul Romer Module 4 -->
<html>
<head>
    <title>User Information</title>
    <style>
        table { border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid black; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Enter Your Information</h2>
    <!-- The form posts back to the same page -->
    <form method="post" action="">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>" /><br/><br/>
        
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>" /><br/><br/>
        
        <label for="age">Age:</label>
        <input type="number" name="age" id="age" value="<%= request.getParameter("age") != null ? request.getParameter("age") : "" %>" /><br/><br/>
        
        <input type="submit" value="Submit" />
    </form>

    <%
        // Retrieve form data when submitted
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        
        // Check if the form has been submitted by ensuring the name is not null
        if (name != null && email != null && age != null && !name.isEmpty() && !email.isEmpty() && !age.isEmpty()) {
    %>
    <h2>Submitted User Information</h2>
    <table>
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Name</td>
            <td><%= name %></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><%= email %></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><%= age %></td>
        </tr>
    </table>
    <%
        }
    %>
</body>
</html>