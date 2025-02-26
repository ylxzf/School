<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <style>
        * {
            font-family: sans-serif;
        }

        form {
            display: flex;
            justify-content: center;
        }

        form fieldset {
            width: 20%;
        }

        .center {
            display: flex;
            justify-content: center;
        }

        table,td{
            border: 1px solid black;
            border-collapse: collapse;
        }

        button {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <?php
        require_once ("./dbconnect.php");
        $db = connectDB("firma");

        global $titleTable;
        global $idTable;

        if (isset($_REQUEST['titulSubmit'])){
            $titleTable = True;
            $titul = htmlspecialchars($_REQUEST['titul']);
            switch($titul){
                case '1':
                    $titul = null;
                    break;
                case '2':
                    $titul = "Ing.";
                    break;
                case '3':
                    $titul = "Mrg.";
                    break;
                case '4':
                    $titul = "MuDr.";
                    break;
            }
//            echo $titul;
            try {
                if ($titul == ""){
                    $query = $db->prepare("SELECT Prijmeni, Titul, Pohlavi FROM zamestnanec where Titul is null ");
                    $query->execute();
                }
                else {
                    $query = $db->prepare("SELECT Prijmeni, Titul, Pohlavi FROM zamestnanec where Titul like ?");
                    $params = array($titul);
                    $query->execute($params);
                }
            }
            catch (PDOException $e) {
                die('Chyba při získání titulu' . $e->getMessage());
            }
        }
        elseif (isset($_REQUEST['idSubmit'])){
            $idTable = True;
            $id = htmlspecialchars($_REQUEST['id']);
            try {
                $query = $db->prepare("select Jmeno, Prijmeni, COUNT(ID_objednavka) AS 'PocetObjednavek' from zakaznik JOIN firma.objednavka on zakaznik.ID_zakaznik = objednavka.ID_zakaznik = objednavka.ID_zamestnanec WHERE zakaznik.ID_zakaznik=? GROUP BY Jmeno, Prijmeni");
                $params = array($id);
                $query->execute($params);
            }
            catch (PDOException $e) {
                die('Chyba při získání id' . $e->getMessage());
            }
        }
    ?>

    <form action="" method="POST">
        <fieldset>
            <legend>Titul</legend>
            <div class="center">
                <div>
                    <label for="titul">Titul: </label>
                    <select name="titul" id="titul">
                        <option value="1">None</option>
                        <option value="2">Ing.</option>
                        <option value="3">Mgr.</option>
                        <option value="4">MuDr.</option>
                    </select>
                    <button type="submit" name="titulSubmit">Submit</button>
                </div>
            </div>
        </fieldset>
        <fieldset>
            <legend>ID</legend>
            <div class="center">
                <input type="number" name="id">
            </div>
            <div>
                <button type="submit" name="idSubmit">Submit</button>
            </div>
        </fieldset>
    </form>

    <?php
        if ($titleTable){
            echo('
            <div class="center"><table border="1">
                <tr>
                    <th>Příjmení</th>
                    <th>Titul</th>
                    <th>Pohlaví</th>
                </tr>
            ');

            foreach ($query->fetchAll() as $row) {
                echo('
                <tr>
                    <td>' . $row['Prijmeni'] . '</td>
                    <td>' . $row['Titul'] . '</td>
                    <td>' . $row['Pohlavi'] . '</td>
                </tr>
            ');
            }

            echo('</table></div>');
            $titleTable = false;
        }
        elseif ($idTable) {
            echo('
            <div class="center"><table border="1">
                <tr>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Počet objednávek</th>
                </tr>
            ');

            foreach ($query->fetchAll() as $row) {
                echo('
                <tr>
                    <td>' . $row['Jmeno'] . '</td>
                    <td>' . $row['Prijmeni'] . '</td>
                    <td>' . $row['PocetObjednavek'] . '</td>
                </tr>
            ');
            }

            echo('</table></div>');
            $idTable = false;
        }

    ?>
</body>
</html>