<?php
// Paul Romer Module 9 Assignment - Query Page

// Database connection parameters
$servername = "localhost";  
$username = "student1";
$password = "pass";
$dbname = "baseball_01";

// Initialize variables
$search_performed = false;
$search_results = [];
$error_message = "";
$search_term = "";
$search_field = "";

// Process form submission
if ($_SERVER["REQUEST_METHOD"] == "POST" && !empty($_POST['search_term'])) {
    $search_term = trim($_POST['search_term']);
    $search_field = $_POST['search_field'];
    
    // Create connection using MySQLi
    $conn = new mysqli($servername, $username, $password, $dbname);
    
    // Check connection
    if ($conn->connect_error) {
        $error_message = "Connection failed: " . $conn->connect_error;
    } else {
        $search_performed = true;
        
        // Build query based on search field
        switch($search_field) {
            case 'name':
                $sql = "SELECT * FROM players WHERE name LIKE ? ORDER BY name";
                $search_param = "%" . $search_term . "%";
                break;
            case 'position':
                $sql = "SELECT * FROM players WHERE position LIKE ? ORDER BY name";
                $search_param = "%" . $search_term . "%";
                break;
            case 'home_runs':
                if (is_numeric($search_term)) {
                    $sql = "SELECT * FROM players WHERE home_runs >= ? ORDER BY home_runs DESC";
                    $search_param = intval($search_term);
                } else {
                    $error_message = "Home runs must be a number";
                }
                break;
            case 'batting_average':
                if (is_numeric($search_term)) {
                    $sql = "SELECT * FROM players WHERE batting_average >= ? ORDER BY batting_average DESC";
                    $search_param = floatval($search_term);
                } else {
                    $error_message = "Batting average must be a number";
                }
                break;
            default:
                $error_message = "Invalid search field";
        }
        
        // Execute query if no errors
        if (empty($error_message)) {
            $stmt = $conn->prepare($sql);
            
            if ($search_field == 'home_runs') {
                $stmt->bind_param("i", $search_param);
            } elseif ($search_field == 'batting_average') {
                $stmt->bind_param("d", $search_param);
            } else {
                $stmt->bind_param("s", $search_param);
            }
            
            $stmt->execute();
            $result = $stmt->get_result();
            
            while ($row = $result->fetch_assoc()) {
                $search_results[] = $row;
            }
            
            $stmt->close();
        }
        
        $conn->close();
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Players - Baseball Database</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1000px;
            margin: 20px auto;
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
        .search-form {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            margin: 20px 0;
        }
        .form-group {
            margin: 15px 0;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #34495e;
        }
        input[type="text"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            background-color: #3498db;
            color: white;
            padding: 12px 30px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
        }
        button:hover {
            background-color: #2980b9;
        }
        .back-btn {
            background-color: #95a5a6;
        }
        .back-btn:hover {
            background-color: #7f8c8d;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .error {
            color: #e74c3c;
            background-color: #fdf2f2;
            padding: 10px;
            border-radius: 4px;
            margin: 10px 0;
        }
        .success {
            color: #27ae60;
            background-color: #f2fff2;
            padding: 10px;
            border-radius: 4px;
            margin: 10px 0;
        }
        .no-results {
            text-align: center;
            color: #666;
            font-style: italic;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Baseball Players</h1>
        
        <div class="search-form">
            <form method="POST" action="">
                <div class="form-group">
                    <label for="search_field">Search by:</label>
                    <select name="search_field" id="search_field" required>
                        <option value="">Select field...</option>
                        <option value="name" <?php echo ($search_field == 'name') ? 'selected' : ''; ?>>Player Name</option>
                        <option value="position" <?php echo ($search_field == 'position') ? 'selected' : ''; ?>>Position</option>
                        <option value="home_runs" <?php echo ($search_field == 'home_runs') ? 'selected' : ''; ?>>Minimum Home Runs</option>
                        <option value="batting_average" <?php echo ($search_field == 'batting_average') ? 'selected' : ''; ?>>Minimum Batting Average</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="search_term">Search term:</label>
                    <input type="text" name="search_term" id="search_term" 
                           value="<?php echo htmlspecialchars($search_term); ?>" 
                           placeholder="Enter search term..." required>
                </div>
                
                <button type="submit">Search Players</button>
                <button type="button" class="back-btn" onclick="window.location.href='index.php'">Back to Home</button>
            </form>
        </div>

        <?php if (!empty($error_message)): ?>
            <div class="error">
                <strong>Error:</strong> <?php echo htmlspecialchars($error_message); ?>
            </div>
        <?php endif; ?>

        <?php if ($search_performed && empty($error_message)): ?>
            <h2>Search Results</h2>
            <?php if (!empty($search_results)): ?>
                <div class="success">
                    Found <?php echo count($search_results); ?> player(s) matching your search.
                </div>
                
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Batting Average</th>
                            <th>Home Runs</th>
                            <th>Debut Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($search_results as $player): ?>
                            <tr>
                                <td><?php echo htmlspecialchars($player['id']); ?></td>
                                <td><?php echo htmlspecialchars($player['name']); ?></td>
                                <td><?php echo htmlspecialchars($player['position']); ?></td>
                                <td><?php echo htmlspecialchars($player['batting_average']); ?></td>
                                <td><?php echo htmlspecialchars($player['home_runs']); ?></td>
                                <td><?php echo htmlspecialchars($player['debut_date']); ?></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            <?php else: ?>
                <div class="no-results">
                    No players found matching your search criteria.
                </div>
            <?php endif; ?>
        <?php endif; ?>
    </div>
</body>
</html>
