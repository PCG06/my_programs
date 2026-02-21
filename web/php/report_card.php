<!-- 
    Program 11:
    PHP webpage to generate a report card using class and constructors
-->

<!DOCTYPE html>
<html>
<head>
    <title>Student Report Card</title>
</head>
<body>
    <form method="post">
        <table border="2" cellpadding="2px">
            <tr>
                <th colspan="2" align="center">Report Card</th>
            </tr>
            <tr>
                <td>Register number:</td>
                <td><input type="number" name="regno"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Class:</td>
                <td><input type="text" name="class"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">Enter Marks</td>
            </tr>
            <tr>
                <td>Programming in Java:</td>
                <td><input type="number" name="java"></td>
            </tr>
            <tr>
                <td>Web Programming using PHP:</td>
                <td><input type="number" name="php"></td>
            </tr>
            <tr>
                <td>Computer Oriented Numerical Analysis:</td>
                <td><input type="number" name="cona"></td>
            </tr>
            <tr>
                <td>Data Mining:</td>
                <td><input type="number" name="dm"></td>
            </tr>
            <tr>
                <td>LAB 1: Programming in Java:</td>
                <td><input type="number" name="lab1"></td>
            </tr>
            <tr>
                <td>LAB 2: Web Programming using PHP:</td>
                <td><input type="number" name="lab2"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" value="Submit">
                    <input type="reset" name="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>
    <br><br>
    <?php
    class Report {
        public $regno, $name, $class;
        public $java, $php, $dm, $cona, $lab1, $lab2;
        public $total, $avg, $result, $bgcolor;

        public function __construct($regno, $name, $class, $java, $php, $dm, $cona, $lab1, $lab2) {
            $this->regno = $regno;
            $this->name = $name;
            $this->class = $class;
            $this->java = $java;
            $this->php = $php;
            $this->dm = $dm;
            $this->cona = $cona;
            $this->lab1 = $lab1;
            $this->lab2 = $lab2;
        }

        public function calculate() {
            $this->total = $this->java + $this->php + $this->dm + $this->cona + $this->lab1 + $this->lab2;
            $this->avg = round($this->total / 6, 2);
            
            if ($this->java < 35 || $this->php < 35 || $this->dm < 35
             || $this->cona < 35 || $this->lab1 < 35 || $this->lab2 < 35) {
                $this->result = "Fail";
                $this->bgcolor = "red";
            } else  {
                $this->result = "Pass";
                $this->bgcolor = "green";
            }
        }

        public function display() {
            echo "
            <table border='2' cellpadding='2px'>
                <tr>
                    <td colspan='2'>St Aloysius College</td>
                </tr>
                <tr>
                    <td colspan='2'>Report Card</td>
                </tr>
                <tr>
                    <td>Student Name:</td>
                    <td>$this->name</td>
                </tr>
                <tr>
                    <td>Register Number:</td>
                    <td>$this->regno</td>
                </tr>
                <tr>
                    <td>Class:</td>
                    <td>$this->class</td>
                </tr>
                <tr>
                    <td colspan='2'>Marks Scored</td>
                </tr>
                <tr>
                    <td>Programming in Java:</td>
                    <td>$this->java</td>
                </tr>
                <tr>
                    <td>Web Programming using PHP:</td>
                    <td>$this->php</td>
                </tr>
                <tr>
                    <td>Data Mining:</td>
                    <td>$this->dm</td>
                </tr>
                <tr>
                    <td>Computer Oriented Numerical Analysis:</td>
                    <td>$this->cona</td>
                </tr>
                <tr>
                    <td>Lab 1: Programming in Java:</td>
                    <td>$this->lab1</td>
                </tr>
                <tr>
                    <td>Lab 2: Web Programming using PHP:</td>
                    <td>$this->lab2</td>
                </tr>
                <tr>
                    <td>Total:</td>
                    <td>$this->total</td>
                </tr>
                <tr>
                    <td>Percentage:</td>
                    <td>$this->avg</td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td bgcolor=$this->bgcolor>$this->result</td>
                </tr>
            </table>";
        }
    }

    if (isset($_POST['submit'])) {
        $regno = $_POST['regno'];
        $name = $_POST['name'];
        $class = $_POST['class'];
        $java = $_POST['java'];
        $php = $_POST['php'];
        $dm = $_POST['dm'];
        $cona = $_POST['cona'];
        $lab1 = $_POST['lab1'];
        $lab2 = $_POST['lab2'];

        if (empty($regno) || empty($name) || empty($class)
         || empty($java) || empty($php) || empty($dm) || empty($cona)
         || empty($lab1) || empty($lab2)) {
            echo "You cannot leave any field blank!";
        } else {
            $report = new Report($regno, $name, $class, $java, $php, $dm, $cona, $lab1, $lab2);
            $report->calculate();
            $report->display();
        }
    }
    ?>
</body>
</html>
