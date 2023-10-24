<?php
$name = "nguyen thi ngoc mai";
$name2 = "nguyen thi ngoc mai";
$name3 = "phan van giu";

echo "name = [$name] \n";
echo "name2 = [$name2] \n";
echo "name3 = [" . $name3 . "] \n\n";

echo "strlen() => " . strlen($name) . "\n";
echo "str_word_count() => " . str_word_count($name) . "\n";
echo "ucwords() => " . ucwords($name) . "\n";
echo "strpos(name,'ngoc') => " . strpos($name,"ngoc") . "\n";
echo "strpos(name,'NGOC') => " . strpos($name,"NGOC") . "\n";
echo "str_replace('i', 'y', name) => ". str_replace("i", "y",$name)."\n";echo "strrev(name) => " . strrev($name) . "\n";
echo "strcmp(name, name2) => " . strcmp($name, $name2) . "\n";
echo "strcmp(name, name3) => " . strcmp($name, $name3) . "\n";