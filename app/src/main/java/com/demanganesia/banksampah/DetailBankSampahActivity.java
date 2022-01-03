package com.demanganesia.banksampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class DetailBankSampahActivity extends AppCompatActivity {

    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_bank_sampah);

        btnPesan = findViewById(R.id.btnPesan);

        //ke input data
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keInput = new Intent(DetailBankSampahActivity.this, InputDataActivity.class);
                startActivity(keInput);
            }
        });

    }
}