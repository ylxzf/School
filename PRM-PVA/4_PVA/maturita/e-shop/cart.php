<?php
    session_start();
    ob_start();

    require_once("dbconnect.php");

    $db = connectDB('eshop');

    if(isset($_GET['delete'])) {
        $cart_id = $_GET['delete'];

        try {
            $query = $db -> prepare("DELETE FROM eshop_kosik WHERE eshop_kosik_id = ?");
            $params = array($cart_id);
            $query -> execute($params);
        }
        catch(PDOException $e){
            die($e->getMessage());
        }

        header('Location: cart.php');
    }
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>E-Shop Cart</title>
    <link rel="stylesheet" href="settings.css">
    <link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="footer.css">
    <link rel="stylesheet" href="cart.css">
</head>
<body>
    <div class="header-title-container">
        <h1><a href="index.php">E-Shop</a></h1>
    </div>
    <div class="content-container">
        <div class="cart-container">
            <h1 class="cart-title">Cart</h1>
            <?php
                try {
                    $query = $db->prepare("SELECT eshop_kosik.eshop_kosik_id, eshop_zbozi.eshop_zbozi_nazev, eshop_zbozi.eshop_zbozi_kategorie, eshop_zbozi.eshop_zbozi_cena, eshop_kosik.eshop_kosik_pocet FROM eshop_kosik JOIN eshop_zbozi ON eshop_zbozi.eshop_zbozi_id = eshop_kosik.eshop_kosik_idZbozi WHERE eshop_kosik.eshop_kosik_idUzivatel = ?");
                    $params = array($_SESSION[session_id()]);
                    $query->execute($params);
                }
                catch (PDOException $e) {
                    die($e->getMessage());
                }

                if ($query->rowCount() == 0) {
                    echo('<h1 class="cart-empty">The cart is empty.</h1>');
                }
                else {
                    echo('
                    <table class="cart-table">
                        <tr>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Count</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                ');
                    foreach ($query->fetchAll() as $row) {
                        echo('
                        <tr class="cart-item">
                            <td class="cart-parameter">' . $row['eshop_zbozi_nazev'] . '</td>
                            <td class="cart-parameter">' . $row['eshop_zbozi_kategorie'] . '</td>
                            <td class="cart-parameter">' . $row['eshop_kosik_pocet'] . '</td>
                            <td class="cart-parameter">' . $row['eshop_zbozi_cena'] * $row['eshop_kosik_pocet'] . '</td>
                            <td class="cart-delete"><a href="cart.php?delete=' . $row['eshop_kosik_id'] . '">Delete</a></td>
                        </tr>
                    ');
                    }
                    echo('</table>');
                }
            ?>
        </div>
    </div>
</body>
</html>
<?php
    ob_end_flush();
?>