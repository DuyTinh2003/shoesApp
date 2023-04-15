<?php
require __DIR__ . '/vendor/autoload.php';
$dotenv = Dotenv\Dotenv::createImmutable(__DIR__);
$dotenv->load();
class DatabaseConnection
{
     private $conn;
     public function __construct()
     {
          $this->conn =mysqli_connect($_ENV['DATABASE_HOST'], $_ENV['DATABASE_USER'], $_ENV['DATABASE_PASSWORD'], $_ENV['DATABASE_NAME']);
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