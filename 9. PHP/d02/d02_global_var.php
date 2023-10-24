<?php
$x = 10; $y=20;
function test_global(){
    $x = 20;
    global $y ;
    $y += $x; 
    echo " *** in function test_global(), x = $x, y = $y ***";
}

echo "\n => before invoke test_global(), x = $x, y = $y\n";
test_global();
echo "\n => after invoke test_global(), x = $x, y = $y\n";