package com.example.miniprojet.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniprojet.Metier.Client;
import com.example.miniprojet.R;


public class ProfileActivity extends AppCompatActivity {


    TextView textViewUsername,textViewPhone,textViewAdress,textViewService,textViewDescription;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewUsername = findViewById(R.id.textViewUsername);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewAdress = findViewById(R.id.textViewAdress);
        textViewService = findViewById(R.id.textViewService);
        textViewDescription = findViewById(R.id.textViewDescription);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CategoryActivitydeux.class);
                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        Client client ;
        client = (Client) intent.getSerializableExtra("client");
        textViewUsername.setText(client.getUserName());
        textViewPhone.setText(client.getPhone());
        textViewAdress.setText(client.getAdress());
        textViewService.setText(client.getService());
        textViewDescription.setText(client.getDescription());

    }

    public void logout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    public void edit(View view) {

        Intent intent = getIntent();
        Client client ;
        client = (Client) intent.getSerializableExtra("client");
        Intent i= new Intent(ProfileActivity.this, EditProfileActivity.class);
        i.putExtra("client",client);
        startActivity(i);

    }


}