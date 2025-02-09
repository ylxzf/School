<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pripojeni k DB</title>
</head>
<body>
    <?php
        //Pripojeni k DB
        //Data Source Name
        $DSN = 'mysql:host=localhost;port=3306;dbname=ordinace';
        $user = 'root';
        $password = '';

        //Instance rozhrani PDO
        try {
            $db = new PDO($DSN, $user, $password, array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION, PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
        }
        catch (PDOException $e) {
            //Co se stane kdyz konstruktor selze
            die("Chyba pri kontaktovani DB: " . $e->getMessage());
        }

        //Spusteni dotazu na DB
        try {
            $query = $db->prepare('SELECT COUNT(login) as Pocet FROM pacient');
            $query->execute();
        }
        catch (PDOException $e) {
            die("Chyba pri pocitani zaznamu: " . $e->getMessage());
        }

        //Stahunuti vysledku dotazu
        $pocet = $query->fetchColumn();

        //Zobrazeni vysledku
        echo 'Pocet zaznamu: ' . $pocet . '<br>';

        // Tabulka zaznamu
        try {
            $query = $db->prepare('SELECT * FROM pacient');
            $query->execute();
        }
        catch (PDOException $e) {
            die("Chyba pri vypisu tabulky: " . $e->getMessage());
        }

        $tabulka = $query->fetchAll();

        echo('
        <table border="1">
            <tr>
                <th>Login</th>
                <th>Heslo</th>
                <th>Datum navstevy</th>
            </tr>
        ');

        //cteme jednotlive radky
        //zpusob while
//        while ($row = $query->fetch(PDO::FETCH_BOTH)) {
//            $login = $row["login"];
//            $heslo = $row["heslo"];
//            $datumNavsteva = $row["DatumNavsteva"];
//            echo('
//                <tr>
//                    <td>' . $login . '</td>
//                    <td>' . $heslo . '</td>
//                    <td>' . $datumNavsteva . '</td>
//                </tr>
//            ');
//        }

        //zpusob foreach
        foreach ($tabulka as $pacient) {
            echo('
               <tr>
                    <td>' . $pacient['login'] . '</td>
                    <td>' . $pacient['heslo'] . '</td>
                    <td>' . $pacient['DatumNavsteva'] . '</td>
               </tr>
            ');
        }

        echo('</table>');

//        print_r($tabulka);

    ?>


</body>
</html>
