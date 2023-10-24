<?php

include_once("../lib/connect_oop.php");
$cn = connect();

//lenh them mau tin moi vo bang tbmodule
$sname = "C#";
$lname = "CSharp Programming";
$hour = 48;
$fee= 200;
$sql = "INSERT INTO `tbmodule` (`id`, `sname`, `lname`, `hours`, `fee`) VALUES (NULL, '$sname', '$lname', '$hour', '$fee')";

$r = $cn->query($sql);
if($r == false){
    die ("LOI: ko the them du lieu moi !" . $cn->error);
}

echo "Them du lieu thanh cong ! <br/>";
echo "Ma mon hoc moi : '$cn->insert_id'";

$cn->close();