<?php

include_once("../lib/connect_oop.php");
$cn = connect();

//xem danh sach cac mon hoc
$sql = "SELECT * FROM `tbmodule`";

$r = $cn->query($sql);
if($r == false){
    die ("LOI: ko the truy van du lieu !");
}


if($r->num_rows==0){
    die("KO TIM THAY DU LIEU !");
}

echo "<h4>Danh sach cac mon hoc </h4><hr/>";
while($row =$r->fetch_array(MYSQLI_NUM)){
    echo $row[0] . ", " . $row[1] .", " . $row[2]. ", ". $row[3]."<br/>";
}

$cn->close();