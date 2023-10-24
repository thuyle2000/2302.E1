<?php

include_once("../lib/connect.php");
$cn = connect();

//xem danh sach cac mon hoc
$sql = "SELECT * FROM `tbmodule`";

$r = mysqli_query($cn,$sql);
if($r == false){
    die ("LOI: ko the truy van du lieu !");
}

if(mysqli_num_rows($r) ==0){
    die("KO TIM THAY DU LIEU !");
}

echo "<p>Danh sach cac mon hoc </p>";
while($row = mysqli_fetch_array($r)){
    echo $row["id"] . ", " . $row["sname"] .", " . $row["lname"]. ", ". $row["hours"]."<br/>";
}

mysqli_close($cn);