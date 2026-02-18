<!-- 
    Program 10:
    PHP webpage to calculate salary for fulltime and partime employee using inheritance concept
-->

<!DOCTYPE html>
<html>
<head>
    <title>Salary Calculation</title>
</head>
<body>
    <form method="post">
        <table border="2" cellpadding="2px">
            <tr>
                <th colspan="2" align="center">Enter employee details</th>
            </tr>
            <tr>
                <td>Employee name:</td>
                <td><input type="text" name="empname"></td>
            </tr>
            <tr>
                <td>Employee number:</td>
                <td><input type="number" name="empno"></td>
            </tr>
            <tr>
                <td>Select job type:</td>
                <td>
                    <input type="radio" name="job" value="fulltime">Full-time<br>
                    <input type="radio" name="job" value="parttime">Part-time
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form>
    <br><br>
    <?php
    class Employee {
        public $empname;
        public $empno;
        
        public function __construct($empname, $empno) {
            $this->empname = $empname;
            $this->empno = $empno;
        }
    }

    class FullTime extends Employee {
        public $bsal = 1000;
        public $DA, $HRA, $PF, $gsal, $tsal, $days;

        public function __construct($empname, $empno) {
            parent::__construct($empname, $empno);
        }

        public function compute() {
            $this->DA = $this->bsal * 0.45;
            $this->HRA = $this->bsal * 0.07;
            $this->PF = $this->bsal * 0.1;
            $this->gsal = $this->DA + $this->HRA + $this->PF;
            $this->tsal = $this->bsal + $this->gsal;
        }

        public function display() {
            echo "
            <table border='2' cellpadding='2px'>
                <tr>
                    <th colspan='2'>Fulltime</th>
                </tr>
                <tr>
                    <td>Employee Name:</td>
                    <td>$this->empname</td>
                </tr>
                <tr>
                    <td>Employee Number:</td>
                    <td>$this->empno</td>
                </tr>
                <tr>
                    <td>Dearness Allowed:</td>
                    <td>$this->DA</td>
                </tr>
                <tr>
                    <td>House Rent Allowed:</td>
                    <td>$this->HRA</td>
                </tr>
                <tr>
                    <td>Provident Fund:</td>
                    <td>$this->PF</td>
                </tr>
                <tr>
                    <td>Gross Salary:</td>
                    <td>$this->gsal</td>
                </tr>
                <tr>
                    <td>Total Salary:</td>
                    <td>$this->tsal</td>
                </tr>
            </table>";
        }
    }

    class PartTime extends Employee {
        public $bsal = 1000;
        public $tsal, $hours = 20;

        public function __construct($empname, $empno) {
            parent::__construct($empname, $empno);
        }

        public function compute() {
            $this->tsal = $this->bsal * $this->hours;
        }

        public function display() {
            echo "
            <table border='2' cellpadding='2px'>
                <tr>
                    <th colspan='2'>Parttime</th>
                </tr>
                <tr>
                    <td>Employee Name:</td>
                    <td>$this->empname</td>
                </tr>
                <tr>
                    <td>Employee Number:</td>
                    <td>$this->empno</td>
                </tr>
                <tr>
                    <td>Total Salary:</td>
                    <td>$this->tsal</td>
                </tr>
            </table>";
        }
    }

    if (isset($_POST['submit'])) {
        $job = $_POST['job'];
        if ($job == "fulltime") {
            $emp = new FullTime($_POST['empname'], $_POST['empno']);
            $emp->compute();
            $emp->display();
        } else  {
            $emp = new PartTime($_POST['empname'], $_POST['empno']);
            $emp->compute();
            $emp->display();
        }
    }
    ?>
</body>
</html>