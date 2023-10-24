<?php

include_once("../lib/connect.php");
$cn = connect();

//lenh them mau tin moi vo bang tbmodule
$sname = "PRJ2";
$lname = "Project 2";
$hour = 36;
$fee= 240;
$sql = "INSERT INTO `tbmodule` (`id`, `sname`, `lname`, `hours`, `fee`) VALUES (NULL, '$sname', '$lname', '$hour', '$fee')";

$r = mysqli_query($cn, $sql);
if($r == false){
    die ("LOI: ko the them du lieu moi !" . mysqli_error($cn));
}

echo "Them du lieu thanh cong ! <br/>";
echo "Ma mon hoc moi : " . mysqli_insert_id($cn);

mysqli_close($cn);