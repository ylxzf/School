<?php
    session_start();
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User login Application</title>
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

        button {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <?php
        require_once '../dbconnect.php';
        $db = connectDB('login');
        global $login;

        if (isset($_POST['submitLogin'])) {
            $login = htmlspecialchars($_POST['login']);
            $password = htmlspecialchars($_POST['password']);

            if (empty($login) || empty($password)) {
                echo('<script type="text/javascript">alert("No password or username entered.");</script>');
            }
            else {
                $password = md5($password);
                try {
                    $query = $db->prepare("SELECT COUNT(*) FROM users WHERE users_login LIKE ? and users_pass LIKE ?");
                    $params =array($login, $password);
                    $query->execute($params);

                    if ($query->fetchColumn() == 1) {
                        session_regenerate_id();
                        try {
                            $query = $db->prepare("SELECT users_id FROM users WHERE users_login LIKE ? and users_pass LIKE ?");
                            $params = array($login, $password);
                            $query->execute($params);
                        }
                        catch (PDOException $e) {
                            die($e->getMessage());
                        }
                        $id = $query->fetchColumn();
                        $_SESSION[session_id()] = $id;
                    }

                    else {
                        echo '<script type="text/javascript">alert("Invalid username or password");</script>';
                    }
                }
                catch (PDOException $e) {
                    die($e->getMessage());
                }
            }
        }
        elseif (isset($_POST['submitLogout'])) {
            if ($_SESSION[session_id()]) {
                unset($_SESSION[session_id()]);
            }
        }

        if (isset($_SESSION[session_id()])) {
            echo ('
            <form action="login.php" method="post">
                <fieldset>
                    <legend>
                        <h3>User Login</h3>
                    </legend>
                    <div class="center">
                        <h3>You are logged in as ' . $login . '.</h3>
                    </div>
                    <div class="center">
                        <button type="submit" name="submitLogout">Logout</button>
                    </div>
                </fieldset>
            </form>
            ');
        }
        else {
            echo ('
            <form action="login.php" method="post">
                <fieldset>
                    <legend>
                        <h3>User Login</h3>
                    </legend>
                    <div class="center">
                        <div>
                            <label for="login">Username: </label>
                            <input type="text" name="login" placeholder="Username">
                        </div>
                        <div>
                            <label for="password">Password: </label>
                            <input type="password" name="password" placeholder="Password">
                        </div>
                    </div>
                    <div>
                        <button type="submit" name="submitLogin">Login</button>
                    </div>
                </fieldset>
            </form>
            ');
        }
    ?>
</body>
</html>