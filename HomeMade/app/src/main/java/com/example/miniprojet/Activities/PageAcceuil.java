package com.example.miniprojet.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.miniprojet.R;

public class PageAcceuil extends AppCompatActivity {
    ImageView femme, acheteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_acceuil);
        femme = findViewById(R.id.femme);
        acheteur = findViewById(R.id.client);

        femme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAcceuil.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        acheteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAcceuil.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}