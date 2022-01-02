package com.demanganesia.banksampah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.demanganesia.banksampah.Helper.FetchData;
import com.demanganesia.banksampah.Helper.HelperAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageProfil;
    RecyclerView recyclerViewHargaSampah;

    List<FetchData> fetchData;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageProfil = findViewById(R.id.imageProfil);
        recyclerViewHargaSampah = findViewById(R.id.recycleViewHargaSampah);
        recyclerViewHargaSampah.setLayoutManager(new LinearLayoutManager(this));

        fetchData = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("JenisSampah");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    FetchData fetchDatalist = dataSnapshot1.getValue(FetchData.class);
                    fetchData.add(fetchDatalist);
                }
                    helperAdapter = new HelperAdapter(fetchData);
                    recyclerViewHargaSampah.setAdapter(helperAdapter);
                ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keProfil = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(keProfil);
            }
        });
    }
}