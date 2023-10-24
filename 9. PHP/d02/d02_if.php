<?php
date_default_timezone_set("Asia/Ho_Chi_Minh");

// Today is Tuesday 17 Oct 2023, 21:10:57
echo "Today is " . date("l d M Y, H:m:s") . "\n"; 

//Today is Tuesday 17 October 2023, 21:10:57
echo "Today is " . date("l d F Y, H:m:s") . "\n";

//Today is Tuesday 17 October 2023, 09:10:57 PM
echo "Today is " . date("l d F Y, h:m:s A") . "\n";

$time = date("H");
if($time < "12"){
    echo "Good Morning \n";
}else if($time < "16"){
    echo "Good Afternoon \n";
}else if($time < "20"){
    echo "Good Evening \n";
}else{
    echo "Good night !\n";
}