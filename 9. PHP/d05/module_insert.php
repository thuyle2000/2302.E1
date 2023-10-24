<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>module-insert</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <div class="container">
        <h3>Create New Module</h3>
        <div class="row">
            <div class="col-md-4" style="border: thin solid salmon; padding: 10px; margin: 10px;">
                <h4>Module Detail</h4>
                <form method="post">
                    <div class="form-group">
                        <label for="">short name</label>
                        <input type="text" class="form-control" name="sname" id="sname" placeholder="input short name" value="HCJS" required />
                    </div>

                    <div class="form-group">
                        <label for="">long name</label>
                        <input type="text" class="form-control" name="lname" id="lname" placeholder="input long name" value="HTML5/CSS3 & Javascript" required />
                    </div>

                    <div class="form-group">
                        <label for="">hours</label>
                        <input type="number" class="form-control" name="hours" id="hours" placeholder="input hours" value="30" required min="4" max="60" />
                    </div>

                    <div class="form-group">
                        <label for="">fee</label>
                        <input type="number" class="form-control" name="fee" id="fee" placeholder="input fee" value="300" required min="0" max="2000" />
                    </div>

                    <div>
                        <br />
                        <input type="submit" value="submit" class="btn btn-danger" name="btnOK">
                        <input type="reset" value="reset" class="btn btn-info">
                    </div>
                </form>
            </div>

        </div>

        <?php
        //code duoc thuc hien tren server
        //lay du lieu nhap trong o email va password da duoc goi len server
        error_reporting(0); //chan, ko in thong bao loi - neu co.
        if (isset($_POST["btnOK"])) {
            include_once("module.php");
            
            $sname = $_POST["sname"];
            $lname = $_POST["lname"];
            $hours = $_POST["hours"];
            $fee = $_POST["fee"];

            $newModule = new Module(null,$sname, $lname, $hours, $fee);
            ModuleDAO::insert($newModule);

            header("location:module_view.php");
        }


        ?>

    </div>
</body>

</html>