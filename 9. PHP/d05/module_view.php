<?php
include_once "module.php";
$ds = ModuleDAO::get();
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>modules-view</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>
    <div class="container">
        <h3>List of Modules</h3> <br>
        <a href="module_insert.php">Create New Module</a>
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>short name</th>
                    <th>long name</th>
                    <th>hours</th>
                    <th>fee</th>
                    <th>action</th>
                </tr>
            </thead>
            <tbody>
                <?php
                foreach ($ds as $item) {
                    echo "<tr>";
                    echo "<td>$item->id</td>";
                    echo "<td>$item->sname</td>";
                    echo "<td>$item->lname</td>";
                    echo "<td>$item->hours</td>";
                    echo "<td>$item->fee</td>";
                    echo "<td>
                          <a href='#'>view</a>
                          <a href='#'>delete</a>
                         </td>";
                    echo "</tr>";
                }
                ?>
            </tbody>
        </table>


    </div>
</body>

</html>