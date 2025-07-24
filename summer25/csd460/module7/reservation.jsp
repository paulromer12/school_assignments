<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>Reserve Your Room</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/reservation.css">
</head>
<body>
    <nav>
        <div class="logo">Moffat Bay Lodge</div>
        <ul class="navbar">
            <li><a href="index.jsp" class="active">Home</a></li>
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
      <h1 style="text-align:center; margin-top:30px;">Reserve Your Room</h1>
      <% if (request.getAttribute("error") != null) { %>
          <p class="error"><%= request.getAttribute("error") %></p>
      <% } %>

      <div class="room-list">
          <!-- Queen Room -->
          <div class="room-card">
              <img src="images/cabin.jpg" alt="Queen Room">
              <h2>Queen Room</h2>
              <p>Spacious queen-bed cabin with a private balcony and great views.</p>
              <p><strong>$135/night</strong></p>
              <form action="ReservationServlet" method="post">
                  <input type="hidden" name="roomTypeId" value="1">
                  <label>Guests:
                      <input type="number" name="numGuests" min="1" max="6" required>
                  </label>
                  <label>Check-In:
                      <input type="date" name="checkIn" required>
                  </label>
                  <label>Check-Out:
                      <input type="date" name="checkOut" required>
                  </label>
                  <p>Estimated Total: $<span class="price-display">0.00</span></p>
                  <input type="hidden" name="totalPrice" class="total-price-hidden" value="0.00">
                  <button type="submit">Reserve Queen</button>
              </form>
          </div>

          <!-- King Room -->
          <div class="room-card">
              <img src="images/cabin.jpg" alt="King Room">
              <h2>King Room</h2>
              <p>Luxurious king-bed suite with fireplace and lakeside view.</p>
              <p><strong>$160/night</strong></p>
              <form action="ReservationServlet" method="post">
                  <input type="hidden" name="roomTypeId" value="2">
                  <label>Guests:
                      <input type="number" name="numGuests" min="1" max="6" required>
                  </label>
                  <label>Check-In:
                      <input type="date" name="checkIn" required>
                  </label>
                  <label>Check-Out:
                      <input type="date" name="checkOut" required>
                  </label>
                  <p>Estimated Total: $<span class="price-display">0.00</span></p>
                  <input type="hidden" name="totalPrice" class="total-price-hidden" value="0.00">
                  <button type="submit">Reserve King</button>
              </form>
          </div>

          <!-- Double Full -->
          <div class="room-card">
              <img src="images/cabin.jpg" alt="Double Full Room">
              <h2>Double Full</h2>
              <p>Two full beds, perfect for families or groups.</p>
              <p><strong>$120/night</strong></p>
              <form action="ReservationServlet" method="post">
                  <input type="hidden" name="roomTypeId" value="3">
                  <label>Guests:
                      <input type="number" name="numGuests" min="1" max="6" required>
                  </label>
                  <label>Check-In:
                      <input type="date" name="checkIn" required>
                  </label>
                  <label>Check-Out:
                      <input type="date" name="checkOut" required>
                  </label>
                  <p>Estimated Total: $<span class="price-display">0.00</span></p>
                  <input type="hidden" name="totalPrice" class="total-price-hidden" value="0.00">
                  <button type="submit">Reserve Double Full</button>
              </form>
          </div>
      </div>
    </main>

    <script>
    document.addEventListener("DOMContentLoaded", function() {
      const forms = document.querySelectorAll(".room-card form");

      forms.forEach(form => {
        const checkInInput = form.querySelector('input[name="checkIn"]');
        const checkOutInput = form.querySelector('input[name="checkOut"]');
        const priceDisplay = form.querySelector(".price-display");
        const hiddenTotalPrice = form.querySelector(".total-price-hidden");
        const roomTypeId = form.querySelector('input[name="roomTypeId"]').value;

        const rates = {
          "1": 135,
          "2": 160,
          "3": 120
        };

        function updatePrice() {
          const checkIn = new Date(checkInInput.value);
          const checkOut = new Date(checkOutInput.value);
          const oneDay = 24 * 60 * 60 * 1000;

          if (checkIn && checkOut && checkOut > checkIn) {
            const nights = Math.round((checkOut - checkIn) / oneDay);
            const total = nights * rates[roomTypeId];
            priceDisplay.textContent = total.toFixed(2);
            hiddenTotalPrice.value = total.toFixed(2);
          } else {
            priceDisplay.textContent = "0.00";
            hiddenTotalPrice.value = "0.00";
          }
        }

        checkInInput.addEventListener("change", updatePrice);
        checkOutInput.addEventListener("change", updatePrice);
      });
    });
    </script>
</body>
</html>