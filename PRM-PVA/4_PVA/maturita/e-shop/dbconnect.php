<?php
function connectDB($dbname){
    $DSN = 'mysql:host=localhost;port=3306;dbname='.$dbname;
    $user = 'root';
    $password = '';

    try {
        return new PDO($DSN, $user, $password, array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION, PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
    }
    catch (PDOException $e) {
        die("Error while contacting DB: " . $e->getMessage());
    }
}
?>
