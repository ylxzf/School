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
    global $query, $id;

    if (isset($_REQUEST["id"])) {
        $id = $_REQUEST["id"];

        try {
            require_once '../dbconnect.php';
            $db = connectDB('filmy');

            $query = $db->prepare('SELECT * FROM film WHERE film_id = ?');
            $params = array($id);
            $queryResult = $query->execute($params);
        }
        catch (PDOException $e) {
            echo $e->getMessage();
        }

        $rowData = $query->fetchAll(PDO::FETCH_ASSOC);


        $film_nazev_get = $rowData[0]['film_nazev'];
        $film_zanr_get = $rowData[0]['film_zanr'];
        $film_rezie_get = $rowData[0]['film_rezie'];

    }

    echo('
        <h1 class="center">Film database addition</h1>
        <form action="filmy_add.php" method="POST">
            <fieldset>
                <div class="center">
                    <div class="input-container">
                        <label for="film_nazev_form">Název filmu: </label>
                        <input type="text" name="film_nazev_form_edit" placeholder="Název filmu" value="'. $film_nazev_get .'" required>                
                    </div>
                    <br>
                    <div class="input-container">
                        <label for="film_zanr_form">Žánr filmu</label>
                        <input type="text" name="film_zanr_form_edit" placeholder="Žánr filmu" value="' . $film_zanr_get .'" required>
                    </div>
                    <br>
                    <div class="input-container">
                        <label for="film_rezie_form">Režie filmu</label>
                        <input type="text" name="film_rezie_form_edit" placeholder="Režie filmu" value="'. $film_rezie_get .'" required>
                    </div>
                    <div class="input-container">
                        <button type="submit" name="formEditSubmit" value="formEditSubmit">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    ');

if (isset($_REQUEST['formEditSubmit'])) {
    require_once '../dbconnect.php';
    $db = connectDB('filmy');

    $film_nazev_edit = $_REQUEST['film_nazev_form_edit'];
    $film_zanr_edit = $_REQUEST['film_zanr_form_edit'];
    $film_rezie_edit = $_REQUEST['film_rezie_form_edit'];

    try {
        $query = $db->prepare('UPDATE film SET film_nazev=?, film_zanr=?, film_rezie=? WHERE film_id=?');
        $params = array($film_nazev_edit, $film_zanr_edit, $film_rezie_edit, $id);
        print_r($params);
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
        header("Location: ./filmy_show.php");
    }
}
?>
</body>
</html>
<?php
ob_end_flush();
?>

