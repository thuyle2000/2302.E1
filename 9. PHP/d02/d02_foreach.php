<?php
$list = array("mai"=>2001, "giu"=>2006, "hoang"=>2008, "tan"=>1990, "an"=>2000);
echo "\n danh sach sinh vien \n";
foreach ($list as $name => $year) {
    echo "$name ,  $year \n";
}

echo "\n danh sach sinh vien \n";
$curr_year = date("Y");
foreach ($list as $name => $year) {
    echo "$name , ".  ($curr_year - $year). " tuoi\n";
}