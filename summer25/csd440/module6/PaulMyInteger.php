<?php
// Paul Romer Module 6 Assignment 
// Write a program that defines a class titled MyInteger. The class is to hold a single integer that is set in the constructor by a parameter. The class is to have methods isEven(int) and isOdd(int).
// In addition, the class will have an isPrime() method.
// Lastly, you are to have a getter and setter method.
// Create two instances and test all methods.
// Title the PHP class as PaulMyInteger 

class PaulMyInteger {
    private $value;
    
    // Constructor to set the integer value
    public function __construct($value) {
        $this->value = $value;
    }
    
    // Getter method
    public function getValue() {
        return $this->value;
    }
    
    // Setter method
    public function setValue($value) {
        $this->value = $value;
    }
    
    // Check if the stored value is even
    public function isEven() {
        return $this->value % 2 == 0;
    }
    
    // Check if the stored value is odd
    public function isOdd() {
        return $this->value % 2 != 0;
    }
    
    // Check if the stored value is prime
    public function isPrime() {
        if ($this->value < 2) {
            return false;
        }
        
        // Check for divisors from 2 to sqrt(value)
        for ($i = 2; $i <= sqrt($this->value); $i++) {
            if ($this->value % $i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

// Create two instances and test all methods
echo "<h2>Paul Romer - Module 6 Assignment - MyInteger Class Testing</h2>\n";

// Create first instance with value 17
$myInt1 = new PaulMyInteger(17);
echo "<h3>Testing Instance 1 (value: " . $myInt1->getValue() . ")</h3>\n";
echo "Value: " . $myInt1->getValue() . "<br>\n";
echo "Is Even: " . ($myInt1->isEven() ? "true" : "false") . "<br>\n";
echo "Is Odd: " . ($myInt1->isOdd() ? "true" : "false") . "<br>\n";
echo "Is Prime: " . ($myInt1->isPrime() ? "true" : "false") . "<br><br>\n";

// Create second instance with value 24
$myInt2 = new PaulMyInteger(24);
echo "<h3>Testing Instance 2 (value: " . $myInt2->getValue() . ")</h3>\n";
echo "Value: " . $myInt2->getValue() . "<br>\n";
echo "Is Even: " . ($myInt2->isEven() ? "true" : "false") . "<br>\n";
echo "Is Odd: " . ($myInt2->isOdd() ? "true" : "false") . "<br>\n";
echo "Is Prime: " . ($myInt2->isPrime() ? "true" : "false") . "<br><br>\n";

// Test setter method by changing the value of first instance
echo "<h3>Testing Setter Method</h3>\n";
echo "Changing first instance from " . $myInt1->getValue() . " to 13<br>\n";
$myInt1->setValue(13);
echo "New value: " . $myInt1->getValue() . "<br>\n";
echo "Is Even: " . ($myInt1->isEven() ? "true" : "false") . "<br>\n";
echo "Is Odd: " . ($myInt1->isOdd() ? "true" : "false") . "<br>\n";
echo "Is Prime: " . ($myInt1->isPrime() ? "true" : "false") . "<br><br>\n";
?>