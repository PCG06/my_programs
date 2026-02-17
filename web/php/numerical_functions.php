<!-- 
    Program 10:
    PHP webpage to use form with numerical functions
-->

<!DOCTYPE html>
<html>
<head>
    <title>PHP Numerical Functions</title>
</head>
<body>
    <h2>Numerical Functions</h2>
    <form method="post">
        Number 1:
        <input type="number" name="num1" required>
        <br><br>
        Number 2:
        <input type="number" name="num2" required>
        <br><br>
        <b>Select Operators</b><br>
        <input type="checkbox" name="op[]" value="abs"> Absolute <br>
        <input type="checkbox" name="op[]" value="ceil"> Ceil <br>
        <input type="checkbox" name="op[]" value="floor"> Floor <br>
        <input type="checkbox" name="op[]" value="round"> Round <br>
        <input type="checkbox" name="op[]" value="sqrt"> Square Root <br>
        <input type="checkbox" name="op[]" value="pow"> Power <br>
        <input type="checkbox" name="op[]" value="max"> Maximum <br>
        <input type="checkbox" name="op[]" value="min"> Minimum <br>
        <input type="checkbox" name="op[]" value="rand"> Random Number <br>
        <input type="submit" name="submit" value="Calculate">
    </form>
    <?php
    if (isset($_POST['submit'])) {
        $n1 = $_POST['num1'];
        $n2 = $_POST['num2'];
        
        if (isset($_POST['op'])) {
            foreach($_POST['op'] as $op) {
                if ($op == "abs")
                    echo "Absolute value of $n1: " . abs($n1) . "<br>";
                else if ($op == "ceil")
                    echo "Ceil value of $n1: " . ceil($n1) . "<br>";
                else if ($op == "floor")
                    echo "Floor value of $n1: " . ceil($n1) . "<br>";
                else if ($op == "round")
                    echo "Rounded value of $n1: " . round($n1) . "<br>";
                else if ($op == "sqrt") {
                    if ($n1 > 0)
                        echo "Square root: " . sqrt($num) . "<br>";
                    else
                        echo "Square root not possible for negative numbers<br>";
                }
                else if ($op == "pow")
                    echo "Power ($n1<sup>$n2</sup>): " . pow($n1, $n2) . "<br>";
                else if ($op == "max")
                    echo "Maximum value: " . max($n1, $n2) . "<br>";
                else if ($op == "pow")
                    echo "Minimum value: " . min($n1, $n2) . "<br>";
                else if ($op == "pow")
                    echo "Random value: " . rand($n1, $n2);
            }
        }
    }
    else {
        echo "Please select at least one operation";
    }
    ?>
</body>
</html>
