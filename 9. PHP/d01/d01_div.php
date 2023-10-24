<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>div</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <div class="container">
        <h2>IntDiv Demo</h2>
        <hr>

        <?php
        $x = 10;
        $y = 3;
        $r = $x / $y;
        $r1 = (int)($x /$y);
        $r2 = intdiv($x,$y);
        echo " $x / $y = $r <br>";
        echo " (int)($x /$y) = $r1 <br>";
        echo " intdiv($x,$y) = $r2  <br>";
        ?>
    </div>


</body>

</html>