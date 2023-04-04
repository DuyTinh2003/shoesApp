<?php

require_once("./DB/databaseConnection.php");

/**
 * Su dung cho cac lenh: insert, update, delete
 * 
 */
function execute($sql)
{
     // Create a new instance of the DatabaseConnection class
     $db = new DatabaseConnection();
     $result = mysqli_query($db->getConnection(), $sql);
     $response = array();
     if (!$result) {
          mysqli_close($db->getConnection());
          $response['success'] = false;
          if (mysqli_connect_error()) {
               $response['message'] = "Update failed. Connection error: ";
          } else {
               $response['message'] = "Update failed. Error message: ";
          }
          echo json_encode($response);
          die();
     }
     mysqli_close($db->getConnection());
     $response['success'] = true;
     echo json_encode($response);
}

/**
 * Su dung cho cac lenh: select
 */
function executeResult($sql, $onlyOne = false)
{
     $db = new DatabaseConnection();
     //query
     $resultset = mysqli_query($db->getConnection(), $sql);
     $response = array();

     if (!$resultset) {
          mysqli_close($db->getConnection());
          $response['success'] = false;
          if (mysqli_connect_error()) {
               $response['message'] = "Update failed. Connection error: ";
          } else {
               $response['message'] = "Update failed. Error message: ";
          }
          echo json_encode($response);
          die();
          // return [];
     }
     if ($onlyOne) {
          $data = mysqli_fetch_array($resultset, 1);
     } else {
          $data = [];
          while (($row = mysqli_fetch_array($resultset, 1)) != null) {
               $data[] = $row;
          }
     }
     //Dong ket noi
     mysqli_close($db->getConnection());
     return $data;
}
