package com.demanganesia.banksampah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demanganesia.banksampah.Helper.FetchData;
import com.demanganesia.banksampah.Helper.HelperAdapter2;

import java.util.ArrayList;

public class DetailSampahActivity extends AppCompatActivity {

    HelperAdapter2 helperAdapter2;
    RecyclerView recyclerViewDetailSampah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_sampah);

        recyclerViewDetailSampah = findViewById(R.id.recyclerViewDetailSampah);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        FetchData fetchData = (FetchData)bundle.getSerializable("key");
        recyclerViewDetailSampah.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(fetchData.getNamaSampah().toString());
        arrayList.add(fetchData.getHargaSatuan());

        helperAdapter2 = new HelperAdapter2(arrayList);
        recyclerViewDetailSampah.setAdapter(helperAdapter2);
    }
}
