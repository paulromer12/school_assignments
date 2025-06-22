<?php 
// Paul Romer Module 4 Assignment
// Write a program that checks to see if a string is a palindrome. Include six examples in your code that displays the string in both orders, three being a palindrome and three not. Indicate in your display the resulting test in a function you have written to test each of the six strings.

// Function to check if a string is a palindrome
function isPalindrome($str) {
    // Convert to lowercase and replaces spaces with no space
    $cleanStr = strtolower(str_replace(' ', '', $str));
    
    // Compare the string with its reverse
    return strcmp($cleanStr, strrev($cleanStr)) === 0;
}

// Function to display string analysis
function displayStringAnalysis($str) {
    // Show the actual reversed string, not the cleaned version
    $reversed = strrev($str);
    $result = isPalindrome($str) ? "is a palindrome" : "is not a palindrome";
    
    echo "<div style='margin: 10px; padding: 10px; border: 1px solid #ccc;'>";
    echo "<strong>Original:</strong> \"$str\"<br>";
    echo "<strong>Reversed:</strong> \"$reversed\"<br>";
    echo "<strong>Result:</strong> This string <em>$result</em><br>";
    echo "</div>";
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Paul's Palindrome Checker</title>
    <style>
        body { font-family: sans-serif; margin: 20px; }
        h1 { color: #333; }
        .palindrome { background-color: #e8f5e8; margin: 5px 0; }
        .not-palindrome { background-color: #ffe8e8; margin: 5px 0; }
        table { margin-top: 20px; }
        th { background-color: #f0f0f0; padding: 8px; }
        td { padding: 8px; }
    </style>
</head>
<body>
    <h1>Palindrome Checker - Paul Romer Module 4</h1>
    
    <h2>Three Palindromes:</h2>
    <?php
    // Array of palindrome examples
    $palindromes = ["racecar", "A man a plan a canal Panama", "Madam"];
    
    foreach ($palindromes as $word) {
        echo "<div class='palindrome'>";
        displayStringAnalysis($word);
        echo "</div>";
    }
    ?>
    
    <h2>Three Non-Palindromes:</h2>
    <?php
    // Array of non-palindrome examples
    $nonPalindromes = ["hello", "programming", "computer"];
    
    foreach ($nonPalindromes as $word) {
        echo "<div class='not-palindrome'>";
        displayStringAnalysis($word);
        echo "</div>";
    }
    ?>

</body>
</html>

<?php?>