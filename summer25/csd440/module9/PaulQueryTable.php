<?php
// Paul Romer Module 8 Assignment

// Database connection parameters
$servername = "localhost";  
$username = "student1";
$password = "pass";
$dbname = "baseball_01";

// Create connection using MySQLi
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

echo "Connected successfully to database: $dbname<br><br>";

// Query 1: Display all players
echo "<h3>All Players in the Database:</h3>";
$sql = "SELECT * FROM players ORDER BY name";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<table border='1' cellpadding='5' cellspacing='0'>";
    echo "<tr><th>ID</th><th>Name</th><th>Position</th><th>Batting Avg</th><th>Home Runs</th><th>Debut Date</th></tr>";
    
    while($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["id"] . "</td>";
        echo "<td>" . $row["name"] . "</td>";
        echo "<td>" . $row["position"] . "</td>";
        echo "<td>" . $row["batting_average"] . "</td>";
        echo "<td>" . $row["home_runs"] . "</td>";
        echo "<td>" . $row["debut_date"] . "</td>";
        echo "</tr>";
    }
    echo "</table>";
} else {
    echo "No players found in the database.";
}

// Query 2: Players with high batting averages
echo "<br><h3>Players with Batting Average > 0.300:</h3>";
$sql2 = "SELECT name, position, batting_average, home_runs FROM players WHERE batting_average > 0.300 ORDER BY batting_average DESC";
$result2 = $conn->query($sql2);

if ($result2->num_rows > 0) {
    echo "<table border='1' cellpadding='5' cellspacing='0'>";
    echo "<tr><th>Name</th><th>Position</th><th>Batting Average</th><th>Home Runs</th></tr>";
    
    while($row = $result2->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["name"] . "</td>";
        echo "<td>" . $row["position"] . "</td>";
        echo "<td>" . $row["batting_average"] . "</td>";
        echo "<td>" . $row["home_runs"] . "</td>";
        echo "</tr>";
    }
    echo "</table>";
} else {
    echo "No players found with batting average > 0.300.";
}

// Query 3: Players with most home runs
echo "<br><h3>Top 5 Home Run Leaders:</h3>";
$sql3 = "SELECT name, position, home_runs, debut_date FROM players ORDER BY home_runs DESC LIMIT 5";
$result3 = $conn->query($sql3);

if ($result3->num_rows > 0) {
    echo "<table border='1' cellpadding='5' cellspacing='0'>";
    echo "<tr><th>Name</th><th>Position</th><th>Home Runs</th><th>Debut Date</th></tr>";
    
    while($row = $result3->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["name"] . "</td>";
        echo "<td>" . $row["position"] . "</td>";
        echo "<td>" . $row["home_runs"] . "</td>";
        echo "<td>" . $row["debut_date"] . "</td>";
        echo "</tr>";
    }
    echo "</table>";
}

// Query 4: Count of players by position
echo "<br><h3>Player Count by Position:</h3>";
$sql4 = "SELECT position, COUNT(*) as player_count FROM players GROUP BY position ORDER BY player_count DESC";
$result4 = $conn->query($sql4);

if ($result4->num_rows > 0) {
    echo "<table border='1' cellpadding='5' cellspacing='0'>";
    echo "<tr><th>Position</th><th>Number of Players</th></tr>";
    
    while($row = $result4->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["position"] . "</td>";
        echo "<td>" . $row["player_count"] . "</td>";
        echo "</tr>";
    }
    echo "</table>";
}

echo "<br><br><strong>Query testing completed successfully!</strong>";

// Close connection
$conn->close();
?>