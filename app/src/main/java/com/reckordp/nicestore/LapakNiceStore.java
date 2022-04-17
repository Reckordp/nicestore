package com.reckordp.nicestore;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class LapakNiceStore implements DetailLapak {
    int thumbnail;
    String teks;

    LapakNiceStore(int thumbnail, String teks) {
        this.thumbnail = thumbnail;
        this.teks = teks;
    }

    @Override
    public void performDetail(View area) {
        MainActivity activity = MainActivity.getInstance();
        ImageView image = area.findViewById(R.id.thumbnail);
        Uri uri = Uri.parse("android.resource://" + activity.getPackageName() + "/" + thumbnail);
        Glide.with(activity)
                .load(uri)
                .into(image);
        image.setImageResource(thumbnail);
        TextView text = area.findViewById(R.id.teks);
        text.setText(this.teks);
    }
}
