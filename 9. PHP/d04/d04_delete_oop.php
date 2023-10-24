<?php

include_once("../lib/connect_oop.php");
$cn = connect();

//xoa mau tin trong bang tbmodule theo ma so
$id = 5;
$sql = "DELETE FROM `tbmodule` WHERE `id`= '$id' ";

$r = $cn->query($sql);
if($r == false){
    die ("LOI: ko the xoa du lieu  ! <br/>" . $cn->error);
}

echo "Xoa du lieu thanh cong ! <br/>";

$cn->close();