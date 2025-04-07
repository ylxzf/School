<?php
    ob_start();
    session_start();

    function editVypRecord ($userID, $knihaID, $status, $db) {
        $queryCount = $db->prepare('SELECT puj_knihy_pocet FROM puj_knihy WHERE puj_knihy_id = ?');
        $params = array($knihaID);
        $queryCount->execute($params);

        $count = $queryCount->fetchColumn();

        if ($status == 'return') {
            $query = $db->prepare("DELETE FROM puj_vypujcky WHERE puj_vyp_idUzivatel = ? AND puj_vyp_idKniha = ?");
            $params = array($userID, $knihaID);
            $query->execute($params);

            $query = $db->prepare("UPDATE puj_knihy SET puj_knihy_pocet = ? WHERE puj_knihy_id = ?");
            $params = array($count + 1, $knihaID);
            $query->execute($params);
        }
        elseif ($status == 'borrow') {
            if ($count != 0) {
                $query = $db->prepare("INSERT INTO puj_vypujcky (puj_vyp_idUzivatel, puj_vyp_idKniha) VALUES (?, ?)");
                $params = array($userID, $knihaID);
                $query->execute($params);

                $query = $db->prepare("UPDATE puj_knihy SET puj_knihy_pocet = ? WHERE puj_knihy_id = ?");
                $params = array($count - 1, $knihaID);
                $query->execute($params);
            }
            else {
                echo('<script type="text/javascript">alert("Cannot borrow!: There are 0 books left");</script>');
            }
        }

        header('Location: ./index.php');
    }

    require_once('../dbconnect.php');
    $db = connectDB('pujcovna');

    editVypRecord($_SESSION[session_id()], $_REQUEST['kniha_id'], $_REQUEST['status'], $db);

    ob_end_flush();
?>
