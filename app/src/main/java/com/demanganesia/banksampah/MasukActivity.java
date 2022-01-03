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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MasukActivity extends AppCompatActivity {

    Button btnMasuk;
    TextView tvDaftar;
    EditText etUsername, etPassword;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_masuk);

        btnMasuk = findViewById(R.id.btnMasuk);
        tvDaftar = findViewById(R.id.tvDaftar);
        etUsername = findViewById(R.id.xetUsername);
        etPassword = findViewById(R.id.xetPassword);


        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference().child("User").child(username);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            //ambil data password dari firebase
                            String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();

                            //validasi password
                            if (password.equals(passwordFromFirebase)){

                                //simpan username ke lokal
                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(username_key, etUsername.getText().toString());
                                editor.apply();

                                //Jika di klik masuk, menuju tampilan Home
                                Intent keHome = new Intent(MasukActivity.this, HomeActivity.class);
                                startActivity(keHome);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Kamu belum terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });

        //menuju tampilan daftar
        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keDaftar = new Intent(MasukActivity.this, DaftarActivity.class);
                startActivity(keDaftar);
            }
        });
    }
}