<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <fieldset>
            <legend>
                <h3>Circle</h3>
            </legend>
            <div>
                <label for="radius">Radius: </label>
                <input type="number" name="radius">
            </div>
            <hr>
            <div>
                <input type="submit" name="submit1">
            </div>
            <hr>
            <div>
                <?php
                    if (isset($_REQUEST["submit1"])){
                        if ($_REQUEST["radius"] != null) {
                            function getCircumference($radius) {
                                echo "Circumference: " . round(2 * pi() * $radius, 2);
                            }
                            getCircumference($_REQUEST["radius"]);

                            echo "<br>";

                            function getArea ($radius) {
                                echo "Area: " . round(pi() * pow($radius, 2), 2) ;
                            }

                            getArea($_REQUEST["radius"]);
                        }
                    }
                ?>
            </div>
        </fieldset>
        <br>
        <fieldset>
            <legend>
                <h3>Greater Number</h3>
            </legend>
            <div>
                <label for="">Num 1: </label>
                <input type="number" name="num1">
            </div>
            <div>
                <label for="">Num 2: </label>
                <input type="number" name="num2">
            </div>
            <hr>
            <div>
                <input type="submit" name="submit2">
            </div>
            <hr>
            <div>
                <?php
                    if (isset($_REQUEST["submit2"])) {
                        if ($_REQUEST["num1"] != null & $_REQUEST["num2"] != null & $_REQUEST["num3"] != null)
                        {
                            function getLarger($num1, $num2) {
                                echo "Max: " . max($num1, $num2);
                            }
                            getLarger($_REQUEST["num1"], $_REQUEST["num2"]);
                        }
                    }
                ?>
            </div>
        </fieldset>
        <br>
        <fieldset>
            <legend>
                <h3>Series</h3>
            </legend>
            <div>
                <label for="">Start: </label>
                <input type="number" name="start">
            </div>
            <div>
                <label for="">End: </label>
                <input type="number" name="end">
            </div>
            <div>
                <label for="">Step size: </label>
                <input type="number" name="stepSize">
            </div>
            <hr>
            <div>
                <input type="submit" name="submit3">
            </div>
            <hr>
            <div>
                <?php
                    if (isset($_REQUEST["submit3"])) {
                        if ($_REQUEST["start"] != null & $_REQUEST["end"] != null & $_REQUEST["stepSize"] != null) {
                            function generateSeries($start, $end, $stepSize) {
                                $arr = [];

                                for ($i = $start; $i <= $end; $i+=$stepSize) {
                                    $arr[] = $i;
                                }

                                if ($arr != null) {
                                    return $arr;
                                }
                                else {
                                    return [];
                                }
                            }

                            echo implode(" | " ,generateSeries($_REQUEST["start"], $_REQUEST["end"], $_REQUEST["stepSize"]));
                        }
                    }
                ?>
            </div>
        </fieldset>
    </form>

</body>
</html>
