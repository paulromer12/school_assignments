<!-- Paul Romer Module 3 Assignment, CSD440 -->
<?php require_once 'functions.php'; // Include the external file with the function ?>
<!DOCTYPE html>
<html>
<head>
    <title>PHP Random Number Table</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Paul's Random Number Table</h2>

<table>  
    <thead>
        <tr>
            <?php for ($col = 1; $col <= 5; $col++): // For loop creating the 5 labeled column headers?>
                <th>Column <?php echo $col; ?></th>
            <?php endfor; // End of loop ?>
        </tr>
    </thead>
    <tbody>
        <?php for ($row = 1; $row <= 5; $row++): // Outer loop that creates 5 rows ?>
        <tr>
            <?php for ($col = 1; $col <= 5; $col++): // Inner loop that generates each cell of the row ?>
            <td>
                <?php 
                $randomNumber1 = rand(1, 100); // Generate first random number
                $randomNumber2 = rand(1, 100); // Generate second random number
                echo sumRandomNumbers($randomNumber1, $randomNumber2); // Call the function, passing the two random numbers, and display the sum
                ?>
            </td>
            <?php endfor; // End of inner loop ?>
        </tr>
        <?php endfor; // End of outer loop ?>
    </tbody>
</table>

</body>
</html>