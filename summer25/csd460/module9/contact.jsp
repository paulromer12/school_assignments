<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact - Moffat Bay Lodge</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/contact.css">
    
    
</head>
<body>
    <div class="landing-container">
        <header>
            <h1>Moffat Bay Lodge</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="cabins.jsp">Cabins</a></li>
                    <li><a href="attractions.jsp">Attractions</a></li>
                    <li><a href="about.jsp">About</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                    <li><a href="login.jsp" class="active">Login</a></li>
                </ul>
            </nav>
        </header>

        <div class="center-content">
            <h2>Contact Us</h2>
            <p>We'd love to hear from you! Fill out the form below and we'll get back to you soon.</p>
            
            <form class="contact-form" action="thankyou.jsp" method="post">
                <input type="text" name="name" placeholder="Your Name" required>
                <input type="email" name="email" placeholder="Your Email" required>
                <textarea name="message" placeholder="Your Message" required></textarea>
                <button type="submit">Send Message</button>
            </form>
        </div>
    </div>
</body>
</html>
