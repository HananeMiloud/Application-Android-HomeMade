package com.example.miniprojet.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.miniprojet.Metier.Client;
import com.example.miniprojet.R;
import com.example.miniprojet.RecyclerView.RecyclerViewActivity;
import com.example.miniprojet.RecyclerView.SaltRecyclerActivity;
import com.example.miniprojet.RecyclerView.SugarRecyclerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CategoryActivitydeux extends AppCompatActivity {
    ImageView sales, sucres, pates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activitydeux);
        sales = findViewById(R.id.sales);
        sucres = findViewById(R.id.sucres);
        pates = findViewById(R.id.pates);
        Intent intent = getIntent();
        Client client ;
        client = (Client) intent.getSerializableExtra("client");
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivitydeux.this, SaltRecyclerActivity.class);
                startActivity(intent);
            }
        });
        sucres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivitydeux.this, SugarRecyclerActivity.class);
                startActivity(intent);
            }
        });
        pates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivitydeux.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.person:
                        Intent i= new Intent(getApplicationContext(), ProfileActivity.class);
                        i.putExtra("client",client);
                        startActivity(i);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;

                }
                return false;
            }
        });

    }

}
