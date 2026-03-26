<!--
    Program 8:
    PHP webpage to calculate the costliest and cheapest items from a list using array functions
-->

<!DOCTYPE html>
<html>
<head>
    <title>Item Entry Form</title>
</head>
<body>
    <h2>Enter Item and Prices</h2>
    <form method="post">
        Item 1 Name:
        <input type="text" name="itemNames[]" required>
        Price:
        <input type="number" name="itemPrices[]" required>
        <br><br>
        Item 2 Name:
        <input type="text" name="itemNames[]" required>
        Price:
        <input type="number" name="itemPrices[]" required>
        <br><br>
        Item 3 Name:
        <input type="text" name="itemNames[]" required>
        Price:
        <input type="number" name="itemPrices[]" required>
        <br><br>
        <input type="submit" value="Submit" name="submit">
    </form>
    <?php
    if (isset($_POST['submit'])) {
        $itemNames = $_POST['itemNames'];
        $itemPrices = $_POST['itemPrices'];

        $maxPrice = max($itemPrices);
        $minPrice = min($itemPrices);
        $maxIndex = array_search($maxPrice, $itemPrices);
        $minIndex = array_search($minPrice, $itemPrices);

        echo "<h2>Results:</h2>";
        echo "Costliest item: $itemNames[$maxIndex] $maxPrice <br>";
        echo "Cheapest item: $itemNames[$minIndex] $minPrice";
    }
    ?>
</body>
</html>
