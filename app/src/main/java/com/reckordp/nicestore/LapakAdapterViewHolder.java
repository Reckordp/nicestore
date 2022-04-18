package com.reckordp.nicestore;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LapakAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    static String LAPAK_NICE_STORE = "LAPAK NICE STORE";

    String lapakNama = "";
    int lapakHarga = 0;
    Parcelable lapak;

    public LapakAdapterViewHolder(@NonNull ViewGroup itemView) {
        super((View) itemView);
        itemView.findViewById(R.id.kartu_toko).setOnClickListener(this);
    }

    public void setLapak(Parcelable fromAdapter) {
        lapak = fromAdapter;
    }

    @Override
    public void onClick(View target) {
        Intent intentBeli;
        MainActivity activity;
        activity = MainActivity.getInstance();
        intentBeli = new Intent(activity, BeliLapak.class);
        intentBeli.putExtra(LAPAK_NICE_STORE, lapak);
        activity.startActivity(intentBeli);
    }
}
