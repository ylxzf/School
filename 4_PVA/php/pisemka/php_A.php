<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <form action="">
        <fieldset>
            <legend>1. Ukol</legend>
            <div>
                <label for="factorial">Number: </label>
                <input type="number" name="factorial">
            </div>
            <hr>
            <div>
                <input type="submit" name="submit1">
            </div>
            <hr>
            <div>
                <?php
                    function factorial($n) {
                        $factorial = 1;
                        for ($i = 1; $i <= abs($n); $i++) {
                            $factorial *= $i;
                        }
                        return $factorial;

                    }

                    if (isset($_REQUEST["submit1"])) {
                        if ($_REQUEST["factorial"] != null) {
                            echo factorial($_REQUEST["factorial"]);
                        }
                    }
                ?>
            </div>
        </fieldset>
        <br>
        <fieldset>
            <legend>2. Ukol</legend>
            <div>
                <div>
                    <label for="sideA">Strana a: </label>
                    <input type="number" name="sideA">
                </div>
                <div>
                    <label for="sideB">Strana b: </label>
                    <input type="number" name="sideB">
                </div>
                <div>
                    <label for="sideC">Strana c: </label>
                    <input type="number" name="sideC">
                </div>
            </div>
            <hr>
            <div>
                <input type="submit" name="submit2">
            </div>
            <hr>
            <div>
                <?php
                    function isTriangle($a, $b, $c) {
                        if ($a > 0 || $b > 0 || $c > 0) {
                            if (($a + $b > $c) && ($a + $c > $b) && ($b + $c > $a)) {
                                if ($a == $b && $b == $c) {
                                    return "Trojúhelník je rovnostraný";
                                }
                                else {
                                    $sides[0] = $a;
                                    $sides[1] = $b;
                                    $sides[2] = $c;
                                    sort($sides);
                                    if (pow($sides[0], 2) + pow($sides[1], 2) == pow($sides[2], 2)) {
                                        if ($a == $b || $b == $c || $c == $a) {
                                            return "Trojúhelník je rovnoramenný pravoúhlý";
                                        }
                                        else {
                                            return "Trojúhelník je obecný pravoúhlý";
                                        }
                                    }
                                    else if ($a == $b || $b == $c || $c == $a) {
                                        return "Trojúhelník je rovnoramenný";
                                    }
                                    else {
                                        return "Trojúhelník je obecný";
                                    }
                                }
                            }
                            else {
                                return "Nelze sestrojit trojúhelník";
                            }
                        }
                        else {
                            echo "Nelze sestrojit trojúhelník";
                        }
                    }
                    if (isset($_REQUEST["submit2"])) {
                        if ($_REQUEST["sideA"] != null && $_REQUEST["sideB"] != null && $_REQUEST["sideC"] != null) {
                            echo isTriangle($_REQUEST["sideA"], $_REQUEST["sideB"], $_REQUEST["sideC"]);
                        }
                    }
                ?>
            </div>
        </fieldset>
    </form>
</body>
</html>