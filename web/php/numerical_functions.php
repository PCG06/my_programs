<!-- PHP webpage to use form with numerical functions and CSS -->

<!DOCTYPE html>
<html>
<head>
    <title>Numerical Functions with Form</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f0f4f8;
        }
        .box {
            width: 350px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        input, button {
            width: 100;
            padding: 8px;
            margin-top: 10px;
        }
        button {
            background-color: #1565c0;
            color: white;
            border: none;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>Numerical Functions</h2>
        <form method="post">
            Enter a number:
            <input type="number" name="num" required>
            <br>
            Enter power value:
            <input type="number" name="pow" required>
            <button type="submit">Calculate</button>
        </form>
        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $num = $_POST['num'];
            $pow = $_POST['pow'];
            echo "<hr>";
            echo "Absolute value: " . abs($num) . "<br>";
            echo "Square root: " . sqrt($num) . "<br>";
            echo "Power result: " . pow($num, $pow) . "<br>";
            echo "Rounded value: " . round($num) . "<br>";
        }
        ?>
    </div>
</body>
