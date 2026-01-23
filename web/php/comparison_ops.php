<!-- PHP webpage to showcase comparison operators -->

<!DOCTYPE html>
<html>
<body>
    <h3>Comparison operators in PHP</h3>
    <form method="post">
        Enter first number:
        <input type="number" name="n1" required>
        <br><br>
        Enter second number:
        <input type="number" name="n2" required>
        <br><br>
        Choose comparison operator:
        <select name="operation" required>
            <option value="">Select</option>
            <option value="eq">Equal (==)</option>
            <option value="neq">Not Equal (!=)</option>
            <option value="gt">Greater than (&gt;)</option>
            <option value="lt">Lesser than (&lt;)</option>
            <option value="gte">Greater than or Equal (&gt;=)</option>
            <option value="lte">Lesser than or Equal (&lt;=)</option>
        </select>
        <br><br>
        <input type="submit" name="submit" value="Compare">
    </form>
    <?php
    if (isset($_POST['submit'])) {
        $a = $_POST['n1'];
        $b = $_POST['n2'];
        $op = $_POST['operation'];

        switch ($op) {
            case "eq":
                $result = ($a == $b);
                break;
            case "neq":
                $result = ($a != $b);
                break;
            case "gt":
                $result = ($a > $b);
                break;
            case "lt":
                $result = ($a < $b);
                break;
            case "gte":
                $result = ($a >= $b);
                break;
            case "lte":
                $result = ($a <= $b);
                break;
            default:
                echo "<br>Please select an operation";
                exit;
        }
        echo "<br><br>Result: ", ($result ? "TRUE" : "FALSE"), "<br>";
    }
    ?>
</body>
</html>
