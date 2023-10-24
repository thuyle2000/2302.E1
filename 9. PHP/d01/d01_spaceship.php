<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>spaceship</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>Spaceship Operator Demo</h2>
        <hr>
        <?php 
        echo "<h4>So sanh 2 so </h4>";
        $x = 10; $y=16;
        echo "x = $x, y = $y <br>";
        echo " x <=> y = " . ($x <=> $y) ."<br>";
        echo " y <=> x = " . ($y <=> $x) ."<br>";
        echo " x <=> x = " . ($x <=> $x) ."<br><br>";

        echo "<h4>So sanh 2 chuoi ky tu </h4>";
        $x = "Nguyen Nhi"; $y="Nguyen Hao";
        echo "x = $x, y = $y <br>";
        echo " x <=> y = " . ($x <=> $y) ."<br>";
        echo " y <=> x = " . ($y <=> $x) ."<br>";
        echo " x <=> x = " . ($x <=> $x) ."<br><br>";       
        
        echo "<h4>So sanh 2 array </h4>";
        $x = [1,2,4]; $y=[1,5,6]; $z= [0,1,2,3]; 
        echo "x[] = ";
        var_dump($x);
        echo "<br>";

        echo "y[] = ";
        var_dump($y);
        echo "<br>";

        echo "z[] = ";
        var_dump($z);
        echo "<br>";

        echo " x <=> y = " . ($x <=> $y) ."<br>";
        echo " y <=> x = " . ($y <=> $x) ."<br>";
        echo " x <=> x = " . ($x <=> $x) ."<br><br>"; 
        echo " x <=> z = " . ($x <=> $z) ."<br><br>";   

        ?>

    </div>
</body>
</html>