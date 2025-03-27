<?php
    ob_start();
    if(isset($_REQUEST["id"])){
        $id = htmlspecialchars($_REQUEST["id"]);

        require_once '../dbconnect.php';
        $db = connectDB('filmy');

        try {
            $query = $db->prepare("DELETE FROM film WHERE film_id = ?");
            $params = array($id);
            $queryResult = $query->execute($params);
        }
        catch(PDOException $e) {
            echo $e->getMessage();
        }

        if (!$queryResult) {
            echo ('<script type="text/javascript">alert("Query failed!");</script>');
        }
        else {
            echo ('<script type="text/javascript">alert("Query completed successfully!");</script>');
            header("Location: ./filmy_show.php");
        }
    }

    ob_end_flush();
?>
