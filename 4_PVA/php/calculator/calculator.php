<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <form action="">
        <div>
            <label for="num1">Num 1: </label>
            <input type="number" name="num1">
        </div>
        <div>
            <label for="operator">Operator: </label>
            <select name="operator">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
        </div>
        <div>
            <label for="num2">Num 2: </label>
            <input type="number" name="num2">
        </div>
        <hr>
        <div>
            <input type="submit" name="submit" value="Submit">
        </div>
    </form>

    <hr>

    <?php

        if (isset($_REQUEST["submit"])) {

            if ($_REQUEST["num1"] != null || $_REQUEST["num2"] != null){
                $num1 = $_REQUEST["num1"];
                $num2 = $_REQUEST["num2"];
                $operator = $_REQUEST["operator"];

                switch ($operator){
                    case "+":
                        echo "Soucet " . $num1 . " a " . $num2 . " je roven " . ($num1 + $num2);
                        break;
                    case "-":
                        echo "Rozdil " . $num1 . " a " . $num2 . " je roven " . ($num1 - $num2);
                        break;
                    case "*":
                        echo "Soucin " . $num1 . " a " . $num2 . " je roven " . ($num1 * $num2);
                        break;
                    case "/":
                        if ($num2 == 0){
                            echo "Nelze delit 0";
                        }
                        else {
                            echo "Podil " . $num1 . " a " . $num2 . " je roven " . $num1 / $num2;
                        }
                        break;
                    default:
                        echo "Invalid operation";
                }
            }
        }
    ?>
</body>
</html>

<?php
