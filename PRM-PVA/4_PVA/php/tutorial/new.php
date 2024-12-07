<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>

    <?php
        $i = 1;
        while ($i <= 10){
            echo $i . " ";
            $i++;
        }

        print "<br/>";

        $i = 1;
        do {
            echo $i . " ";
            $i++;
        } while ($i <= 10);

        print "<br />";

        for ($j = 1; $j < 11; $j++) {
            echo $j . " ";
        }

        print "<br />";


    ?>
</body>
</html>