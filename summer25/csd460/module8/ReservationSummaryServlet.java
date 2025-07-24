package com.moffatbay.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ReservationSummaryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Check for session-based messages (from POST redirect)
        if (session.getAttribute("success") != null) {
            request.setAttribute("success", session.getAttribute("success"));
            session.removeAttribute("success");
        }
        if (session.getAttribute("error") != null) {
            request.setAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }

        String userEmail = (String) session.getAttribute("user");
        List<Map<String, Object>> reservations = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/moffat_bay", "root", "root")) {
                
                // Get user's reservations with room type information
                String sql = "SELECT r.reservation_ID, r.check_in_date, r.check_out_date, " +
                           "r.num_guests, r.total_price, r.status, r.created_at, " +
                           "rt.name as room_name, rt.description as room_description " +
                           "FROM Reservation r " +
                           "JOIN RoomType rt ON r.room_type_id = rt.room_type_id " +
                           "JOIN User u ON r.user_ID = u.user_id " +
                           "WHERE u.email = ? " +
                           "ORDER BY r.check_in_date DESC";
                
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, userEmail);
                    ResultSet rs = stmt.executeQuery();
                    
                    while (rs.next()) {
                        Map<String, Object> reservation = new HashMap<>();
                        reservation.put("id", rs.getInt("reservation_ID"));
                        reservation.put("checkIn", rs.getDate("check_in_date"));
                        reservation.put("checkOut", rs.getDate("check_out_date"));
                        reservation.put("numGuests", rs.getInt("num_guests"));
                        reservation.put("totalPrice", rs.getDouble("total_price"));
                        reservation.put("status", rs.getString("status"));
                        reservation.put("createdAt", rs.getTimestamp("created_at"));
                        reservation.put("roomName", rs.getString("room_name"));
                        reservation.put("roomDescription", rs.getString("room_description"));
                        reservations.add(reservation);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to load reservations. Please try again later.");
        }
        
        // Set reservations as request attribute
        request.setAttribute("reservations", reservations);
        
        // Forward to JSP
        request.getRequestDispatcher("reservationSummary.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Handle reservation cancellation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userEmail = (String) session.getAttribute("user");
        String reservationIdStr = request.getParameter("reservationId");
        String action = request.getParameter("action");

        if ("cancel".equals(action) && reservationIdStr != null && !reservationIdStr.trim().isEmpty()) {
            try {
                int reservationId = Integer.parseInt(reservationIdStr);
                
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/moffat_bay", "root", "root")) {

                    // Verify the reservation belongs to the logged-in user and is cancellable
                    String verifySql = "SELECT r.reservation_ID, r.check_in_date " +
                                     "FROM Reservation r " +
                                     "JOIN User u ON r.user_ID = u.user_id " +
                                     "WHERE r.reservation_ID = ? AND u.email = ? AND r.check_in_date > CURDATE()";
                    
                    boolean canCancel = false;
                    try (PreparedStatement verifyStmt = conn.prepareStatement(verifySql)) {
                        verifyStmt.setInt(1, reservationId);
                        verifyStmt.setString(2, userEmail);
                        ResultSet rs = verifyStmt.executeQuery();
                        canCancel = rs.next();
                    }

                    if (!canCancel) {
                        request.setAttribute("error", "Reservation cannot be cancelled (either not found or check-in date has passed).");
                    } else {
                        // Delete the reservation
                        String deleteSql = "DELETE FROM Reservation WHERE reservation_ID = ?";
                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                            deleteStmt.setInt(1, reservationId);
                            int rowsAffected = deleteStmt.executeUpdate();
                            
                            if (rowsAffected > 0) {
                                // Use session to persist the success message across redirect
                                session.setAttribute("success", "Reservation cancelled successfully!");
                            } else {
                                session.setAttribute("error", "Failed to cancel reservation. Please try again.");
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    session.setAttribute("error", "Database error occurred. Please try again later.");
                }

            } catch (NumberFormatException e) {
                session.setAttribute("error", "Invalid reservation ID.");
            } catch (ClassNotFoundException e) {
                session.setAttribute("error", "Database driver not found.");
            }
        } else {
            session.setAttribute("error", "Invalid cancellation request.");
        }
        
        // Redirect back to GET to refresh the page
        response.sendRedirect("ReservationSummaryServlet");
    }
}
