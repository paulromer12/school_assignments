<?php
// Paul Romer Module 9 Assignment - Index Page
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Baseball Database Management - Module 9</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
        }
        h2 {
            color: #34495e;
            margin-top: 30px;
        }
        .nav-section {
            margin: 20px 0;
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
        .nav-links {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin: 15px 0;
        }
        .nav-links a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .nav-links a:hover {
            background-color: #2980b9;
        }
        .module8-links a {
            background-color: #e74c3c;
        }
        .module8-links a:hover {
            background-color: #c0392b;
        }
        .description {
            color: #666;
            font-style: italic;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Baseball Database Management System</h1>
        <p style="text-align: center; color: #666;">Module 9 Assignment - Paul Romer</p>

        <h2>Module 8 Database Operations</h2>
        <div class="nav-section">
            <div class="nav-links module8-links">
                <a href="PaulCreateTable.php">Create Table</a>
                <a href="PaulPopulateTable.php">Populate Table</a>
                <a href="PaulQueryTable.php">View All Players</a>
                <a href="PaulDropTable.php">Drop Table</a>
            </div>
        </div>
        
        <h2>Module 9 Features (MySQLi)</h2>
        <div class="nav-section">
            <div class="nav-links">
                <a href="PaulQuery.php">Search Players</a>
                <a href="PaulForms.php">Add New Player</a>
            </div>
        </div>



        <h2>Database Information</h2>
        <div class="nav-section" style="background-color: #e8f4fd;">
            <p><strong>Database:</strong> baseball_01</p>
            <p><strong>Table:</strong> players</p>
            <p><strong>Fields:</strong> id, name, position, batting_average, home_runs, debut_date, created_at</p>
        </div>
    </div>
</body>
</html>
