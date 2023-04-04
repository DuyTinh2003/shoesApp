<?php
require_once("../DB/dbHelper.php");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     // Get the form data
     if (!empty($_POST['id'] && !empty($_POST['name']) && !empty($_POST['class']))) {
          $id = $_POST['id'];
          $name = $_POST['name'];
          $class = $_POST['class'];
          // Build the SQL query
          $sql = "UPDATE student SET name='$name', class='$class' WHERE id='$id'";
          execute($sql);
     }
}
