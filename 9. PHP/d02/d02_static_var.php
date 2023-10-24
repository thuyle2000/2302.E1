<?php
function test_static(){
    static $x = 1;
    $y = 1;
    echo " hit counter: #$x , y = $y \n";
    $x++;   $y++;
}

for ($i=0; $i <5 ; $i++) { 
    test_static();
}