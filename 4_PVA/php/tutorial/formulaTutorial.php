<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <div>
            <div>
                <label for="name">Name: </label>
                <input type="text" name="name" placeholder="Name" value="">
            </div>
            <div>
                <label for="pass">Password: </label>
                <input type="password" name="pass" placeholder="Password" value="">
            </div>
        </div>
        <hr>
        <div>
            <div>
                <label for="pivo">Pivo: </label>
                <input type="checkbox" name="pivo" value="10">
            </div>

            <div>
                <label for="vino">Vino: </label>
                <input type="checkbox" name="vino" value="15">
            </div>

            <div>
                <label for="voda">Voda: </label>
                <input type="checkbox" name="voda" value="30">

            </div>
        </div>
        <hr>
        <div>
            <div>
                ZS: <input type="radio" name="skola" value="zs">
            </div>

            <div>
                SS: <input type="radio" name="skola" value="ss">
            </div>

            <div>
                VS: <input type="radio" name="skola" value="vs">
            </div>
        </div>
        <hr>
        <div>
            <label for="skoleni">Skola: </label>
            <select name="skoleni">
                <option value="zs">Zakladni</option>
                <option value="ss">Stredni</option>
                <option value="vs">Vysoka</option>
            </select>
        </div>
        <hr>
        <div>
            <input type="submit" name="odesli" value="Odesli data">
        </div>
    </form>

    <?php
        print_r($_REQUEST);

        echo "<br>";
        echo "pass je " . $_REQUEST("pass");
    ?>
</body>
</html>
