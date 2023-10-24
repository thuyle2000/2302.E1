<?php
$a  = 10;
echo "a= $a,  type = ". gettype($a) ."\n";

$a = 3.2425;
echo "a= $a,  type = ". gettype($a) ."\n";

$a = "Hello PHP !";
echo "a= $a,  type = ". gettype($a) ."\n";

$a = ["xuan", "ha","thu","dong"];
if(gettype($a) == "array"){
    var_dump($a);
}
else{
    echo "a= $a,  type = ". gettype($a) ."\n";
}

