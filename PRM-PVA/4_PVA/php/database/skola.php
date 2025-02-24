<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Škola - filtrování</title>
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
    <div class="center">
        <h1>Filtrování dat</h1>
    </div>
    <?php
        //vlozeni pripojeni k db
        include_once './dbconnect.php';
        $db = connectDB('skola');

        //pomocna promenna pro dotaz
        $query=null;
        //zpracovani tlacitek
        if (isset($_REQUEST['submitPohlavi'])) {
            $pohlavi = htmlspecialchars($_REQUEST['pohlavi']);
            try {
                $query = $db->prepare("SELECT * FROM studenti WHERE pohlavi=?;");
                $params = array($pohlavi);
                $query->execute($params);
            }
            catch (PDOException $e) {
                die('Chyba při získání pohlaví' . $e->getMessage());
            }
        }
        elseif (isset($_REQUEST['submitRocnik'])) {
            $rocnik = htmlspecialchars($_REQUEST['rocnik']);
            try {
                $query = $db->prepare("SELECT * FROM studenti WHERE rocnik=?;");
                $params = array($rocnik);
                $query->execute($params);
            }
            catch (PDOException $e) {
                die('Chyba při získání ročníku' . $e->getMessage());
            }
        }
        elseif (isset($_REQUEST['submitZamereni'])) {
            if ((isset($_REQUEST['EL'])) || (isset($_REQUEST['ST'])) || (isset($_REQUEST['IT'])) ) {
                //alepson jeden checkbox byl zatrzeny
                $query = "SELECT * FROM studenti WHERE";
                $isChecked = false;
                //zatrhnul EL?
                if (isset($_REQUEST['EL'])) {
                    $query = $query . " zamereni LIKE ?";
                    $isChecked = true;
                    $params[] = "EL";
                }
                //zatrhnul ST?
                if (isset($_REQUEST['ST'])) {
                    if ($isChecked) {
                        $query = $query . " OR";
                    }
                    $query = $query . " zamereni LIKE ?";
                    $isChecked = true;
                    $params[] = "ST";
                }
                //zatrhnul IT?
                if (isset($_REQUEST['IT'])) {
                    if ($isChecked) {
                        $query = $query . " OR";
                    }
                    $query = $query . " zamereni LIKE ?";
                    $params[] = "IT";
                }
            }
            try {
                $query = $db->prepare($query);
                $query->execute($params);
            }
            catch (PDOException $e) {
                die('Chyba při získání zamereni' . $e->getMessage());
            }
        }
        elseif (isset($_REQUEST['submitZamereniPole']) && isset($_REQUEST['zamereni'])) {
            $zamereni_pole = $_REQUEST['zamereni'];
            if(count($zamereni_pole) > 0){
                $query = "SELECT * FROM studenti WHERE ";
                for($i = 0; $i < count($zamereni_pole); $i++) {
                    if ($i > 0) {
                        $query .= " OR ";
                    }
                    $query .= "zamereni=?";
                }

            }
            try {
                $query = $db->prepare($query);
                $params = $zamereni_pole;
                $query->execute($params);
            }
            catch (PDOException $e) {
                die('Chyba při získání pohlaví' . $e->getMessage());
            }
        }
    ?>


    <form action="" method="post">
        <fieldset>
            <legend>
                <h3>Filtrování podle pohlaví</h3>
            </legend>
            <div class="center">
                <div>
                    Muž: <input type="radio" name="pohlavi" value="muž">
                    Žena: <input type="radio" name="pohlavi" value="žena">
                    <br>
                </div>
            </div>
            <div class="center">
                <button type="submit" name="submitPohlavi" value="submitPohlavi">Submit</button>
            </div>
            <br>
        </fieldset>
        <fieldset>
            <legend>
                <h3>Filtrovani podle rocniku</h3>
            </legend>
            <div class="center">
                <div>
                    <label for="rocnik">Ročník: </label>
                    <select name="rocnik" id="rocnik">
                        <option value="1">1. Ročník</option>
                        <option value="2">2. Ročník</option>
                        <option value="3">3. Ročník</option>
                        <option value="4">4. Ročník</option>
                    </select>
                </div>
            </div>
            <div class="center">
                <button type="submit" name="submitRocnik" value="submitRocnik">Submit</button>
            </div>
        </fieldset>
        <fieldset>
            <legend>
                <h3>Filtrovani podle zamereni - single hodnoty</h3>
            </legend>
            <div class="center">
                <div>
                    <label for="EL">EL: </label>
                    <input type="checkbox" name="EL">
                    <label for="ST">ST: </label>
                    <input type="checkbox" name="ST">
                    <label for="IT">IT: </label>
                    <input type="checkbox" name="IT">
                </div>
            </div>
            <div class="center">
                <button type="submit" name="submitZamereni" value="submitZamereni">Submit</button>
            </div>
        </fieldset>
        <fieldset>
            <legend>
                <h3>Filtrovani podle zamereni - pole</h3>
            </legend>
            <div class="center">
                <div>
                    <label for="EL">EL: </label>
                    <input type="checkbox" name="zamereni[]" value="EL">
                    <label for="ST">ST: </label>
                    <input type="checkbox" name="zamereni[]" value="ST">
                    <label for="IT">IT: </label>
                    <input type="checkbox" name="zamereni[]" value="IT">
                </div>
            </div>
            <div class="center">
                <button type="submit" name="submitZamereniPole" value="submitZamereniPole">Submit</button>
            </div>
        </fieldset>

    </form>

    <br>

    <?php
    //zobrazeni dat

        echo('
            <div class="center"><table border="1">
                <tr>
                    <th>ID</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Login</th>
                    <th>Heslo</th>
                    <th>Email</th>
                    <th>Ročník</th>
                    <th>Zaměření</th>
                    <th>Narození</th>
                    <th>Pohlaví</th>
                    <th>Ulice</th>
                    <th>Město</th>
                </tr>
            ');

        foreach ($query->fetchAll() as $row) {
            echo('
                <tr>
                    <td>' . $row['id'] . '</td>
                    <td>' . $row['jmeno'] . '</td>
                    <td>' . $row['prijmeni'] . '</td>
                    <td>' . $row['login'] . '</td>
                    <td>' . $row['heslo'] . '</td>
                    <td>' . $row['email'] . '</td>
                    <td>' . $row['rocnik'] . '</td>
                    <td>' . $row['zamereni'] . '</td>
                    <td>' . $row['narozeni'] . '</td>
                    <td>' . $row['pohlavi'] . '</td>
                    <td>' . $row['ulice'] . '</td>
                    <td>' . $row['mesto'] . '</td>
                </tr>
            ');
        }

        echo('</table></div>');
    ?>
</body>
</html>
