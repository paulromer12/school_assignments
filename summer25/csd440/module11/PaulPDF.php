<?php
// Paul Romer Module 11 Assignment - PDF Generation with FPDF

// Include FPDF library (download from http://www.fpdf.org/)
require('fpdf186/fpdf.php');

// Database connection parameters
$servername = "localhost";  
$username = "student1";
$password = "pass";
$dbname = "baseball_01";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetch data from players table
$sql = "SELECT id, name, position, batting_average, home_runs, debut_date FROM players ORDER BY name";
$result = $conn->query($sql);

// Create PDF class extending FPDF
class PDF extends FPDF
{
    // Page header
    function Header()
    {
        // Set font first before any text output
        $this->SetFont('Arial','B',16);
        $this->Cell(0,10,'Baseball Players Database Report',0,1,'C');
        $this->SetFont('Arial','',10);
        $this->Cell(0,5,'Paul Romer - Module 11 Assignment',0,1,'C');
        $this->Ln(10);
    }

    // Page footer
    function Footer()
    {
        // Position at 1.5 cm from bottom
        $this->SetY(-15);
        // Set font and color for footer
        $this->SetFont('Arial','',8);
        $this->SetTextColor(0);
        // Page number and date
        $this->Cell(0,10,'Page '.$this->PageNo().' | Generated: '.date('F j, Y g:i A'),0,0,'C');
    }

    // table with colors
    function FancyTable($header, $data)
    {
        // Set font for table
        $this->SetFont('Arial','B',10);
        
        // Colors, line width and bold
        $this->SetFillColor(76,175,80); // Green header
        $this->SetTextColor(255);
        $this->SetLineWidth(.3);
        
        // Header
        $w = array(15, 45, 30, 25, 25, 30); // Column widths
        for($i=0;$i<count($header);$i++)
            $this->Cell($w[$i],7,$header[$i],1,0,'C',true);
        $this->Ln();
        
        // Color and font restoration
        $this->SetFillColor(242,242,242); // Light gray for alternate rows
        $this->SetTextColor(0);
        $this->SetFont('Arial','',9); // font for data
        
        // Data
        $fill = false;
        foreach($data as $row)
        {
            $this->Cell($w[0],6,$row[0],'LR',0,'C',$fill);
            $this->Cell($w[1],6,substr($row[1],0,20),'LR',0,'L',$fill);
            $this->Cell($w[2],6,$row[2],'LR',0,'L',$fill);
            $this->Cell($w[3],6,number_format($row[3],3),'LR',0,'C',$fill);
            $this->Cell($w[4],6,$row[4],'LR',0,'C',$fill);
            $date_display = $row[5] ? date('M j, Y', strtotime($row[5])) : 'N/A';
            $this->Cell($w[5],6,$date_display,'LR',0,'C',$fill);
            $this->Ln();
            $fill = !$fill;
        }
        
        // Closing line
        $this->Cell(array_sum($w),0,'','T');
        $this->Ln();
        
        // Footer row with summary
        $this->SetFillColor(33,150,243); // Blue footer
        $this->SetTextColor(255);
        $this->Cell(array_sum($w),7,'Total Players: '.count($data),1,0,'C',true);
        $this->Ln();
    }
}

// Create PDF instance
$pdf = new PDF();
$pdf->AddPage();

// Set default font before any text output
$pdf->SetFont('Arial','B',12);
$pdf->Cell(0,10,'About Baseball Statistics',0,1,'L');

// Set regular font for body text
$pdf->SetFont('Arial','',10);

$info_text = "This database contains information about baseball players, including both current stars and historical legends. The data tracks key performance metrics essential for evaluating player performance:

- Batting Average: A measure of hitting performance (hits + at-bats). A .300+ average is excellent.
- Home Runs: Total home runs hit by the player.
- Position: The defensive position the player primarily plays on the field.
- Debut Date: When the player first appeared in professional baseball.

The report includes data for ".$result->num_rows." players.";

// Split text from info_text into lines and add to PDF
$lines = explode("\n", $info_text);
foreach($lines as $line) {
    if(trim($line) != '') {
        if(strpos($line, '-') !== false) {
            $pdf->Cell(5,6,'',0,0); // Indent bullet points
            $pdf->MultiCell(0,6,trim($line),0,'L');
        } else {
            $pdf->MultiCell(0,6,trim($line),0,'L');
        }
        $pdf->Ln(2);
    } else {
        $pdf->Ln(3);
    }
}

$pdf->Ln(5);

// Prepare data for table
$tableData = array();
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $tableData[] = array(
            $row["id"],
            $row["name"],
            $row["position"],
            $row["batting_average"],
            $row["home_runs"],
            $row["debut_date"]
        );
    }
}

// Add table title
$pdf->SetFont("Arial", "BU", 12);
$pdf->Cell(0,10,'Players Data Table',0,1,'C');
$pdf->Ln(2);

// Create table
$pdf->SetLeftMargin(18);
$header = array('ID', 'Player Name', 'Position', 'Batting Avg', 'Home Runs', 'Debut Date');
$pdf->FancyTable($header, $tableData);

// Reset margin 
$pdf->SetLeftMargin(10);

// Close database connection
$conn->close();

// Output PDF
$pdf->Output();
?>