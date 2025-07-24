<?php
/**
 * Paul Romer Module 7 Form Processor
 * Processes form data and validates all required fields
 */

// Function to sanitize input data
function sanitizeInput($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Function to validate email format
function isValidEmail($email) {
    return filter_var($email, FILTER_VALIDATE_EMAIL) !== false;
}

// Function to validate phone number format (at least 7 digits)
function isValidPhone($phone) {
    // Remove all non-digit characters
    $digitsOnly = preg_replace('/\D/', '', $phone);
    // Check if at least 7 digits remain
    return strlen($digitsOnly) >= 7;
}

// Function to validate date
function isValidDate($date) {
    $d = DateTime::createFromFormat('Y-m-d', $date);
    return $d && $d->format('Y-m-d') === $date;
}

// Initialize variables
$errors = [];
$formData = [];

// Check if form was submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    // Sanitize and validate Full Name (String)
    if (empty($_POST["fullName"])) {
        $errors[] = "Full Name is required";
    } else {
        $fullName = sanitizeInput($_POST["fullName"]);
        if (strlen($fullName) < 2) {
            $errors[] = "Full Name must be at least 2 characters long";
        } else {
            $formData["fullName"] = $fullName;
        }
    }
    
    // Sanitize and validate Email (Email format)
    if (empty($_POST["email"])) {
        $errors[] = "Email Address is required";
    } else {
        $email = sanitizeInput($_POST["email"]);
        if (!isValidEmail($email)) {
            $errors[] = "Please enter a valid email address";
        } else {
            $formData["email"] = $email;
        }
    }
    
    // Sanitize and validate Age (Integer)
    if (empty($_POST["age"])) {
        $errors[] = "Age is required";
    } else {
        $age = sanitizeInput($_POST["age"]);
        if (!is_numeric($age) || $age < 1 || $age > 120) {
            $errors[] = "Age must be a number between 1 and 120";
        } else {
            $formData["age"] = (int)$age;
        }
    }
    
    // Sanitize and validate Birth Date (Date)
    if (empty($_POST["birthDate"])) {
        $errors[] = "Date of Birth is required";
    } else {
        $birthDate = sanitizeInput($_POST["birthDate"]);
        if (!isValidDate($birthDate)) {
            $errors[] = "Please enter a valid date of birth";
        } else {
            // Check if date is not in the future
            $today = new DateTime();
            $birth = new DateTime($birthDate);
            if ($birth > $today) {
                $errors[] = "Date of birth cannot be in the future";
            } else {
                $formData["birthDate"] = $birthDate;
            }
        }
    }
    
    // Sanitize and validate Phone Number (Phone format)
    if (empty($_POST["phoneNumber"])) {
        $errors[] = "Phone Number is required";
    } else {
        $phoneNumber = sanitizeInput($_POST["phoneNumber"]);
        if (!isValidPhone($phoneNumber)) {
            $errors[] = "Phone number must contain at least 7 digits";
        } else {
            $formData["phoneNumber"] = $phoneNumber;
        }
    }
    
    // Sanitize and validate Favorite Color (Selection)
    if (empty($_POST["favoriteColor"])) {
        $errors[] = "Favorite Color is required";
    } else {
        $favoriteColor = sanitizeInput($_POST["favoriteColor"]);
        $validColors = ["red", "blue", "green", "yellow", "purple", "orange", "pink", "black", "white"];
        if (!in_array($favoriteColor, $validColors)) {
            $errors[] = "Please select a valid color";
        } else {
            $formData["favoriteColor"] = $favoriteColor;
        }
    }
    
    // Handle Subscription (Boolean/Checkbox)
    $formData["subscription"] = isset($_POST["subscription"]) && $_POST["subscription"] === "yes";
    
} else {
    $errors[] = "Form was not submitted properly";
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Processing Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .success {
            background-color: #d4edda;
            color: #155724;
            padding: 20px;
            border-radius: 5px;
            border: 1px solid #c3e6cb;
            margin-bottom: 20px;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
            border-radius: 5px;
            border: 1px solid #f5c6cb;
            margin-bottom: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .data-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .data-table th,
        .data-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .data-table th {
            background-color: #f8f9fa;
            font-weight: bold;
            color: #495057;
        }
        .data-table tr:hover {
            background-color: #f5f5f5;
        }
        .back-button {
            display: inline-block;
            background: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .back-button:hover {
            background: #0056b3;
        }
        ul {
            margin: 0;
            padding-left: 20px;
        }
        .boolean-value {
            font-weight: bold;
        }
        .true { color: #28a745; }
        .false { color: #dc3545; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Form Processing Results</h1>
        
        <?php if (!empty($errors)): ?>
            <div class="error">
                <h2>Validation Errors</h2>
                <p>The following errors were found in your form submission:</p>
                <ul>
                    <?php foreach ($errors as $error): ?>
                        <li><?php echo htmlspecialchars($error); ?></li>
                    <?php endforeach; ?>
                </ul>
                <p>Please go back and correct these issues.</p>
            </div>
        <?php else: ?>
            <div class="success">
                <h2>Form Submitted Successfully!</h2>
                <p>All fields have been validated and your data has been processed successfully.</p>
            </div>
            
            <h2>Submitted Data</h2>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Field</th>
                        <th>Value</th>
                        <th>Data Type</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Full Name</td>
                        <td><?php echo htmlspecialchars($formData["fullName"]); ?></td>
                        <td>String</td>
                    </tr>
                    <tr>
                        <td>Email Address</td>
                        <td><?php echo htmlspecialchars($formData["email"]); ?></td>
                        <td>Email</td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td><?php echo $formData["age"]; ?> years old</td>
                        <td>Integer</td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td><?php echo date('F j, Y', strtotime($formData["birthDate"])); ?></td>
                        <td>Date</td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><?php echo htmlspecialchars($formData["phoneNumber"]); ?></td>
                        <td>Phone</td>
                    </tr>
                    <tr>
                        <td>Favorite Color</td>
                        <td style="color: <?php echo $formData["favoriteColor"]; ?>;">
                            <?php echo ucfirst(htmlspecialchars($formData["favoriteColor"])); ?>
                        </td>
                        <td>Selection</td>
                    </tr>
                    <tr>
                        <td>Subscription</td>
                        <td>
                            <span class="boolean-value <?php echo $formData["subscription"] ? 'true' : 'false'; ?>">
                                <?php echo $formData["subscription"] ? 'Yes' : 'No'; ?>
                            </span>
                        </td>
                        <td>Boolean</td>
                    </tr>
                </tbody>
            </table>
            
            <div style="margin-top: 30px; padding: 15px; background-color: #e9ecef; border-radius: 5px;">
                <h3>Summary Statistics</h3>
                <p><strong>Total Fields Processed:</strong> 7</p>
                <p><strong>Data Types Used:</strong> String, Email, Integer, Date, Phone, Selection, Boolean</p>
                <p><strong>Form Submitted At:</strong> <?php echo date('Y-m-d H:i:s'); ?></p>
            </div>
        <?php endif; ?>
        
        <a href="PaulForm.html" class="back-button">← Back to Form</a>
    </div>
</body>
</html>
