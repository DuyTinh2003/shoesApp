package com.example.shoesapp.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}