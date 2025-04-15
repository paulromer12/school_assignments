<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paul Romer CSD430 Module 2 Assignment</title>
</head>
<body>
<h1>Paul Romer Module 2 Assignment</h1>
<h2>Scriplet 1</h2>
<%@ page import="java.sql.*" %>
<%@page import="java.util.*"%>

<!-- commented out the first scriplet since it involves calling a db. Included word doc with screenshot -->
<%--
    // JDBC connection parameters
    String url = "jdbc:mysql://localhost:3306/cool_cars";
    String user = "root";
    String password = "password";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Load JDBC driver (if required by your environment)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to the cool_cars database
        conn = DriverManager.getConnection(url, user, password);

        // Create and execute SQL query
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT name FROM cars");

        // Display each car name on a new line
        while (rs.next()) {
            out.println(rs.getString("name") + "<br>");
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } 
    
    conn.close();
--%>

<h2>Scriplet 2</h2>
<%@page import="java.util.Date"%>
Server date and time: <%=new Date()%>

<h2>Scriplet 3</h2>
<%
Enumeration headers = request.getHeaderNames();
int kh = 0;
while (headers.hasMoreElements()) {
String hName = (String)headers.nextElement();
out.println("------- " + hName);
Enumeration hValues = request.getHeaders(hName);
while (hValues.hasMoreElements()) {
out.println("<br/>& nbsp;& nbsp;& nbsp;" + hValues.nextElement());
}
out.println("<br/>");
}
%>

<h2>Scriplet 4</h2>
<h3>User Agent</h3>
<%
String userAgent = request.getHeader("user-agent");
out.println("<br/>user-agent " + userAgent);
%>

<h2>Scriplet 5</h2>
<%
    // Set a cookie
    Cookie myCookie = new Cookie("studentName", "Paul");
    myCookie.setMaxAge(60 * 60); // 1 hour
    response.addCookie(myCookie);

    // Read cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " = " + cookie.getValue() + "<br/>");
        }
    } else {
        out.println("No cookies found.");
    }
%>

<h2>Scriplet 6</h2>
<%
    String studentName = null;
    Cookie[] studentCookies = request.getCookies();
    
    if (studentCookies != null) {
        for (Cookie cookie : studentCookies) {
            if ("studentName".equals(cookie.getName())) {
                studentName = cookie.getValue();
                break;
            }
        }
    }

    if (studentName != null) {
        out.println("Hello, " + studentName + "!");
    } else {
        out.println("Hello, guest! I don't know your name yet.");
    }
%>
</body>
</html>