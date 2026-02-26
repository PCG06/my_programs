<!DOCTYPE html>
<html>
<head>
    <title>Passport Registration Form</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data">
        <table border="2">
            <tr>
                <th colspan="2" align="center">Enter passport details</th>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><input type="text" name="sname"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="g" value="Male">Male
                    <input type="radio" name="g" value="Female">Female
                    <input type="radio" name="g" value="Other">Other
                </td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="date" name="dob"></td>
            </tr>
            <tr>
                <td>Nationality:</td>
                <td>
                    <input type="radio" name="n" value="indian">Indian
                    <input type="radio" name="n" value="nri">NRI
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><textarea cols="22" rows="3" name="add"></textarea></td>
            </tr>
            <tr>
                <td>Father's name:</td>
                <td><input type="text" name="fname"></td>
            </tr>
                <td>Mother's name:</td>
                <td><input type="text" name="mname"></td>
            </tr>
                <td>Place of Birth:</td>
                <td><input type="text" name="place"></td>
            </tr>
                <td>Date of Issue:</td>
                <td><input type="date" name="doi"></td>
            </tr>
                <td>Image:</td>
                <td><input type="file" name="imag"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" value="Submit">
                </td>
            </tr>
        </table>
        <br><br>
    <?php
    $con = new mysqli("localhost", "pcg06", "0000", "Passport");

    if (mysqli_connect_error()) {
        die("Not connected");
    } else {
        if (isset($_POST['submit'])) {
            $name = $_POST['name'];
            $sname = $_POST['sname'];
            $gender = $_POST['g'];
            $birth = $_POST['dob'];
            $nationality = $_POST['n'];
            $address = $_POST['add'];
            $fathersname = $_POST['fname'];
            $mothersname = $_POST['mname'];
            $place = $_POST['place'];
            $issue = $_POST['doi'];
            $image = $_FILES['imag'];

            $filename = time() . "_" . $_FILES['imag']['name'];
            $tempname = $_FILES['imag']['tmp_name'];
            $folder = "bin/" . $filename;
            move_uploaded_file($tempname, $folder);
            $image = $folder;

            $date = $birth;
            $t = explode('-', $issue);
            $t[0] = $t[0] + 10;
            $expiry = implode('-', $t);
            $pno = "R".mt_rand(1000000, 9999999);
            echo "
            <br>
            <table border='2'>
                <tr>
                    <th colspan='2'>Passport</th>
                </tr>
                <tr>
                    <td colspan='2' align='center'><img src=$image height='100px' width='80px'></td>
                </tr>
                <tr>
                    <td>Passport Number:</td>
                    <td>$pno</td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>$name</td>
                </tr>
                <tr>
                    <td>Surname:</td>
                    <td>$sname</td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>$gender</td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td>$birth</td>
                </tr>
                <tr>
                    <td>Nationality:</td>
                    <td>$nationality</td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td>$address</td>
                </tr>
                <tr>
                    <td>Father's Name:</td>
                    <td>$fathersname</td>
                </tr>
                <tr>
                    <td>Mother's Name:</td>
                    <td>$mothersname</td>
                </tr>
                <tr>
                    <td>Place of Birth:</td>
                    <td>$place</td>
                </tr>
                <tr>
                    <td>Date of Issue:</td>
                    <td>$issue</td>
                </tr>
                <tr>
                    <td>Date of Expiry:</td>
                    <td>$expiry</td>
                </tr>
            </table>
            ";

            $res = "INSERT INTO passport VALUES('$pno', '$name', '$sname', '$gender', '$birth', '$nationality', '$address', '$fathersname', '$mothersname', '$place', '$issue', '$expiry', '$image')";
            $con->query($res);
        }
    }
    $con->close();
    ?>
    </form>
</body>
</html>
