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
                        <input type="email" class="form-control" name="email" id="mail" placeholder="input email" value="lin@gmail.com" />
                    </div>

                    <div class="form-group">
                        <label for="">password</label>
                        <input type="password" class="form-control" name="password" id="pwd" placeholder="input password" value="123" />
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
    echo "<h4> Hello, your email is [$email] and password : [$pass] </h4>";
}
