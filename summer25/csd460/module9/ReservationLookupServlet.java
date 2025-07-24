package com.moffatbay.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.moffatbay.models.Reservation;

public class ReservationLookupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resId = request.getParameter("reservationNumber");
        String email = request.getParameter("email");

        if ((resId == null || resId.isEmpty()) && (email == null || email.isEmpty())) {
            request.setAttribute("error", "Please enter a reservation number or email address.");
            request.getRequestDispatcher("reservationLookup.jsp").forward(request, response);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/moffat_bay", "root", "root")) {

                String sql;
                PreparedStatement stmt;

                if (resId != null && !resId.isEmpty()) {
                    // lookup by reservation number
                    sql = "SELECT r.reservation_id, u.first_name, rt.name, "
                            + "r.check_in_date, r.check_out_date, r.num_guests, r.total_price "
                            + "FROM Reservation r "
                            + "JOIN User u ON r.user_id = u.user_id "
                            + "JOIN RoomType rt ON r.room_type_id = rt.room_type_id "
                            + "WHERE r.reservation_id = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, Integer.parseInt(resId));

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        Reservation res = new Reservation(
                                rs.getInt("reservation_id"),
                                rs.getString("first_name"),
                                rs.getString("name"),
                                rs.getDate("check_in_date").toString(),
                                rs.getDate("check_out_date").toString(),
                                rs.getInt("num_guests"),
                                rs.getBigDecimal("total_price")
                        );
                        request.setAttribute("reservation", res);
                    } else {
                        request.setAttribute("error", "No reservation found with that number.");
                    }
                } else {
                    // lookup by email — get ALL reservations
                    sql = "SELECT r.reservation_id, u.first_name, rt.name, "
                            + "r.check_in_date, r.check_out_date, r.num_guests, r.total_price "
                            + "FROM Reservation r "
                            + "JOIN User u ON r.user_id = u.user_id "
                            + "JOIN RoomType rt ON r.room_type_id = rt.room_type_id "
                            + "WHERE u.email = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);

                    ResultSet rs = stmt.executeQuery();
                    List<Reservation> reservations = new ArrayList<>();
                    while (rs.next()) {
                        Reservation res = new Reservation(
                                rs.getInt("reservation_id"),
                                rs.getString("first_name"),
                                rs.getString("name"),
                                rs.getDate("check_in_date").toString(),
                                rs.getDate("check_out_date").toString(),
                                rs.getInt("num_guests"),
                                rs.getBigDecimal("total_price")
                        );
                        reservations.add(res);
                    }
                    if (reservations.isEmpty()) {
                        request.setAttribute("error", "No reservations found for that email address.");
                    } else {
                        request.setAttribute("reservations", reservations);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving reservation(s).");
        }

        request.getRequestDispatcher("reservationLookup.jsp").forward(request, response);
    }
}