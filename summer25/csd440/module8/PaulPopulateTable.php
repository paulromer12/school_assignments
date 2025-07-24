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

echo "Connected successfully to database: $dbname<br>";

// Sample data for players table
$players_data = [
    ['Mike Trout', 'Outfielder', 0.305, 40, '2011-07-08'],
    ['Mookie Betts', 'Outfielder', 0.292, 35, '2014-06-29'],
    ['Aaron Judge', 'Outfielder', 0.284, 62, '2016-08-13'],
    ['Vladimir Guerrero Jr.', 'First Base', 0.274, 32, '2019-04-26'],
    ['Fernando Tatis Jr.', 'Shortstop', 0.282, 42, '2019-03-28'],
    ['Ronald Acuna Jr.', 'Outfielder', 0.266, 41, '2018-04-25'],
    ['Juan Soto', 'Outfielder', 0.314, 35, '2018-05-20'],
    ['Babe Ruth', 'Outfielder', 0.342, 714, '1914-07-11'],
    ['Lou Gehrig', 'First Base', 0.340, 493, '1923-06-15'],
    ['Ted Williams', 'Outfielder', 0.344, 521, '1939-04-20']
];

// Insert data using prepared statements
$stmt = $conn->prepare("INSERT INTO players (name, position, batting_average, home_runs, debut_date) VALUES (?, ?, ?, ?, ?)");

$insert_count = 0;
foreach ($players_data as $player) {
    $stmt->bind_param("ssdis", $player[0], $player[1], $player[2], $player[3], $player[4]);
    
    if ($stmt->execute()) {
        $insert_count++;
        echo "Inserted: " . $player[0] . " (" . $player[1] . ")<br>";
    } else {
        echo "Error inserting " . $player[0] . ": " . $stmt->error . "<br>";
    }
}

echo "<br>Successfully inserted $insert_count players into the table.<br>";

// Close statement and connection
$stmt->close();
$conn->close();
?>