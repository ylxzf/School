<?php
    ob_start();
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Film adding</title>

    <style>
        * {
            font-family: sans-serif;
        }

        form {
            display: flex;
            justify-content: center;
        }

        form fieldset {
            width: 20%;
        }

        .center {
            display: flex;
            justify-content: center;
        }

        table,td{
            border: 1px solid black;
            border-collapse: collapse;
        }

        td {
            padding: 0.3rem;
        }

        button {
            margin-top: 15px;
        }

        a {
            color: black;
        }

        a:active {
            color: black;
        }

        .input-container {
            margin-left: 0.5rem;
            margin-right: 0.5rem;
        }

        .input-container input {
            margin-top: 0.25rem;
        }
    </style>
</head>
<body>
    <?php
        echo('
            <h1 class="center">Film database addition</h1>
            <form action="filmy_add.php" method="POST">
                <fieldset>
                    <div class="center">
                        <div class="input-container">
                            <label for="film_nazev_form">Název filmu: </label>
                            <input type="text" name="film_nazev_form" placeholder="Název filmu" required>                
                        </div>
                        <br>
                        <div class="input-container">
                            <label for="film_zanr_form">Žánr filmu</label>
                            <input type="text" name="film_zanr_form" placeholder="Žánr filmu" required>
                        </div>
                        <br>
                        <div class="input-container">
                            <label for="film_rezie_form">Režie filmu</label>
                            <input type="text" name="film_rezie_form" placeholder="Režie filmu" required>
                        </div>
                        <div class="input-container">
                            <button type="submit" name="formSubmit" value="formSubmit">Submit</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        ');

        if (isset($_REQUEST['formSubmit'])) {
            require_once '../dbconnect.php';
            $db = connectDB('filmy');

            try {
                $query = $db->prepare('INSERT INTO film (film_nazev, film_zanr, film_rezie)
                                            VALUES (?, ?, ?)');
                $params = array($_REQUEST['film_nazev_form'], $_REQUEST['film_zanr_form'], $_REQUEST['film_rezie_form']);
                $queryResult = $query->execute($params);
            }
            catch (PDOException $e) {
                echo $e->getMessage();
            }

            if (!$queryResult) {
                echo ('<script type="text/javascript">alert("Query failed!");</script>');
            }
            else {
                echo ('<script type="text/javascript">alert("Query completed successfully!");</script>');
            }
        }
    ?>
</body>
</html>
<?php
    ob_end_flush();
?>
