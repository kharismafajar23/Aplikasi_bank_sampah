package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ImageView imageProfil, transaksi, profil;
    LinearLayout btnFilter, lRek1;
    TextView btnLihatSemua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        imageProfil = findViewById(R.id.imageProfil);
        transaksi = findViewById(R.id.ic_transaksi);
        profil = findViewById(R.id.ic_profil);
        btnFilter = findViewById(R.id.btnFilter);
        btnLihatSemua = findViewById(R.id.tvLihatSemua);
        lRek1 = findViewById(R.id.lrek1);

        //filter
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keFilter = new Intent( HomeActivity.this, FilterActivity.class);
                startActivity(keFilter);
            }
        });

        //ke profil
        imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keProfil = new Intent(HomeActivity.this, ProfilActivity.class);
                startActivity(keProfil);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keProfil2 = new Intent(HomeActivity.this, ProfilActivity.class);
                startActivity(keProfil2);
            }
        });

        //lihat semua harga sampah
        btnLihatSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHarga = new Intent(HomeActivity.this, DaftarHargaActivity.class);
                startActivity(keHarga);
            }
        });

        //ke bank sampah dri rekomendasi
        lRek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keDetBS = new Intent(HomeActivity.this, DetailBankSampahActivity.class);
                startActivity(keDetBS);
            }
        });

        //ke input data
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keInput = new Intent(HomeActivity.this, InputDataActivity.class);
                startActivity(keInput);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // or finish();
    }
}