<!--
    Program 12:
    PHP webpage to calculate investment gains using function overriding
-->

<!DOCTYPE html>
<html>
<head>
    <title>Investment Gain Calculator</title>
</head>
<body>
    <form method="post">
        <table border="2" cellpadding="2px">
            <tr>
                <td>Customer Name:</td>
                <td><input type="text" name="name">
            </tr>
            <tr>
                <td>Investment Amount:</td>
                <td><input type="number" name="amt">
            </tr>
            <tr>
                <td>Duration:</td>
                <td><input type="number" name="dur">
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
    class Investment {
        public $amt, $dur;

        public function __construct($amt, $dur) {
            $this->amt = $amt;
            $this->dur = $dur;
        }

        public function maturity_calculation() {
            echo "Overriden method";
        }
    }

    class SBI extends Investment {
        public $roi = 6.5;
        public $m1, $m2, $MA;

        public function __construct($amt, $dur) {
            parent::__construct($amt, $dur);
        }

        public function maturity_calculation() {
            $this->m1 = 1 + (($this->roi * 0.01) / 4);
            $this->dur *= 4;
            $this->m2 = pow($this->m1, $this->dur);
            $this->MA = $this->amt * $this->m2;
            echo " Maturity amount in SBI is " . round($this->MA, 2);
        }
    }

    class CBI extends Investment {
        public $roi = 5.6;
        public $m1, $m2, $MA;

        public function __construct($amt, $dur) {
            parent::__construct($amt, $dur);
        }

        public function maturity_calculation() {
            $this->m1 = 1 + (($this->roi * 0.01) / 4);
            $this->dur *= 4;
            $this->m2 = pow($this->m1, $this->dur);
            $this->MA = $this->amt * $this->m2;
            echo " Maturity amount in CBI is " . round($this->MA, 2);
        }
    }

    if (isset($_POST['submit'])) {
        $sbi = new SBI($_POST['amt'], $_POST['dur']);
        $sbi->maturity_calculation();
        echo "<br>";
        $cbi = new CBI($_POST['amt'], $_POST['dur']);
        $cbi->maturity_calculation();
    }
    ?>
</body>
</html>