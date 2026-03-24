<!-- 
    Program 13:
    PHP webpage to insert items using MySQL and display the table content
-->

<!DOCTYPE html>
<html>
<head>
    <title>Item Database</title>
</head>
<body>
    <form method="post">
        <table border="3">
            <tr>
                <th colspan="2" align="center">Enter item details</th>
            </tr>
            <tr>
                <td>Item ID:</td>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <td>Item Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Item Price:</td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="number" name="qty"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="add" value="ADD">
                    <input type="submit" name="view" value="VIEW">
                </td>
            </tr>
        </table>
        <br><br>
    <?php
    $con = new mysqli("localhost", "pcg06", "0000"); // "items" - fourth arg

    // Database creation
    $con->query("CREATE DATABASE IF NOT EXISTS items");
    $con->query("USE items");
    $con->query("CREATE TABLE IF NOT EXISTS product (
                    id INT PRIMARY KEY,
                    name VARCHAR(10),
                    price INT,
                    qty INT
                )");

    if (mysqli_connect_error()) {
        die("Not connected");
    } else {
        if (isset($_POST['add'])) {
            $name = $_POST['name'];
            $id = $_POST['id'];
            $price = $_POST['price'];
            $qty = $_POST['qty'];

            $ins = "INSERT INTO product values ('$id', '$name', '$price', '$qty')";
            if ($con->query($ins)) {
                echo "Data added";
            } else {
                echo "Data not added";
            }
        } else if ($_POST['view']) {
            $sql = "SELECT * FROM product";
            $res = $con->query($sql);

            if ($res->num_rows > 0) {
                echo "
                <br>
                <table border='2'>
                    <tr>
                        <th>Item ID</th>
                        <th>Item Name</th>
                        <th>Item Price</th>
                        <th>Item Quantity</th>
                    </tr>
                ";

                while ($row = $res->fetch_assoc()) {
                    $id = $row['id'];
                    $name = $row['name'];
                    $price = $row['price'];
                    $qty = $row['qty'];

                    echo "
                    <tr>
                        <td>$id</td>
                        <td>$name</td>
                        <td>$price</td>
                        <td>$qty</td>
                    </tr>
                    ";
                }
            }
        } else {
            echo "No result";
        }
        $con->close();
    }
    ?>
    </form>
</body>
</html>
