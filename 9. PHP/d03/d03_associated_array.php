<?php
class Product{
    public $id, $name, $price;
    public function __construct($id="P01", $name="laptop", $price=100)
    {
        $this->id = $id;
        $this->name = $name;
        $this->price = $price;
    }

    public function __toString():string
    {
        return "$this->id, $this->name, $this->price ";
    }
}
//khai bao mang associated [ds], co key la ma-sp va value la sp tuong ung
$ds = [ "P01"=> new Product(),
        "P03"=> new Product("P03","computer",150),
        "P06"=> new Product("P06","HDD",50),
        "P02"=> new Product("P02","monitor LCD",90),
        "P05"=> new Product("P05","mouse",10)
    ];

echo "demo associated array \n";
echo ">> list of products \n";
foreach ($ds as $key => $value) {
    echo $key . " : " . $value . "\n" ;
}

//in ra thong tin san pham co id ="P03" 
echo "\n => product has id='P03' : " .$ds["P03"] ."\n";

//sap xep mang
echo "\n>> list of products , sorted by key[z-a] \n";
krsort($ds);
foreach ($ds as $key => $value) {
    echo $key . " : " . $value . "\n" ;
}

echo "\n>> list of products , sorted by value[a-z] \n";
asort($ds);
foreach ($ds as $key => $value) {
    echo $key . " : " . $value . "\n" ;
}