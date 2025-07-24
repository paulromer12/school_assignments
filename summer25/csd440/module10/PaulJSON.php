<?php
// PaulJSON.php

// Set content type to HTML
header('Content-Type: text/html; charset=utf-8');

// Check if form was submitted via POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    // Validate required fields
    $required_fields = ['product_name', 'quantity', 'customer_name', 'email', 'phone', 'shipping_address', 'payment_method'];
    $errors = [];
    
    foreach ($required_fields as $field) {
        if (empty($_POST[$field])) {
            $errors[] = ucfirst(str_replace('_', ' ', $field)) . ' is required';
        }
    }
    
// If no errors, process the data
if (empty($errors)) {
    // Create nested JSON structure
    $form_data = [
        'order' => [
            'order_id' => 'ORD-' . date('YmdHis') . '-' . rand(1000, 9999),
            'order_date' => date('Y-m-d H:i:s'),
            'status' => 'pending',
            'customer' => [
                'name' => $_POST['customer_name'],
                'email' => $_POST['email'],
                'phone' => $_POST['phone']
            ],
            'shipping' => [
                'address' => $_POST['shipping_address'],
                'instructions' => !empty($_POST['delivery_instructions']) ? $_POST['delivery_instructions'] : 'None'
            ],
            'billing' => [
                'payment_method' => $_POST['payment_method']
            ],
            'items' => [
                'product_name' => $_POST['product_name'],
                'quantity' => (int)$_POST['quantity'],
                'promo_code' => !empty($_POST['promo_code']) ? $_POST['promo_code'] : 'None'
            ]
        ]
    ];
    
        // Encode data to JSON
        $json_data = json_encode($form_data, JSON_PRETTY_PRINT);
        
        // Check if JSON encoding was successful
        if ($json_data === false) {
            $errors[] = 'Error encoding data to JSON format';
        }
    }
} else {
    $errors[] = 'Invalid request method. Please submit the form properly.';
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Processing Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .success {
            border-left: 5px solid #28a745;
            background-color: #d4edda;
            color: #155724;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .error {
            border-left: 5px solid #dc3545;
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .json-display {
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            padding: 20px;
            margin: 20px 0;
            overflow-x: auto;
        }
        .json-content {
            font-family: 'Courier New', monospace;
            font-size: 14px;
            line-height: 1.5;
            white-space: pre-wrap;
            word-wrap: break-word;
        }
        .back-button {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .back-button:hover {
            background-color: #0056b3;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        h2 {
            color: #555;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
        }
        .error-list {
            list-style-type: none;
            padding: 0;
        }
        .error-list li {
            margin-bottom: 10px;
            padding: 10px;
            background-color: #fff5f5;
            border-left: 3px solid #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Order Processing Result</h1>
        
        <?php if (empty($errors)): ?>
            <!-- Success Display -->
            <div class="success">
                <h2>Order Submitted Successfully!</h2>
                <p>Your order has been processed and the data has been successfully converted to JSON format.</p>
            </div>
            
            <h2>Order Data in JSON Format:</h2>
            <div class="json-display">
                <div class="json-content"><?php echo htmlspecialchars($json_data); ?></div>
            </div>
            
            <h2>Order Summary:</h2>
            <div style="background-color: #e9ecef; padding: 15px; border-radius: 5px;">
                <p><strong>Customer:</strong> <?php echo htmlspecialchars($form_data['order']['customer']['name']); ?></p>
                <p><strong>Product:</strong> <?php echo htmlspecialchars($form_data['order']['items']['product_name']); ?></p>
                <p><strong>Quantity:</strong> <?php echo htmlspecialchars($form_data['order']['items']['quantity']); ?></p>
                <p><strong>Payment Method:</strong> <?php echo htmlspecialchars($form_data['order']['billing']['payment_method']); ?></p>
                <p><strong>Order Date:</strong> <?php echo htmlspecialchars($form_data['order']['order_date']); ?></p>
            </div>
            
        <?php else: ?>
            <!-- Error Display -->
            <div class="error">
                <h2>Error Processing Order</h2>
                <p>The following errors occurred while processing your order:</p>
                <ul class="error-list">
                    <?php foreach ($errors as $error): ?>
                        <li><?php echo htmlspecialchars($error); ?></li>
                    <?php endforeach; ?>
                </ul>
                <p>Please go back and correct these issues before resubmitting your order.</p>
            </div>
        <?php endif; ?>
        
        <a href="PaulOrderForm.html" class="back-button">← Back to Order Form</a>
    </div>
</body>
</html>