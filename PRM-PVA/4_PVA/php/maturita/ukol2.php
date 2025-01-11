<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <div>
        <form action="">
            <fieldset>
                <legend>Ukol 1</legend>
                <div>
                    <label for="num">Num 1: </label>
                    <input type="number" name="num1">
                </div>
                <br>
                <div>
                    <label for="num">Num 2: </label>
                    <input type="number" name="num2">
                </div>
                <br>
                <div>
                    <button type="submit" name="submitBTN">Submit</button>
                </div>
                <hr>
                <?php
                    if (isset($_REQUEST['submitBTN'])) {
                        if(isset($_REQUEST['num1']) && isset($_REQUEST['num2'])) {

                            $num1 = intval($_REQUEST['num1']);
                            $num2 = intval($_REQUEST['num2']);

                            function GCD()
                            {
                                global $num1, $num2;

                                for ($i = 1; $i < min($num1, $num2); $i++) {
                                    if ($num1 % $i === 0 && $num2 % $i === 0)
                                    $gcd = $i;
                                }
                                return $gcd;
                            }

                            function ArithmeticAverage()
                            {
                                global $num1, $num2;
                                return ($num1 + $num2)/2;
                            }

                            function PowerOfNums()
                            {
                                global $num1, $num2;
                                return pow($num1, $num2);
                            }

                            function MaxOfNums()
                            {
                                global $num1, $num2;
                                return max($num1, $num2);
                            }

                            function Hypotenuse()
                            {
                                global $num1, $num2;
                                return sqrt(pow($num1, 2) + pow($num2, 2));
                            }

                            print("Greatest common divisor: " . GCD() . "\n");
                            print ("<br>");
                            print("Arithemtic average: " . ArithmeticAverage() . "\n");
                            print ("<br>");
                            print("Power of nums (num1^num2): " . PowerOfNums() . "\n");
                            print ("<br>");
                            print("Max of nums: " . MaxOfNums() . "\n");
                            print ("<br>");
                            print("Hypotenuse: " . Hypotenuse() . "\n");
                        }
                    }
                ?>
            </fieldset>
            <br>
            <fieldset>
                <legend>Ukol 2</legend>
                <div>
                    <label for="num3">Num: </label>
                    <input type="number" name="num3">
                </div>
                <br>
                <div>
                    <label for="base">Base: </label>
                    <select name="base" id="base">
                        <option value="2">2</option>
                        <option value="8">8</option>
                        <option value="16">16</option>
                    </select>
                </div>
                <hr>
                <div>
                    <button type="submit" name="submitBTN2">Submit</button>
                </div>
                <br>
                <?php
                if (isset($_REQUEST['submitBTN2'])) {
                    if(isset($_REQUEST['num3'])) {
                        $num3 = intval($_REQUEST['num3']);

                        function BaseConversion($num, $base)
                        {
                            $result = "";
                            $extra = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];

                            while ($num > 0) {
                                if ($num % $base > 9) {
                                    $result .= $extra[($num % $base)-10];
                                }
                                else {
                                    $result .= strval($num % $base);
                                }
                                $num = floor($num / $base);
                            }

                            return strrev($result);
                        }
                        function toBase2()
                        {
                            global $num3;
                            return BaseConversion($num3, 2);
                        }

                        function toBase8()
                        {
                            global $num3;
                            return BaseConversion($num3, 8);
                        }

                        function toBase16()
                        {
                            global $num3;
                            return BaseConversion($num3, 16);
                        }

                        if ($_REQUEST["base"] == 2){
                            print (toBase2());
                        }
                        else if ($_REQUEST["base"] == 8){
                            print (toBase8());
                        }
                        else if ($_REQUEST["base"] == 16){
                            print (toBase16());
                        }
                    }
                }
                ?>
            </fieldset>
        </form>
    </div>
</body>
</html>
