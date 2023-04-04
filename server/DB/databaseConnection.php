<?php
class DatabaseConnection
{
     private $conn;
     public function __construct()
     {
          require("./DB/configDB.php");
          // Create a connection
          $this->conn = mysqli_connect($host, $username, $password, $dbname);
          mysqli_set_charset($this->conn, 'utf8');
          // Check connection
          if (!$this->conn) {
               die("Connection failed: " . mysqli_connect_error());
          }
     }
     public function getConnection()
     {
          return $this->conn;
     }

     // Other methods can be defined here that make use of the $conn object.
}
