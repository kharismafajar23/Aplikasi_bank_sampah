package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfilActivity extends AppCompatActivity {

    ImageButton btnBack2;
    ImageView btnHome, btnTransaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profil);

        btnBack2 = findViewById(R.id.btnBack2);
        btnHome = findViewById(R.id.ic_rumah);
        btnTransaksi = findViewById(R.id.ic_transaksi3);


        //kembali
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //ke bank sampah dri rekomendasi
        btnTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keDetBS = new Intent(ProfilActivity.this, InputDataActivity.class);
                startActivity(keDetBS);
            }
        });

        //ke bank sampah dri rekomendasi
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent(ProfilActivity.this, HomeActivity.class);
                startActivity(keHome);
            }
        });
    }
}