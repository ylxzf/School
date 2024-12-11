<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pong</title>
</head>
<body>
    <h1>Pong</h1>
    <?php
        if (isset($_GET['reset'])) {
            $id = rand(1, 1000);
            $count = 1;
        }

        if (isset($_GET['id'])) {
            $id = htmlspecialchars($_GET['id']);
        }
        else {
            $id = rand(1, 1000);
        }


        if (isset($_GET['count'])) {
            $count = htmlspecialchars($_GET['count']);
            $count++;
        }
        else {
            $count = 1;
        }
        //show data
        print ("<p>ID: $id</p>");
        //show count
        print ("<p>Visits: $count</p>");
        print ("<p><a href=\"ping_L.php?id=$id&count=$count\">PING</a></p>");


    ?>
    <form action="" method="get">
        <button type="submit" name="reset">Reset</button>
    </form>
</body>
</html>
