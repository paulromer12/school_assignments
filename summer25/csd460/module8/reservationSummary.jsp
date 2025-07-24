<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
    <title>My Reservations - Moffat Bay Lodge</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/reservationSummary.css">
</head>
<body>
    <nav>
        <div class="logo">Moffat Bay Lodge</div>
        <ul class="navbar">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="reservation.jsp">Cabins</a></li>
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

    <main>
        <div class="container">
            <h1>My Reservations</h1>
            
            <!-- Display success/error messages -->
            <% if (request.getAttribute("success") != null) { %>
                <div class="message success"><%= request.getAttribute("success") %></div>
            <% } %>
            <% if (request.getAttribute("error") != null) { %>
                <div class="message error"><%= request.getAttribute("error") %></div>
            <% } %>
            
            <% 
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> reservations = (List<Map<String, Object>>) request.getAttribute("reservations");
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                SimpleDateFormat datetimeFormat = new SimpleDateFormat("MMM dd, yyyy 'at' h:mm a");
                
                if (reservations == null || reservations.isEmpty()) {
            %>
                <div class="no-reservations">
                    <h2>No Reservations Found</h2>
                    <p>You don't have any reservations yet. Ready to plan your getaway?</p>
                    <a href="reservation.jsp" class="book-now-btn">Book a Room</a>
                </div>
            <%
                } else {
            %>
                <div class="reservations-grid">
                    <%
                        for (Map<String, Object> reservation : reservations) {
                            java.util.Date checkIn = (java.util.Date) reservation.get("checkIn");
                            java.util.Date checkOut = (java.util.Date) reservation.get("checkOut");
                            java.util.Date now = new java.util.Date();
                            String statusClass = "";
                            String statusText = "Upcoming"; // Default status
                            
                            // Safely get status from database
                            Object statusObj = reservation.get("status");
                            if (statusObj != null) {
                                statusText = statusObj.toString();
                            }
                            
                            // Determine status based on dates if check-in and check-out dates are available
                            if (checkIn != null && checkOut != null) {
                                if (checkOut.before(now)) {
                                    statusClass = "status-completed";
                                    statusText = "Completed";
                                } else if (checkIn.before(now) && checkOut.after(now)) {
                                    statusClass = "status-active";
                                    statusText = "Active";
                                } else {
                                    statusClass = "status-upcoming";
                                    statusText = "Upcoming";
                                }
                            } else {
                                // Fallback to database status if dates are null
                                statusClass = "status-upcoming";
                            }
                    %>
                        <div class="reservation-card">
                            <div class="reservation-header">
                                <h3><%= reservation.get("roomName") != null ? reservation.get("roomName") : "Unknown Room" %></h3>
                                <span class="status <%= statusClass %>"><%= statusText %></span>
                            </div>
                            
                            <div class="reservation-details">
                                <div class="detail-row">
                                    <span class="label">Reservation ID:</span>
                                    <span class="value">#<%= reservation.get("id") %></span>
                                </div>
                                
                                <div class="detail-row">
                                    <span class="label">Check-in:</span>
                                    <span class="value"><%= checkIn != null ? dateFormat.format(checkIn) : "Not available" %></span>
                                </div>
                                
                                <div class="detail-row">
                                    <span class="label">Check-out:</span>
                                    <span class="value"><%= checkOut != null ? dateFormat.format(checkOut) : "Not available" %></span>
                                </div>
                                
                                <div class="detail-row">
                                    <span class="label">Guests:</span>
                                    <span class="value"><%= reservation.get("numGuests") %> guest<%= (Integer) reservation.get("numGuests") > 1 ? "s" : "" %></span>
                                </div>
                                
                                <div class="detail-row">
                                    <span class="label">Total Price:</span>
                                    <span class="value price">$<%= String.format("%.2f", reservation.get("totalPrice")) %></span>
                                </div>
                                
                                <div class="detail-row">
                                    <span class="label">Booked:</span>
                                    <span class="value"><%= reservation.get("createdAt") != null ? datetimeFormat.format(reservation.get("createdAt")) : "Not available" %></span>
                                </div>
                            </div>
                            
                            <%
                                // Only show cancel button for upcoming reservations (check-in date is in the future)
                                if (checkIn != null && checkIn.after(now)) {
                            %>
                                <div class="reservation-actions">
                                    <form action="ReservationSummaryServlet" method="post" style="display: inline;">
                                        <input type="hidden" name="action" value="cancel">
                                        <input type="hidden" name="reservationId" value="<%= reservation.get("id") %>">
                                        <button type="submit" class="cancel-btn" 
                                                onclick="return confirm('Are you sure you want to cancel this reservation? This action cannot be undone.');">
                                            Cancel Reservation
                                        </button>
                                    </form>
                                </div>
                            <%
                                } else if (checkIn != null && checkIn.before(now) && checkOut.after(now)) {
                            %>
                                <div class="reservation-actions">
                                    <span>Call to Cancel</span>
                                </div>
                            <%
                                }
                            %>
                        </div>
                    <%
                        }
                    %>
                </div>
            <%
                }
            %>
            <%
                // Only show "Book Another Room" button if user has reservations
                if (reservations != null && !reservations.isEmpty()) {
            %>
                <div class="action-buttons">
                    <a href="reservation.jsp" class="book-another-btn">Book Another Room</a>
                </div>
            <%
                }
            %>
        </div>
    </main>
</body>
</html>