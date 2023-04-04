<?php
require("../DB/dbHelper.php");
$sql = "select * from student";
$response = executeResult($sql);
echo json_encode($response);
