<?php
function test_local(){
    $x = 100;
    echo "in function test_local(), x = $x \n";
}

function test_local2(){
    $x = 200;
    echo "in function test_local2(), x = $x \n";
    for ($i=0; $i <10 ; $i++) { 
        echo "i = $i, ";
    }
    echo "\n";
    echo "i = $i \n\n";
}

test_local();
test_local2();

echo "outside function test_local(), test_local2(), x= $x \n";
