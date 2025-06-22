<?php
// Paul Romer Module 5 Assignment
//Write a program that creates and displays an array of customers (minimum of 10 customers) that includes their first name, last name, age, and phone number.
//Then, using array methods, find several records and display the customer information based on different data fields.

// Create an array of customers with first name, last name, age, and phone number
$customers = [
    [
        'first_name' => 'John',
        'last_name' => 'Smith',
        'age' => 28,
        'phone' => '555-0101'
    ],
    [
        'first_name' => 'Sarah',
        'last_name' => 'Johnson',
        'age' => 34,
        'phone' => '555-0102'
    ],
    [
        'first_name' => 'Michael',
        'last_name' => 'Brown',
        'age' => 42,
        'phone' => '555-0103'
    ],
    [
        'first_name' => 'Emily',
        'last_name' => 'Davis',
        'age' => 29,
        'phone' => '555-0104'
    ],
    [
        'first_name' => 'David',
        'last_name' => 'Wilson',
        'age' => 35,
        'phone' => '555-0105'
    ],
    [
        'first_name' => 'Jessica',
        'last_name' => 'Martinez',
        'age' => 31,
        'phone' => '555-0106'
    ],
    [
        'first_name' => 'Christopher',
        'last_name' => 'Anderson',
        'age' => 27,
        'phone' => '555-0107'
    ],
    [
        'first_name' => 'Amanda',
        'last_name' => 'Taylor',
        'age' => 38,
        'phone' => '555-0108'
    ],
    [
        'first_name' => 'Robert',
        'last_name' => 'Thomas',
        'age' => 45,
        'phone' => '555-0109'
    ],
    [
        'first_name' => 'Lisa',
        'last_name' => 'Garcia',
        'age' => 33,
        'phone' => '555-0110'
    ]
];

echo "<h1>Customer Management System</h1>";

// Display all customers
echo "<h2>All Customers</h2>";
echo "<table border='1' cellpadding='10' cellspacing='0'>";
echo "<tr><th>First Name</th><th>Last Name</th><th>Age</th><th>Phone</th></tr>";

foreach ($customers as $customer) {
    echo "<tr>";
    echo "<td>" . $customer['first_name'] . "</td>";
    echo "<td>" . $customer['last_name'] . "</td>";
    echo "<td>" . $customer['age'] . "</td>";
    echo "<td>" . $customer['phone'] . "</td>";
    echo "</tr>";
}
echo "</table>";

// Function to display customer information
function displayCustomer($customer) {
    if ($customer) {
        echo "<strong>Name:</strong> " . $customer['first_name'] . " " . $customer['last_name'] . "<br>";
        echo "<strong>Age:</strong> " . $customer['age'] . "<br>";
        echo "<strong>Phone:</strong> " . $customer['phone'] . "<br><br>";
    } else {
        echo "Customer not found.<br><br>";
    }
}

// 1. Find customer by first name using array_filter
echo "<h2>Using Array Methods</h2>";

echo "<h3>1. Find customer by first name (Sarah)</h3>";
$foundByFirstName = array_filter($customers, function($customer) {
    return $customer['first_name'] === 'Sarah';
});
if (!empty($foundByFirstName)) {
    displayCustomer(array_values($foundByFirstName)[0]);
} else {
    echo "Customer not found.<br><br>";
}

// 2. Find customer by last name
echo "<h3>2. Find customer by last name (Wilson)</h3>";
$foundByLastName = array_filter($customers, function($customer) {
    return $customer['last_name'] === 'Wilson';
});
if (!empty($foundByLastName)) {
    displayCustomer(array_values($foundByLastName)[0]);
} else {
    echo "Customer not found.<br><br>";
}

// 3. Find customers by age range 30 - 35
echo "<h3>3. Find customers between ages 30-35</h3>";
$foundByAge = array_filter($customers, function($customer) {
    return $customer['age'] >= 30 && $customer['age'] <= 35;
});
foreach ($foundByAge as $customer) {
    displayCustomer($customer);
}

// 4. Find customer by phone number
echo "<h3>4. Find customer by phone number (555-0105)</h3>";
$foundByPhone = array_filter($customers, function($customer) {
    return $customer['phone'] === '555-0105';
});
if (!empty($foundByPhone)) {
    displayCustomer(array_values($foundByPhone)[0]);
} else {
    echo "Customer not found.<br><br>";
}

// 5. Find customers whose first name starts with 'M'
echo "<h3>5. Find customers whose first name starts with 'M'</h3>";
$foundByFirstLetter = array_filter($customers, function($customer) {
    return substr($customer['first_name'], 0, 1) === 'M';
});
foreach ($foundByFirstLetter as $customer) {
    displayCustomer($customer);
}

// 6. Sort customers by age and display youngest and oldest
echo "<h3>6. Youngest and Oldest Customers</h3>";
$sortedByAge = $customers;
usort($sortedByAge, function($a, $b) {
    return $a['age'] - $b['age'];
});

echo "<strong>Youngest Customer:</strong><br>";
displayCustomer($sortedByAge[0]);

echo "<strong>Oldest Customer:</strong><br>";
displayCustomer($sortedByAge[count($sortedByAge) - 1]);

// 7. Get average age
echo "<h3>7. Average Age of All Customers</h3>";
$ages = array_column($customers, 'age');
$averageAge = array_sum($ages) / count($ages);
echo "Average age: " . round($averageAge, 1) . " years<br><br>";

// 8. Count customers by age groups
echo "<h3>8. Customers by Age Groups</h3>";
$under30 = array_filter($customers, function($customer) {
    return $customer['age'] < 30;
});
$thirties = array_filter($customers, function($customer) {
    return $customer['age'] >= 30 && $customer['age'] < 40;
});
$fortyPlus = array_filter($customers, function($customer) {
    return $customer['age'] >= 40;
});

echo "Under 30: " . count($under30) . " customers<br>";
echo "30-39: " . count($thirties) . " customers<br>";
echo "40+: " . count($fortyPlus) . " customers<br><br>";
?>