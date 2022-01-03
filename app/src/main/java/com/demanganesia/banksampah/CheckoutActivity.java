package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    Button btnSelesai, btnLihatMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_checkout);

        btnSelesai = findViewById(R.id.btnSelesai);
        btnLihatMaps = findViewById(R.id.btnLihatMaps);

        //ke Home
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent(CheckoutActivity.this, HomeActivity.class);
                startActivity(keHome);
            }
        });

        //lihat maps
        btnLihatMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keMaps = new Intent(CheckoutActivity.this, Lokasi.class);
                startActivity(keMaps);
            }
        });
    }
}