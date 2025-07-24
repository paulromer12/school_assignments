<?php
// Paul Romer Module 8 Assignment

// Database connection parameters
$servername = "localhost";  
$username = "student1";
$password = "pass";
$dbname = "baseball_01";

// First connect without specifying database to create it if needed
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

echo "Connected successfully to MySQL server<br>";

// Create Database if it doesn't exist
$sql = "CREATE DATABASE IF NOT EXISTS `$dbname` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";

if ($conn->query($sql) === TRUE) {
    echo "Database '$dbname' ready<br>";
} else {
    echo "Error creating database: " . $conn->error;
    $conn->close();
    exit();
}

// Now select the database
if (!$conn->select_db($dbname)) {
    die("Error selecting database: " . $conn->error);
}

// SQL to create table with IF NOT EXISTS
$sql = "CREATE TABLE IF NOT EXISTS players (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(20) NOT NULL,
    batting_average DECIMAL(4,3) DEFAULT 0.000,
    home_runs INT DEFAULT 0,
    debut_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)";

if ($conn->query($sql) === TRUE) {
    echo "Table 'players' created successfully or already exists<br>";
    echo "Table structure:<br>";
    echo "- id: INT (Primary Key, Auto Increment)<br>";
    echo "- name: VARCHAR(100)<br>";
    echo "- position: VARCHAR(20)<br>";
    echo "- batting_average: DECIMAL(4,3)<br>";
    echo "- home_runs: INT<br>";
    echo "- debut_date: DATE<br>";
    echo "- created_at: TIMESTAMP<br>";
} else {
    echo "Error creating table: " . $conn->error;
}

// Close connection
$conn->close();
?>