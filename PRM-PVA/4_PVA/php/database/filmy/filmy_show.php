<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Filmy</title>
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
    </style>
</head>
<body>
    <?php
        require_once('../dbconnect.php');
        $db = connectDB('filmy');

        try {
            $query = $db->prepare("SELECT * FROM film");
            $query->execute();
        }
        catch (PDOException $e) {
            echo $e->getMessage();
        }

        echo('
            <h1 class="center">Film database</h1>
            <div class="center">
                <table>
                    <tr>
                        <th>Název</th>
                        <th>Žánr</th>
                        <th>Režie</th>
                        <th colspan="2">Akce</th>
                    </tr>
        ');

        foreach($query->fetchAll() as $row){
            $id = $row['film_id'];
            echo('
                    <tr>
                        <td>'.$row['film_nazev'].'</td>
                        <td>'.$row['film_zanr'].'</td>
                        <td>'.$row['film_rezie'].'</td>
                        <td><a href="filmy_edit.php?id=' . $id . '">Edit</a></td>
                        <td><a href="filmy_delete.php?id=' . $id. '">Delete</a></td>
                    </tr>
            ');
        }

        echo('
                </table>
            </div>
        ');

        echo('
            <br>
            <div class="center">
                <a href="filmy_add.php">Add new records</a>
            </div>   
        ')
    ?>
</body>
</html>
