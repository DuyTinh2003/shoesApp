package com.example.shoesapp.api;


import com.example.shoesapp.model.Response;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String BASE_URL = "http://192.168.1.12/shoes-app/server/";

    @POST("login.php")
    @FormUrlEncoded
    Observable<Response> login(
            @Field("username") String user,
            @Field("password") String pass
    );
}













//
//    @GET("displayStudent.php")
//    Call<List<Student>> getListStudent();
//    @POST("addStudent.php")
//    Call<Student> addStudent(@Body String name,String className);
//    @POST("deleteStudent.php")
//    Call<Response> deleteStudent(@Body int id);
//    @POST("editStudent.php")
//    Call<Response> editStudent(@Body Student student);
