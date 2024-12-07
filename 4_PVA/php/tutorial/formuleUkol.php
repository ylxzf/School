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
            <label for="input">Input number</label>
            <input type="number" name="input">
        </div>
        <div>
            <input type="submit" name="submit">
        </div>
    </form>

    <hr>

    <?php
        if (isset($_REQUEST["submit"])) {

            function getDivisors($num) {
                for ($i = 0; $i < $num /2; $i++) {
                    if ($num % $i == 0) {
                        $divisors[] = $i;
                    }
                }
                return $divisors;
            }


            if ($_REQUEST["input"] != null) {
                $num = $_REQUEST["input"];

                echo "Number: " . $num;

                print "<br>";
                print "<hr>";

                if ($num % 2 == 0) {
                    echo "Number is: Even";
                } else {
                    echo "Number is: Odd";
                }

                print "<br>";

                if ($num > 0) {
                    echo "Number is: Positive";
                } elseif ($num < 0) {
                    echo "Number is: Negative";
                } else {
                    echo "Number is: Neutral (0)";
                }

                print "<br>";

                $digitSum = 0;

                foreach (str_split($num) as $digit) {
                    $digitSum += intval($digit);
                }

                echo "Number's digit sum is: " . $digitSum;

                print "<br>";

                echo "Number squared: " . pow($num, 2);

                print "<br>";

                echo " Number cubed: " . pow($num, 3);

                print "<br>";

                $temp = 0;
                foreach (getDivisors($num) as $divisor) {
                    $temp += $divisor;
                }

                if ($temp > $num) {
                    echo "Number is abundant";
                }
                else if ($temp < $num) {
                    echo "Number is deficient";
                }
                else {
                    echo "Number is perfect";
                }

                print "<br>";

                for ($i = 1; $i < abs($num + 1); $i++) {
                    $arr[$i - 1] = $i;
                }

                echo join(", ", $arr);

            }
        }
    ?>

</body>
</html>