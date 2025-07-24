<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.moffatbay.models.Reservation" %>
<%@ page import="java.util.List" %>
<%
if (session.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Lookup</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/reservation.css">
</head>
<body>
<nav>
    <div class="logo">Moffat Bay Lodge</div>
    <ul class="navbar">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="cabins.jsp" class="active">Cabins</a></li>
        <li><a href="attractions.jsp">Attractions</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="contact.jsp">Contact</a></li>
        	    <%
	        String user = (String) session.getAttribute("user");
	        if (user != null) {
	    %>
	        <li><a href="ReservationSummaryServlet">Account</a></li>
	        <li><a href="logout.jsp">Logout</a></li>
	    <%
	        } else {
	    %>
	        <li><a href="login.jsp">Login</a></li>
	    <%
	        }
	    %>
    </ul>
</nav>

<div class="login-container">
    <h2>Lookup Reservation</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
<form action="ReservationLookupServlet" method="get" style="display: flex; flex-direction: column; gap: 12px;">
    <label for="reservationNumber">Reservation Number:</label>
    <input type="number" name="reservationNumber" id="reservationNumber" class="reservation-input">

    <label for="email">or Email Address:</label>
    <input type="email" name="email" id="email" class="reservation-input">

    <small>Enter either your reservation number or your email address.</small>

    <button type="submit">Lookup</button>
</form>
</div>

<%
Reservation res = (Reservation) request.getAttribute("reservation");
List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");

if (res != null) {
%>
    <div class="room-list">
        <div class="room-card">
            <h2>Reservation #<%= res.getReservationId() %></h2>
            <p><strong>Guest:</strong> <%= res.getGuestName() %></p>
            <p><strong>Room Type:</strong> <%= res.getRoomType() %></p>
            <p><strong>Check-In:</strong> <%= res.getCheckIn() %></p>
            <p><strong>Check-Out:</strong> <%= res.getCheckOut() %></p>
            <p><strong>Guests:</strong> <%= res.getNumGuests() %></p>
            <p><strong>Total Price:</strong> $<%= res.getTotalPrice() %></p>
            <button onclick="location.href='reservation.jsp'">Back to Cabins</button>
        </div>
    </div>
<%
} else if (reservations != null && !reservations.isEmpty()) {
    for (Reservation r : reservations) {
%>
    <div class="room-list">
        <div class="room-card">
            <h2>Reservation #<%= r.getReservationId() %></h2>
            <p><strong>Guest:</strong> <%= r.getGuestName() %></p>
            <p><strong>Room Type:</strong> <%= r.getRoomType() %></p>
            <p><strong>Check-In:</strong> <%= r.getCheckIn() %></p>
            <p><strong>Check-Out:</strong> <%= r.getCheckOut() %></p>
            <p><strong>Guests:</strong> <%= r.getNumGuests() %></p>
            <p><strong>Total Price:</strong> $<%= r.getTotalPrice() %></p>
            <button onclick="location.href='reservation.jsp'">Back to Cabins</button>
        </div>
    </div>
<%
    }
}
%>
</body>
</html>