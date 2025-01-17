<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <div>
        <form action="">
            <fieldset>
                <legend>Reverse cipher</legend>
                <div>
                    <label for="input1">Encrypt</label>
                    <input type="text" name="input1">
                </div>
                <div>
                    <label for="input2">Decrypt</label>
                    <input type="text" name="input2">
                </div>
                <br>
                <div>
                    <button type="submit" name="submitBTN">Submit</button>
                </div>
                <hr>
                <div>
                    <?php
                    if (isset($_REQUEST['submitBTN'])) {
                        if(isset($_REQUEST['input1']) || isset($_REQUEST['input2'])) {
                            $input1 = $_REQUEST['input1'];
                            $input2 = $_REQUEST['input2'];

                            function reverseCipher($input)
                            {
                                return strrev($input);
                            }

                            if ($input1 != null) {
                                print("Encrypted string: " . reverseCipher($input1));
                                print("<br>");
                            }
                            if ($input2 != null) {
                                print("Decrypted string: " . reverseCipher($input2));
                                print("<br>");
                            }
                        }
                    }
                    ?>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>