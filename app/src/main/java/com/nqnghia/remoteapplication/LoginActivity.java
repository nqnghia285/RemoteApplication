package com.nqnghia.remoteapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText username;
    private EditText password;
    private Button login;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_edit_text);
        password = findViewById(R.id.password_edit_text);
        forgotPassword = findViewById(R.id.forgot_text_view);


    }

}

