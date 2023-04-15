<?php
require_once('vendor/autoload.php');
require_once("./databaseConnection.php");

use Firebase\JWT\JWT;

$db = new DatabaseConnection();
// API đăng nhập
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $input = json_decode(file_get_contents('php://input'), true);
    $username = $input['username'];
    $password = $input['password'];
    $sql = "SELECT * FROM user WHERE username='$username' AND password='$password'";
    $result = mysqli_query($db->getConnection(), $sql);
    if (mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        $secret_key = "123";
        $issuer_claim = "3321";
        $audience_claim = "123";
        // Thời gian phát hành token
        $issuedat_claim = time();
        // Token sẽ có hiệu lực sau 10 giây
        $notbefore_claim = $issuedat_claim + 10;
        // Token hết hạn sau 1 giờ
        $expire_claim = $issuedat_claim + 3600;
        $token = array(
            "iss" => $issuer_claim,
            "aud" => $audience_claim,
            "iat" => $issuedat_claim,
            "nbf" => $notbefore_claim,
            "exp" => $expire_claim,
            "data" => array(
                "id" => $row['id'],
                "username" => $row['username']
            )
        );
        http_response_code(200);
        $jwt = JWT::encode($token, $secret_key, 'HS256');
        echo json_encode(
            array(
                "message" => "Login success!",
                "jwt" => $jwt
            )
        );
    } else {
        http_response_code(401);
        echo json_encode(
            array("message" => "Login fail")
        );
    }
}

// API yêu cầu xác thực JWT
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $headers = apache_request_headers();
    $token = $headers['Authorization'];
    if (!empty($token)) {
        $secret_key = "YOUR_SECRET_KEY";
        try {
            $decoded = JWT::decode($token, $secret_key, array('HS256'));
            http_response_code(200);
            echo json_encode(
                array(
                    "message" => "Xác thực thành công.",
                    "data" => $decoded->data
                )
            );
        } catch (Exception $e) {
            http_response_code(401);
            echo json_encode(
                array("message" => "Xác thực thất bại.")
            );
        }
    } else {
        http_response_code(401);
        echo json_encode(
            array("message" => "Vui lòng cung cấp JWT.")
        );
    }
}