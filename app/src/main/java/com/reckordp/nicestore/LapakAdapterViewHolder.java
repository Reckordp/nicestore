package com.reckordp.nicestore;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LapakAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    static String LAPAK_NAMA = "NAMA LAPAK";
    static String LAPAK_HARGA = "HARGA LAPAK";

    String lapakNama = "";
    int lapakHarga = 0;

    public LapakAdapterViewHolder(@NonNull ViewGroup itemView) {
        super((View) itemView);
        itemView.findViewById(R.id.kartu_toko).setOnClickListener(this);
    }

    @Override
    public void onClick(View target) {
        Intent intentBeli;
        MainActivity activity;
        activity = MainActivity.getInstance();
        intentBeli = new Intent(activity, BeliLapak.class);
        intentBeli.putExtra(LAPAK_NAMA, lapakNama);
        intentBeli.putExtra(LAPAK_HARGA, lapakHarga);
        activity.startActivity(intentBeli);
    }
}
