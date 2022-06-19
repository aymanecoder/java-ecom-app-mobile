package com.ex.ecommerceapplication.Acitivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ex.ecommerceapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistraionActivity extends AppCompatActivity {
    private TextView name, email, password;
    private FirebaseAuth auth;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);

        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("OnBoardingScreen", MODE_PRIVATE);

        boolean isFirstTime = sharedPreferences.getBoolean("fisrtTime", true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();

            Intent intent = new Intent(RegistraionActivity.this, OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signup(){

        String user_name = name.getText().toString();
        String user_email = email.getText().toString();
        String user_password = password.getText().toString();

        if (TextUtils.isEmpty(user_name))
        {
            Toast.makeText(this, "Entrer name", Toast.LENGTH_SHORT).show();
            return;
        }
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
        auth.createUserWithEmailAndPassword(user_email,user_password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegistraionActivity.this,"Successfully Registration",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegistraionActivity.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(RegistraionActivity.this,"Failed Registration"+task.getException(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void signin(View view) {

    }
}