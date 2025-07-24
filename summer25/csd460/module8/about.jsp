<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/about.css">
</head>
<body>

<!-- Navigation -->
 <nav>
       <div class="logo">Moffat Bay Lodge</div>
	<ul class="navbar">
	    <li><a href="index.jsp" class="active">Home</a></li>
	    <li><a href="cabins.jsp">Cabins</a></li>
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

<!-- About Us -->
<div class="about-container">
    <h2>About Us</h2>
    <div class="about-grid">
        <div class="about-section">
            <img src="images/about1.jpg" alt="A family enjoying the lodge">
            <p>Experience Moffat Bay Lodge where the outdoors come alive. Surrounded by forest, water, and open skies, every stay blends natural beauty with adventure.</p>
        </div>
        <div class="about-section">
            <img src="images/about2.jpg" alt="Interior of the cozy lodge">
            <p>Whether you're venturing out on your own or visiting with family, Moffat Bay Lodge offers a break from the everyday. With comfortable cabins, a friendly atmosphere, and a setting immersed in nature, it's a place to step away from distractions and enjoy what’s right in front of you.</p>
        </div>
        <div class="about-section">
            <img src="images/about3.jpg" alt="Lake with kayaks">
            <p>From kayaking along the lake to guided hikes through forest trails, Moffat Bay Lodge offers plenty of ways to enjoy the outdoors.</p>
        </div>
    </div>

    <h2>Ready to Book?</h2>
    <div class="cta-box">
        <div class="cta-item">
            <img src="images/about-cabin.jpg" alt="Cabins">
            <p>Cabins</p>
            <a href="registration.jsp"><button>Book Now</button></a>
        </div>
        <div class="cta-item">
            <img src="images/about-attraction.jpg" alt="Attractions">
            <p>Attractions</p>
            <a href="attractions.jsp"><button>Book Now</button></a>
        </div>
    </div>
</div>

</body>
</html>