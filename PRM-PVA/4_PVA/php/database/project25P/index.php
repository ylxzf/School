<?php
    session_start();
    ob_start();
    require_once '../dbconnect.php';
    $db = connectDb('pujcovna');

    require_once 'functions.php';
    $error = "";

    if (isset($_POST['submitLogin'])) {
        $username = htmlspecialchars($_REQUEST['username_form']);
        $password = htmlspecialchars($_REQUEST['password_form']);

        if (($username == "") || ($password == "")) {
            $error = "Username or Password is empty";
        }
        else {
            if (!login($username, $password, $db)) {
                $error = "Invalid Username or Password";
            }
        }
    }

    if (isset($_REQUEST['submitLogout'])) {
        if (!LogOut()) {
            $error = "Error in logging out";
        }
    }

?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Projekt</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div id="header">
        <h1>Projekt</h1>
    </div>
    <div id="obsah">
        <?php
            try {
                $query = $db -> prepare("SELECT * FROM `puj_knihy`");
                $query -> execute();
            }
            catch (PDOException $e) {
                die("Database error: " . $e -> getMessage());
            }

            echo('
                <table>
                    <tr>
                        <th>Název</th>
                        <th>Autor</th>
                        <th>Žánr</th>
                        <th>Počet</th>
                        <th>Půjčit/Vrátit</th>
                    </tr>
            ');

            foreach ($query -> fetchAll() as $row) {
                $kniha_id = $row['puj_knihy_id'];
                echo ('
                    <tr>
                        <td>' . $row['puj_knihy_nazev'] . '</td>
                        <td>' . $row['puj_knihy_autor'] . '</td>
                        <td>' . $row['puj_knihy_zanr'] . '</td>
                        <td>' . $row['puj_knihy_pocet'] . '</td>
                ');
                if (isLoggedIn()) {
                    $userID = $_SESSION[session_id()];
                    try {
                        $queryVyp = $db -> prepare('SELECT * FROM `puj_vypujcky` WHERE `puj_vyp_idKniha` = ?');
                        $params = array($kniha_id);
                        $queryVyp -> execute($params);
                    }
                    catch (PDOException $e) {
                        die("Database error: " . $e -> getMessage());
                    }

                    $check = false;
                    $status = 'borrow';


                    foreach ($queryVyp -> fetchAll() as $rowVyp) {
                        if ($rowVyp['puj_vyp_idKniha'] == $kniha_id && $rowVyp['puj_vyp_idUzivatel'] == $_SESSION[session_id()]) {
                            $check = true;
                            $status = 'return';
                            echo ('
                                <td>
                                    <a href="./changeStatus.php?kniha_id=' . $kniha_id . '&status=' . $status .'">Vrátit</a>
                                </td>
                            ');
                            break;
                        }
                    }

                    if ($check == false) {
                        echo('
                                <td>
                                    <a href="./changeStatus.php?kniha_id=' . $kniha_id . '&status=' . $status .'">Půjčit</a>
                                </td>
                            </tr>
                        ');
                    }
                }
                else {
                    echo ('
                        <td colspan="2">You must log in.</td>
                    </tr>
                ');
                }
            }

            echo('</table>')
        ?>
    </div>
    <div id="login">
        <?php
            if (!isset($_SESSION[session_id()])) {
                echo('
                    <form action="" method="POST">
                        <legend>
                            <h3>Login Form</h3>
                        </legend>
                        <fieldset>
                            <div>
                                <label for="username">Username: </label>
                                <input type="text" name="username_form" placeholder="Username">
                            </div>
                            <div>
                                <label for="">Password: </label>
                                <input type="password" name="password_form" placeholder="Password">
                            </div>
                            <div>
                                <button name="submitLogin" value="submitForm">Log In</button>
                            </div>
                        </fieldset>
                    </form>
                ');
            }
            else {
                echo('
                    <form action="" method="POST">
                        <legend>
                            <h3>Login Form</h3>
                        </legend>
                        <fieldset>
                            <div>
                                <h3>You are logged in.</h3>
                            </div>
                            <div>
                                <button name="submitLogout">Log Out</button>
                            </div>
                        </fieldset>
                    </form>
                ');
            }
        ?>
    </div>
    <div>
        <p class="error">
            <?php
                if ($error != "") {
                    echo($error);
                }
            ?>
        </p>
    </div>
</body>
</html>
<?php
    ob_end_flush();
?>