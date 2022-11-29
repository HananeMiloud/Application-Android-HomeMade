package com.example.miniprojet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniprojet.Metier.DBConnector;
import com.example.miniprojet.R;

public class ResetPswdActivity extends AppCompatActivity {
    TextView userName;
    EditText password, confrPassword;
    Button confirm;
    DBConnector database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pswd);
        password = findViewById(R.id.password);
        confrPassword = findViewById(R.id.confrPassword);
        confirm = findViewById(R.id.ResetPasswd);

        database = new DBConnector(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String Username = i.getStringExtra("username");
                String password= ResetPswdActivity.this.password.getText().toString();
                String rePassword = confrPassword.getText().toString();
                if (password.equals(rePassword)){
                    Boolean checkPasswordUpdate= database.updatePasswd(Username,password);
                    if (checkPasswordUpdate){
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(ResetPswdActivity.this, "mot de passe modifier avec succes", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ResetPswdActivity.this, "mot de passe non modifier ", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(ResetPswdActivity.this, "mot de passe non verifier", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}