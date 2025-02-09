<?php
    function connectDB($dbname){
        //Pripojeni k DB
        //Data Source Name
        $DSN = 'mysql:host=localhost;port=3306;dbname='.$dbname;
        $user = 'root';
        $password = '';

        //Instance rozhrani PDO
        try {
            return new PDO($DSN, $user, $password, array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION, PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
        }
        catch (PDOException $e) {
            //Co se stane kdyz konstruktor selze
            die("Chyba pri kontaktovani DB: " . $e->getMessage());
        }
    }
?>
