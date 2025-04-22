<?php
    function isLoggedIn() {
        if (isset($_SESSION[session_id()])) {
            return true;
        }
        else {
            return false;
        }
    }

    function logIn($username, $password, $db) {
        $password = md5($password);
        $params = array($username, $password);

        try {
            $query = $db->prepare("SELECT COUNT(*) FROM uziv WHERE uziv_login = ? AND uziv_heslo = ?");
            $query->execute($params);
        }
        catch (PDOException $e) {
            die($e -> getMessage());
        }

        if ($query->fetchColumn(0) == 1) {
            session_regenerate_id();
            try {
                $query = $db->prepare("SELECT uziv_id FROM uziv WHERE uziv_login = ? AND uziv_heslo = ?");
                $query->execute($params);
            }
            catch (PDOException $e) {
                die($e -> getMessage());
            }
            $id = $query->fetchColumn(0);
            $_SESSION[session_id()] = $id;

            return true;
        }
        else {
            return false;
        }
    }

    function logOut() {
        if (isLoggedIn()) {
            unset($_SESSION[session_id()]);
        }
    }
?>