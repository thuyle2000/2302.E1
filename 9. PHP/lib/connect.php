<?php
//thu thiet lap ket noi den csdl db2302.e1

function connect(){
    $host = "localhost:3306";
    $uid = "root";
    $pwd = "";
    $db = "db2302.e1";
    
    $cn = mysqli_connect($host, $uid, $pwd, $db);
    if ($cn == false) {
        die("LOI: Ket noi ko thanh cong !<br/>" . mysqli_connect_error());
    }
    
    // echo "Ket noi Thanh cong ";
    // mysqli_close($cn);
    return $cn;
}
