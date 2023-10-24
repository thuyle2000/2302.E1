<?php

include_once("../lib/connect.php");
$cn = connect();

//xoa mau tin trong bang tbmodule theo ma so
$id = 4;

$sql = "DELETE FROM `tbmodule` WHERE `id`= '$id' ";

$r = mysqli_query($cn, $sql);
if($r == false){
    die ("LOI: ko the xoa du lieu !" . mysqli_error($cn));
}

echo "xoa du lieu thanh cong ! <br/>";

mysqli_close($cn);