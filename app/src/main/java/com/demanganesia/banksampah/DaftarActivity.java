package com.demanganesia.banksampah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DaftarActivity extends AppCompatActivity {

    Button btnDaftar;
    TextView tvMasuk;
    EditText etUsername, etEmail, etPassword, etKonfirmasiPassword, etNoTelepon;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daftar);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etKonfirmasiPassword = findViewById(R.id.etKonfirmasiPassword);
        etNoTelepon = findViewById(R.id.etNoTelepon);


        //ke halaman utama
        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //menyimpon data ke lokal
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, etUsername.getText().toString());
                editor.apply();

                //menyimpan ke database
                reference = FirebaseDatabase.getInstance().getReference().child("User").child(etUsername.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("username").setValue(etUsername.getText().toString());
                        dataSnapshot.getRef().child("email").setValue(etEmail.getText().toString());
                        dataSnapshot.getRef().child("password").setValue(etPassword.getText().toString());
                        dataSnapshot.getRef().child("no_telepon").setValue(etNoTelepon.getText().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                Intent keHome = new Intent(DaftarActivity.this, HomeActivity.class);
                startActivity(keHome);
            }
        });

        //ke halaman masuk
        tvMasuk = findViewById(R.id.tvMasuk);
        tvMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keMasuk = new Intent(DaftarActivity.this, MasukActivity.class);
                startActivity(keMasuk);
            }
        });
    }
}