<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pong</title>
</head>
<body>
    <h1>Pong</h1>
    <a href="ping_C.php">Ping</a>
    <?php
        if (isset($_POST['reset'])) {
            unset($_COOKIE['id']);
            unset($_COOKIE['count']);
        }

        if (isset($_COOKIE['id'])) {
            $id = htmlspecialchars($_COOKIE['id']);
        }
        else {
            setcookie("id", rand(0, 1000));
            $id = $_COOKIE['id'];
        }

        if (isset($_COOKIE['count'])) {
            setcookie("count", $_COOKIE['count'] + 1);
            $count = htmlspecialchars($_COOKIE['count']);
        }
        else {
            setcookie("count", 1);
            $count = $_COOKIE['count'];
        }
        //show data
        print ("<p>ID: $id</p>");
        //show count
        print ("<p>Visits: $count</p>");
    ?>

    <form action="" method="POST">
        <button type="submit" name="reset" value="reset">Reset</button>
    </form>
</body>
</html>
