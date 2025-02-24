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
        require_once './dbconnect.php';
        connectDB('login');

        if (isset($_SESSION[session_id()])) {
            echo ('
            <form action="login.php" method="post">
                <fieldset>
                    <legend>
                        <h3>User Login</h3>
                    </legend>
                    <div class="center">
                        <h3>You are logged in.</h3>
                    </div>
                    <div class="center">
                        <button type="submit">Logout</button>
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
                        <button type="submit">Login</button>
                    </div>
                </fieldset>
            </form>
            ');
        }
    ?>
</body>
</html>