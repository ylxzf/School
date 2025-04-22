<?php
    ob_start();
    session_start();

    require_once('functions.php');
    require_once('dbconnect.php');

    $db = connectDB('eshop');

    if (isset($_GET['logout'])) {
        logOut();
        header('Location: index.php');
    }

    if (isset($_GET['cart'])) {
        if (isLoggedIn()) {
            header('Location: cart.php');
        }
        else {
            echo('<script>alert("You are not logged in.")</script>');
        }
    }

    if (isset($_POST['purchase_button'])) {
        if (isLoggedIn()) {
            $productId = $_POST['product_id'] ?? null;
            $quantity = $_POST['quantity'] ?? 1;
            try {
                $query = $db->prepare("SELECT COUNT(*) FROM eshop_kosik WHERE eshop_kosik_idUzivatel = ? AND eshop_kosik_idZbozi = ?");
                $params = array($_SESSION[session_id()], $productId);
                $query->execute($params);
            }
            catch (PDOException $e) {
                die($e->getMessage());
            }

            if ($query->fetchColumn() == 1) {

                try {
                    $query = $db->prepare("SELECT eshop_kosik_pocet FROM eshop_kosik WHERE eshop_kosik_idUzivatel = ? And eshop_kosik_idZbozi = ?");
                    $params = array($_SESSION[session_id()], $productId);
                    $query->execute($params);
                }
                catch (PDOException $e) {
                    die($e->getMessage());
                }

                $countOfGood = $query->fetchColumn();

                try {
                    $query = $db->prepare("UPDATE eshop_kosik SET eshop_kosik_pocet = ? WHERE eshop_kosik_idUzivatel = ? AND eshop_kosik_idZbozi = ?");
                    $params = array($countOfGood + $quantity ,$_SESSION[session_id()], $productId);
                    $query->execute($params);
                }
                catch (PDOException $e) {
                    die($e->getMessage());
                }
            }
            else {
                $query = $db->prepare("INSERT INTO eshop_kosik (eshop_kosik_idUzivatel, eshop_kosik_idZbozi, eshop_kosik_pocet) VALUES (?, ?, ?)");
                $params = array($_SESSION[session_id()], $productId, $quantity);
                $query->execute($params);
            }

            echo('<script>alert("Item successfully added to cart.")</script>');

        }
        else {
            echo('<script>alert("You are not logged in.")</script>');
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>E-Shop</title>
    <link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="content.css">
    <link rel="stylesheet" href="footer.css">
    <link rel="stylesheet" href="settings.css">
</head>
<body>
    <div class="index-container">
        <div class="header-title-container">
            <h1><a href="index.php">E-Shop</a></h1>
            <div class="header-options">
                <a class="log" href="index.php?cart=1">Cart</a>
                <?php
                    if (isLoggedIn()) {
                        echo '<a href="index.php?logout=1">Logout</a>';
                    }
                    else {
                        echo '<a href="login.php">Login</a>';
                    }
                ?>
            </div>
        </div>
        <div class="content">
            <div class="content-container">
                <div class="catalog-container">
                    <?php
                        try {
                            $query = $db -> prepare("SELECT COUNT(*) FROM eshop_zbozi");
                            $query -> execute();
                        }
                        catch (PDOException $e) {
                            die($e -> getMessage());
                        }

                        $itemCount = $query->fetchColumn();

                        $itemsPerRow = 5;

                        if ($itemCount % $itemsPerRow > 0){
                            $rowCount = ($itemCount / $itemsPerRow) + 1;
                        }
                        else {
                           $rowCount = $itemCount / $itemsPerRow;
                        }

                        try {
                            $query = $db -> prepare("SELECT * FROM eshop_zbozi");
                            $query -> execute();
                        }
                        catch (PDOException $e) {
                            die($e -> getMessage());
                        }


                        $items = $query->fetchAll();

                        $currentItem = -1;

                        for ($i = 0; $i < $rowCount; $i++) {
                            echo('<div class="catalog-row">');
                                for ($j = 0; $j < $itemsPerRow; $j++) {
                                    $currentItem++;

                                    if ($itemCount - $currentItem == 0) {
                                        break;
                                    }

                                    $itemID = $items[$currentItem][0];
                                    $itemName = htmlspecialchars($items[$currentItem][1], ENT_QUOTES);
                                    $itemCategory = $items[$currentItem][2];
                                    $itemPrice = $items[$currentItem][3];

                                    echo('
                                        <div class="catalog-item">
                                            <h4>'. $itemID . '. ' . $itemName .'</h4>
                                            <p>Category: ' . $itemCategory . '</p>
                                            <p>Price: ' . $itemPrice . '</p>                                                
                                            <form method="POST" action="">
                                                <input type="hidden" name="product_id" value="' . $itemID . '">
                                                <input type="number" name="quantity" min="1" value="1">
                                                <button type="submit" name="purchase_button">Purchase</button>
                                            </form>
                                        </div>
                                    ');
                                }
                            echo('</div>');
                        }
                    ?>
                </div>
            </div>
        </div>
        <footer>
            <div class="footer-container">
                <h2>Ondřej Vondra</h2>
            </div>
        </footer>
    </div>
</body>    
</html>
<?php
    ob_end_flush()
?>