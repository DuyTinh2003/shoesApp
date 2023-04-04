<?php

require_once("../DB/dbHelper.php");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     // Get the student id from the request body
     if (!empty($_POST['id'])) {
          $id = $_POST['id'];
          // Build the SQL query to delete the student record

          $sql = "DELETE FROM student WHERE id = '$id'";
          echo $sql;
          // Execute the query
          execute($sql);
     }
}
