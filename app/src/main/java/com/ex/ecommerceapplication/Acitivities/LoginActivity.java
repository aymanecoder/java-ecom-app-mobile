package com.ex.ecommerceapplication.Acitivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ex.ecommerceapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        getSupportActionBar().hide();
    }

    public void signin(View view) {
        String user_email = email.getText().toString();
        String user_password = password.getText().toString();

        if (TextUtils.isEmpty(user_email))
        {
            Toast.makeText(this, "Entrer Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(user_password))
        {
            Toast.makeText(this, "Entrer Password", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void signup(){

    }
}