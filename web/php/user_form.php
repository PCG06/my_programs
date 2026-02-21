<!--
    Program 6:
    PHP webpage to validate the user form
-->

<!DOCTYPE html>
<html>
<head>
    <title>Form Validation</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f5f5f5;
        }
        .box {
            width: 450px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 20px;
            border: 1px solid #ccc;
        }
        h2, h3 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th {
            background-color: #4caf50;
            color: white;
            text-align: left;
        }
        td, th {
            border: 1px solid #ccc;
            padding: 8px;
        }
        input[type=text], input[type=password], input[type=date] {
            width: 100%;
            padding: 6px;
        }
        input[type=submit] {
            width: 100%;
            padding: 8px;
            background-color: #4caf50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="box">
        <?php
        $showForm = TRUE;
        if (isset($_POST['username'])) {
            $name = $_POST['name'];
            $regno = $_POST['regno'];
            $dob = $_POST['dob'];
            $mobile = $_POST['mobile'];
            $username = $_POST['username'];
            $password = $_POST['password'];

            if ($username == "admin" && $password == "1234") {
                echo "<h3>Login Successful</h3>
                <table>
                    <tr><th>Field</th><th>Value</th></tr>
                    <tr><th>Name</th><th>$name</th></tr>
                    <tr><th>Register Number</th><th>$regno</th></tr>
                    <tr><th>Date of Birth</th><th>$dob</th></tr>
                    <tr><th>Mobile Number</th><th>$mobile</th></tr>
                    <tr><th>Username</th><th>$username</th></tr>
                <table>";
            }
            $showForm = false;
        } else {
            echo "<h3 class='error'>Invalid Username or Password</h3>";
        }
        
            if ($showForm) {
        ?>
                <h2>User Details Form</h2>
                
                <form method="post">
                    Name:
                    <input type="text" name="name" required><br><br>
                    Register Number:
                    <input type="text" name="regno" required><br><br>
                    Date of Birth:
                    <input type="date" name="dob" required><br><br>
                    Mobile Number:
                    <input type="number" name="mobile" required><br><br>
                    Username:
                    <input type="text" name="username" required><br><br>
                    Password:
                    <input type="password" name="password" required><br><br>

                    <input type="submit" value="Submit">
                </form>
        <?php
            }
        ?>
    </div>
</body>
</html>
