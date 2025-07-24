<?php
// Paul Romer Module 9 Assignment - Add Player Form

// Database connection parameters
$servername = "localhost";  
$username = "student1";
$password = "pass";
$dbname = "baseball_01";

// Initialize variables
$success_message = "";
$error_message = "";
$form_data = [
    'name' => '',
    'position' => '',
    'batting_average' => '',
    'home_runs' => '',
    'debut_date' => ''
];

// Process form submission
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get form data
    $form_data['name'] = trim($_POST['name']);
    $form_data['position'] = trim($_POST['position']);
    $form_data['batting_average'] = trim($_POST['batting_average']);
    $form_data['home_runs'] = trim($_POST['home_runs']);
    $form_data['debut_date'] = trim($_POST['debut_date']);
    
    // Validate input
    $errors = [];
    
    if (empty($form_data['name'])) {
        $errors[] = "Player name is required";
    }
    
    if (empty($form_data['position'])) {
        $errors[] = "Position is required";
    }
    
    if (!empty($form_data['batting_average'])) {
        if (!is_numeric($form_data['batting_average']) || $form_data['batting_average'] < 0 || $form_data['batting_average'] > 1) {
            $errors[] = "Batting average must be a number between 0 and 1";
        }
    }
    
    if (!empty($form_data['home_runs'])) {
        if (!is_numeric($form_data['home_runs']) || $form_data['home_runs'] < 0) {
            $errors[] = "Home runs must be a non-negative number";
        }
    }
    
    if (!empty($form_data['debut_date'])) {
        $date = DateTime::createFromFormat('Y-m-d', $form_data['debut_date']);
        if (!$date || $date->format('Y-m-d') !== $form_data['debut_date']) {
            $errors[] = "Invalid debut date format";
        }
    }
    
    // If no validation errors, proceed with database insertion
    if (empty($errors)) {
        // Create connection using MySQLi
        $conn = new mysqli($servername, $username, $password, $dbname);
        
        // Check connection
        if ($conn->connect_error) {
            $error_message = "Connection failed: " . $conn->connect_error;
        } else {
            // Prepare and execute insert statement
            $sql = "INSERT INTO players (name, position, batting_average, home_runs, debut_date) VALUES (?, ?, ?, ?, ?)";
            $stmt = $conn->prepare($sql);
            
            // Set default values for optional fields
            $batting_avg = !empty($form_data['batting_average']) ? floatval($form_data['batting_average']) : 0.000;
            $home_runs = !empty($form_data['home_runs']) ? intval($form_data['home_runs']) : 0;
            $debut_date = !empty($form_data['debut_date']) ? $form_data['debut_date'] : null;
            
            $stmt->bind_param("ssdis", 
                $form_data['name'], 
                $form_data['position'], 
                $batting_avg, 
                $home_runs, 
                $debut_date
            );
            
            if ($stmt->execute()) {
                $success_message = "Player '" . htmlspecialchars($form_data['name']) . "' has been successfully added to the database!";
                // Clear form data after successful insertion
                $form_data = [
                    'name' => '',
                    'position' => '',
                    'batting_average' => '',
                    'home_runs' => '',
                    'debut_date' => ''
                ];
            } else {
                $error_message = "Error adding player: " . $stmt->error;
            }
            
            $stmt->close();
            $conn->close();
        }
    } else {
        $error_message = implode("<br>", $errors);
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Player - Baseball Database</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
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
        .form-container {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            margin: 20px 0;
        }
        .form-group {
            margin: 20px 0;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #34495e;
        }
        .required {
            color: #e74c3c;
        }
        input[type="text"], 
        input[type="number"], 
        input[type="date"], 
        select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input:focus, select:focus {
            border-color: #3498db;
            outline: none;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
        }
        button {
            background-color: #27ae60;
            color: white;
            padding: 12px 30px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
        }
        button:hover {
            background-color: #229954;
        }
        .back-btn {
            background-color: #95a5a6;
        }
        .back-btn:hover {
            background-color: #7f8c8d;
        }
        .error {
            color: #e74c3c;
            background-color: #fdf2f2;
            padding: 15px;
            border-radius: 4px;
            margin: 15px 0;
            border-left: 4px solid #e74c3c;
        }
        .success {
            color: #27ae60;
            background-color: #f2fff2;
            padding: 15px;
            border-radius: 4px;
            margin: 15px 0;
            border-left: 4px solid #27ae60;
        }
        .help-text {
            font-size: 14px;
            color: #666;
            margin-top: 5px;
        }
        .form-section {
            border-bottom: 1px solid #eee;
            padding-bottom: 20px;
            margin-bottom: 20px;
        }
        .form-section:last-child {
            border-bottom: none;
            margin-bottom: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Baseball Player</h1>
        
        <?php if (!empty($success_message)): ?>
            <div class="success">
                <strong>Success!</strong> <?php echo $success_message; ?>
            </div>
        <?php endif; ?>

        <?php if (!empty($error_message)): ?>
            <div class="error">
                <strong>Error:</strong><br><?php echo $error_message; ?>
            </div>
        <?php endif; ?>

        <div class="form-container">
            <form method="POST" action="">
                <div class="form-section">
                    <h3>Required Information</h3>
                    
                    <div class="form-group">
                        <label for="name">Player Name <span class="required">*</span></label>
                        <input type="text" name="name" id="name" 
                               value="<?php echo htmlspecialchars($form_data['name']); ?>" 
                               placeholder="Enter player's full name" required>
                        <div class="help-text">Enter the player's full name</div>
                    </div>
                    
                    <div class="form-group">
                        <label for="position">Position <span class="required">*</span></label>
                        <select name="position" id="position" required>
                            <option value="">Select position...</option>
                            <option value="Pitcher" <?php echo ($form_data['position'] == 'Pitcher') ? 'selected' : ''; ?>>Pitcher</option>
                            <option value="Catcher" <?php echo ($form_data['position'] == 'Catcher') ? 'selected' : ''; ?>>Catcher</option>
                            <option value="First Base" <?php echo ($form_data['position'] == 'First Base') ? 'selected' : ''; ?>>First Base</option>
                            <option value="Second Base" <?php echo ($form_data['position'] == 'Second Base') ? 'selected' : ''; ?>>Second Base</option>
                            <option value="Third Base" <?php echo ($form_data['position'] == 'Third Base') ? 'selected' : ''; ?>>Third Base</option>
                            <option value="Shortstop" <?php echo ($form_data['position'] == 'Shortstop') ? 'selected' : ''; ?>>Shortstop</option>
                            <option value="Left Field" <?php echo ($form_data['position'] == 'Left Field') ? 'selected' : ''; ?>>Left Field</option>
                            <option value="Center Field" <?php echo ($form_data['position'] == 'Center Field') ? 'selected' : ''; ?>>Center Field</option>
                            <option value="Right Field" <?php echo ($form_data['position'] == 'Right Field') ? 'selected' : ''; ?>>Right Field</option>
                            <option value="Outfielder" <?php echo ($form_data['position'] == 'Outfielder') ? 'selected' : ''; ?>>Outfielder (General)</option>
                            <option value="Designated Hitter" <?php echo ($form_data['position'] == 'Designated Hitter') ? 'selected' : ''; ?>>Designated Hitter</option>
                        </select>
                        <div class="help-text">Select the player's primary position</div>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Optional Statistics</h3>
                    
                    <div class="form-group">
                        <label for="batting_average">Batting Average</label>
                        <input type="number" name="batting_average" id="batting_average" 
                               value="<?php echo htmlspecialchars($form_data['batting_average']); ?>" 
                               step="0.001" min="0" max="1" placeholder="0.000">
                        <div class="help-text">Enter batting average as decimal</div>
                    </div>
                    
                    <div class="form-group">
                        <label for="home_runs">Career Home Runs</label>
                        <input type="number" name="home_runs" id="home_runs" 
                               value="<?php echo htmlspecialchars($form_data['home_runs']); ?>" 
                               min="0" placeholder="0">
                        <div class="help-text">Enter total career home runs</div>
                    </div>
                    
                    <div class="form-group">
                        <label for="debut_date">MLB Debut Date</label>
                        <input type="date" name="debut_date" id="debut_date" 
                               value="<?php echo htmlspecialchars($form_data['debut_date']); ?>">
                        <div class="help-text">Select the date of the player's MLB debut</div>
                    </div>
                </div>

                <div style="text-align: center; margin-top: 30px;">
                    <button type="submit">Add Player</button>
                    <button type="button" class="back-btn" onclick="window.location.href='index.php'">Back to Home</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
