package com.moffatbay.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String email = (String) session.getAttribute("user");

        // Get form inputs
        String roomTypeIdStr = request.getParameter("roomTypeId");
        String numGuestsStr = request.getParameter("numGuests");
        String checkInStr = request.getParameter("checkIn");
        String checkOutStr = request.getParameter("checkOut");
        String totalPriceStr = request.getParameter("totalPrice");

        // Basic validation
        if (roomTypeIdStr == null || numGuestsStr == null || checkInStr == null || checkOutStr == null || totalPriceStr == null) {
            request.setAttribute("error", "Missing reservation details.");
            request.getRequestDispatcher("reserve.jsp").forward(request, response);
            return;
        }

        int roomTypeId = Integer.parseInt(roomTypeIdStr);
        int numGuests = Integer.parseInt(numGuestsStr);
        double totalPrice = Double.parseDouble(totalPriceStr);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/moffat_bay", "root", "root")) { // I have to remove the underscore for it to work with mine - William, also be sure to enter your proper password

                // get the user's ID
                int userId = -1;
                String findUserSql = "SELECT user_id FROM User WHERE email = ?";
                try (PreparedStatement userStmt = conn.prepareStatement(findUserSql)) {
                    userStmt.setString(1, email);
                    ResultSet rs = userStmt.executeQuery();
                    if (rs.next()) {
                        userId = rs.getInt("user_id");
                    } else {
                        request.setAttribute("error", "User not found.");
                        request.getRequestDispatcher("reserve.jsp").forward(request, response);
                        return;
                    }
                }

                // Insert the reservation
                String insertSql = "INSERT INTO Reservation (user_ID, room_type_id, num_guests, check_in_date, check_out_date, total_price, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                    stmt.setInt(1, userId);
                    stmt.setInt(2, roomTypeId);
                    stmt.setInt(3, numGuests);
                    stmt.setDate(4, Date.valueOf(checkInStr));
                    stmt.setDate(5, Date.valueOf(checkOutStr));
                    stmt.setDouble(6, totalPrice);
                    stmt.setString(7, "confirmed");

                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        response.sendRedirect("ReservationSummaryServlet");
                    } else {
                        request.setAttribute("error", "Reservation failed. Please try again.");
                        request.getRequestDispatcher("reserve.jsp").forward(request, response);
                    }
                }

            }

        } catch (ClassNotFoundException e) {
            request.setAttribute("error", "MySQL JDBC driver not found.");
            request.getRequestDispatcher("reserve.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("reserve.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // redirect to reservation form
        response.sendRedirect("reserve.jsp");
    }
}