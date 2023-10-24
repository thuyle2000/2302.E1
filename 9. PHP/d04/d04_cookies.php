<?php
    $uid = "mai@hotmail.com";
    $pwd = "abc";
    if(isset($_COOKIE["uid"])){
        $uid = $_COOKIE["uid"];
        $pwd = $_COOKIE["pwd"];
    }
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4" style="border: thin solid salmon; padding: 10px; margin: 10px;">
                <h2>Login</h2>
                <form method="get" >
                    <div class="form-group">
                        <label for="">email</label>
                        <input type="email" class="form-control" name="email" id="mail" placeholder="input email" value="<?php echo $uid ?>" />
                    </div>

                    <div class="form-group">
                        <label for="">password</label>
                        <input type="password" class="form-control" name="password" id="pwd" placeholder="input password" value="<?php echo $pwd ?>" />
                    </div>

                    <div>
                        <br />
                        <input type="submit" value="submit" class="btn btn-danger" name="btnOK">
                        <input type="reset" value="reset" class="btn btn-info">
                    </div>
                </form>
            </div>

        </div>

    </div>
</body>

</html>

<?php
//code duoc thuc hien tren server
//lay du lieu nhap trong o email va password da duoc goi len server
error_reporting(0); //chan, ko in thong bao loi - neu co.
if (isset($_REQUEST["btnOK"])) {
    $email = $_REQUEST["email"];
    $pass = $_REQUEST["password"];
    
    $account = [
        "aptech@fpt.com.vn" => "aptech",
        "lin@gmail.com" => "123",
        "mai@hotmail.com" => "abc",
        "nhan@fpt.com.vn" => "nghia"
    ];

    echo "<br/><hr/>";
    if (array_key_exists($email, $account) ){
        //email input co trong ds account
        if($pass == $account[$email]){       
            echo "<h4>Hi, $email. Welcome to mysite <h4>";
            setcookie("uid",$email,time()+3*60);
            setcookie("pwd",$pass,time()+3*60);
        }
        else{
            echo "<h4> Sorry, wrong password !<h4>";
        }
    }
    else{
        echo "<h4> Sorry, invalid account !<h4>";
    }

}

