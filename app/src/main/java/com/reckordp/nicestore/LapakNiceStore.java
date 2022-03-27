package com.reckordp.nicestore;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LapakNiceStore implements DetailLapak {
    int thumbnail;
    String teks;

    LapakNiceStore(int thumbnail, String teks) {
        this.thumbnail = thumbnail;
        this.teks = teks;
    }

    @Override
    public void performDetail(View area) {
        ImageView image = area.findViewById(R.id.thumbnail);
        image.setImageResource(thumbnail);
        TextView text = area.findViewById(R.id.teks);
        text.setText(this.teks);
    }
}
