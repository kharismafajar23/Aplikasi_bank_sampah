package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class InputDataActivity extends AppCompatActivity {

    Spinner spinnerJenisBarang, spinnerOpsi;
    ImageView icProfil2, icRumah2;
    Button btnPesan;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_input_data);

        spinnerJenisBarang = findViewById(R.id.spinnerJenisBarang);
        spinnerOpsi = findViewById(R.id.spinnerOpsi);
        icRumah2 = findViewById(R.id.ic_rumah2);
        icProfil2 = findViewById(R.id.ic_profil2);
        btnPesan = findViewById(R.id.btnPesan2);
        btnBack = findViewById(R.id.imageButton);

        String[] value = {"Sampah Plastik","Sampah Organik","Kantong Plastik","Sampah Kertas"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner, arrayList);
        spinnerJenisBarang.setAdapter(arrayAdapter);

        String[] value2 = {"Gerobak","Pickup","Truk","Motor"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.style_spinner, arrayList2);
        spinnerOpsi.setAdapter(arrayAdapter2);

        //ke beranda
        icRumah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keHome = new Intent( InputDataActivity.this, HomeActivity.class);
                startActivity(keHome);
            }
        });

        //ke profil
        icProfil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keProfil = new Intent(InputDataActivity.this, ProfilActivity.class);
                startActivity(keProfil);
            }
        });

        //ke checkout
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keCheckout = new Intent(InputDataActivity.this, CheckoutActivity.class);
                startActivity(keCheckout);
            }
        });

        //ke kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}