<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
<?php
    $a = '12345';
    print $a[4];
    print "<br>";
    print strlen($a);
    print "<br>";
    print gettype($a);
    print "<br>";

    $cislo = 5;
    if ($cislo == 5) {
        print "cislo nie jest odnalen";
        print "<br>";
    }
    var_dump($a);
    print "<br>";

    $c = 10 / 3;
    var_dump($c);
    print "<br>";

    $d = 10 / 4 ;
    var_dump($d);
    print "<br>";

    $test = true;
    if ($test) {
        print ("<p>yes</p>\n");
    }
    else {
        print ("<p>no</p>\n");
    }

    $test = 4;
    if ($test == 1) {
        print ("<p>test is 1 fr</p>\n");
    }
    elseif ($test == 2) {
        print ("<p>test is 2 fr</p>\n");
    }
    elseif ($test == 3) {
        print ("<p>test is 3 fr</p>\n");
    }
    else {
        print ("<p>test is not 1, 2 or 3 fr</p>\n");
    }

    switch ($test){
        case 1:
            print ("<p>test is 1 frfr</p>\n");
            break;
        case 2:
            print ("<p>test is 2 frfr</p>\n");
            break;
        case 3:
            print ("<p>test is 3 frfr</p>\n");
        default:
            print ("<p>test is not 1, 2 or 3 <frfr></frfr></p>\n");
    }


    for ($i = 0; $i < 10; $i++) {
        $array[$i] = $i;
    }
    echo implode(", " , $array);
    print ("<br>");
    var_dump($array);
    print ("<br>");

    echo $_SERVER["REQUEST_URI"];

?>
</body>
</html>