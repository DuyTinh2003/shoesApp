<?php
require("./DB/dbHelper.php");
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     if (isset($_POST['username']) && isset($_POST['password'])) {
          $username = $_POST['username'];
          $password = $_POST['password'];
          $response = array();
          $sql = "select * from user where username = '$username' and password='$password'";
          $rs = executeResult($sql, true);
          if ($rs == null) {
               $response['success'] = false;
               $response['message'] = "username or password not correct!";
          } else {
               $response['success'] = true;
               $response['message'] = "dang nhap thanh cong";
          }
          echo json_encode($response);
     } else {
          $response = array();
          $response['success'] = false;
          $response['message'] = "Empty data";
          echo json_encode($response);
     }
}