<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>null-coalescing</title>
</head>
<body>
    <div class="container">
        <h2>Null Coalesing Demo</h2>
        <hr>

        <?php 
        $username = null;
        $s1 = $username ?? "Guest"; 
        echo "Welcome $s1 ! <br>";

        $username = "Hao";
        $s1 = $username ?? "Guest"; 
        echo "Welcome $s1 ! <br>";        

        ?>
    </div>
</body>
</html>