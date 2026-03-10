<!-- 
    Program 15:
    PHP webpage to book movie tickets online using sessions, cookies and exception handling
-->

<!DOCTYPE html>
<html>
<head>
    <title>Movie Ticket Booking</title>
</head>
<body>
    <h2>Online Movie Ticket Booking</h2>
    <form method="post">
        Name:
        <input type="text" name="name">
        <br><br>
        Movie Name:
        <input type="text" name="movie">
        <br><br>
        Tickets:
        <input type="number" name="tickets">
        <br><br>
        <input type="submit" name="submit" value="Book Tickets">
    </form>
    <?php
    session_start();

    // Custom exception
    class TicketBookingException extends Exception {
        public function errorMessage() {
            return $this->getMessage();
        }
    }

    if (isset($_POST['submit'])) {
        try {
            $name = $_POST['name'];
            $movie = $_POST['movie'];
            $tickets = $_POST['tickets'];

            if (empty($name)) {
                throw new TicketBookingException("Customer name cannot be empty!");
            }
            if (empty($movie)) {
                throw new TicketBookingException("Movie name cannot be empty!");
            }
            if (!is_numeric($tickets) || $tickets < 0) {
                throw new TicketBookingException("Number of tickets must be greater than 0!");
            }
            if ($tickets > 5) {
                throw new TicketBookingException("Maximum 5 tickets allowed per booking!");
            }

            echo "<h3 style='color: green'>Ticket booking successful!</h3>";
            echo "<h3>Dear, $name.<br>$tickets ticket(s) booked for the movie '$movie'</h3>";

            $_SESSION['name'] = $name;
            $_SESSION['movie'] = $movie;
            $_SESSION['tickets'] = $tickets;

            setcookie("last_movie", $movie, time() + 3600); // cookie expires after 1 hour
            $total_amt = 500 * $tickets;
            echo "Total amount: Rs $total_amt<br>";
        } catch (TicketBookingException $e) {
            echo "<h3 style='color:red'>" . $e->errorMessage() . "</h3>";
            error_log($e->getMessage());
        } catch (Exception $e) {
            echo "<h3 style='color:red'>" . $e->getMessage() . "</h3>";
            error_log($e->getMessage());
        }
    }

    // Display session, only if booking was successful
    if (isset($_SESSION['name'])) {
        echo "<h3>Session Data:</h3>";
        echo "Customer name: " . $_SESSION['name'] . "<br>";
        echo "Movie name: " . $_SESSION['movie'] . "<br>";
        echo "Tickets: " . $_SESSION['tickets'] . "<br>";
    }

    // Cookie data
    if (isset($_COOKIE['last_movie'])) {
        echo "<h3>Cookie Data:</h3>";
        echo "Last movie: " . $_COOKIE['last_movie'];
    }
    ?>
</body>
</html>