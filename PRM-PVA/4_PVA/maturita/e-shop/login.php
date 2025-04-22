<?php
    session_start();
    ob_start();

    require_once("functions.php");
    require_once('dbconnect.php');
    $db = connectDB('eshop');

    if (isset($_POST['loginFormSubmit'])) {
        if (logIn($_POST['username'], $_POST['password'], $db)) {
            header('Location: index.php');
        }
        else {
            echo('<script>alert("Error while logging in.")</script>');
        }

    }
?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>E-Shop Login</title>

    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="footer.css">
    <link rel="stylesheet" href="settings.css">
</head>
<body>
    <div class="header-title-container">
        <h1><a href="index.php">E-Shop</a></h1>
    </div>
    <div class="content-container">
        <div class="login-container">
            <h1>Login</h1>
            <form action="" method="POST">
                <div class="login-controls">
                    <div class="login-labels">
                        <div>
                            <label for="username">Username: </label>
                        </div>
                        <div>
                            <label for="password">Password: </label>
                        </div>
                    </div>
                    <div class="login-form-inputs">
                        <div>
                            <input type="text" name="username">
                        </div>
                        <div>
                            <input type="password" name="password">
                        </div>
                    </div>
                </div>
                <div class="login-button">
                    <button type="submit" name="loginFormSubmit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
<?php
    ob_end_flush();
?>