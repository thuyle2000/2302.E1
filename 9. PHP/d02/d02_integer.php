<?php
$x = "12345"; $y = 12345; $z=123.4567;
echo "x = '$x'  => is_int(x) = " . is_int($x). "\n";
echo "y = $y => is_int(y) = " . is_int($y). "\n";
echo "z = $z => is_int(z) = " . is_int($z). "\n\n";

echo "Max INT = " . PHP_INT_MAX. "\n";
echo "Min INT = " . PHP_INT_MIN. "\n\n";

echo "(x + z) = " . ($x + $z) . "\n";
echo "(x - z) = " . ($x - $z) . "\n";
echo "(x * z) = " . ($x * $z) . "\n";
