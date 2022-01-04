package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DaftarHargaActivity extends AppCompatActivity {

    ImageButton btnBack;
    ImageView btnHome, btnTransaksi, btnProfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daftar_harga);

        btnBack = findViewById(R.id.imageButton2);
        btnHome = findViewById(R.id.ic_home);
        btnTransaksi = findViewById(R.id.btn_transaksi);
        btnProfil = findViewById(R.id.ic_profil3);

        //ke kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //ke home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent(DaftarHargaActivity.this, HomeActivity.class);
                startActivity(keHome);
            }
        });

        //ke input data
        btnTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keInput = new Intent(DaftarHargaActivity.this, InputDataActivity.class);
                startActivity(keInput);
            }
        });

        //ke profil
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keProfil = new Intent(DaftarHargaActivity.this, ProfilActivity.class);
                startActivity(keProfil);
            }
        });
    }
}