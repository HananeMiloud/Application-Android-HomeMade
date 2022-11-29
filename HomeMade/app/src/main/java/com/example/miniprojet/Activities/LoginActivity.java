package com.example.miniprojet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniprojet.Metier.Client;
import com.example.miniprojet.Metier.DBHelper;
import com.example.miniprojet.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginBtn;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper= new DBHelper(this);
        dbHelper.OpenDB();

        username = findViewById(R.id.usernamerow);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        // Initialize and assign variable
       /* BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.person);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.person:
                        return true;

                }
                return false;
            }
        });*/


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Client> userDetails = dbHelper.LoginClient(username.getText().toString(),password.getText().toString());
                if(userDetails.size() !=0){
                    Client client = userDetails.get(0);
                    Toast.makeText(getApplicationContext(),"valide user",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(LoginActivity.this, CategoryActivitydeux.class);
                    intent.putExtra("client",client);
                    startActivity(intent);

                }
                else{

                    Toast.makeText(getApplicationContext(),"invalide user",Toast.LENGTH_LONG).show();

                }
            }
        });



    }

    public void Register(View view){
        Intent intent= new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);

    }

    public void motdpOublie(View view){
        Intent intent= new Intent(LoginActivity.this, ForgotPswdActivity.class);
        startActivity(intent);

    }

}