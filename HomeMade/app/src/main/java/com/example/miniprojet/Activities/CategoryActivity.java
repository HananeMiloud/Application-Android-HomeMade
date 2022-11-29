package com.example.miniprojet.Activities;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.miniprojet.R;
import com.example.miniprojet.RecyclerView.RecyclerViewActivity;
import com.example.miniprojet.RecyclerView.SaltRecyclerActivity;
import com.example.miniprojet.RecyclerView.SugarRecyclerActivity;

public class CategoryActivity extends AppCompatActivity {
    ImageView sales, sucres, pates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        sales = findViewById(R.id.sales);
        sucres = findViewById(R.id.sucres);
        pates = findViewById(R.id.pates);
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, SaltRecyclerActivity.class);
                startActivity(intent);
            }
        });
        sucres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, SugarRecyclerActivity.class);
                startActivity(intent);
            }
        });
        pates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
    }
