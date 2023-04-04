package com.example.shoesapp.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoesapp.R;
import com.example.shoesapp.model.Response;
import com.example.shoesapp.retrofit.RetrofitClient;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private EditText editTextUser, editTextPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLoginTest();
            }
        });
    }

    void handleLoginTest() {
        editTextUser = findViewById(R.id.input_username);
        editTextPassword = findViewById(R.id.input_password);
        username= editTextUser.getText().toString();
        password = editTextPassword.getText().toString();

        RetrofitClient.getInstance().getApi().login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Toast.makeText(Login.this, "1", Toast.LENGTH_SHORT).show();
                        System.out.println("error 1"+d);

                    }

                    @Override
                    public void onNext(@NonNull Response response) {
                        System.out.println("Succcccceeeeee");
                        Toast.makeText(Login.this, "Suceescc", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(Login.this, "2", Toast.LENGTH_SHORT).show();
                        System.out.println("error"+e);
                    }
                    @Override
                    public void onComplete() {
                        Toast.makeText(Login.this, "3", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}