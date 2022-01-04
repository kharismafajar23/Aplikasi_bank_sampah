package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FilterActivity extends AppCompatActivity {

    Spinner spinnerProvinsi, spinnerKabupaten, spinnerKecamatan;
    ImageButton btnBack;
    Button btnHapus, btnTampilkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_filter);

        spinnerProvinsi = findViewById(R.id.spinnerProvinsi1);
        spinnerKabupaten = findViewById(R.id.spinnerKabupaten1);
        spinnerKecamatan = findViewById(R.id.spinnerKecamatan1);
        btnBack = findViewById(R.id.imageButton);
        btnHapus = findViewById(R.id.btnHapus);
        btnTampilkan = findViewById(R.id.btnTampilkan);

        String[] value = {"1","2","3","4","5"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner,arrayList);
        spinnerProvinsi.setAdapter(arrayAdapter);

        String[] value2 = {"A","B","C","D","E"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.style_spinner,arrayList2);
        spinnerKabupaten.setAdapter(arrayAdapter2);

        String[] value3 = {"a","b","c","d","e"};
        ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList(value3));
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this,R.layout.style_spinner,arrayList3);
        spinnerKecamatan.setAdapter(arrayAdapter3);

        //ke kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //ke home
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hapus = new Intent(FilterActivity.this, HomeActivity.class);
                startActivity(hapus);
            }
        });

        //ke home
        btnTampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hapus2 = new Intent(FilterActivity.this, HomeActivity.class);
                startActivity(hapus2);
            }
        });

    }
}