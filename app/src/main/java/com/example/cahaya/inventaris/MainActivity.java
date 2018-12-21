package com.example.cahaya.inventaris;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements InventarisAdapter.OnItemClick {
    ProgressBar pbInvent;
    RecyclerView rvInvent;
    InventarisAdapter adapter;
    private ArrayList<Inventaris> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new InventarisAdapter();
        adapter.setHandler(this);

        pbInvent = findViewById(R.id.pb_invent);
        rvInvent = findViewById(R.id.rv_invent);
        rvInvent.setLayoutManager(new LinearLayoutManager(this));
        rvInvent.setAdapter(adapter);
        rvInvent.setVisibility(View.VISIBLE);

        getData();

    }

    private void getData() {

        rvInvent.setVisibility(View.INVISIBLE);
        pbInvent.setVisibility(View.VISIBLE);

     if(isConnected()) {
            Toast.makeText(MainActivity.this,"Connection Established",Toast.LENGTH_LONG).show();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://inventaris.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api client = retrofit.create(Api.class);

        Call<List<Inventaris>> call = client.getInventaris();
            //Toast.makeText(MainActivity.this,String.valueOf(),Toast.LENGTH_LONG).show();


        call.enqueue(new Callback<List<Inventaris>>() {
            @Override
            public void onResponse(Call<List<Inventaris>> call, Response<List<Inventaris>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<Inventaris> data = response.body();
                Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                ArrayList<Inventaris> listinvent = new ArrayList<Inventaris>(data);
                adapter.setListInventaris(listinvent);
                rvInvent.setAdapter(adapter);

                //saveGaleryData(listinvent);

                pbInvent.setVisibility(View.INVISIBLE);
                rvInvent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<Inventaris>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                pbInvent.setVisibility(View.INVISIBLE);
                rvInvent.setVisibility(View.VISIBLE);
            }
        });

    }/*else {
            Toast.makeText(MainActivity.this,"tidak konek",Toast.LENGTH_LONG).show();
            List<RomGalery> galeryRom = db.getGaleryDao().getGalery();
            List<Galery> galeriModels = new ArrayList<>();

            for (RomGalery rg: galeryRom ){
                Inventaris galeryModel = new Inventaris(
                        rg.id,
                        rg.nama,
                        rg.lokasi,
                        rg.gambar_url,
                        rg.deskripsi,
                        rg.lat,
                        rg.lng
                );
                galeriModels.add(galeryModel);
            }

            adapter.setListGalery(new ArrayList<Galery>(galeriModels));
            rvInvent.setAdapter(adapter);

            pbInvent.setVisibility(View.INVISIBLE);
            rvInvent.setVisibility(View.VISIBLE);*/

        }

        @Override
        public void click(Inventaris m) {
           Intent detailActivityIntent = new Intent(this, DetailActivity.class);
            detailActivityIntent.putExtra("movie_extra_key", m);
            startActivity(detailActivityIntent);
        }

        public Boolean isConnected(){
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            return isConnected;
        }

}
