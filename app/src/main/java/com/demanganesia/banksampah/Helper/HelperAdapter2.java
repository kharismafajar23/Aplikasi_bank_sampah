package com.demanganesia.banksampah.Helper;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demanganesia.banksampah.R;

import java.util.List;

public class HelperAdapter2 extends RecyclerView.Adapter {

    List<String> fetchData;

    public HelperAdapter2(List<String> fetchData) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        final String fetchDataList = fetchData.get(position);
        viewHolderClass.namaSampah.setText(fetchDataList);
        viewHolderClass.hargaSatuan.setText(fetchDataList);

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
