<?php
require_once("../DB/dbHelper.php");
// Check if the form has been submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     // Get the form data
     if (!empty($_POST['name'] && !empty($_POST['class']))) {
          $name = $_POST['name'];
          $class = $_POST['class'];
          $sql = "INSERT INTO student (name, class) VALUES ('$name', '$class')";
          // Execute the query
          execute($sql);
     }
}
