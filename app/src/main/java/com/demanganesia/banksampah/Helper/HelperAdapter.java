package com.demanganesia.banksampah.Helper;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demanganesia.banksampah.DetailSampahActivity;
import com.demanganesia.banksampah.R;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter{

    List<FetchData> fetchData;

    public HelperAdapter(List<FetchData> fetchData) {
        this.fetchData = fetchData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.harga_sampah_item,parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass)holder;
        final FetchData fetchDataList = fetchData.get(position);
        viewHolderClass.namaSampah.setText(fetchDataList.getNamaSampah());
        viewHolderClass.hargaSatuan.setText(fetchDataList.getHargaSatuan());
        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent keDetailSampah = new Intent(view.getContext(), DetailSampahActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("key",fetchDataList);
                    keDetailSampah.putExtras(bundle);
                    view.getContext().startActivity(keDetailSampah);

                }
        });

    }

    @Override
    public int getItemCount() {
        return fetchData.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView namaSampah, hargaSatuan;
        ImageView gambarSampah;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            gambarSampah = itemView.findViewById(R.id.gambarJenisSampah);
            namaSampah = itemView.findViewById(R.id.tvNamaJenisSampah);
            hargaSatuan = itemView.findViewById(R.id.hargaJenisSampah);
        }
    }

}
