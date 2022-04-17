package com.reckordp.nicestore;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

public class LapakNiceStore implements DetailLapak {
    int thumbnail;
    String nama;
    int harga;

    LapakNiceStore(int thumbnail, String teks) {
        this.thumbnail = thumbnail;
        this.nama = teks;
    }

    @Override
    public void performDetail(@NonNull LapakAdapterViewHolder viewHolder) {
        View area = viewHolder.itemView;
        MainActivity activity = MainActivity.getInstance();
        ImageView image = area.findViewById(R.id.thumbnail);
        Uri uri = Uri.parse("android.resource://" + activity.getPackageName() + "/" + thumbnail);
        Glide.with(activity)
                .load(uri)
                .into(image);
        TextView text = area.findViewById(R.id.teks);
        text.setText(this.nama);

        viewHolder.lapakNama = this.nama;
        viewHolder.lapakHarga = this.harga;
    }
}
