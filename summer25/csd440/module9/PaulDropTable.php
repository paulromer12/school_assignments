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

// SQL to drop table
$sql = "DROP TABLE IF EXISTS players";

if ($conn->query($sql) === TRUE) {
    echo "Table 'players' dropped successfully<br>";
    echo "The table and all its data have been removed from the database.";
} else {
    echo "Error dropping table: " . $conn->error;
}

// Close connection
$conn->close();
?>