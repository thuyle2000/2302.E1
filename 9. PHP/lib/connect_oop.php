<?php

function connect()
{
    //thu thiet lap ket noi den csdl db2302.e1
    $host = "localhost:3306";
    $uid = "root";
    $pwd = "";
    $db = "db2302.e1";

    $cn = new mysqli($host, $uid, $pwd, $db);
    if ($cn->connect_error) {
        die("LOI: Ket noi ko thanh cong ! ($cn->connect_error)");
    }

    return $cn;
}


