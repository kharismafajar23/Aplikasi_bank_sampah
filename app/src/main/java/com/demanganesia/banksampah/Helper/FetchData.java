package com.demanganesia.banksampah.Helper;

import android.widget.ImageView;

import java.io.Serializable;

public class FetchData implements Serializable {
    String namaSampah, hargaSatuan;
    ImageView gambarSampah;

    public FetchData() {
    }

    public FetchData(String namaSampah, String hargaSatuan, ImageView gambarSampah) {
        this.namaSampah = namaSampah;
        this.hargaSatuan = hargaSatuan;
        this.gambarSampah = gambarSampah;
    }

    public String getNamaSampah() {
        return namaSampah;
    }

    public void setNamaSampah(String namaSampah) {
        this.namaSampah = namaSampah;
    }

    public String getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(String hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public ImageView getGambarSampah() {
        return gambarSampah;
    }

    public void setGambarSampah(ImageView gambarSampah) {
        this.gambarSampah = gambarSampah;
    }
}
