<?php
class Module
{
    public $id, $sname, $lname, $hours, $fee;

    public function __construct($id = null, $sname = "C", $lname = "Logic building with C", $hours = 56, $fee = 250)
    {
        $this->id = $id;
        $this->sname = $sname;
        $this->lname = $lname;
        $this->hours = $hours;
        $this->fee = $fee;
    }
}

include_once("../lib/connect_oop.php");
class ModuleDAO
{
    public static function insert(Module $m)
    {
        $cn = connect();
        $sql = "INSERT INTO `tbmodule` (`id`, `sname`, `lname`, `hours`, `fee`) VALUES (NULL, '$m->sname', '$m->lname', '$m->hours', '$m->fee')";

        $r = $cn->query($sql);
        if ($r == false) {
            die("<h4> LOI: ko the them du lieu moi !</h4>" . $cn->error);
        }
        $cn->close();
    }

    public static function get()
    {
        $cn = connect();

        //xem danh sach cac mon hoc
        $sql = "SELECT * FROM `tbmodule`";

        $r = $cn->query($sql);
        if ($r == false) {
            die("<h4>LOI: ko the truy van du lieu !</h4>");
        }


        if ($r->num_rows == 0) {
            die("<h4>KO TIM THAY DU LIEU ! </h4>");
        }

        $a = [];
        while ($row = $r->fetch_array(MYSQLI_BOTH)) {
            $m = new Module($row["id"], $row["sname"], $row["lname"], $row["hours"], $row["fee"]);
            array_push($a, $m);
        }

        $cn->close();
        return $a;
    }

    public static function delete($id)
    {
        $cn = connect();

        //xoa mau tin trong bang tbmodule theo ma so
        $id = 5;
        $sql = "DELETE FROM `tbmodule` WHERE `id`= '$id' ";

        $r = $cn->query($sql);
        if ($r == false) {
            die("LOI: ko the xoa du lieu  ! <br/>" . $cn->error);
        }
        $cn->close();
    }
}




// $ds = ModuleDAO::get();
// echo "<pre>";
// print_r($ds);
