package com.example.cahaya.inventaris;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class InventarisAdapter extends RecyclerView.Adapter<InventarisAdapter.CardViewViewHolder> {
    private Context context;
    OnItemClick handler;

    public ArrayList<Inventaris> getListInventaris() {
        return listInventaris;
    }

    public void setListInventaris(ArrayList<Inventaris> listInventaris) {
        this.listInventaris = listInventaris;
    }

    private ArrayList<Inventaris> listInventaris;

    @NonNull
    @Override
    public InventarisAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row,viewGroup,false);
        return new CardViewViewHolder (itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull InventarisAdapter.CardViewViewHolder holder, int i) {
        Inventaris inventaris = listInventaris.get(i);
        holder.tvId.setText(inventaris.getId());
        holder.tvNama.setText(inventaris.getNama());
        holder.tvJumlah.setText(inventaris.getJumlah());

        String gambar_url = inventaris.getGambar_url();

        Glide.with(holder.itemView.getContext())
                .load(gambar_url)
                .override(350, 550)
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        if(listInventaris != null) {
            return listInventaris.size();
        }
        return 0;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvId, tvNama, tvJumlah;
        Button btnDetail;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvJumlah = itemView.findViewById(R.id.tv_jumlah);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Inventaris m = listInventaris.get(position);
                    handler.click(m);
                }
            });
        }

    }
    public interface OnItemClick{
        void click(Inventaris m);
    }

    public void setHandler(OnItemClick clickHandler){
        handler = clickHandler;
    }

}
