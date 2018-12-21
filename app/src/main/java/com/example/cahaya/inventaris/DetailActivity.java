package com.example.cahaya.inventaris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Inventaris invent;

    TextView Id,Nama,Spesifikasi,Tahun,Harga,Jumlah,Satuan,Kondisi;
    Button Bagikan, Ubah, Hapus;
    ImageView img_item_photo;
    Database dbase;


    InventarisAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


    }
}
