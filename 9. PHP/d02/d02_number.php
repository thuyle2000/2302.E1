<?php
$x = 12; $y=-300.45678; $z=123.678;
echo "sqrt($x) = " . sqrt($x) . "\n";
echo "abs($y) = " . abs($y) . "\n\n";

echo "round($y) = " . round($y) . "\n";
echo "round($y,2) = " . round($y,2) . "\n\n";

echo "floor($y) = " . floor($y) . "\n";
echo "floor($z) = " . floor($z) . "\n\n";

echo "ceil($y) = " . ceil($y) . "\n";
echo "ceil($z) = " . ceil($z) . "\n\n";

echo "generate 5 random numbers: ";
for ($i=0; $i <5 ; $i++) { 
    echo rand(0, 100) . "\t";
}